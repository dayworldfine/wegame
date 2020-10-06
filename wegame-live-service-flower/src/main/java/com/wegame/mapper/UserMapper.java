package com.wegame.mapper;

import com.wegame.dto.GameOverNameDto;
import com.wegame.model.User;
import com.wegame.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Delete({
            "delete from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into t_user (id, create_time, ",
            "update_time, version, ",
            "head_portrait, integral, ",
            "nick_name, user_name, ",
            "pwd, phone)",
            "values (#{id,jdbcType=BIGINT}, #{createTime,jdbcType=BIGINT}, ",
            "#{updateTime,jdbcType=BIGINT}, #{version,jdbcType=BIGINT}, ",
            "#{headPortrait,jdbcType=VARCHAR}, #{integral,jdbcType=BIGINT}, ",
            "#{nickName,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
            "#{pwd,jdbcType=VARCHAR}, #{phone,jdbcType=BIGINT})"
    })
    int insert(User record);

    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    int insertSelective(User record);

    @Select({
            "select",
            "id, create_time, update_time, version, head_portrait, integral, nick_name, user_name, ",
            "pwd, phone",
            "from t_user",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.BIGINT),
            @Result(column = "head_portrait", property = "headPortrait", jdbcType = JdbcType.VARCHAR),
            @Result(column = "integral", property = "integral", jdbcType = JdbcType.BIGINT),
            @Result(column = "nick_name", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.BIGINT)
    })
    User selectByPrimaryKey(Long id);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update t_user",
            "set create_time = #{createTime,jdbcType=BIGINT},",
            "update_time = #{updateTime,jdbcType=BIGINT},",
            "version = #{version,jdbcType=BIGINT},",
            "head_portrait = #{headPortrait,jdbcType=VARCHAR},",
            "integral = #{integral,jdbcType=BIGINT},",
            "nick_name = #{nickName,jdbcType=VARCHAR},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "pwd = #{pwd,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=BIGINT}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);

    @Update({
            "update t_user ",
            "set integral = (integral+ #{Integral,jdbcType=BIGINT})",
            "where id = #{userId,jdbcType=BIGINT}"
    })
    int updateUserIntegral(Long userId, Long Integral);

    /**
     * 根据名字查询实体
     * @param userName
     * @return
     */
    @Select({
            "select ",
            "id,create_time,update_time,version,head_portrait,integral,nick_name,",
            "user_name,pwd,phone ",
            "from t_user ",
            "where user_name = #{userName,jdbcType=VARCHAR}"
    })
    User findByUserName(String userName);

    @Select({
            "select id as userId, nick_name as nickName from t_user where id in (${userIds})"
    })
    List<GameOverNameDto> selectGameOverMsg(@Param(value = "userIds")  String userIds);
}
