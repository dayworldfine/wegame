package com.wegame.wegameliveserviceall.repository;

import com.wegame.wegameliveserviceall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName：UserRepository
 * @Description: 用户
 * @Author：13738700108
 * @Data 2020/2/15 21:12
 * @Version: v1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User u where u.userName = ?1")
    User findByUserName(String userName);
}
