package com.wegame.mapper;

import com.wegame.model.GamblingDetails;
import com.wegame.provider.GamblingDetailsSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingDetailsMapper {
    @Insert({
        "insert into t_gambling_details (id, create_date, ",
        "last_modified_time, version, ",
        "compare_user, do_type, ",
        "operating_leverage, round, ",
        "seat_serial, user_code)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{compareUser,jdbcType=VARCHAR}, #{doType,jdbcType=INTEGER}, ",
        "#{operatingLeverage,jdbcType=INTEGER}, #{round,jdbcType=INTEGER}, ",
        "#{seatSerial,jdbcType=INTEGER}, #{userCode,jdbcType=INTEGER})"
    })
    int insert(GamblingDetails record);

    @InsertProvider(type=GamblingDetailsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingDetails record);
}
