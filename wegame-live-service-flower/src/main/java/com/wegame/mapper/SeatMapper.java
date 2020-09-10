package com.wegame.mapper;

import com.wegame.dto.SeatUserDto;
import com.wegame.entity.SeatUserEntity;
import com.wegame.model.Seat;
import com.wegame.provider.SeatSqlProvider;
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

import java.util.List;
import java.util.Map;

@Repository
public interface SeatMapper {

    @Delete({
        "delete from t_seat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_seat (id, create_time, ",
        "update_time, version, ",
        "seat_status, room_id, ",
        "user_id)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{seatStatus,jdbcType=TINYINT}, #{roomId,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=BIGINT})"
    })
    int insert(Seat record);

    @InsertProvider(type= SeatSqlProvider.class, method="insertSelective")
    int insertSelective(Seat record);

    @Select({
        "select",
        "id, create_time, update_time, version, seat_status, room_id, user_id",
        "from t_seat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="seat_status", property="seatStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT)
    })
    Seat selectByPrimaryKey(Long id);

    @UpdateProvider(type=SeatSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Seat record);

    @Update({
        "update t_seat",
        "set create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "version = #{version,jdbcType=BIGINT},",
          "seat_status = #{seatStatus,jdbcType=TINYINT},",
          "room_id = #{roomId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Seat record);

    /**
     * 查看房间信息
     * @param roomId
     * @return
     */
    @Select("SELECT u.id as userId, u.head_portrait as userImg, u.nick_name as userNickName,\n" +
            "s.id as seatId, u.integral as integral, \n" +
            "s.seat_status as seatStatus\n" +
            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.room_id\n" +
            "LEFT JOIN t_user u ON u.id = s.user_id\n" +
            "WHERE r.id= #{roomId,jdbcType=INTEGER}")
    List<SeatUserEntity> listRoomInfo(long roomId);

    /**
     * 准备
     * @param roomId
     * @param userId
     * @param seatId
     * @return
     */
    @Update("update t_seat t\n" +
            "LEFT JOIN t_room r\n" +
            "ON t.room_id = r.ID\n" +
            "SET t.seat_status = 2, t.update_time= #{timeMillis,jdbcType=BIGINT}\n" +
            "WHERE r.id = #{roomId,jdbcType=INTEGER}\n" +
            "AND t.user_id = #{userId,jdbcType=INTEGER}\n" +
            "AND t.id = #{seatId,jdbcType=INTEGER}\n" +
            "AND t.seat_status !=2")
    int updateUserSetOut(int roomId, int userId, int seatId,long timeMillis);


    /**
     * 查询房间所有座位信息
     * @param roomId
     * @return
     */
    @Select("SELECT \n" +
            "t.id as id ,\n" +
            "t.seat_status as seatStatus,\n" +
            "t.user_id as userId\n" +
            "FROM\n" +
            "t_seat t \n" +
            "INNER JOIN t_room r \n" +
            "on t.room_id =r.id\n" +
            "WHERE r.id =#{roomId,jdbcType=BIGINT}")
    List<SeatUserDto> selGmaeStartCondition(int roomId);
}
