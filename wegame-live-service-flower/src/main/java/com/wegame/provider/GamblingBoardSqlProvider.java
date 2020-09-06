package com.wegame.provider;

import com.wegame.model.GamblingBoard;
import org.apache.ibatis.jdbc.SQL;

public class GamblingBoardSqlProvider {

    public String insertSelective(GamblingBoard record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_board");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=BIGINT}");
        }
        
        if (record.getGamblingMessageId() != null) {
            sql.VALUES("gambling_message_id", "#{gamblingMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getBoardSize() != null) {
            sql.VALUES("board_size", "#{boardSize,jdbcType=BIGINT}");
        }
        
        if (record.getBoardType() != null) {
            sql.VALUES("board_type", "#{boardType,jdbcType=TINYINT}");
        }
        
        if (record.getIsSpecial() != null) {
            sql.VALUES("is_special", "#{isSpecial,jdbcType=TINYINT}");
        }
        
        if (record.getIsA32() != null) {
            sql.VALUES("is_a32", "#{isA32,jdbcType=TINYINT}");
        }
        
        if (record.getFirstBoardColor() != null) {
            sql.VALUES("first_board_color", "#{firstBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getFirstBoardValue() != null) {
            sql.VALUES("first_board_value", "#{firstBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getSecondBoardColor() != null) {
            sql.VALUES("second_board_color", "#{secondBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getSecondBoardValue() != null) {
            sql.VALUES("second_board_value", "#{secondBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getThirdlyBoardColor() != null) {
            sql.VALUES("thirdly_board_color", "#{thirdlyBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getThirdlyBoardValue() != null) {
            sql.VALUES("thirdly_board_value", "#{thirdlyBoardValue,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GamblingBoard record) {
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_board");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }
        
        if (record.getGamblingMessageId() != null) {
            sql.SET("gambling_message_id = #{gamblingMessageId,jdbcType=BIGINT}");
        }
        
        if (record.getBoardSize() != null) {
            sql.SET("board_size = #{boardSize,jdbcType=BIGINT}");
        }
        
        if (record.getBoardType() != null) {
            sql.SET("board_type = #{boardType,jdbcType=TINYINT}");
        }
        
        if (record.getIsSpecial() != null) {
            sql.SET("is_special = #{isSpecial,jdbcType=TINYINT}");
        }
        
        if (record.getIsA32() != null) {
            sql.SET("is_a32 = #{isA32,jdbcType=TINYINT}");
        }
        
        if (record.getFirstBoardColor() != null) {
            sql.SET("first_board_color = #{firstBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getFirstBoardValue() != null) {
            sql.SET("first_board_value = #{firstBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getSecondBoardColor() != null) {
            sql.SET("second_board_color = #{secondBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getSecondBoardValue() != null) {
            sql.SET("second_board_value = #{secondBoardValue,jdbcType=INTEGER}");
        }
        
        if (record.getThirdlyBoardColor() != null) {
            sql.SET("thirdly_board_color = #{thirdlyBoardColor,jdbcType=TINYINT}");
        }
        
        if (record.getThirdlyBoardValue() != null) {
            sql.SET("thirdly_board_value = #{thirdlyBoardValue,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}