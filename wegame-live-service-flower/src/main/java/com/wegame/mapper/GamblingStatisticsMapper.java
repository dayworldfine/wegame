package com.wegame.mapper;

import com.wegame.model.GamblingStatistics;
import com.wegame.provider.GamblingStatisticsSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingStatisticsMapper {
    @Insert({
        "insert into t_gambling_statistics (id, create_date, ",
        "last_modified_time, version, ",
        "end_time, integral, ",
        "room_serial, seat_serial, ",
        "start_time, user_code, ",
        "gambling)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{endTime,jdbcType=VARCHAR}, #{integral,jdbcType=INTEGER}, ",
        "#{roomSerial,jdbcType=INTEGER}, #{seatSerial,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=VARCHAR}, #{userCode,jdbcType=INTEGER}, ",
        "#{gambling,jdbcType=VARCHAR})"
    })
    int insert(GamblingStatistics record);

    @InsertProvider(type=GamblingStatisticsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingStatistics record);
}
