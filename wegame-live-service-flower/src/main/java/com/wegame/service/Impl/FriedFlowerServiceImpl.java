package com.wegame.service.Impl;
import com.google.common.collect.Lists;
import com.wegame.dto.RoomMsgDto;
import com.wegame.dto.SeatUserDto;
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
import com.wegame.vo.Message;
import com.wegame.vo.RoomMsgVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
        List<SeatUserEntity> objects = seatMapper.listRoomInfo(room.getId());
        System.out.println("objects:" + objects);
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(Integer.parseInt(msg.get("roomId").toString())),
                FriedFlowerJsonObject.room(Integer.parseInt(msg.get("type").toString())-1 , objects));
    }

    @Override
    public int selSeatHavePeople(int roomId, int seatId) {
//        return roomRepository.selSeatHavePeople(roomSerial, seatSerial);
        return roomMapper.selSeatHavePeople(roomId, seatId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int SaveUserSitDown(int userId, int seatId,int roomId) {
//        return seatRepository.saveUserSitDown(userId,seatId,roomId);
        return  1;
    }

    @Override
    public void sendUserSitDown(int type, int roomId, int userId, int seatId, String userImg, String userNickName, int integral) {
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(roomId),
                FriedFlowerJsonObject.userSitDown(type, userId, seatId, userImg,userNickName,integral));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int saveUserSetOut(int roomId, int userId, int seatId) {
//        return  seatRepository.saveUserSetOut(roomSerial,userCode,seatSerial);
       return seatMapper.updateUserSetOut(roomId,userId,seatId,System.currentTimeMillis());
    }


    @Override
    public void sendUserSetOut(int type, int roomId, int seatId) {
        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(roomId),
                FriedFlowerJsonObject.userSetOut(type,seatId));
    }

    @Override
    public List<SeatUserDto> selGmaeStartCondition(int roomId) {
//        return  seatRepository.selGmaeStartCondition(roomSerial);
        return  seatMapper.selGmaeStartCondition(roomId);
    }

    @Override
    public void sendAndSaveGmaeStart(int roomId,List<SeatUserDto> SeatUserDtoCount,List<SeatUserDto> SeatUserDtoCountSetOut) {
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
        gambling.setRoomId((long)roomId);
        gambling.setGamblingStatus(EnumUtils.GAMBLING_STATUS_ENUM.PROCEED.getValue());
        gambling.setIntegralFundus(GamblingDefault.INTEGRAL_FUNDUS);
        gambling.setIntegralSum(GamblingDefault.INTEGRAL_FUNDUS*SeatUserDtoCountSetOut.size());
        int insert = gamblingMapper.insert(gambling);

        List<GamblingMessage> gamblingMessageList = Lists.newArrayList();
        List<GamblingBoard> gamblingBoardList = Lists.newArrayList();
        int bankerIndex = new Random().nextInt(SeatUserDtoCountSetOut.size());
        for (int i=0;i<SeatUserDtoCount.size();i++){
            //2.插入牌局信息数据 t_gambling_message
            //庄家座位暂时处理成随机
            SeatUserDto sud = SeatUserDtoCount.get(i);
            GamblingMessage gm = new GamblingMessage();
            gm.setId(SnowUtils.generateId());
            gm.setCreateTime(System.currentTimeMillis());
            gm.setUpdateTime(System.currentTimeMillis());
            gm.setVersion(1l);
            gm.setGamblingId(gambling.getId());
            gm.setUserId(sud.getUserId());
            gm.setSeatId(sud.getId());
            gm.setIsBanker(bankerIndex==i?EnumUtils.JUDGE_ENUM.YES.getValue():EnumUtils.JUDGE_ENUM.NO.getValue());
            gm.setSeeCardStatus(EnumUtils.JUDGE_ENUM.NO.getValue());
            gm.setGameStatus(EnumUtils.GAMBLING_STATUS_ENUM.PROCEED.getValue());
            if (sud.getUserId()==GamblingDefault.LONG_ZERO){
                gm.setIsUser(EnumUtils.JUDGE_ENUM.NO.getValue());
            }else {
                gm.setIsUser(EnumUtils.JUDGE_ENUM.YES.getValue());
                //如有有角色还要添加牌局的牌
                //3.插入牌局牌信息表
                GamblingBoard gb = new GamblingBoard();
                Player player = players.get(i);
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
                i<SeatUserDtoCount.size() ||
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
        BeanUtils.copyProperties(roomMsgDto,roomMsgVo);

        //发送全局消息
//        template.convertAndSend("/friedFlowerServer/" + FriedFlowerJsonObject.serial(roomId),
//                FriedFlowerJsonObject.gameStart(11,));
    }

}
