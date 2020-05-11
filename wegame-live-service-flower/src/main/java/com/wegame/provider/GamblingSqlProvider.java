package com.wegame.provider;

import com.wegame.model.Gambling;
import org.apache.ibatis.jdbc.SQL;

public class GamblingSqlProvider {

    public String insertSelective(Gambling record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=VARCHAR}");
        }
        
        if (record.getLastModifiedTime() != null) {
            sql.VALUES("last_modified_time", "#{lastModifiedTime,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=BIGINT}");
        }
        
        if (record.getRoomSerial() != null) {
            sql.VALUES("room_serial", "#{roomSerial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getSeatId() != null) {
            sql.VALUES("seat_id", "#{seatId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}