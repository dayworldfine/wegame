package com.wegame.mapper;

import com.wegame.entity.SeatUserEntity;
import com.wegame.model.Seat;
import com.wegame.provider.SeatSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SeatMapper {
    @Insert({
        "insert into t_seat (id, create_date, ",
        "last_modified_time, version, ",
        "serial, status, ",
        "room_id, user_code, ",
        "see_card)",
        "values (#{id,jdbcType=VARCHAR}, #{create_date,jdbcType=VARCHAR}, ",
        "#{last_modified_time,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{serial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{room_Id,jdbcType=VARCHAR}, #{user_code,jdbcType=INTEGER}, ",
        "#{see_card,jdbcType=INTEGER})"
    })
    int insert(Seat record);

    @InsertProvider(type=SeatSqlProvider.class, method="insertSelective")
    int insertSelective(Seat record);

    /**
      * 查看房间信息
      * @param serial
      * @return
      */
    @Select("SELECT u.code as user_code, u.head_portrait as userImg, u.nick_name as userNickName,\n" +
            "s.serial%6 as seatSerial, u.integral as integral, \n" +
            "s.status as status\n" +
            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.room_id\n" +
            "LEFT JOIN t_user u ON u.code = s.user_code\n" +
            "WHERE r.serial= #{serial,jdbcType=INTEGER}")
    List<SeatUserEntity> findRoomInfo(Integer serial);

    /**
     * 准备
     * @param roomSerial
     * @param userCode
     * @param seatSerial
     * @return
     */
    @Update("update t_seat t\n" +
            "LEFT JOIN t_room r\n" +
            "ON t.room_id = r.ID\n" +
            "SET t.status = 2\n" +
            "WHERE r.serial = #{roomSerial,jdbcType=INTEGER}\n" +
            "AND t.user_code = #{userCode,jdbcType=INTEGER}\n" +
            "AND t.serial = #{seatSerial,jdbcType=INTEGER}\n" +
            "AND t.status !=2")
    int saveUserSetOut(int roomSerial, int userCode, int seatSerial);


    /**
     * 查询房间人数和已准备人数
     * @param roomSerial
     * @return
     */
    @Select("SELECT \n" +
            "SUM(CASE WHEN t.status = 2 THEN 1 ELSE 0 END ) AS 'isSetOut',\n" +
            "count(*) AS 'isAllOut'\n" +
            "FROM t_seat t\n" +
            "LEFT JOIN t_room r\n" +
            "ON t.room_id = r.ID\n" +
            "WHERE r.serial = #{roomSerial,jdbcType=INTEGER}\n" +
            "AND t.user_code IS NOT NULL")
    Map<String, Object> selGmaeStartCondition(int roomSerial);
}
