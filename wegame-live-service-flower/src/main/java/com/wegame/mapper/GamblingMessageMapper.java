package com.wegame.mapper;

import com.wegame.model.GamblingMessage;
import com.wegame.provider.GamblingMessageSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface GamblingMessageMapper {
    @Insert({
        "insert into t_gambling_message (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "BOARD, ENDING, SEATSERIAL, ",
        "SEECARD, USERCODE, ",
        "GAMBLINGID)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{board,jdbcType=VARCHAR}, #{ending,jdbcType=INTEGER}, #{seatserial,jdbcType=INTEGER}, ",
        "#{seecard,jdbcType=INTEGER}, #{usercode,jdbcType=INTEGER}, ",
        "#{gamblingid,jdbcType=VARCHAR})"
    })
    int insert(GamblingMessage record);

    @InsertProvider(type= GamblingMessageSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingMessage record);
}
