package com.wegame.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.263
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.263
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.264
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.264
     */
    private Long version;

    /**
     * 头像
	 * 2020-09-06T21:55:05.264
     */
    private String headPortrait;

    /**
     * 积分
	 * 2020-09-06T21:55:05.264
     */
    private Long integral;

    /**
     * 昵称
	 * 2020-09-06T21:55:05.264
     */
    private String nickName;

    /**
     * 账号
	 * 2020-09-06T21:55:05.264
     */
    private String userName;

    /**
     * 密码
	 * 2020-09-06T21:55:05.264
     */
    private String pwd;

    /**
     * 手机号
	 * 2020-09-06T21:55:05.264
     */
    private Long phone;

    /**
     * 2020-09-06T21:55:05.264
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建日期
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建日期
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改日期
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后修改日期
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 版本
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 版本
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    /**
     * 积分
     */
    public Long getIntegral() {
        return integral;
    }

    /**
     * 积分
     */
    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    /**
     * 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 账号
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 手机号
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 手机号
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", integral=").append(integral);
        sb.append(", nickName=").append(nickName);
        sb.append(", userName=").append(userName);
        sb.append(", pwd=").append(pwd);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
