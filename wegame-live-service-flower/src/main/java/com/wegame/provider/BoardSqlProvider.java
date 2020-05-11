package com.wegame.provider;

import com.wegame.model.Board;
import org.apache.ibatis.jdbc.SQL;

public class BoardSqlProvider {

    public String insertSelective(Board record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_board");
        
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
        
        if (record.getFirstBoardColor() != null) {
            sql.VALUES("first_board_color", "#{firstBoardColor,jdbcType=INTEGER}");
        }
        
        if (record.getFirstBoardValue() != null) {
            sql.VALUES("first_board_value", "#{firstBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getSecondBoardColor() != null) {
            sql.VALUES("second_board_color", "#{secondBoardColor,jdbcType=INTEGER}");
        }
        
        if (record.getSecondBoardValue() != null) {
            sql.VALUES("second_board_value", "#{secondBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getThirdlyBoardColor() != null) {
            sql.VALUES("thirdly_board_color", "#{thirdlyBoardColor,jdbcType=INTEGER}");
        }
        
        if (record.getThirdlyBoardValue() != null) {
            sql.VALUES("thirdly_board_value", "#{thirdlyBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getSize() != null) {
            sql.VALUES("size", "#{size,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }
}