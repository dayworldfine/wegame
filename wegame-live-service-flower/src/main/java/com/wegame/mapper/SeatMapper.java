package com.wegame.mapper;

import com.wegame.entity.SeatUserEntity;
import com.wegame.model.Seat;
import com.wegame.provider.SeatSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatMapper {
    @Insert({
        "insert into t_seat (id, create_date, ",
        "last_modified_time, version, ",
        "serial, status, ",
        "room_id, user_code, ",
        "see_card)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{serial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{roomId,jdbcType=VARCHAR}, #{userCode,jdbcType=INTEGER}, ",
        "#{seeCard,jdbcType=INTEGER})"
    })
    int insert(Seat record);

    @InsertProvider(type=SeatSqlProvider.class, method="insertSelective")
    int insertSelective(Seat record);

    /**
      * 查看房间信息
      * @param serial
      * @return
      */
    @Select("SELECT u.Code as userCode, u.headPortrait as userImg, u.nickName as userNickName,\n" +
            "s.SERIAL%6 as seatSerial, u.integral as integral, s.BOARDA as boardA ,\n" +
            "s.BOARDB as boardB ,s.BOARDC as boardC , s.`STATUS` as status\n" +
            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.room_id\n" +
            "LEFT JOIN t_user u ON u.`CODE` = s.user_code\n" +
            "WHERE r.SERIAL= #{serial,jdbcType=INTEGER}")
    List<SeatUserEntity> findRoomInfo(Integer serial);

    /**
     * 准备
     * @param roomSerial
     * @param userCode
     * @param seatSerial
     * @return
     */
    @Select("update t_seat t\n" +
            "LEFT JOIN t_room r\n" +
            "ON t.ROOMID = r.ID\n" +
            "SET t.`STATUS` = 2\n" +
            "WHERE r.SERIAL = #{roomSerial,jdbcType=INTEGER}\n" +
            "AND t.USERCODE = #{userCode,jdbcType=INTEGER}\n" +
            "AND t.SERIAL = #{seatSerial,jdbcType=INTEGER}\n" +
            "AND t.`STATUS` !=2")
    int saveUserSetOut(int roomSerial, int userCode, int seatSerial);
}
