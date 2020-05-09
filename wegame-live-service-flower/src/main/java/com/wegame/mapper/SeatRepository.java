//package com.wegame.mapper;
//
//import com.alibaba.fastjson.JSONObject;
//import com.wegame.wegameliveserviceall.entity.Room;
//import com.wegame.wegameliveserviceall.entity.Seat;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @InterfaceName：SeatRepository
// * @Description: 座位实现
// * @Author：13738700108
// * @Data 2020/2/29 23:33
// * @Version: v1.0
// **/
//@Repository
//public interface SeatRepository extends JpaRepositoryImplementation<Seat,String> {
//
//    /**
//     * 根据房间查询座位
//     * @param room
//     * @return
//     */
//    @Query("select s from Seat s where s.room = ?1")
//    List<Seat> findSeatsByRoom(Room room);
//
//
//    /**
//     * 查看房间信息
//     * @param serial
//     * @return
//     */
//    @Query(value = "SELECT u.Code as userCode, u.headPortrait as userImg, u.nickName as userNickName,\n" +
//            "s.SERIAL%6 as seatSerial, u.integral as integral, s.BOARDA as boardA ,\n" +
//            "s.BOARDB as boardB ,s.BOARDC as boardC , s.`STATUS` as status\n" +
//            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.ROOMID\n" +
//            "LEFT JOIN t_user u ON u.`CODE` = s.USERCODE\n" +
//            "WHERE r.SERIAL=?1",nativeQuery = true)
//    List<JSONObject> findRoomInfo(int serial);
//
//    /**
//     * 坐下
//     * @param userCode
//     * @return
//     */
//    @Modifying
//    @Query(value = "UPDATE t_seat t\n" +
//            "LEFT JOIN t_room r\n" +
//            "on t.ROOMID =r.ID\n" +
//            "set t.USERCODE=?1, t.`STATUS`=1\n" +
//            "WHERE t.SERIAL=?2\n" +
//            "AND r.SERIAL =?3\n" +
//            "AND USERCODE IS NULL \n",nativeQuery = true)
//    int saveUserSitDown(int userCode, int seatSerial, int roomSerial);
//
//    /**
//     * 准备
//     * @param roomSerial
//     * @param userCode
//     * @param seatSerial
//     * @return
//     */
//    @Modifying
//    @Query(value = "update t_seat t\n" +
//            "LEFT JOIN t_room r\n" +
//            "ON t.ROOMID = r.ID\n" +
//            "SET t.`STATUS` = 2\n" +
//            "WHERE r.SERIAL = (?1)\n" +
//            "AND t.USERCODE = (?2)\n" +
//            "AND t.SERIAL = (?3)\n" +
//            "AND t.`STATUS` !=2",nativeQuery = true)
//    int saveUserSetOut(int roomSerial, int userCode, int seatSerial);
//
//    /**
//     * 查询房间人数和已准备人数
//     * @param roomSerial
//     * @return
//     */
//    @Query(value = "SELECT \n" +
//            "SUM(CASE WHEN t.`STATUS` = 2 THEN 1 ELSE 0 END ) AS 'isSetOut',\n" +
//            "count(*) AS 'isAllOut'\n" +
//            "FROM t_seat t\n" +
//            "LEFT JOIN t_room r\n" +
//            "ON t.ROOMID = r.ID\n" +
//            "WHERE r.SERIAL =(?1)\n" +
//            "AND t.USERCODE IS NOT NULL",nativeQuery = true)
//    Map<String,Object> selGmaeStartCondition(int roomSerial);
//}
