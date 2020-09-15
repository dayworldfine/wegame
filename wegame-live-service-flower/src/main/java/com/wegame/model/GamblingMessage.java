package com.wegame.model;

import com.wegame.tools.utils.SnowUtils;

import java.io.Serializable;

public class GamblingMessage implements Serializable {

    public GamblingMessage(){
    }
    /**
     * ID
	 * 2020-09-06T21:55:05.255
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.255
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.255
     */
    private Long updateTime;

    /**
     * 版本
	 * 2020-09-06T21:55:05.255
     */
    private Long version;

    /**
     * 牌局id
	 * 2020-09-06T21:55:05.256
     */
    private Long gamblingId;

    /**
     * 用户id
	 * 2020-09-06T21:55:05.256
     */
    private Long userId;

    /**
     * 座位id
	 * 2020-09-06T21:55:05.256
     */
    private Long seatId;

    /**
     * 是否庄家座位(字典常规判断枚举)
	 * 2020-09-06T21:55:05.256
     */
    private Integer isBanker;

    /**
     * 是否有玩家(字典常规判断枚举)
	 * 2020-09-06T21:55:05.256
     */
    private Integer isUser;

    /**
     * 看牌状态(字段常规判断枚举)
	 * 2020-09-06T21:55:05.256
     */
    private Integer seeCardStatus;

    /**
     * 牌局游戏状态(字典牌局游戏状态枚举)
	 * 2020-09-06T21:55:05.256
     */
    private Integer gameStatus;

    /**
     * 2020-09-06T21:55:05.256
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
     * 是否庄家座位(字典常规判断枚举)
     */
    public Integer getIsBanker() {
        return isBanker;
    }

    /**
     * 是否庄家座位(字典常规判断枚举)
     */
    public void setIsBanker(Integer isBanker) {
        this.isBanker = isBanker;
    }

    /**
     * 是否有玩家(字典常规判断枚举)
     */
    public Integer getIsUser() {
        return isUser;
    }

    /**
     * 是否有玩家(字典常规判断枚举)
     */
    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }

    /**
     * 看牌状态(字段常规判断枚举)
     */
    public Integer getSeeCardStatus() {
        return seeCardStatus;
    }

    /**
     * 看牌状态(字段常规判断枚举)
     */
    public void setSeeCardStatus(Integer seeCardStatus) {
        this.seeCardStatus = seeCardStatus;
    }

    /**
     * 牌局游戏状态(字典牌局游戏状态枚举)
     */
    public Integer getGameStatus() {
        return gameStatus;
    }

    /**
     * 牌局游戏状态(字典牌局游戏状态枚举)
     */
    public void setGameStatus(Integer gameStatus) {
        this.gameStatus = gameStatus;
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
        sb.append(", gamblingId=").append(gamblingId);
        sb.append(", userId=").append(userId);
        sb.append(", seatId=").append(seatId);
        sb.append(", isBanker=").append(isBanker);
        sb.append(", isUser=").append(isUser);
        sb.append(", seeCardStatus=").append(seeCardStatus);
        sb.append(", gameStatus=").append(gameStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
