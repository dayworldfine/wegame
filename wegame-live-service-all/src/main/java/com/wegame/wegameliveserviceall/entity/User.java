package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName：User
 * @Description: 用户表
 * @Author：13738700108
 * @Data 2020/2/14 21:13
 * @Version: v1.0
 **/

//@Data
@Entity
@Table(name = "t_user")
@org.hibernate.annotations.Table(appliesTo = "t_user",comment="用户")
public class User extends BaseEntity<String> {

    private static final long serialVersionUID = -702313206961667663L;

    /**
     * 编号
     */
    @Column(name = "CODE", nullable = false, length = 10, unique = true,columnDefinition = "int(10) comment '编号' not null UNIQUE key auto_increment")
    private int code;

    /**
     * 昵称
     */
    @Column(name = "NICKNAME", columnDefinition = "varchar(20) comment '昵称'")
    private String nickName;

    /**
     * 头像
     */
    @Column(name = "HEADPORTRAIT", columnDefinition = "varchar(50) comment '头像'")
    private String headPortrait;

    /**
     *  账号
     */
    @Column(name = "USERNAME", columnDefinition = "varchar(50) comment '账号'")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "PASSWORD", columnDefinition = "varchar(50) comment '密码'")
    private String passWord;

    /**
     * 手机号
     */
    @Column(name = "PHONE", columnDefinition = "int(11) comment '手机号'")
    private int phone;

    /**
     * 积分
     */
    @Column(name = "INTEGRAL", columnDefinition = "int(20) comment '积分'")
    private int integral;


//    /**
//     * 牌局统计
//     */
//    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//    private Set<GamblingStatistics> gamblingStatistics;

//    /**
//     * 牌局信息
//     */
//    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//    private Set<GamblingMessage> gamblingMessages;

//    /**
//     * 牌局详情
//     */
//    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//    private Set<GamblingDetails> gamblingDetails;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

