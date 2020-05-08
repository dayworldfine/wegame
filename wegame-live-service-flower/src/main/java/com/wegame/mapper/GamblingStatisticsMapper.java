package com.wegame.mapper;

import com.wegame.model.GamblingStatistics;
import com.wegame.provider.GamblingStatisticsSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingStatisticsMapper {
    @Insert({
        "insert into t_gambling_statistics (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "ENDTIME, INTEGRAL, ",
        "ROOMSERIAL, SEATSERIAL, ",
        "STARTTIME, USERCODE, ",
        "GAMBLING)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{endtime,jdbcType=VARCHAR}, #{integral,jdbcType=INTEGER}, ",
        "#{roomserial,jdbcType=INTEGER}, #{seatserial,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=VARCHAR}, #{usercode,jdbcType=INTEGER}, ",
        "#{gambling,jdbcType=VARCHAR})"
    })
    int insert(GamblingStatistics record);

    @InsertProvider(type= GamblingStatisticsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingStatistics record);
}
