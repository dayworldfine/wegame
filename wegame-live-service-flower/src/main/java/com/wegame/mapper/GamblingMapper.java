package com.wegame.mapper;

import com.wegame.model.Gambling;
import com.wegame.provider.GamblingSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingMapper {
    @Insert({
        "insert into t_gambling (id, create_date, ",
        "last_modified_time, version, ",
        "room_serial, status, ",
        "seat_id)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{roomSerial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{seatId,jdbcType=VARCHAR})"
    })
    int insert(Gambling record);

    @InsertProvider(type=GamblingSqlProvider.class, method="insertSelective")
    int insertSelective(Gambling record);
}
