package com.wegame.model;

import java.io.Serializable;

public class Seat implements Serializable {
    /**
     * ID
	 * 2020-05-26T09:58:35.486
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-26T09:58:35.486
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-26T09:58:35.486
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-26T09:58:35.486
     */
    private Long version;

    /**
     * 序号
	 * 2020-05-26T09:58:35.486
     */
    private Integer serial;

    /**
     * 状态
	 * 2020-05-26T09:58:35.486
     */
    private Integer status;

    /**
     * 房间id
	 * 2020-05-26T09:58:35.486
     */
    private String roomId;

    /**
     * 用户编码
	 * 2020-05-26T09:58:35.486
     */
    private Integer userCode;

    /**
     * 看牌情况
	 * 2020-05-26T09:58:35.486
     */
    private Integer seeCard;

    /**
     * 2020-05-26T09:58:35.486
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
     * 序号
     */
    public Integer getSerial() {
        return serial;
    }

    /**
     * 序号
     */
    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 房间id
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * 房间id
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
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
     * 看牌情况
     */
    public Integer getSeeCard() {
        return seeCard;
    }

    /**
     * 看牌情况
     */
    public void setSeeCard(Integer seeCard) {
        this.seeCard = seeCard;
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
        sb.append(", serial=").append(serial);
        sb.append(", status=").append(status);
        sb.append(", roomId=").append(roomId);
        sb.append(", userCode=").append(userCode);
        sb.append(", seeCard=").append(seeCard);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}