package com.wegame.mapper;

import com.wegame.model.Room;
import com.wegame.provider.RoomSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMapper {
    @Insert({
        "insert into t_room (id, create_date, ",
        "last_modified_time, version, ",
        "room_name, serial, ",
        "status)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{roomName,jdbcType=VARCHAR}, #{serial,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(Room record);

    @InsertProvider(type=RoomSqlProvider.class, method="insertSelective")
    int insertSelective(Room record);

    @Select("select r from Room r where r.serial = #{roomSerial,jdbcType=INTEGER}")
    Room findRoomMessageByRoomSerial(Integer roomSerial);

    /**
     * 查询这个位置是否有人（0 没人  1有人）
     * @param roomSerial
     * @param seatSerial
     * @return
     */
    @Select("SELECT count(*) \n" +
            "from t_seat s \n" +
            "INNER JOIN t_room r\n" +
            "on s.ROOMID = r.ID AND r.SERIAL = #{roomSerial,jdbcType=INTEGER}\n" +
            "where s.SERIAL = #{seatSerial,jdbcType=INTEGER}\n" +
            "AND s.userCode IS NOT NULL")
    int selSeatHavePeople(int roomSerial, int seatSerial);
}
