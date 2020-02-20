package com.wegame.wegameliveserviceall.service.Impl;

import com.wegame.wegameliveserviceall.entity.User;
import com.wegame.wegameliveserviceall.repository.UserRepository;
import com.wegame.wegameliveserviceall.service.UserService;
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
    private UserRepository userRepository;

    @Override
    public User findUserByUserName(String userName) {
       User user = userRepository.findByUserName(userName);
        return null;
    }
}
