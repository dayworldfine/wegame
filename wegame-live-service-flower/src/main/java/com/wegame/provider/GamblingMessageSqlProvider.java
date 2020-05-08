package com.wegame.provider;

import com.wegame.model.GamblingMessage;
import org.apache.ibatis.jdbc.SQL;

public class GamblingMessageSqlProvider {

    public String insertSelective(GamblingMessage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_message");
        
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
        
        if (record.getBoard() != null) {
            sql.VALUES("BOARD", "#{board,jdbcType=VARCHAR}");
        }
        
        if (record.getEnding() != null) {
            sql.VALUES("ENDING", "#{ending,jdbcType=INTEGER}");
        }
        
        if (record.getSeatserial() != null) {
            sql.VALUES("SEATSERIAL", "#{seatserial,jdbcType=INTEGER}");
        }
        
        if (record.getSeecard() != null) {
            sql.VALUES("SEECARD", "#{seecard,jdbcType=INTEGER}");
        }
        
        if (record.getUsercode() != null) {
            sql.VALUES("USERCODE", "#{usercode,jdbcType=INTEGER}");
        }
        
        if (record.getGamblingid() != null) {
            sql.VALUES("GAMBLINGID", "#{gamblingid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}