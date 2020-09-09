package com.wegame.model;

import java.io.Serializable;

public class GamblingStatistics implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.252
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.252
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.252
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.252
     */
    private Long version;

    /**
     * 积分计算
	 * 2020-09-06T21:55:05.252
     */
    private Long integral;

    /**
     * 牌局id
	 * 2020-09-06T21:55:05.252
     */
    private Long gamblingId;

    /**
     * 座位id
	 * 2020-09-06T21:55:05.252
     */
    private Integer seatId;

    /**
     * 用户id
	 * 2020-09-06T21:55:05.253
     */
    private Long userId;

    /**
     * 是否胜利(字段常规判断字段)
	 * 2020-09-06T21:55:05.253
     */
    private Integer isWin;

    /**
     * 开始时间
	 * 2020-09-06T21:55:05.253
     */
    private Long startTime;

    /**
     * 结束时间
	 * 2020-09-06T21:55:05.253
     */
    private Long endTime;

    /**
     * 2020-09-06T21:55:05.253
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
     * 积分计算
     */
    public Long getIntegral() {
        return integral;
    }

    /**
     * 积分计算
     */
    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    /**
     * 牌局id
     */
    public Long getGamblingId() {
        return gamblingId;
    }

    /**
     * 牌局id
     */
    public void setGamblingId(Long gamblingId) {
        this.gamblingId = gamblingId;
    }

    /**
     * 座位id
     */
    public Integer getSeatId() {
        return seatId;
    }

    /**
     * 座位id
     */
    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
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

    /**
     * 是否胜利(字段常规判断字段)
     */
    public Integer getIsWin() {
        return isWin;
    }

    /**
     * 是否胜利(字段常规判断字段)
     */
    public void setIsWin(Integer isWin) {
        this.isWin = isWin;
    }

    /**
     * 开始时间
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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
        sb.append(", integral=").append(integral);
        sb.append(", gamblingId=").append(gamblingId);
        sb.append(", seatId=").append(seatId);
        sb.append(", userId=").append(userId);
        sb.append(", isWin=").append(isWin);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
