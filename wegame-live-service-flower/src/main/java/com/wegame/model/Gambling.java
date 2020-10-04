package com.wegame.model;

import com.wegame.tools.utils.SnowUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Gambling implements Serializable {

    public Gambling() {
    }

    /**
     * ID
	 * 2020-09-08T23:15:19.363
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-08T23:15:19.366
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-08T23:15:19.366
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-08T23:15:19.366
     */
    private Long version;

    /**
     * 轮次
     * 2020-09-08T23:15:19.366
     */
    private Integer round;

    /**
     * 房间id
	 * 2020-09-08T23:15:19.366
     */
    private Long roomId;

    /**
     * 状态(字典牌局状态枚举)
	 * 2020-09-08T23:15:19.366
     */
    private Integer gamblingStatus;

    /**
     * 积分底注
	 * 2020-09-08T23:15:19.366
     */
    private Long integralFundus;

    /**
     * 牌局总积分
	 * 2020-09-08T23:15:19.366
     */
    private Long integralSum;

    /**
     * 2020-09-08T23:15:19.367
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
     * 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
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
     * 状态(字典牌局状态枚举)
     */
    public Integer getGamblingStatus() {
        return gamblingStatus;
    }

    /**
     * 状态(字典牌局状态枚举)
     */
    public void setGamblingStatus(Integer gamblingStatus) {
        this.gamblingStatus = gamblingStatus;
    }

    /**
     * 积分底注
     */
    public Long getIntegralFundus() {
        return integralFundus;
    }

    /**
     * 积分底注
     */
    public void setIntegralFundus(Long integralFundus) {
        this.integralFundus = integralFundus;
    }

    /**
     * 牌局总积分
     */
    public Long getIntegralSum() {
        return integralSum;
    }

    /**
     * 牌局总积分
     */
    public void setIntegralSum(Long integralSum) {
        this.integralSum = integralSum;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "Gambling{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", round=" + round +
                ", roomId=" + roomId +
                ", gamblingStatus=" + gamblingStatus +
                ", integralFundus=" + integralFundus +
                ", integralSum=" + integralSum +
                '}';
    }
}
