package com.wegame.wegameliveserviceall.repository;

import com.alibaba.fastjson.JSONObject;
import com.wegame.wegameliveserviceall.entity.Room;
import com.wegame.wegameliveserviceall.entity.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName：SeatRepository
 * @Description: 座位实现
 * @Author：13738700108
 * @Data 2020/2/29 23:33
 * @Version: v1.0
 **/
@Repository
public interface SeatRepository extends JpaRepositoryImplementation<Seat,String> {

    /**
     * 根据房间查询座位
     * @param room
     * @return
     */
    @Query("select s from Seat s where s.room = ?1")
    List<Seat> findSeatsByRoom(Room room);

//    /**
//     * 查看已开始的房间信息
//     * @param serial
//     * @return
//     */
//    @Query(value = "SELECT gm.userCode , u.headPortrait ,u.nickName ,gm.seatSerial, u.integral, gm.board , gm.ending\n" +
//            "from t_room r RIGHT JOIN  t_gambling g ON r.SERIAL = g.ROOMSERIAL\n" +
//            "RIGHT JOIN t_gambling_message gm ON g.ID = gm.GAMBLINGID\n" +
//            "LEFT JOIN t_user u ON u.`CODE` = gm.USERCODE\n" +
//            "WHERE r.SERIAL=?1",nativeQuery = true)
//    List<JSONObject> findRoomIsStart(int serial);
//
//    /**
//     * 查看未开始的房间信息
//     * @param serial
//     * @return
//     */
//    @Query(value = "SELECT u.code , u.headPortrait, u.nickName, s.serial,u.integral,s.status\n" +
//            "FROM t_room r RIGHT JOIN t_seat s ON  r.ID=s.ROOMID\n" +
//            "RIGHT JOIN t_user u ON u.`CODE` = s.USERCODE \n" +
//            "WHERE  r.SERIAL= ?1",nativeQuery = true)
//    List<JSONObject> findRoomNoStart(int serial);

    /**
     * 查看房间信息
     * @param serial
     * @return
     */
    @Query(value = "SELECT u.Code as userCode, u.headPortrait as userImg, u.nickName as userNickName,\n" +
            "s.SERIAL as seatSerial, u.integral as integral, s.board as board , s.`STATUS` as status\n" +
            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.ROOMID\n" +
            "LEFT JOIN t_user u ON u.`CODE` = s.USERCODE\n" +
            "WHERE r.SERIAL=?1",nativeQuery = true)
    List<JSONObject> findRoomInfo(int serial);
}
