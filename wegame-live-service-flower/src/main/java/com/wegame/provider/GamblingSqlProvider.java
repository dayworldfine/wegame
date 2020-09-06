package com.wegame.provider;

import com.wegame.model.Gambling;
import org.apache.ibatis.jdbc.SQL;

public class GamblingSqlProvider {

    public String insertSelective(Gambling record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.VALUES("room_id", "#{roomId,jdbcType=BIGINT}");
        }
        
        if (record.getGamblingStatus() != null) {
            sql.VALUES("gambling_status", "#{gamblingStatus,jdbcType=TINYINT}");
        }
        
        if (record.getIntegralFundus() != null) {
            sql.VALUES("integral_fundus", "#{integralFundus,jdbcType=BIGINT}");
        }
        
        if (record.getIntegralSum() != null) {
            sql.VALUES("integral_sum", "#{integralSum,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }
}