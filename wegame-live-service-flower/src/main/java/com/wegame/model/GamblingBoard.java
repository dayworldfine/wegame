package com.wegame.model;

import java.io.Serializable;

public class GamblingBoard implements Serializable {
    /**
     * ID
	 * 2020-09-08T20:55:36.864
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-08T20:55:36.867
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-08T20:55:36.867
     */
    private Long updateTime;

    /**
     * 牌局信息id
	 * 2020-09-08T20:55:36.867
     */
    private Long gamblingMessageId;

    /**
     * 牌值大小
	 * 2020-09-08T20:55:36.867
     */
    private Long boardSize;

    /**
     * 牌值类型(字典牌值类型枚举)
	 * 2020-09-08T20:55:36.867
     */
    private Integer boardType;

    /**
     * 是否特殊牌(字段常规判断枚举)
	 * 2020-09-08T20:55:36.867
     */
    private Integer isSpecial;

    /**
     * A32也是顺子(字段常规判断枚举)
	 * 2020-09-08T20:55:36.868
     */
    private Integer isA32;

    /**
     * 第一张牌花色类型(字典花色类型枚举)
	 * 2020-09-08T20:55:36.868
     */
    private Integer firstBoardColor;

    /**
     * 第一张牌值
	 * 2020-09-08T20:55:36.868
     */
    private Integer firstBoardNumber;

    /**
     * 第二张牌花色类型(字典花色类型枚举)
	 * 2020-09-08T20:55:36.868
     */
    private Integer secondBoardColor;

    /**
     * 第二张牌值
	 * 2020-09-08T20:55:36.868
     */
    private Integer secondBoardNumber;

    /**
     * 第三张牌花色类型(字典花色类型枚举)
	 * 2020-09-08T20:55:36.868
     */
    private Integer thirdlyBoardColor;

    /**
     * 第三张牌值
	 * 2020-09-08T20:55:36.868
     */
    private Integer thirdlyBoardNumber;

    /**
     * 2020-09-08T20:55:36.868
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
     * 牌局信息id
     */
    public Long getGamblingMessageId() {
        return gamblingMessageId;
    }

    /**
     * 牌局信息id
     */
    public void setGamblingMessageId(Long gamblingMessageId) {
        this.gamblingMessageId = gamblingMessageId;
    }

    /**
     * 牌值大小
     */
    public Long getBoardSize() {
        return boardSize;
    }

    /**
     * 牌值大小
     */
    public void setBoardSize(Long boardSize) {
        this.boardSize = boardSize;
    }

    /**
     * 牌值类型(字典牌值类型枚举)
     */
    public Integer getBoardType() {
        return boardType;
    }

    /**
     * 牌值类型(字典牌值类型枚举)
     */
    public void setBoardType(Integer boardType) {
        this.boardType = boardType;
    }

    /**
     * 是否特殊牌(字段常规判断枚举)
     */
    public Integer getIsSpecial() {
        return isSpecial;
    }

    /**
     * 是否特殊牌(字段常规判断枚举)
     */
    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }

    /**
     * A32也是顺子(字段常规判断枚举)
     */
    public Integer getIsA32() {
        return isA32;
    }

    /**
     * A32也是顺子(字段常规判断枚举)
     */
    public void setIsA32(Integer isA32) {
        this.isA32 = isA32;
    }

    /**
     * 第一张牌花色类型(字典花色类型枚举)
     */
    public Integer getFirstBoardColor() {
        return firstBoardColor;
    }

    /**
     * 第一张牌花色类型(字典花色类型枚举)
     */
    public void setFirstBoardColor(Integer firstBoardColor) {
        this.firstBoardColor = firstBoardColor;
    }

    /**
     * 第一张牌值
     */
    public Integer getFirstBoardNumber() {
        return firstBoardNumber;
    }

    /**
     * 第一张牌值
     */
    public void setFirstBoardNumber(Integer firstBoardNumber) {
        this.firstBoardNumber = firstBoardNumber;
    }

    /**
     * 第二张牌花色类型(字典花色类型枚举)
     */
    public Integer getSecondBoardColor() {
        return secondBoardColor;
    }

    /**
     * 第二张牌花色类型(字典花色类型枚举)
     */
    public void setSecondBoardColor(Integer secondBoardColor) {
        this.secondBoardColor = secondBoardColor;
    }

    /**
     * 第二张牌值
     */
    public Integer getSecondBoardNumber() {
        return secondBoardNumber;
    }

    /**
     * 第二张牌值
     */
    public void setSecondBoardNumber(Integer secondBoardNumber) {
        this.secondBoardNumber = secondBoardNumber;
    }

    /**
     * 第三张牌花色类型(字典花色类型枚举)
     */
    public Integer getThirdlyBoardColor() {
        return thirdlyBoardColor;
    }

    /**
     * 第三张牌花色类型(字典花色类型枚举)
     */
    public void setThirdlyBoardColor(Integer thirdlyBoardColor) {
        this.thirdlyBoardColor = thirdlyBoardColor;
    }

    /**
     * 第三张牌值
     */
    public Integer getThirdlyBoardNumber() {
        return thirdlyBoardNumber;
    }

    /**
     * 第三张牌值
     */
    public void setThirdlyBoardNumber(Integer thirdlyBoardNumber) {
        this.thirdlyBoardNumber = thirdlyBoardNumber;
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
        sb.append(", gamblingMessageId=").append(gamblingMessageId);
        sb.append(", boardSize=").append(boardSize);
        sb.append(", boardType=").append(boardType);
        sb.append(", isSpecial=").append(isSpecial);
        sb.append(", isA32=").append(isA32);
        sb.append(", firstBoardColor=").append(firstBoardColor);
        sb.append(", firstBoardNumber=").append(firstBoardNumber);
        sb.append(", secondBoardColor=").append(secondBoardColor);
        sb.append(", secondBoardNumber=").append(secondBoardNumber);
        sb.append(", thirdlyBoardColor=").append(thirdlyBoardColor);
        sb.append(", thirdlyBoardNumber=").append(thirdlyBoardNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
