package com.wegame.provider;

import com.wegame.model.GamblingMessage;
import org.apache.ibatis.jdbc.SQL;

public class GamblingMessageSqlProvider {

    public String insertSelective(GamblingMessage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_message");

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

        if (record.getGamblingId() != null) {
            sql.VALUES("gambling_id", "#{gamblingId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getSeatId() != null) {
            sql.VALUES("seat_id", "#{seatId,jdbcType=BIGINT}");
        }

        if (record.getIsBanker() != null) {
            sql.VALUES("is_banker", "#{isBanker,jdbcType=TINYINT}");
        }

        if (record.getIsUser() != null) {
            sql.VALUES("is_user", "#{isUser,jdbcType=TINYINT}");
        }

        if (record.getIsUser() != null) {
            sql.VALUES("is_turn", "#{isTurn,jdbcType=TINYINT}");
        }

        if (record.getSeeCardStatus() != null) {
            sql.VALUES("see_card_status", "#{seeCardStatus,jdbcType=TINYINT}");
        }

        if (record.getGameStatus() != null) {
            sql.VALUES("game_status", "#{gameStatus,jdbcType=TINYINT}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GamblingMessage record) {
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_message");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=BIGINT}");
        }

        if (record.getGamblingId() != null) {
            sql.SET("gambling_id = #{gamblingId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getSeatId() != null) {
            sql.SET("seat_id = #{seatId,jdbcType=BIGINT}");
        }

        if (record.getIsBanker() != null) {
            sql.SET("is_banker = #{isBanker,jdbcType=TINYINT}");
        }

        if (record.getIsUser() != null) {
            sql.SET("is_user = #{isUser,jdbcType=TINYINT}");
        }

        if (record.getIsTurn() != null) {
            sql.SET("is_turn = #{isTurn,jdbcType=TINYINT}");
        }

        if (record.getSeeCardStatus() != null) {
            sql.SET("see_card_status = #{seeCardStatus,jdbcType=TINYINT}");
        }

        if (record.getGameStatus() != null) {
            sql.SET("game_status = #{gameStatus,jdbcType=TINYINT}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }
}
