package com.wegame.provider;

import com.wegame.model.Seat;
import org.apache.ibatis.jdbc.SQL;

public class SeatSqlProvider {

    public String insertSelective(Seat record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_seat");
        
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
        
        if (record.getSeatStatus() != null) {
            sql.VALUES("seat_status", "#{seatStatus,jdbcType=TINYINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.VALUES("room_id", "#{roomId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Seat record) {
        SQL sql = new SQL();
        sql.UPDATE("t_seat");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=BIGINT}");
        }
        
        if (record.getSeatStatus() != null) {
            sql.SET("seat_status = #{seatStatus,jdbcType=TINYINT}");
        }
        
        if (record.getRoomId() != null) {
            sql.SET("room_id = #{roomId,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}