package com.wegame.provider;

import com.wegame.model.GamblingDetails;
import org.apache.ibatis.jdbc.SQL;

public class GamblingDetailsSqlProvider {

    public String insertSelective(GamblingDetails record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_gambling_details");

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

        if (record.getCompareUserId() != null) {
            sql.VALUES("compare_user_id", "#{compareUserId,jdbcType=BIGINT}");
        }

        if (record.getOperationType() != null) {
            sql.VALUES("operation_type", "#{operationType,jdbcType=TINYINT}");
        }

        if (record.getOperatingLeverage() != null) {
            sql.VALUES("operating_leverage", "#{operatingLeverage,jdbcType=BIGINT}");
        }

        if (record.getRound() != null) {
            sql.VALUES("round", "#{round,jdbcType=INTEGER}");
        }

        if (record.getSeatId() != null) {
            sql.VALUES("seat_id", "#{seatId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=BIGINT}");
        }

        if (record.getSort() != null) {
            sql.VALUES("sort", "#{sort,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GamblingDetails record) {
        SQL sql = new SQL();
        sql.UPDATE("t_gambling_details");

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

        if (record.getCompareUserId() != null) {
            sql.SET("compare_user_id = #{compareUserId,jdbcType=BIGINT}");
        }

        if (record.getOperationType() != null) {
            sql.SET("operation_type = #{operationType,jdbcType=TINYINT}");
        }

        if (record.getOperatingLeverage() != null) {
            sql.SET("operating_leverage = #{operatingLeverage,jdbcType=BIGINT}");
        }

        if (record.getRound() != null) {
            sql.SET("round = #{round,jdbcType=INTEGER}");
        }

        if (record.getSeatId() != null) {
            sql.SET("seat_id = #{seatId,jdbcType=BIGINT}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=BIGINT}");
        }

        if (record.getSort() != null) {
            sql.SET("sort = #{sort,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=BIGINT}");

        return sql.toString();
    }
}
