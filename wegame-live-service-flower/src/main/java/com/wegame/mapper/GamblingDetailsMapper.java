package com.wegame.mapper;

import com.wegame.model.GamblingDetails;
import com.wegame.model.GamblingDetailsExample;
import java.util.List;

import com.wegame.provider.GamblingDetailsSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface GamblingDetailsMapper {
    @SelectProvider(type= GamblingDetailsSqlProvider.class, method="countByExample")
    long countByExample(GamblingDetailsExample example);

    @DeleteProvider(type=GamblingDetailsSqlProvider.class, method="deleteByExample")
    int deleteByExample(GamblingDetailsExample example);

    @Insert({
        "insert into t_gambling_details (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "COMPAREUSER, DOTYPE, ",
        "OPERATINGLEVERAGE, ROUND, ",
        "SEATSERIAL, USERCODE)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{compareuser,jdbcType=VARCHAR}, #{dotype,jdbcType=INTEGER}, ",
        "#{operatingleverage,jdbcType=INTEGER}, #{round,jdbcType=INTEGER}, ",
        "#{seatserial,jdbcType=INTEGER}, #{usercode,jdbcType=INTEGER})"
    })
    int insert(GamblingDetails record);

    @InsertProvider(type=GamblingDetailsSqlProvider.class, method="insertSelective")
    int insertSelective(GamblingDetails record);

    @SelectProvider(type=GamblingDetailsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATEDATE", property="createdate", jdbcType=JdbcType.VARCHAR),
        @Result(column="LASTMODIFIEDTIME", property="lastmodifiedtime", jdbcType=JdbcType.VARCHAR),
        @Result(column="VERSION", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="COMPAREUSER", property="compareuser", jdbcType=JdbcType.VARCHAR),
        @Result(column="DOTYPE", property="dotype", jdbcType=JdbcType.INTEGER),
        @Result(column="OPERATINGLEVERAGE", property="operatingleverage", jdbcType=JdbcType.INTEGER),
        @Result(column="ROUND", property="round", jdbcType=JdbcType.INTEGER),
        @Result(column="SEATSERIAL", property="seatserial", jdbcType=JdbcType.INTEGER),
        @Result(column="USERCODE", property="usercode", jdbcType=JdbcType.INTEGER)
    })
    List<GamblingDetails> selectByExample(GamblingDetailsExample example);

    @UpdateProvider(type=GamblingDetailsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GamblingDetails record, @Param("example") GamblingDetailsExample example);

    @UpdateProvider(type=GamblingDetailsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GamblingDetails record, @Param("example") GamblingDetailsExample example);
}
