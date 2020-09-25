package com.wegame.service.Impl;

import com.wegame.mapper.UserMapper;
import com.wegame.model.User;
import com.wegame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：UserServiceImpl
 * @Description: 用户
 * @Author：13738700108
 * @Data 2020/2/15 21:07
 * @Version: v1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
