package com.wegame.mapper;

import com.wegame.model.GamblingDetails;
import com.wegame.provider.GamblingDetailsSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface GamblingDetailsMapper {
    @Delete({
        "delete from t_gambling_details",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_gambling_details (id, create_time, ",
        "update_time, version, ",
        "gambling_id, compare_user_id, ",
        "operation_type, operating_leverage, ",
        "round, seat_id, user_id, ",
        "sort)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{gamblingId,jdbcType=BIGINT}, #{compareUserId,jdbcType=BIGINT}, ",
        "#{operationType,jdbcType=TINYINT}, #{operatingLeverage,jdbcType=BIGINT}, ",
        "#{round,jdbcType=INTEGER}, #{seatId,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, ",
        "#{sort,jdbcType=INTEGER})"
    })
    int insert(GamblingDetails record);

    @InsertProvider(type= GamblingDetailsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingDetails record);

    @Select({
        "select",
        "id, create_time, update_time, version, gambling_id, compare_user_id, operation_type, ",
        "operating_leverage, round, seat_id, user_id, sort",
        "from t_gambling_details",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="gambling_id", property="gamblingId", jdbcType=JdbcType.BIGINT),
        @Result(column="compare_user_id", property="compareUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="operation_type", property="operationType", jdbcType=JdbcType.TINYINT),
        @Result(column="operating_leverage", property="operatingLeverage", jdbcType=JdbcType.BIGINT),
        @Result(column="round", property="round", jdbcType=JdbcType.INTEGER),
        @Result(column="seat_id", property="seatId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    GamblingDetails selectByPrimaryKey(Long id);

    @UpdateProvider(type=GamblingDetailsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GamblingDetails record);

    @Update({
        "update t_gambling_details",
        "set create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "version = #{version,jdbcType=BIGINT},",
          "gambling_id = #{gamblingId,jdbcType=BIGINT},",
          "compare_user_id = #{compareUserId,jdbcType=BIGINT},",
          "operation_type = #{operationType,jdbcType=TINYINT},",
          "operating_leverage = #{operatingLeverage,jdbcType=BIGINT},",
          "round = #{round,jdbcType=INTEGER},",
          "seat_id = #{seatId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GamblingDetails record);


}
