package com.wegame.service.Impl;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.wegame.dto.*;
import com.wegame.entity.SeatUserEntity;
import com.wegame.mapper.*;
import com.wegame.model.*;
import com.wegame.service.FriedFlowerService;
import com.wegame.tools.common.GamblingDefault;
import com.wegame.tools.flower.DisorganizeUtil;
import com.wegame.tools.flower.FriedFlowerJsonObject;
import com.wegame.tools.flower.Player;
import com.wegame.tools.flower.calculator.impl.NonFlowerValueCalculator;
import com.wegame.tools.flower.compare.PlayerComparator;
import com.wegame.tools.flower.provider.PlayerProvider;
import com.wegame.tools.flower.provider.impl.LimitedPlayerProvider;
import com.wegame.tools.utils.EnumUtils;
import com.wegame.tools.utils.SnowUtils;
import com.wegame.tools.utils.ValidateUtil;
import com.wegame.vo.Message;
import com.wegame.vo.RoomChildMsgVo;
import com.wegame.vo.RoomMsgVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName：FriedFlowerServiceImpl
 * @Description: 即时通讯
 * @Author：13738700108
 * @Data 2020/2/12 14:41
 * @Version: v1.0
 **/

@Transactional(rollbackFor = Exception.class)
@Service
public class FriedFlowerServiceImpl implements FriedFlowerService {


    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private GamblingMapper gamblingMapper;

    @Autowired
    private GamblingMessageMapper gamblingMessageMapper;

    @Autowired
    private GamblingBoardMapper gamblingBoardMapper;

    @Autowired
    private GamblingDetailsMapper gamblingDetailsMapper;

    @Autowired
    private GamblingStatisticsMapper gamblingStatisticsMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void sendMessage(Message message) {
        template.convertAndSend("/friedFlower/one", FriedFlowerJsonObject.userOutRoom("111", "aaa"));
    }

    @Override
    public Room findRoomMessageByRoomSerial(Integer roomId) {
        Room room =  roomMapper.findRoomMessageByRoomSerial(roomId);
//        Room room = roomRepository.findRoomMessageByRoomSerial(roomSerial);
        return room;
    }

//    @Override
//    public List<Seat> findSeatsByRoom(Room room) {
//        List<Seat> seats = seatRepository.findSeatsByRoom(room);
//        return seats;
//    }

    @Override
    public void sendUserInToRoomMessage(Map<String, Object> msg) {
        template.convertAndSend("/friedFlower/" + FriedFlowerJsonObject.serial(Integer.parseInt(msg.get("roomId").toString())),
                FriedFlowerJsonObject.userInToRoom(Integer.parseInt(msg.get("type").toString()),
                        msg.get("userId").toString(),
                        msg.get("userImg").toString(),
                        msg.get("userNickName").toString(),
                        Integer.parseInt(msg.get("integral").toString())));
    }

    @Override
    public void sendRoomMessage(Room room, Map<String, Object> msg) {

        /* 0 未开始  1 一开始*/
//        List<JSONObject> objects = seatRepository.findRoomInfo(room.getSerial());
        List<SeatUserListDto> objects = seatMapper.listRoomInfo(room.getId());
        System.out.println("objects:" + objects);
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.parseInt(msg.get("roomId").toString())),
                FriedFlowerJsonObject.room(Integer.parseInt(msg.get("type").toString())-1 , objects));
    }

    @Override
    public int selSeatHavePeople(long roomId, long seatId) {
//        return roomRepository.selSeatHavePeople(roomSerial, seatSerial);
        return roomMapper.selSeatHavePeople(roomId, seatId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int SaveUserSitDown(long userId, long seatId,long roomId) {

        return  seatMapper.saveUserSitDown(userId,seatId,roomId);
    }

    @Override
    public void sendUserSitDown(int type, long roomId, long userId, long seatId) {
        //查询数据库实体
        User user = userMapper.selectByPrimaryKey(userId);
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.userSitDown(type, String.valueOf(userId), String.valueOf(seatId), user.getHeadPortrait(),user.getNickName(),String.valueOf(user.getIntegral())));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int saveUserSetOut(long roomId, long userId, long seatId) {
//        return  seatRepository.saveUserSetOut(roomSerial,userCode,seatSerial);
       return seatMapper.updateUserSetOut(roomId,userId,seatId,System.currentTimeMillis());
    }


    @Override
    public void sendUserSetOut(int type, long roomId, long seatId) {
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.userSetOut(type,String.valueOf(seatId)));
    }

    @Override
    public List<SeatUserDto> selGmaeStartCondition(long roomId) {
//        return  seatRepository.selGmaeStartCondition(roomSerial);
        return  seatMapper.selGmaeStartCondition(roomId);
    }

    @Override
    public void sendAndSaveGmaeStart(long roomId,List<SeatUserDto> countMap,List<SeatUserDto> SeatUserDtoCountSetOut) {
        long timeMillis = System.currentTimeMillis();
        //改变座位的状态
        int seatStatusOne =  seatMapper.updateSeatStatus(roomId,EnumUtils.SEAT_STATUS_ENUM.FREE.getValue(),EnumUtils.SEAT_STATUS_ENUM.IS_NOT_GAME.getValue(),timeMillis);
        int seatStatusTwo =  seatMapper.updateSeatStatus(roomId,EnumUtils.SEAT_STATUS_ENUM.READY.getValue(),EnumUtils.SEAT_STATUS_ENUM.IS_GAME.getValue(),timeMillis);

        //使用有人数下限制的发牌器
        PlayerProvider playerProvider = new LimitedPlayerProvider();
        //使用花色不参与牌大小比较的计算器
        PlayerComparator playerComparator = new PlayerComparator(new NonFlowerValueCalculator());
        //创建多副牌
        List<Player> players = playerProvider.getPlayers(SeatUserDtoCountSetOut.size());
        /*输出每个角色的所有*/
        System.err.println("Player:"+players);
        //算好牌值
        playerComparator.sortUnRegularPlayers(players);
        /*输出每个角色的所有算好牌值*/
        System.err.println("Player:"+players);
        //这里打乱下用户数组的数据  和牌的数据再插入到数据库
        players= DisorganizeUtil.disorganizePlayers(players);

        //1.插入牌局数据 t_gambling 表
        Gambling gambling = new Gambling();
        gambling.setId(SnowUtils.generateId());
        gambling.setCreateTime(System.currentTimeMillis());
        gambling.setUpdateTime(System.currentTimeMillis());
        gambling.setVersion(1l);
        gambling.setRound(1);
        gambling.setRoomId((long)roomId);
        gambling.setGamblingStatus(EnumUtils.GAMBLING_STATUS_ENUM.PROCEED.getValue());
        gambling.setIntegralFundus(GamblingDefault.INTEGRAL_FUNDUS);
        gambling.setIntegralSum(GamblingDefault.INTEGRAL_FUNDUS*SeatUserDtoCountSetOut.size());
        int insert = gamblingMapper.insert(gambling);

        List<GamblingMessage> gamblingMessageList = Lists.newArrayList();
        List<GamblingBoard> gamblingBoardList = Lists.newArrayList();
        //生成是庄家的userId ,用userId进行判断
        int bankerIndex = new Random().nextInt(SeatUserDtoCountSetOut.size());
        List<Long> collect = SeatUserDtoCountSetOut.stream().map(p -> p.getUserId()).collect(Collectors.toList());
        Long[] userIds = collect.toArray(new Long[collect.size()]);
        long bankerUser =  userIds[bankerIndex];
        int numPayle =0;
        for (int i=0;i<countMap.size();i++){
            //2.插入牌局信息数据 t_gambling_message
            //庄家座位暂时处理成随机
            SeatUserDto sud = countMap.get(i);
            GamblingMessage gm = new GamblingMessage();
            gm.setId(SnowUtils.generateId());
            gm.setCreateTime(System.currentTimeMillis());
            gm.setUpdateTime(System.currentTimeMillis());
            gm.setVersion(1l);
            gm.setGamblingId(gambling.getId());
            gm.setUserId(sud.getUserId());
            gm.setSeatId(sud.getId());
            gm.setIsBanker(sud.getUserId().equals(bankerUser)?EnumUtils.JUDGE_ENUM.YES.getValue():EnumUtils.JUDGE_ENUM.NO.getValue());
            gm.setIsTurn(sud.getUserId().equals(bankerUser)?EnumUtils.JUDGE_ENUM.YES.getValue():EnumUtils.JUDGE_ENUM.NO.getValue());
            gm.setSeeCardStatus(EnumUtils.JUDGE_ENUM.NO.getValue());

            if (sud.getUserId()==GamblingDefault.LONG_ZERO){
                gm.setIsUser(EnumUtils.JUDGE_ENUM.NO.getValue());
                gm.setGameStatus(EnumUtils.GAME_STATUS_ENUM.NO_BODY.getValue());
            }else {
                gm.setIsUser(EnumUtils.JUDGE_ENUM.YES.getValue());
                gm.setGameStatus(EnumUtils.GAME_STATUS_ENUM.NORMAL.getValue());
                //如有有角色还要添加牌局的牌
                //3.插入牌局牌信息表
                GamblingBoard gb = new GamblingBoard();
                Player player = players.get(numPayle);
                gb.setId(SnowUtils.generateId());
                gb.setCreateTime(System.currentTimeMillis());
                gb.setUpdateTime(System.currentTimeMillis());
                gb.setVersion(1l);
                gb.setGamblingMessageId(gm.getId());
                gb.setBoardSize((long) player.getValue());
                gb.setBoardType(player.getType());
                gb.setIsSpecial(player.isSpecial()? EnumUtils.JUDGE_ENUM.YES.getValue():EnumUtils.JUDGE_ENUM.NO.getValue());
                gb.setIsA32(player.isA32()?EnumUtils.JUDGE_ENUM.YES.getValue():EnumUtils.JUDGE_ENUM.NO.getValue());
                gb.setFirstBoardColor(player.getCards()[0].getFlower());
                gb.setFirstBoardNumber(player.getCards()[0].getNumber());
                gb.setSecondBoardColor(player.getCards()[1].getFlower());
                gb.setSecondBoardNumber(player.getCards()[1].getNumber());
                gb.setThirdlyBoardColor(player.getCards()[2].getFlower());
                gb.setThirdlyBoardNumber(player.getCards()[2].getNumber());
                gamblingBoardList.add(gb);
                numPayle+=1;
            }
            gamblingMessageList.add(gm);

        }
        int i = gamblingMessageMapper.insertGamblingMessageList(gamblingMessageList);
        int j =gamblingBoardMapper.insertGamblingBoardList(gamblingBoardList);

        //4.插入牌局信息开局底注信息
        List<GamblingDetails> gamblingDetailsList = Lists.newArrayList();
        SeatUserDtoCountSetOut.forEach(a->{
            GamblingDetails gd = new GamblingDetails();
            gd.setId(SnowUtils.generateId());
            gd.setCreateTime(System.currentTimeMillis());
            gd.setUpdateTime(System.currentTimeMillis());
            gd.setVersion(1l);
            gd.setGamblingId(gambling.getId());
            gd.setCompareUserId(GamblingDefault.LONG_ZERO);
            gd.setOperationType(EnumUtils.OPERATION_ENUM.START_ADD.getValue());
            gd.setOperatingLeverage(GamblingDefault.INTEGRAL_FUNDUS);
            gd.setRound(GamblingDefault.INT_ZERO);
            gd.setSeatId(a.getId());
            gd.setUserId(a.getUserId());
            gd.setSort(GamblingDefault.INT_ZERO);
            gamblingDetailsList.add(gd);
            //5.减少用户积分
            int num= userMapper.updateUserIntegral(a.getUserId(),1l);
            if (num<1){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        int k =gamblingDetailsMapper.insertGamblingDetailsList(gamblingDetailsList);
        //校验插入的数据是否正常
        if (insert!=1 ||
                i<countMap.size() ||
                j<SeatUserDtoCountSetOut.size() ||
                k<SeatUserDtoCountSetOut.size()
        ){
            try {
                throw  new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //查询这个房间的全部信息
        RoomMsgVo roomMsgVo = new RoomMsgVo();
        RoomMsgDto roomMsgDto = gamblingMapper.getRoomMsgByRoomId(roomId);
        if (ValidateUtil.isEmpty(roomMsgDto)){
            LOGGER.error("错误信息为 [{}]","roomMsgDto为空");
            return;
        }
        BeanUtils.copyProperties(roomMsgDto,roomMsgVo);

        List<RoomChildMsgDto> roomChildMsgDtoList = gamblingMapper.listRoomMsgByGamblingId(roomMsgDto.getGamblingId());
        if (ValidateUtil.isEmpty(roomChildMsgDtoList)){
            LOGGER.error("错误信息为 [{}]","roomChildMsgDtoList为空");
            return;
        }
        roomChildMsgDtoList.forEach(a->{
            RoomChildMsgVo roomChildMsgVo = new RoomChildMsgVo();
            BeanUtils.copyProperties(a,roomChildMsgVo);
            roomMsgVo.getRoomChildMsgVoList().add(roomChildMsgVo);
        });

//        gamblingMapper

        //发送全局消息
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.gameStart(11,roomMsgVo));
    }



    @Override
    public int updateUserSeeCard(long userId, long gamblingId, int type, long roomId,int round,long seatId ,int sort) {
         //修改状态
        int num = gamblingMessageMapper.updateSeeCard(userId,1,gamblingId);

            //添加牌局详情用户操作
            GamblingDetails gamblingDetails = new GamblingDetails();
            gamblingDetails.setId(SnowUtils.generateId());
            gamblingDetails.setCreateTime(System.currentTimeMillis());
            gamblingDetails.setUpdateTime(System.currentTimeMillis());
            gamblingDetails.setVersion(1l);
            gamblingDetails.setGamblingId(gamblingId);
            gamblingDetails.setCompareUserId(0l);
            gamblingDetails.setOperationType(EnumUtils.OPERATION_ENUM.SEE_CARD.getValue());
            gamblingDetails.setOperatingLeverage(0l);
            gamblingDetails.setRound(round);
            gamblingDetails.setSeatId(seatId);
            gamblingDetails.setUserId(userId);
            gamblingDetails.setSort(sort);
            int insert = gamblingDetailsMapper.insert(gamblingDetails);
        num= num+insert;


        return num;
    }

    @Override
    public void sendUserSeeCard(int type, long roomId, long gamblingId, long userId,long seatId) {
    //发送全局消息
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.userSeeCard(
                        type,String.valueOf(userId),String.valueOf(seatId))
        );
    }

    @Override
    public int addUserWithChip(long userId, long gamblingId, int type, long roomId, int round, long seatId, long integralFundus ,int sort) {
        GamblingDetails gamblingDetails = new GamblingDetails();
        gamblingDetails.setId(SnowUtils.generateId());
        gamblingDetails.setCreateTime(System.currentTimeMillis());
        gamblingDetails.setUpdateTime(System.currentTimeMillis());
        gamblingDetails.setVersion(1l);
        gamblingDetails.setGamblingId(gamblingId);
        gamblingDetails.setCompareUserId(0l);
        if (type==7){
            gamblingDetails.setOperationType(EnumUtils.OPERATION_ENUM.FOLLOW_CARD.getValue());
        }else {
            gamblingDetails.setOperationType(EnumUtils.OPERATION_ENUM.ADD_CARD.getValue());
        }
        gamblingDetails.setOperatingLeverage(0l);
        gamblingDetails.setRound(round);
        gamblingDetails.setSeatId(seatId);
        gamblingDetails.setUserId(userId);
        gamblingDetails.setSort(sort);
        int insert = gamblingDetailsMapper.insert(gamblingDetails);
        //减少用户积分
        int userNum =  userMapper.updateUserIntegral(userId,-integralFundus);
        return insert+userNum;
    }

    @Override
    public void sendAddUserWithChip(int type, long roomId, long gamblingId, long userId, long seatId, long integralFundus,int roundNum ,long trueUserId) {

        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.userWithChip(
                        type,String.valueOf(userId),String.valueOf(seatId),String.valueOf(integralFundus),roundNum,String.valueOf(trueUserId))
        );
    }

    @Override
    public int addUserDisCard(int type, long roomId, long seatId, long gamblingId, int round, int sort,long userId) {
        GamblingDetails gamblingDetails = new GamblingDetails();
        gamblingDetails.setId(SnowUtils.generateId());
        gamblingDetails.setCreateTime(System.currentTimeMillis());
        gamblingDetails.setUpdateTime(System.currentTimeMillis());
        gamblingDetails.setVersion(1l);
        gamblingDetails.setGamblingId(gamblingId);
        gamblingDetails.setCompareUserId(0l);
        gamblingDetails.setOperationType(EnumUtils.OPERATION_ENUM.DIS_CARD.getValue());
        gamblingDetails.setOperatingLeverage(0l);
        gamblingDetails.setRound(round);
        gamblingDetails.setSeatId(seatId);
        gamblingDetails.setUserId(userId);
        gamblingDetails.setSort(sort);
        int insert = gamblingDetailsMapper.insert(gamblingDetails);
        int num =  gamblingMessageMapper.updateGameStatus(userId,EnumUtils.GAME_STATUS_ENUM.DIS_BOARD.getValue(),gamblingId);
        return insert+num;
    }

    @Override
    public void sendUserDisCard(int type, long roomId, long seatId, long gamblingId, int roundNum,long userId, long trueUserId) {
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                FriedFlowerJsonObject.userDisCard(
                        type,String.valueOf(userId),String.valueOf(seatId),roundNum,String.valueOf(trueUserId))
        );
    }

    @Override
    public JSONObject compareThanCard(long userId, long gamblingId, int type, long roomId, int round, long seatId, int sort, long beUserId,long integralFundus) {
        GamblingDetails gamblingDetails = new GamblingDetails();
        gamblingDetails.setId(SnowUtils.generateId());
        gamblingDetails.setCreateTime(System.currentTimeMillis());
        gamblingDetails.setUpdateTime(System.currentTimeMillis());
        gamblingDetails.setVersion(1l);
        gamblingDetails.setGamblingId(gamblingId);
        gamblingDetails.setCompareUserId(beUserId);
        gamblingDetails.setOperationType(EnumUtils.OPERATION_ENUM.COMPARE_CARD.getValue());
        gamblingDetails.setOperatingLeverage(integralFundus);
        gamblingDetails.setRound(round);
        gamblingDetails.setSeatId(seatId);
        gamblingDetails.setUserId(userId);
        gamblingDetails.setSort(sort);
        int insert = gamblingDetailsMapper.insert(gamblingDetails);
        //根据比牌结果 改变牌局信息
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add(String.valueOf(userId));
        stringJoiner.add(String.valueOf(beUserId));
        String userIds = stringJoiner.toString();
        List<userCompareBoardDto> userCompareBoardDtoList = gamblingBoardMapper.selectByUserIds(gamblingId,userIds);
        userCompareBoardDto userCompareBoardDto = userCompareBoardDtoList.stream()
                .min(Comparator.comparing(com.wegame.dto.userCompareBoardDto::getBoardSize)).get();
        int gamblingMsgNum = gamblingMessageMapper.updateGameStatus(Long.valueOf(userCompareBoardDto.getUserId()),EnumUtils.GAME_STATUS_ENUM.COMPARE_LOSE.getValue(),gamblingId);

       JSONObject jsb = new JSONObject();
       jsb.put("num",insert+gamblingMsgNum);
       jsb.put("loseUserId",userCompareBoardDto.getUserId());

        int userNum =  userMapper.updateUserIntegral(userId,-integralFundus);
        return jsb;


    }

    @Override
    public void sendUserThanCard(int type, long roomId, long gamblingId, long userId, long seatId, Integer round, Long trueUserId,String loseUserId,long integralFundus,long beUserId) {

            //进行发送消息操作
            template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                    FriedFlowerJsonObject.userThanCard(
                            type,String.valueOf(userId),String.valueOf(seatId),round,String.valueOf(trueUserId),loseUserId,String.valueOf(integralFundus),String.valueOf(beUserId))
            );
    }

    @Override
    public void updateSeatUser() {
        seatMapper.updateCleanUser();
    }


    @Override
    public void examineGameOver(long gamblingId,long roomId) {
        int num = gamblingMapper.selectGamblingGameNormal(gamblingId);
        /* 小于等于1表示游戏结束了 ，要进行的操作如下
        *       1.修改房间状态
        *       2.修改座位状态
        *       3.修改牌局状态
        *       4.改变最后一个用户胜利
        *       5.添加牌局统计
        *       6.更改用户积分*/
        if (num<=1){
            long systemTimer = System.currentTimeMillis();
            /*1-4*/
            int roomNum = roomMapper.updateRoomStatusByGamblingId(gamblingId,EnumUtils.ROOM_STATUS_ENUM.NOT_START.getValue(),systemTimer);
            int seatNumOne = seatMapper.updateSeatStatusByGamblingId(gamblingId,EnumUtils.SEAT_STATUS_ENUM.IS_GAME.getValue(),EnumUtils.SEAT_STATUS_ENUM.NOT_READY.getValue(),systemTimer);
            int seatNumTwo = seatMapper.updateSeatStatusByGamblingId(gamblingId,EnumUtils.SEAT_STATUS_ENUM.IS_NOT_GAME.getValue(),EnumUtils.SEAT_STATUS_ENUM.FREE.getValue(),systemTimer);
            int gamblingNum = gamblingMapper.updateStatusByGamblingId(gamblingId,EnumUtils.GAMBLING_STATUS_ENUM.END.getValue(),systemTimer);
            int gamblingMessageNum =  gamblingMessageMapper.updateGameStatusByWin(gamblingId,EnumUtils.GAME_STATUS_ENUM.NORMAL.getValue(),EnumUtils.GAME_STATUS_ENUM.WIN.getValue(),systemTimer);
            /*5*/
            List<GamblingMessage> gamblingMessageList = gamblingMessageMapper.selectByGamblingId(gamblingId);
            List<GamblingDetails> gamblingDetailsList = gamblingDetailsMapper.selectByGamblingId(gamblingId);
            List<GamblingMessage> collect = gamblingMessageList.stream().filter(p -> p.getIsUser().equals(EnumUtils.JUDGE_ENUM.YES.getValue())).collect(Collectors.toList());

            List<GamblingStatistics> gamblingStatisticsList = Lists.newArrayList();

            collect.forEach(a->{
                GamblingStatistics gs = new GamblingStatistics();
                gs.setId(SnowUtils.generateId());
                gs.setCreateTime(System.currentTimeMillis());
                gs.setUpdateTime(System.currentTimeMillis());
                gs.setVersion(1l);
                gs.setGamblingId(gamblingId);
                gs.setSeatId(a.getSeatId());
                gs.setUserId(a.getUserId());
                gs.setStartTime(System.currentTimeMillis());
                gs.setEndTime(System.currentTimeMillis());
                //如果是胜利者
                if (a.getGameStatus().equals(EnumUtils.GAME_STATUS_ENUM.WIN.getValue())){
                    gs.setIsWin(EnumUtils.JUDGE_ENUM.YES.getValue());

                    Long winMoney = gamblingDetailsList.stream()
                            .filter(p -> !p.getUserId().equals(a.getUserId()))
                            .collect(Collectors.summingLong(p -> p.getOperatingLeverage()));
                    gs.setIntegral(winMoney);
                    /*6*/
                    int userNum = userMapper.updateUserIntegral(a.getUserId(), winMoney);

                }else {
                    gs.setIsWin(EnumUtils.JUDGE_ENUM.NO.getValue());
                    Long loseMoney = gamblingDetailsList.stream()
                            .filter(p -> p.getUserId().equals(a.getUserId()))
                            .collect(Collectors.summingLong(p -> p.getOperatingLeverage()));
                    loseMoney =-loseMoney;
                    gs.setIntegral(loseMoney);
                }
                gamblingStatisticsList.add(gs);
            });
           int gamblingStatisicsNum =  gamblingStatisticsMapper.insertAll(gamblingStatisticsList);

            List<SeatUserListDto> seatUserListDtoList = seatMapper.listRoomInfo(roomId);
            String winUserId = collect.stream().filter(p -> p.getGameStatus().equals(EnumUtils.GAME_STATUS_ENUM.WIN.getValue()))
                    .map(p -> String.valueOf(p.getUserId()))
                    .collect(Collectors.joining(","));
            String winUserNickName = seatUserListDtoList.stream().filter(p -> String.valueOf(p.getUserId()).equals(winUserId))
                    .map(p -> p.getUserNickName())
                    .collect(Collectors.joining(","));
            //发送游戏结束即时通讯
            template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.valueOf(String.valueOf(roomId))),
                    FriedFlowerJsonObject.gameOver(
                            12,seatUserListDtoList,winUserNickName)
            );
        }
    }



    @Override
    public JSONObject changGeRound(long gamblingId) {
        JSONObject jsonObject  = new JSONObject();
        //牌局信息
        List<GamblingMessage> gamblingMessageList = gamblingMessageMapper.selectByGamblingId(gamblingId);
        //最后一次操作信息
        GamblingDetails gamblingDetails =   gamblingDetailsMapper.selectByGamblingIdLastRound(gamblingId);
        //找出庄家座位
        String bankSeatId = gamblingMessageList.stream()
                .filter(p -> p.getIsBanker() == 1)
                .map(p -> String.valueOf(p.getSeatId())).limit(1)
                .collect(Collectors.joining(","));
        Long seatId = gamblingDetails.getSeatId();
        Long collect =0l;

        Long userNum = gamblingMessageList.stream()
                .filter(p -> p.getIsUser() == 1)
                .collect(Collectors.counting());
        if (userNum==2){
            collect=0l;
        }else {
            if (Long.valueOf(bankSeatId)>gamblingDetails.getSeatId()){
                collect = gamblingMessageList.stream()
                        .filter(p -> p.getSeatId() > seatId && p.getSeatId()< Long.valueOf(bankSeatId)
                                && p.getIsUser() == 1 && p.getGameStatus() == 3)
                        .collect(Collectors.counting());

            }else if (Long.valueOf(bankSeatId)<gamblingDetails.getSeatId() ) {
                collect = gamblingMessageList.stream()
                        .filter( p -> (p.getSeatId() > seatId || p.getSeatId() <Long.valueOf(bankSeatId))
                                && p.getIsUser() == 1 && p.getGameStatus() == 3)
                        .collect(Collectors.counting());
            }else {
                collect=1l;
            }
        }




        int round = gamblingDetails.getRound();
        if (collect==0){
            int num = gamblingMapper.updateRoundByGamblingId(gamblingId);
            if (num<=0){
                try {
                    throw  new Exception("更改牌局轮次错误");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            round+=1;
        }

        jsonObject.put("round",round);

        long trueUserId =0l;
        Optional<GamblingMessage> gamblingMessage = gamblingMessageList.stream().
                filter(p -> p.getIsUser() == 1 && p.getSeatId() > seatId
                        && p.getGameStatus() == EnumUtils.GAME_STATUS_ENUM.NORMAL.getValue())
                .min(Comparator.comparingLong(GamblingMessage::getSeatId));

        if ( gamblingMessage.isPresent()){
            trueUserId = gamblingMessage.get().getUserId();
        }else {
            Optional<GamblingMessage> gamblingMessage1 = gamblingMessageList.stream().
                    filter(p -> p.getIsUser() == 1 && p.getSeatId() < seatId
                            && p.getGameStatus() == EnumUtils.GAME_STATUS_ENUM.NORMAL.getValue())
                    .min(Comparator.comparingLong(GamblingMessage::getSeatId));
            if (gamblingMessage1.isPresent()){
                trueUserId=gamblingMessage1.get().getUserId();
            }
        }
        if (0!=trueUserId){
            gamblingMessageMapper.updateIsTrue(gamblingId,EnumUtils.JUDGE_ENUM.NO.getValue(),0l);
            gamblingMessageMapper.updateIsTrue(gamblingId,EnumUtils.JUDGE_ENUM.YES.getValue(),trueUserId);
        }

        jsonObject.put("trueUserId",trueUserId);

        return jsonObject;
    }



}
