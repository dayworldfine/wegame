package com.wegame.service.Impl;

import com.wegame.mapper.UserMapper;
import com.wegame.model.User;
import com.wegame.service.UserService;
import com.wegame.tools.utils.MD5Utiles;
import com.wegame.tools.utils.SnowUtils;
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

    @Override
    public void addUser(String userName, String nickName, String pwd, String phone) {
        User user = new User();
//        user.setId(SnowUtils.generateId());
        user.setCreateTime(System.currentTimeMillis());
        user.setUpdateTime(System.currentTimeMillis());
        user.setVersion(1l);
        user.setHeadPortrait("https://img.tomtangmu.com/images/2019/08/05/u203009510364911888fm26gp0.jpg");
        user.setIntegral(10000l);
        user.setNickName(nickName);
        user.setUserName(userName);
        user.setPwd(MD5Utiles.StringMD5(pwd));
        user.setPhone(Long.valueOf(phone));
        userMapper.insert(user);
    }
}
