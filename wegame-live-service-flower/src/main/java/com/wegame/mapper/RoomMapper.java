package com.wegame.mapper;

import com.wegame.model.Room;
import com.wegame.provider.RoomSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMapper {
    @Delete({
        "delete from t_room",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_room (id, create_time, ",
        "update_time, version, ",
        "room_name, status)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{roomName,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT})"
    })
    int insert(Room record);

    @InsertProvider(type= RoomSqlProvider.class, method="insertSelective")
    int insertSelective(Room record);

    @Select({
        "select",
        "id, create_time, update_time, version, room_name, status",
        "from t_room",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="room_name", property="roomName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Room selectByPrimaryKey(Long id);

    @UpdateProvider(type=RoomSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Room record);

    @Update({
        "update t_room",
        "set create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "version = #{version,jdbcType=BIGINT},",
          "room_name = #{roomName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Room record);


    /**
     *
     * @param roomId
     * @return
     */
    @Select("select * from t_room r where r.id = #{roomSerial,jdbcType=INTEGER}")
    Room findRoomMessageByRoomSerial(Integer roomId);

    /**
     * 查询这个位置是否有人（0 没人  1有人）
     * @param roomId
     * @param seatId
     * @return
     */
    @Select("SELECT count(*) \n" +
            "from t_seat s \n" +
            "INNER JOIN t_room r\n" +
            "on s.room_id = r.id AND r.id = #{roomId,jdbcType=BIGINT}\n" +
            "where s.id = #{seatId,jdbcType=BIGINT}\n" +
            "AND s.user_id IS NOT NULL AND s.user_id !=0")
    int selSeatHavePeople(long roomId, long seatId);

    @Update({
            "update t_room ",
            "set status = #{status,jdbcType=INTEGER} ,update_time =#{systemTimer,jdbcType=BIGINT} ",
            "where id = (select room_id from t_gambling where id = #{gamblingId,jdbcType=BIGINT})"
    })
    int updateRoomStatusByGamblingId(long gamblingId, int status, long systemTimer);
}
