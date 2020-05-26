package com.wegame.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * ID
	 * 2020-05-26T09:58:35.488
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-26T09:58:35.488
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-26T09:58:35.488
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-26T09:58:35.488
     */
    private Long version;

    /**
     * 编号
	 * 2020-05-26T09:58:35.488
     */
    private Integer code;

    /**
     * 头像
	 * 2020-05-26T09:58:35.488
     */
    private String headPortrait;

    /**
     * 积分
	 * 2020-05-26T09:58:35.488
     */
    private Integer integral;

    /**
     * 昵称
	 * 2020-05-26T09:58:35.488
     */
    private String nickName;

    /**
     * 密码
	 * 2020-05-26T09:58:35.488
     */
    private String pwd;

    /**
     * 手机号
	 * 2020-05-26T09:58:35.488
     */
    private Integer phone;

    /**
     * 账号
	 * 2020-05-26T09:58:35.488
     */
    private String userName;

    /**
     * 2020-05-26T09:58:35.488
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 创建日期
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 最后修改日期
     */
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * 最后修改日期
     */
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime == null ? null : lastModifiedTime.trim();
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
     * 编号
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 编号
     */
    public void setCode(Integer code) {
        this.code = code;
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
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 积分
     */
    public void setIntegral(Integer integral) {
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
    public Integer getPhone() {
        return phone;
    }

    /**
     * 手机号
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastModifiedTime=").append(lastModifiedTime);
        sb.append(", version=").append(version);
        sb.append(", code=").append(code);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", integral=").append(integral);
        sb.append(", nickName=").append(nickName);
        sb.append(", pwd=").append(pwd);
        sb.append(", phone=").append(phone);
        sb.append(", userName=").append(userName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}