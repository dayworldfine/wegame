//package com.wegame.mapper;
//
//import com.wegame.wegameliveserviceall.entity.Room;
//import com.wegame.wegameliveserviceall.entity.Seat;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
//
//import java.util.List;
//
///**
// * @InterfaceName：RoomRepository
// * @Description: 房间
// * @Author：13738700108
// * @Data 2020/2/29 0:45
// * @Version: v1.0
// **/
//public interface RoomRepository extends JpaRepositoryImplementation<Room,String> {
//
//    /**
//     * 查询这个座位所在的房间
//     * @param roomSerial
//     * @return
//     */
//    @Query("select r from Room r where r.serial = ?1")
//    Room findRoomMessageByRoomSerial(int roomSerial);
//
//    /**
//     * 查询这个位置是否有人（0 没人  1有人）
//     * @param roomSerial
//     * @param seatSerial
//     * @return
//     */
//    @Query(value = "SELECT count(*) \n" +
//            "from t_seat s \n" +
//            "INNER JOIN t_room r\n" +
//            "on s.ROOMID = r.ID AND r.SERIAL =?1\n" +
//            "where s.SERIAL = ?2\n" +
//            "AND s.userCode IS NOT NULL",nativeQuery = true)
//    int selSeatHavePeople(int roomSerial, int seatSerial);
//}
