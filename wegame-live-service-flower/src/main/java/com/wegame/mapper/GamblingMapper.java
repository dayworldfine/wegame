package com.wegame.mapper;

import com.wegame.model.Gambling;
import com.wegame.provider.GamblingSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface GamblingMapper {
    @Insert({
        "insert into t_gambling (id, create_time, ",
        "update_time, version, ",
        "room_id, gambling_status, ",
        "integral_fundus, integral_sum)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{roomId,jdbcType=BIGINT}, #{gamblingStatus,jdbcType=TINYINT}, ",
        "#{integralFundus,jdbcType=BIGINT}, #{integralSum,jdbcType=BIGINT})"
    })
    int insert(Gambling record);

    @InsertProvider(type= GamblingSqlProvider.class, method="insertSelective")
    int insertSelective(Gambling record);
}
