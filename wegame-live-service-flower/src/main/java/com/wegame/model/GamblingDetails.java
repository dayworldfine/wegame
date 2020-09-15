package com.wegame.model;

import com.wegame.tools.utils.SnowUtils;

import java.io.Serializable;

public class GamblingDetails implements Serializable {

    public GamblingDetails(){
    }

    /**
     * ID
	 * 2020-09-06T21:55:05.243
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.243
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.243
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.243
     */
    private Long version;

    /**
     * 牌局id
	 * 2020-09-06T21:55:05.243
     */
    private Long gamblingId;

    /**
     * 比牌用户id
	 * 2020-09-06T21:55:05.243
     */
    private Long compareUserId;

    /**
     * 操作类型(见字典表操作类型枚举)
	 * 2020-09-06T21:55:05.243
     */
    private Integer operationType;

    /**
     * 操作筹码加减
	 * 2020-09-06T21:55:05.243
     */
    private Long operatingLeverage;

    /**
     * 轮次
	 * 2020-09-06T21:55:05.243
     */
    private Integer round;

    /**
     * 座位id
	 * 2020-09-06T21:55:05.243
     */
    private Long seatId;

    /**
     * 用户id
	 * 2020-09-06T21:55:05.243
     */
    private Long userId;

    /**
     * 同用户同轮次排序
	 * 2020-09-06T21:55:05.243
     */
    private Integer sort;

    /**
     * 2020-09-06T21:55:05.244
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
     * 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
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
     * 比牌用户id
     */
    public Long getCompareUserId() {
        return compareUserId;
    }

    /**
     * 比牌用户id
     */
    public void setCompareUserId(Long compareUserId) {
        this.compareUserId = compareUserId;
    }

    /**
     * 操作类型(见字典表操作类型枚举)
     */
    public Integer getOperationType() {
        return operationType;
    }

    /**
     * 操作类型(见字典表操作类型枚举)
     */
    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    /**
     * 操作筹码加减
     */
    public Long getOperatingLeverage() {
        return operatingLeverage;
    }

    /**
     * 操作筹码加减
     */
    public void setOperatingLeverage(Long operatingLeverage) {
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
     * 座位id
     */
    public Long getSeatId() {
        return seatId;
    }

    /**
     * 座位id
     */
    public void setSeatId(Long seatId) {
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
     * 同用户同轮次排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 同用户同轮次排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "GamblingDetails{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", gamblingId=" + gamblingId +
                ", compareUserId=" + compareUserId +
                ", operationType=" + operationType +
                ", operatingLeverage=" + operatingLeverage +
                ", round=" + round +
                ", seatId=" + seatId +
                ", userId=" + userId +
                ", sort=" + sort +
                '}';
    }
}
