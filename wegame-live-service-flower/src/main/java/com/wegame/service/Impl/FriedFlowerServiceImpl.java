package com.wegame.service.Impl;
import com.google.common.collect.Lists;
import com.wegame.dto.SeatUserDto;
import com.wegame.entity.SeatUserEntity;
//import com.wegame.mapper.BoardMapper;
import com.wegame.mapper.*;
import com.wegame.model.Gambling;
import com.wegame.model.GamblingDetails;
import com.wegame.model.GamblingMessage;
import com.wegame.model.Room;
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
import com.wegame.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        gambling.setRoomId((long)roomId);
        gambling.setGamblingStatus(EnumUtils.GAMBLING_STATUS_ENUM.PROCEED.getValue());
        gambling.setIntegralFundus(GamblingDefault.INTEGRAL_FUNDUS);
        gambling.setIntegralSum(GamblingDefault.INTEGRAL_SUM);
        gamblingMapper.insert(gambling);

        //2.插入牌局信息数据 t_gambling_message
            //庄家座位暂时处理成随机
        int bankerIndex = new Random().nextInt(SeatUserDtoCountSetOut.size());
        List<GamblingMessage> gamblingMessageList = Lists.newArrayList();
        for (int i=0;i<SeatUserDtoCount.size();i++){
            SeatUserDto sud = SeatUserDtoCount.get(i);
            GamblingMessage gamblingMessage = new GamblingMessage();
            gamblingMessage.setGamblingId(gambling.getId());
            gamblingMessage.setUserId(sud.getUserId());
            gamblingMessage.setSeatId(sud.getId());
            if (bankerIndex==i){
                gamblingMessage.setIsBanker(EnumUtils.JUDGE_ENUM.YES.getValue());
            }else {
                gamblingMessage.setIsBanker(EnumUtils.JUDGE_ENUM.NO.getValue());
            }
            if (sud.getUserId()==GamblingDefault.LONG_ZERO){
                gamblingMessage.setIsUser(EnumUtils.JUDGE_ENUM.NO.getValue());
            }else {
                gamblingMessage.setIsUser(EnumUtils.JUDGE_ENUM.YES.getValue());
            }
            gamblingMessage.setSeeCardStatus(EnumUtils.JUDGE_ENUM.NO.getValue());
            gamblingMessage.setGameStatus(EnumUtils.GAMBLING_STATUS_ENUM.PROCEED.getValue());
            gamblingMessageList.add(gamblingMessage);
        }
        int i = gamblingMessageMapper.insertGamblingMessageList(gamblingMessageList);

//        Lists List<GamblingMessage> gamblingMessageList
//        GamblingMessage gamblingMessage = new GamblingMessage();




        //3.插入牌局牌信息牌
        //4.插入牌局信息开局底注信息
        //5.减少用户积分
        //4.返回信息给控制层



        //拼接数据

//        List<Board> boards = new ArrayList<>();
//        Board board ;
//        for (Player p : players){
//            board = new Board();
//            Card[] cards = p.getCards();
//            board.setFirstBoardValue(cards[0].getNumber());
//            board.setFirstBoardColor(cards[0].getFlower());
//            board.setSecondBoardValue(cards[1].getNumber());
//            board.setSecondBoardColor(cards[1].getFlower());
//            board.setThirdlyBoardValue(cards[2].getNumber());
//            board.setThirdlyBoardColor(cards[2].getFlower());
//            board.setType(p.getType());
//            board.setSize((long) p.getValue());
//            boards.add(board);
//        }
//        /*存入数据库*/
//        int num =  boardMapper.insertAll(boards);  //待测试


    }

}
