package com.wegame.model;

import java.io.Serializable;

public class Room implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.260
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.260
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.260
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.260
     */
    private Long version;

    /**
     * 房间名称
	 * 2020-09-06T21:55:05.260
     */
    private String roomName;

    /**
     * 状态(字段房间状态枚举)
	 * 2020-09-06T21:55:05.261
     */
    private Integer status;

    /**
     * 2020-09-06T21:55:05.261
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
     * 房间名称
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 房间名称
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * 状态(字段房间状态枚举)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(字段房间状态枚举)
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
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", version=").append(version);
        sb.append(", roomName=").append(roomName);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
