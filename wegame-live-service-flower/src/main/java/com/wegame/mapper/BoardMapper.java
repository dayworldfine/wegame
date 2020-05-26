package com.wegame.mapper;

import com.wegame.model.Board;
import com.wegame.provider.BoardSqlProvider;
import com.wegame.tools.flower.Player;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    @Insert({
        "insert into t_board (id, create_date, ",
        "last_modified_time, version, ",
        "first_board_color, first_board_value, ",
        "second_board_color, second_board_value, ",
        "thirdly_board_color, thirdly_board_value, ",
        "size, type)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{firstBoardColor,jdbcType=INTEGER}, #{firstBoardValue,jdbcType=INTEGER}, ",
        "#{secondBoardColor,jdbcType=INTEGER}, #{secondBoardValue,jdbcType=INTEGER}, ",
        "#{thirdlyBoardColor,jdbcType=INTEGER}, #{thirdlyBoardValue,jdbcType=INTEGER}, ",
        "#{size,jdbcType=BIGINT}, #{type,jdbcType=INTEGER})"
    })
    int insert(Board record);

    @InsertProvider(type=BoardSqlProvider.class, method="insertSelective")
    int insertSelective(Board record);

    @Insert("<script>"  +
            "INSERT INTO t_board(firstBoardValue,firstBoardColor,secondBoardValue,secondBoardColor" +
            ",thirdlyBoardValue,thirdlyBoardColor,size,type,special,isa32) VALUES" +
            "<foreach collection=\"boards\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{item.firstBoardValue},#{item.firstBoardColor},#{item.secondBoardValue}" +
            ",#{item.secondBoardColor},#{item.thirdlyBoardValue},#{item.thirdlyBoardColor}" +
            ",#{item.size},#{item.type},#{item.special},#{item.isa32})" +
            "</foreach>" +
            "</script>")
    int insertAll(List<Board> boards);
}
