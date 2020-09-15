package com.wegame.mapper;

import com.wegame.model.GamblingMessage;
import com.wegame.provider.GamblingMessageSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamblingMessageMapper {
    @Delete({
            "delete from t_gambling_message",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_gambling_message (id, create_time, ",
            "update_time, version, ",
            "gambling_id, user_id, ",
            "seat_id, is_banker, ",
            "is_user, see_card_status, ",
            "game_status)",
            "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
            "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
            "#{gamblingId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
            "#{seatId,jdbcType=BIGINT}, #{isBanker,jdbcType=TINYINT}, ",
            "#{isUser,jdbcType=TINYINT}, #{seeCardStatus,jdbcType=TINYINT}, ",
            "#{gameStatus,jdbcType=TINYINT})"
    })
    int insert(GamblingMessage record);

    @InsertProvider(type = GamblingMessageSqlProvider.class, method = "insertSelective")
    int insertSelective(GamblingMessage record);

    @Select({
            "select",
            "id, create_time, update_time, version, gambling_id, user_id, seat_id, is_banker, ",
            "is_user, see_card_status, game_status",
            "from t_gambling_message",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.BIGINT),
            @Result(column = "gambling_id", property = "gamblingId", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "seat_id", property = "seatId", jdbcType = JdbcType.BIGINT),
            @Result(column = "is_banker", property = "isBanker", jdbcType = JdbcType.TINYINT),
            @Result(column = "is_user", property = "isUser", jdbcType = JdbcType.TINYINT),
            @Result(column = "see_card_status", property = "seeCardStatus", jdbcType = JdbcType.TINYINT),
            @Result(column = "game_status", property = "gameStatus", jdbcType = JdbcType.TINYINT)
    })
    GamblingMessage selectByPrimaryKey(Long id);

    @UpdateProvider(type = GamblingMessageSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GamblingMessage record);

    @Update({
            "update t_gambling_message",
            "set create_time = #{createTime,jdbcType=BIGINT},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "version = #{version,jdbcType=BIGINT},",
            "gambling_id = #{gamblingId,jdbcType=BIGINT},",
            "user_id = #{userId,jdbcType=BIGINT},",
            "seat_id = #{seatId,jdbcType=BIGINT},",
            "is_banker = #{isBanker,jdbcType=TINYINT},",
            "is_user = #{isUser,jdbcType=TINYINT},",
            "see_card_status = #{seeCardStatus,jdbcType=TINYINT},",
            "game_status = #{gameStatus,jdbcType=TINYINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GamblingMessage record);

    @Insert({
            "<script>",
            "insert into t_gambling_message(" +
                    "id, " +
                    "create_time, " +
                    "update_time, " +
                    "version, " +
                    "gambling_id, " +
                    "user_id, " +
                    "seat_id," +
                    "is_banker," +
                    "is_user," +
                    "see_card_status," +
                    "game_status) values ",
            "<foreach collection='gamblingMessageList' item='item' index='index' separator=','>",
            "(" +
                    "#{item.id}, " +
                    "#{item.createTime}, " +
                    "#{item.updateTime}," +
                    "#{item.version}," +
                    "#{item.gamblingId}," +
                    "#{item.userId}," +
                    "#{item.seatId}," +
                    "#{item.isBanker}," +
                    "#{item.isUser}," +
                    "#{item.seeCardStatus}," +
                    "#{item.gameStatus}" +
            ")",
            "</foreach>",
            "</script>"
    })
    int insertGamblingMessageList(@Param(value = "gamblingMessageList") List<GamblingMessage> gamblingMessageList);
}
