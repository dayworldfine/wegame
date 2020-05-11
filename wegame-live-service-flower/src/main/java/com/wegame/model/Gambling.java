package com.wegame.model;

import java.io.Serializable;

public class Gambling implements Serializable {
    /**
     * ID
	 * 2020-05-11T16:28:03.493
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-11T16:28:03.495
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-11T16:28:03.495
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-11T16:28:03.495
     */
    private Long version;

    /**
     * 房间序号
	 * 2020-05-11T16:28:03.495
     */
    private Integer roomSerial;

    /**
     * 状态
	 * 2020-05-11T16:28:03.495
     */
    private Integer status;

    /**
     * 庄家座位序号
	 * 2020-05-11T16:28:03.495
     */
    private String seatId;

    /**
     * 2020-05-11T16:28:03.495
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
     * 庄家座位序号
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * 庄家座位序号
     */
    public void setSeatId(String seatId) {
        this.seatId = seatId == null ? null : seatId.trim();
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
        sb.append(", roomSerial=").append(roomSerial);
        sb.append(", status=").append(status);
        sb.append(", seatId=").append(seatId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}