package com.wegame.provider;

import com.wegame.model.GamblingDetails;
import org.apache.ibatis.jdbc.SQL;

public class GamblingDetailsSqlProvider {

    public String insertSelective(GamblingDetails record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_details");
        
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
        
        if (record.getCompareUser() != null) {
            sql.VALUES("compare_user", "#{compareUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDoType() != null) {
            sql.VALUES("do_type", "#{doType,jdbcType=INTEGER}");
        }
        
        if (record.getOperatingLeverage() != null) {
            sql.VALUES("operating_leverage", "#{operatingLeverage,jdbcType=INTEGER}");
        }
        
        if (record.getRound() != null) {
            sql.VALUES("round", "#{round,jdbcType=INTEGER}");
        }
        
        if (record.getSeatSerial() != null) {
            sql.VALUES("seat_serial", "#{seatSerial,jdbcType=INTEGER}");
        }
        
        if (record.getUserCode() != null) {
            sql.VALUES("user_code", "#{userCode,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}