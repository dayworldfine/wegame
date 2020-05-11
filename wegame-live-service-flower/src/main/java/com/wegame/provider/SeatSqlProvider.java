package com.wegame.provider;

import com.wegame.model.Seat;
import org.apache.ibatis.jdbc.SQL;

public class SeatSqlProvider {

    public String insertSelective(Seat record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_seat");
        
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
        
        if (record.getSerial() != null) {
            sql.VALUES("serial", "#{serial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getRoomId() != null) {
            sql.VALUES("room_id", "#{roomId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserCode() != null) {
            sql.VALUES("user_code", "#{userCode,jdbcType=INTEGER}");
        }
        
        if (record.getSeeCard() != null) {
            sql.VALUES("see_card", "#{seeCard,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}