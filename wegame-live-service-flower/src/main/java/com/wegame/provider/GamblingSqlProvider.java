package com.wegame.provider;

import com.wegame.model.Gambling;
import org.apache.ibatis.jdbc.SQL;

public class GamblingSqlProvider {

    public String insertSelective(Gambling record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.VALUES("CREATEDATE", "#{createdate,jdbcType=VARCHAR}");
        }
        
        if (record.getLastmodifiedtime() != null) {
            sql.VALUES("LASTMODIFIEDTIME", "#{lastmodifiedtime,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("VERSION", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getRoomserial() != null) {
            sql.VALUES("ROOMSERIAL", "#{roomserial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getSeatid() != null) {
            sql.VALUES("SEATID", "#{seatid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}