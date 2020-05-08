package com.wegame.mapper;

import com.wegame.model.User;
import com.wegame.provider.UserSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface UserMapper {
    @Insert({
        "insert into t_user (ID, CREATEDATE, ",
        "LASTMODIFIEDTIME, VERSION, ",
        "CODE, HEADPORTRAIT, ",
        "INTEGRAL, NICKNAME, ",
        "PASSWORD, PHONE, ",
        "USERNAME)",
        "values (#{id,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, ",
        "#{lastmodifiedtime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{code,jdbcType=INTEGER}, #{headportrait,jdbcType=VARCHAR}, ",
        "#{integral,jdbcType=INTEGER}, #{nickname,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=INTEGER}, ",
        "#{username,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type= UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);
}
