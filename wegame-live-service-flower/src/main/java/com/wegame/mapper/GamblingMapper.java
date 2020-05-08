package com.wegame.mapper;

import com.wegame.model.Gambling;
import com.wegame.provider.GamblingSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingMapper {
    @Insert({
        "insert into t_gambling (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "ROOMSERIAL, STATUS, ",
        "SEATID)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{roomserial,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{seatid,jdbcType=VARCHAR})"
    })
    int insert(Gambling record);

    @InsertProvider(type= GamblingSqlProvider.class, method="insertSelective")
    int insertSelective(Gambling record);
}
