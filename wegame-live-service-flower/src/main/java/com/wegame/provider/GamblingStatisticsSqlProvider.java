package com.wegame.provider;

import com.wegame.model.GamblingStatistics;
import org.apache.ibatis.jdbc.SQL;

public class GamblingStatisticsSqlProvider {

    public String insertSelective(GamblingStatistics record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_statistics");
        
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
        
        if (record.getEndtime() != null) {
            sql.VALUES("ENDTIME", "#{endtime,jdbcType=VARCHAR}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("INTEGRAL", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getRoomserial() != null) {
            sql.VALUES("ROOMSERIAL", "#{roomserial,jdbcType=INTEGER}");
        }
        
        if (record.getSeatserial() != null) {
            sql.VALUES("SEATSERIAL", "#{seatserial,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            sql.VALUES("STARTTIME", "#{starttime,jdbcType=VARCHAR}");
        }
        
        if (record.getUsercode() != null) {
            sql.VALUES("USERCODE", "#{usercode,jdbcType=INTEGER}");
        }
        
        if (record.getGambling() != null) {
            sql.VALUES("GAMBLING", "#{gambling,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}