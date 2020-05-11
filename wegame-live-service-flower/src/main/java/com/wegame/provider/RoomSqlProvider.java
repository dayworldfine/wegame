package com.wegame.provider;

import com.wegame.model.Room;
import org.apache.ibatis.jdbc.SQL;

public class RoomSqlProvider {

    public String insertSelective(Room record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_room");
        
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
        
        if (record.getRoomName() != null) {
            sql.VALUES("room_name", "#{roomName,jdbcType=VARCHAR}");
        }
        
        if (record.getSerial() != null) {
            sql.VALUES("serial", "#{serial,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}