package com.wegame.model;

import java.io.Serializable;

public class GamblingStatistics implements Serializable {
    /**
     * ID
	 * 2020-05-11T16:28:03.512
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-11T16:28:03.512
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-11T16:28:03.512
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-11T16:28:03.512
     */
    private Long version;

    /**
     * 结束时间
	 * 2020-05-11T16:28:03.512
     */
    private String endTime;

    /**
     * 积分
	 * 2020-05-11T16:28:03.512
     */
    private Integer integral;

    /**
     * 房间序号
	 * 2020-05-11T16:28:03.512
     */
    private Integer roomSerial;

    /**
     * 座位序号
	 * 2020-05-11T16:28:03.512
     */
    private Integer seatSerial;

    /**
     * 开始时间
	 * 2020-05-11T16:28:03.512
     */
    private String startTime;

    /**
     * 用户编码
	 * 2020-05-11T16:28:03.512
     */
    private Integer userCode;

    /**
     * 牌局
	 * 2020-05-11T16:28:03.512
     */
    private String gambling;

    /**
     * 2020-05-11T16:28:03.512
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
     * 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
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
     * 房间序号
     */
    public Integer getRoomSerial() {
        return roomSerial;
    }

    /**
     * 房间序号
     */
    public void setRoomSerial(Integer roomSerial) {
        this.roomSerial = roomSerial;
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
     * 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
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

    /**
     * 牌局
     */
    public String getGambling() {
        return gambling;
    }

    /**
     * 牌局
     */
    public void setGambling(String gambling) {
        this.gambling = gambling == null ? null : gambling.trim();
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
        sb.append(", endTime=").append(endTime);
        sb.append(", integral=").append(integral);
        sb.append(", roomSerial=").append(roomSerial);
        sb.append(", seatSerial=").append(seatSerial);
        sb.append(", startTime=").append(startTime);
        sb.append(", userCode=").append(userCode);
        sb.append(", gambling=").append(gambling);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}