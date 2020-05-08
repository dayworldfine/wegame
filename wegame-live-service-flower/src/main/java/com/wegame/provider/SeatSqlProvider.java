package com.wegame.provider;

import com.wegame.model.Seat;
import org.apache.ibatis.jdbc.SQL;

public class SeatSqlProvider {

    public String insertSelective(Seat record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_seat");
        
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
        
        if (record.getSerial() != null) {
            sql.VALUES("SERIAL", "#{serial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getRoomid() != null) {
            sql.VALUES("ROOMID", "#{roomid,jdbcType=VARCHAR}");
        }
        
        if (record.getUsercode() != null) {
            sql.VALUES("USERCODE", "#{usercode,jdbcType=INTEGER}");
        }
        
        if (record.getSeecard() != null) {
            sql.VALUES("SEECARD", "#{seecard,jdbcType=INTEGER}");
        }
        
        if (record.getBoarda() != null) {
            sql.VALUES("BOARDA", "#{boarda,jdbcType=INTEGER}");
        }
        
        if (record.getBoardb() != null) {
            sql.VALUES("BOARDB", "#{boardb,jdbcType=INTEGER}");
        }
        
        if (record.getBoardc() != null) {
            sql.VALUES("BOARDC", "#{boardc,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}