package com.wegame.mapper;

import com.wegame.model.User;
import com.wegame.provider.UserSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;

public interface UserMapper {
    @Insert({
        "insert into t_user (id, create_date, ",
        "last_modified_time, version, ",
        "code, head_portrait, ",
        "integral, nick_name, ",
        "pwd, phone, user_name)",
        "values (#{id,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, ",
        "#{lastModifiedTime,jdbcType=VARCHAR}, #{version,jdbcType=BIGINT}, ",
        "#{code,jdbcType=INTEGER}, #{headPortrait,jdbcType=VARCHAR}, ",
        "#{integral,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{phone,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);
}
