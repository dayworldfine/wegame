package com.wegame.mapper;

import com.wegame.model.GamblingBoard;
import com.wegame.provider.GamblingBoardSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamblingBoardMapper {
    @Delete({
            "delete from t_gambling_board",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_gambling_board (id, create_time, ",
            "update_time,version, gambling_message_id, ",
            "board_size, board_type, ",
            "is_special, is_a32, ",
            "first_board_color, first_board_number, ",
            "second_board_color, second_board_number, ",
            "thirdly_board_color, thirdly_board_number)",
            "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT},",
            "#{updateTime,jdbcType=BIGINT}, #{gamblingMessageId,jdbcType=BIGINT}, ",
            "#{boardSize,jdbcType=BIGINT}, #{boardType,jdbcType=TINYINT}, ",
            "#{isSpecial,jdbcType=TINYINT}, #{isA32,jdbcType=TINYINT}, ",
            "#{firstBoardColor,jdbcType=TINYINT}, #{firstBoardNumber,jdbcType=INTEGER}, ",
            "#{secondBoardColor,jdbcType=TINYINT}, #{secondBoardNumber,jdbcType=INTEGER}, ",
            "#{thirdlyBoardColor,jdbcType=TINYINT}, #{thirdlyBoardNumber,jdbcType=INTEGER})"
    })
    int insert(GamblingBoard record);

    @InsertProvider(type = GamblingBoardSqlProvider.class, method = "insertSelective")
    int insertSelective(GamblingBoard record);

    @Select({
            "select",
            "id, create_time, update_time,version, gambling_message_id, board_size, board_type, is_special, ",
            "is_a32, first_board_color, first_board_number, second_board_color, second_board_number, ",
            "thirdly_board_color, thirdly_board_number",
            "from t_gambling_board",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.BIGINT),
            @Result(column = "gambling_message_id", property = "gamblingMessageId", jdbcType = JdbcType.BIGINT),
            @Result(column = "board_size", property = "boardSize", jdbcType = JdbcType.BIGINT),
            @Result(column = "board_type", property = "boardType", jdbcType = JdbcType.TINYINT),
            @Result(column = "is_special", property = "isSpecial", jdbcType = JdbcType.TINYINT),
            @Result(column = "is_a32", property = "isA32", jdbcType = JdbcType.TINYINT),
            @Result(column = "first_board_color", property = "firstBoardColor", jdbcType = JdbcType.TINYINT),
            @Result(column = "first_board_number", property = "firstBoardNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "second_board_color", property = "secondBoardColor", jdbcType = JdbcType.TINYINT),
            @Result(column = "second_board_number", property = "secondBoardNumber", jdbcType = JdbcType.INTEGER),
            @Result(column = "thirdly_board_color", property = "thirdlyBoardColor", jdbcType = JdbcType.TINYINT),
            @Result(column = "thirdly_board_number", property = "thirdlyBoardNumber", jdbcType = JdbcType.INTEGER)
    })
    GamblingBoard selectByPrimaryKey(Long id);

    @UpdateProvider(type = GamblingBoardSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GamblingBoard record);

    @Update({
            "update t_gambling_board",
            "set create_time = #{createTime,jdbcType=BIGINT},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "version = #{version,jdbcType=BIGINT},",
            "gambling_message_id = #{gamblingMessageId,jdbcType=BIGINT},",
            "board_size = #{boardSize,jdbcType=BIGINT},",
            "board_type = #{boardType,jdbcType=TINYINT},",
            "is_special = #{isSpecial,jdbcType=TINYINT},",
            "is_a32 = #{isA32,jdbcType=TINYINT},",
            "first_board_color = #{firstBoardColor,jdbcType=TINYINT},",
            "first_board_number = #{firstBoardNumber,jdbcType=INTEGER},",
            "second_board_color = #{secondBoardColor,jdbcType=TINYINT},",
            "second_board_number = #{secondBoardNumber,jdbcType=INTEGER},",
            "thirdly_board_color = #{thirdlyBoardColor,jdbcType=TINYINT},",
            "thirdly_board_number = #{thirdlyBoardNumber,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GamblingBoard record);

    @Insert({
            "<script>",
            "insert into t_gambling_board(" +
                    "id, " +
                    "create_time, " +
                    "update_time, " +
                    "version, " +
                    "gambling_message_id, " +
                    "board_size, " +
                    "board_type," +
                    "is_special," +
                    "is_a32," +
                    "first_board_color," +
                    "first_board_number," +
                    "second_board_color," +
                    "second_board_number," +
                    "thirdly_board_color," +
                    "thirdly_board_number) values ",
            "<foreach collection='gamblingBoardList' item='item' index='index' separator=','>",
            "(" +
                    "#{item.id}, " +
                    "#{item.createTime}, " +
                    "#{item.updateTime}," +
                    "#{item.version}," +
                    "#{item.gamblingMessageId}," +
                    "#{item.boardSize}," +
                    "#{item.boardType}," +
                    "#{item.isSpecial}," +
                    "#{item.isA32}," +
                    "#{item.firstBoardColor}," +
                    "#{item.firstBoardNumber}," +
                    "#{item.secondBoardColor}," +
                    "#{item.secondBoardNumber}," +
                    "#{item.thirdlyBoardColor}," +
                    "#{item.thirdlyBoardNumber}" +
                    ")",
            "</foreach>",
            "</script>"
    })
    int insertGamblingBoardList(@Param(value = "gamblingBoardList") List<GamblingBoard> gamblingBoardList);


}
