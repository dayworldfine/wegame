package com.wegame.wegameliveserviceall.service;

import com.wegame.wegameliveserviceall.entity.User;

/**
 * @InterfaceName：UserService
 * @Description: 用户接口
 * @Author：13738700108
 * @Data 2020/2/15 21:06
 * @Version: v1.0
 **/
public interface UserService {

    /**
     * 根据用户名查找用户
     * @return
     */
    User findUserByUserName(String userName);
}
