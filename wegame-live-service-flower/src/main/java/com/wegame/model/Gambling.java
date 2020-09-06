package com.wegame.model;

import java.io.Serializable;

public class Gambling implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.220
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.222
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.222
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.222
     */
    private Long version;

    /**
     * 房间id
	 * 2020-09-06T21:55:05.222
     */
    private Long roomId;

    /**
     * 状态(字典牌局状态枚举)
	 * 2020-09-06T21:55:05.222
     */
    private Byte gamblingStatus;

    /**
     * 积分底注


	 * 2020-09-06T21:55:05.222
     */
    private Long integralFundus;

    /**
     * 牌局总积分
	 * 2020-09-06T21:55:05.222
     */
    private Long integralSum;

    /**
     * 2020-09-06T21:55:05.222
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
    public Byte getGamblingStatus() {
        return gamblingStatus;
    }

    /**
     * 状态(字典牌局状态枚举)
     */
    public void setGamblingStatus(Byte gamblingStatus) {
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
        sb.append(", roomId=").append(roomId);
        sb.append(", gamblingStatus=").append(gamblingStatus);
        sb.append(", integralFundus=").append(integralFundus);
        sb.append(", integralSum=").append(integralSum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
