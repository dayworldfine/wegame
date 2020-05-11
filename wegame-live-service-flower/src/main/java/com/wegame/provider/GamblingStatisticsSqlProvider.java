package com.wegame.provider;

import com.wegame.model.GamblingStatistics;
import org.apache.ibatis.jdbc.SQL;

public class GamblingStatisticsSqlProvider {

    public String insertSelective(GamblingStatistics record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_statistics");
        
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
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getRoomSerial() != null) {
            sql.VALUES("room_serial", "#{roomSerial,jdbcType=INTEGER}");
        }
        
        if (record.getSeatSerial() != null) {
            sql.VALUES("seat_serial", "#{seatSerial,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=VARCHAR}");
        }
        
        if (record.getUserCode() != null) {
            sql.VALUES("user_code", "#{userCode,jdbcType=INTEGER}");
        }
        
        if (record.getGambling() != null) {
            sql.VALUES("gambling", "#{gambling,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}