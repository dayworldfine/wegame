package com.wegame.mapper;

import com.wegame.model.GamblingStatistics;
import com.wegame.provider.GamblingStatisticsSqlProvider;
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
public interface GamblingStatisticsMapper {
    @Delete({
        "delete from t_gambling_statistics",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_gambling_statistics (id, create_time, ",
        "update_time, version, ",
        "integral, gambling_id, ",
        "seat_id, user_id, is_win, ",
        "start_time, end_time)",
        "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
        "#{integral,jdbcType=BIGINT}, #{gamblingId,jdbcType=BIGINT}, ",
        "#{seatId,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, #{isWin,jdbcType=TINYINT}, ",
        "#{startTime,jdbcType=BIGINT}, #{endTime,jdbcType=BIGINT})"
    })
    int insert(GamblingStatistics record);

    @InsertProvider(type= GamblingStatisticsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingStatistics record);

    @Select({
        "select",
        "id, create_time, update_time, version, integral, gambling_id, seat_id, user_id, ",
        "is_win, start_time, end_time",
        "from t_gambling_statistics",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="integral", property="integral", jdbcType=JdbcType.BIGINT),
        @Result(column="gambling_id", property="gamblingId", jdbcType=JdbcType.BIGINT),
        @Result(column="seat_id", property="seatId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="is_win", property="isWin", jdbcType=JdbcType.TINYINT),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.BIGINT),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.BIGINT)
    })
    GamblingStatistics selectByPrimaryKey(Long id);

    @UpdateProvider(type=GamblingStatisticsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GamblingStatistics record);

    @Update({
        "update t_gambling_statistics",
        "set create_time = #{createTime,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=BIGINT},",
          "version = #{version,jdbcType=BIGINT},",
          "integral = #{integral,jdbcType=BIGINT},",
          "gambling_id = #{gamblingId,jdbcType=BIGINT},",
          "seat_id = #{seatId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "is_win = #{isWin,jdbcType=TINYINT},",
          "start_time = #{startTime,jdbcType=BIGINT},",
          "end_time = #{endTime,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GamblingStatistics record);
}
