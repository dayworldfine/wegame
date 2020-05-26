package com.wegame.model;

import java.io.Serializable;

public class GamblingDetails implements Serializable {
    /**
     * ID
	 * 2020-05-26T09:58:35.481
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-26T09:58:35.481
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-26T09:58:35.481
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-26T09:58:35.481
     */
    private Long version;

    /**
     * 比牌用户id
	 * 2020-05-26T09:58:35.481
     */
    private String compareUser;

    /**
     * 操作类型
	 * 2020-05-26T09:58:35.481
     */
    private Integer doType;

    /**
     * 操作筹码加减
	 * 2020-05-26T09:58:35.481
     */
    private Integer operatingLeverage;

    /**
     * 轮次
	 * 2020-05-26T09:58:35.482
     */
    private Integer round;

    /**
     * 座位序号
	 * 2020-05-26T09:58:35.482
     */
    private Integer seatSerial;

    /**
     * 用户编码
	 * 2020-05-26T09:58:35.482
     */
    private Integer userCode;

    /**
     * 2020-05-26T09:58:35.482
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
     * 比牌用户id
     */
    public String getCompareUser() {
        return compareUser;
    }

    /**
     * 比牌用户id
     */
    public void setCompareUser(String compareUser) {
        this.compareUser = compareUser == null ? null : compareUser.trim();
    }

    /**
     * 操作类型
     */
    public Integer getDoType() {
        return doType;
    }

    /**
     * 操作类型
     */
    public void setDoType(Integer doType) {
        this.doType = doType;
    }

    /**
     * 操作筹码加减
     */
    public Integer getOperatingLeverage() {
        return operatingLeverage;
    }

    /**
     * 操作筹码加减
     */
    public void setOperatingLeverage(Integer operatingLeverage) {
        this.operatingLeverage = operatingLeverage;
    }

    /**
     * 轮次
     */
    public Integer getRound() {
        return round;
    }

    /**
     * 轮次
     */
    public void setRound(Integer round) {
        this.round = round;
    }

    /**
     * 座位序号
     */
    public Integer getSeatSerial() {
        return seatSerial;
    }

    /**
     * 座位序号
     */
    public void setSeatSerial(Integer seatSerial) {
        this.seatSerial = seatSerial;
    }

    /**
     * 用户编码
     */
    public Integer getUserCode() {
        return userCode;
    }

    /**
     * 用户编码
     */
    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
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
        sb.append(", compareUser=").append(compareUser);
        sb.append(", doType=").append(doType);
        sb.append(", operatingLeverage=").append(operatingLeverage);
        sb.append(", round=").append(round);
        sb.append(", seatSerial=").append(seatSerial);
        sb.append(", userCode=").append(userCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}