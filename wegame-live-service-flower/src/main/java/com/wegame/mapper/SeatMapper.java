package com.wegame.mapper;

import com.wegame.model.Seat;
import com.wegame.provider.SeatSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

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
}
