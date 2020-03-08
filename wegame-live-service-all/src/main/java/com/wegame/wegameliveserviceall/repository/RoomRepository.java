package com.wegame.wegameliveserviceall.repository;

import com.wegame.wegameliveserviceall.entity.Room;
import com.wegame.wegameliveserviceall.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

/**
 * @InterfaceName：RoomRepository
 * @Description: 房间
 * @Author：13738700108
 * @Data 2020/2/29 0:45
 * @Version: v1.0
 **/
public interface RoomRepository extends JpaRepositoryImplementation<Room,String> {

    @Query("select r from Room r where r.serial = ?1")
    Room findRoomMessageByRoomSerial(int roomSerial);

}
