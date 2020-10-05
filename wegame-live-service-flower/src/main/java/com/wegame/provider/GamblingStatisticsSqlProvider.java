package com.wegame.provider;

import com.wegame.model.GamblingStatistics;
import org.apache.ibatis.jdbc.SQL;

public class GamblingStatisticsSqlProvider {

    public String insertSelective(GamblingStatistics record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_statistics");

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

        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=BIGINT}");
        }

        if (record.getGamblingId() != null) {
            sql.VALUES("gambling_id", "#{gamblingId,jdbcType=BIGINT}");
        }

        if (record.getSeatId() != null) {
            sql.VALUES("seat_id", "#{seatId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getIsWin() != null) {
            sql.VALUES("is_win", "#{isWin,jdbcType=TINYINT}");
        }

        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=BIGINT}");
        }

        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=BIGINT}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GamblingStatistics record) {
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_statistics");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=BIGINT}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=BIGINT}");
        }

        if (record.getIntegral() != null) {
            sql.SET("integral = #{integral,jdbcType=BIGINT}");
        }

        if (record.getGamblingId() != null) {
            sql.SET("gambling_id = #{gamblingId,jdbcType=BIGINT}");
        }

        if (record.getSeatId() != null) {
            sql.SET("seat_id = #{seatId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getIsWin() != null) {
            sql.SET("is_win = #{isWin,jdbcType=TINYINT}");
        }

        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=BIGINT}");
        }

        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=BIGINT}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }
}
