package com.wegame.provider;

import com.wegame.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_user");
        
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
        
        if (record.getCode() != null) {
            sql.VALUES("CODE", "#{code,jdbcType=INTEGER}");
        }
        
        if (record.getHeadportrait() != null) {
            sql.VALUES("HEADPORTRAIT", "#{headportrait,jdbcType=VARCHAR}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("INTEGRAL", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("NICKNAME", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("PASSWORD", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("PHONE", "#{phone,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("USERNAME", "#{username,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}