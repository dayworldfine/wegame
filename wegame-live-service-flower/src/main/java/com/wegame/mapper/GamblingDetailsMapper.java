package com.wegame.mapper;

import com.wegame.model.GamblingDetails;
import com.wegame.provider.GamblingDetailsSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

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
            "#{round,jdbcType=INTEGER}, #{seatId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
            "#{sort,jdbcType=INTEGER})"
    })
    int insert(GamblingDetails record);

    @InsertProvider(type = GamblingDetailsSqlProvider.class, method = "insertSelective")
    int insertSelective(GamblingDetails record);

    @Select({
            "select",
            "id, create_time, update_time, version, gambling_id, compare_user_id, operation_type, ",
            "operating_leverage, round, seat_id, user_id, sort",
            "from t_gambling_details",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.BIGINT),
            @Result(column = "gambling_id", property = "gamblingId", jdbcType = JdbcType.BIGINT),
            @Result(column = "compare_user_id", property = "compareUserId", jdbcType = JdbcType.BIGINT),
            @Result(column = "operation_type", property = "operationType", jdbcType = JdbcType.TINYINT),
            @Result(column = "operating_leverage", property = "operatingLeverage", jdbcType = JdbcType.BIGINT),
            @Result(column = "round", property = "round", jdbcType = JdbcType.INTEGER),
            @Result(column = "seat_id", property = "seatId", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "sort", property = "sort", jdbcType = JdbcType.INTEGER)
    })
    GamblingDetails selectByPrimaryKey(Long id);

    @UpdateProvider(type = GamblingDetailsSqlProvider.class, method = "updateByPrimaryKeySelective")
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
            "seat_id = #{seatId,jdbcType=BIGINT},",
            "user_id = #{userId,jdbcType=BIGINT},",
            "sort = #{sort,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GamblingDetails record);

    /**
     * 根据牌局id查询所有牌局详情
     *
     * @param gamblingId
     * @return
     */
    @Select("select * from t_gambling_details where gambling_id = #{gamblingId,jdbcType=BIGINT}")
    List<GamblingDetails> queryByGamblingId(Long gamblingId);


    @Insert({
            "<script>",
            "insert into t_gambling_details(" ,
                    "id, " ,
                    "create_time, " ,
                    "update_time, " ,
                    "version, " ,
                    "gambling_id, " ,
                    "compare_user_id, " ,
                    "operation_type," ,
                    "operating_leverage," ,
                    "round," ,
                    "seat_id," ,
                    "user_id," ,
                    "sort) values ",
            "<foreach collection='gamblingDetailsList' item='item' index='index' separator=','>",
            "(" ,
                    "#{item.id}, " ,
                    "#{item.createTime}, " ,
                    "#{item.updateTime}," ,
                    "#{item.version}," ,
                    "#{item.gamblingId}," ,
                    "#{item.compareUserId}," ,
                    "#{item.operationType}," ,
                    "#{item.operatingLeverage}," ,
                    "#{item.round}," ,
                    "#{item.seatId}," ,
                    "#{item.userId}," ,
                    "#{item.sort}" ,
                    ")",
            "</foreach>",
            "</script>"
    })
    int insertGamblingDetailsList(@Param(value = "gamblingDetailsList") List<GamblingDetails> gamblingDetailsList);

    /*查询最后个轮次的所有操作信息*/
    @Select({
            "select * from ",
            "t_gambling_details where gambling_id = #{gamblingId,jdbcType=BIGINT} ",
            "order by create_time desc limit 1"
    })
    GamblingDetails selectByGamblingIdLastRound(long gamblingId);

    @Select({
            "select * from ",
            "t_gambling_details where gambling_id = #{gamblingId,jdbcType=BIGINT} "
    })
    List<GamblingDetails> selectByGamblingId(long gamblingId);
}
