package com.wegame.model;

import java.io.Serializable;

public class Room implements Serializable {
    /**
     * ID
	 * 2020-05-26T09:58:35.484
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-26T09:58:35.484
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-26T09:58:35.485
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-26T09:58:35.485
     */
    private Long version;

    /**
     * 用户名
	 * 2020-05-26T09:58:35.485
     */
    private String roomName;

    /**
     * 序号
	 * 2020-05-26T09:58:35.485
     */
    private Integer serial;

    /**
     * 状态
	 * 2020-05-26T09:58:35.485
     */
    private Integer status;

    /**
     * 2020-05-26T09:58:35.485
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
     * 用户名
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 用户名
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
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
        sb.append(", roomName=").append(roomName);
        sb.append(", serial=").append(serial);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}