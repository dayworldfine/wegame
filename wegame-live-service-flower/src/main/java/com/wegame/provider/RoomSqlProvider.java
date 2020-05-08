package com.wegame.provider;

import com.wegame.model.Room;
import org.apache.ibatis.jdbc.SQL;

public class RoomSqlProvider {

    public String insertSelective(Room record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_room");
        
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
        
        if (record.getName() != null) {
            sql.VALUES("NAME", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSerial() != null) {
            sql.VALUES("SERIAL", "#{serial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("STATUS", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}