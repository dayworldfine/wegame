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
        "insert into t_seat (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "SERIAL, STATUS, ",
        "ROOMID, USERCODE, ",
        "SEECARD, BOARDA, ",
        "BOARDB, BOARDC)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{serial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{roomid,jdbcType=VARCHAR}, #{usercode,jdbcType=INTEGER}, ",
        "#{seecard,jdbcType=INTEGER}, #{boarda,jdbcType=INTEGER}, ",
        "#{boardb,jdbcType=INTEGER}, #{boardc,jdbcType=INTEGER})"
    })
    int insert(Seat record);

    @InsertProvider(type= SeatSqlProvider.class, method="insertSelective")
    int insertSelective(Seat record);

//        @Query(value = "SELECT u.Code as userCode, u.headPortrait as userImg, u.nickName as userNickName,\n" +
//            "s.SERIAL%6 as seatSerial, u.integral as integral, s.BOARDA as boardA ,\n" +
//            "s.BOARDB as boardB ,s.BOARDC as boardC , s.`STATUS` as status\n" +
//            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.ROOMID\n" +
//            "LEFT JOIN t_user u ON u.`CODE` = s.USERCODE\n" +
//            "WHERE r.SERIAL=?1",nativeQuery = true)

    @Select("SELECT u.Code as userCode, u.headPortrait as userImg, u.nickName as userNickName,\n" +
            "s.SERIAL%6 as seatSerial, u.integral as integral, s.BOARDA as boardA ,\n" +
            "s.BOARDB as boardB ,s.BOARDC as boardC , s.`STATUS` as status\n" +
            "from t_room r RIGHT JOIN  t_seat s ON r.ID = s.ROOMID\n" +
            "LEFT JOIN t_user u ON u.`CODE` = s.USERCODE\n" +
            "WHERE r.SERIAL=#{serial,jdbcType=INTEGER}")
    List<SeatUserEntity> findRoomInfo(int serial);

    /**
     * 准备
     * @param roomSerial
     * @param userCode
     * @param seatSerial
     * @return
     */
//    @Query(value = "update t_seat t\n" +
//            "LEFT JOIN t_room r\n" +
//            "ON t.ROOMID = r.ID\n" +
//            "SET t.`STATUS` = 2\n" +
//            "WHERE r.SERIAL = (?1)\n" +
//            "AND t.USERCODE = (?2)\n" +
//            "AND t.SERIAL = (?3)\n" +
//            "AND t.`STATUS` !=2",nativeQuery = true)
    @Select("update t_seat t\n" +
            "LEFT JOIN t_room r\n" +
            "ON t.ROOMID = r.ID\n" +
            "SET t.`STATUS` = 2\n" +
            "WHERE r.SERIAL = #{roomSerial,jdbcType=INTEGER}\n" +
            "AND t.USERCODE =#{userCode,jdbcType=INTEGER}\n" +
            "AND t.SERIAL = #{seatSerial,jdbcType=INTEGER}\n" +
            "AND t.`STATUS` !=2")
    int saveUserSetOut(int roomSerial, int userCode, int seatSerial);
}
