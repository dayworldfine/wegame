package com.wegame.model;

import java.io.Serializable;

public class Seat implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.262
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.262
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.262
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.262
     */
    private Long version;

    /**
     * 座位状态(字典座位状态枚举)
	 * 2020-09-06T21:55:05.262
     */
    private Byte seatStatus;

    /**
     * 房间id
	 * 2020-09-06T21:55:05.262
     */
    private Long roomId;

    /**
     * 用户id
	 * 2020-09-06T21:55:05.262
     */
    private Long userId;

    /**
     * 2020-09-06T21:55:05.262
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
     * 座位状态(字典座位状态枚举)
     */
    public Byte getSeatStatus() {
        return seatStatus;
    }

    /**
     * 座位状态(字典座位状态枚举)
     */
    public void setSeatStatus(Byte seatStatus) {
        this.seatStatus = seatStatus;
    }

    /**
     * 房间id
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * 房间id
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
        sb.append(", seatStatus=").append(seatStatus);
        sb.append(", roomId=").append(roomId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
