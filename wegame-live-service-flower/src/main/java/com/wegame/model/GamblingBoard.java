package com.wegame.model;

import java.io.Serializable;

public class GamblingBoard implements Serializable {
    /**
     * ID
	 * 2020-09-06T21:55:05.257
     */
    private Long id;

    /**
     * 创建时间
	 * 2020-09-06T21:55:05.257
     */
    private Long createTime;

    /**
     * 更新时间
	 * 2020-09-06T21:55:05.257
     */
    private Long updateTime;

    /**
     * 牌局信息id
	 * 2020-09-06T21:55:05.257
     */
    private Long gamblingMessageId;

    /**
     * 牌值大小
	 * 2020-09-06T21:55:05.257
     */
    private Long boardSize;

    /**
     * 牌值类型(字典牌值类型枚举)
	 * 2020-09-06T21:55:05.257
     */
    private Byte boardType;

    /**
     * 是否特殊牌(字段常规判断枚举)
	 * 2020-09-06T21:55:05.257
     */
    private Byte isSpecial;

    /**
     * A32也是顺子(字段常规判断枚举)
	 * 2020-09-06T21:55:05.258
     */
    private Byte isA32;

    /**
     * 第一张牌花色类型(字典花色类型枚举)
	 * 2020-09-06T21:55:05.258
     */
    private Byte firstBoardColor;

    /**
     * 第一张牌值
	 * 2020-09-06T21:55:05.258
     */
    private Integer firstBoardValue;

    /**
     * 第二张牌花色类型(字典花色类型枚举)
	 * 2020-09-06T21:55:05.258
     */
    private Byte secondBoardColor;

    /**
     * 第二张牌值
	 * 2020-09-06T21:55:05.258
     */
    private Integer secondBoardValue;

    /**
     * 第三张牌花色类型(字典花色类型枚举)
	 * 2020-09-06T21:55:05.258
     */
    private Byte thirdlyBoardColor;

    /**
     * 第三张牌值
	 * 2020-09-06T21:55:05.258
     */
    private Integer thirdlyBoardValue;

    /**
     * 2020-09-06T21:55:05.258
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
    public Byte getBoardType() {
        return boardType;
    }

    /**
     * 牌值类型(字典牌值类型枚举)
     */
    public void setBoardType(Byte boardType) {
        this.boardType = boardType;
    }

    /**
     * 是否特殊牌(字段常规判断枚举)
     */
    public Byte getIsSpecial() {
        return isSpecial;
    }

    /**
     * 是否特殊牌(字段常规判断枚举)
     */
    public void setIsSpecial(Byte isSpecial) {
        this.isSpecial = isSpecial;
    }

    /**
     * A32也是顺子(字段常规判断枚举)
     */
    public Byte getIsA32() {
        return isA32;
    }

    /**
     * A32也是顺子(字段常规判断枚举)
     */
    public void setIsA32(Byte isA32) {
        this.isA32 = isA32;
    }

    /**
     * 第一张牌花色类型(字典花色类型枚举)
     */
    public Byte getFirstBoardColor() {
        return firstBoardColor;
    }

    /**
     * 第一张牌花色类型(字典花色类型枚举)
     */
    public void setFirstBoardColor(Byte firstBoardColor) {
        this.firstBoardColor = firstBoardColor;
    }

    /**
     * 第一张牌值
     */
    public Integer getFirstBoardValue() {
        return firstBoardValue;
    }

    /**
     * 第一张牌值
     */
    public void setFirstBoardValue(Integer firstBoardValue) {
        this.firstBoardValue = firstBoardValue;
    }

    /**
     * 第二张牌花色类型(字典花色类型枚举)
     */
    public Byte getSecondBoardColor() {
        return secondBoardColor;
    }

    /**
     * 第二张牌花色类型(字典花色类型枚举)
     */
    public void setSecondBoardColor(Byte secondBoardColor) {
        this.secondBoardColor = secondBoardColor;
    }

    /**
     * 第二张牌值
     */
    public Integer getSecondBoardValue() {
        return secondBoardValue;
    }

    /**
     * 第二张牌值
     */
    public void setSecondBoardValue(Integer secondBoardValue) {
        this.secondBoardValue = secondBoardValue;
    }

    /**
     * 第三张牌花色类型(字典花色类型枚举)
     */
    public Byte getThirdlyBoardColor() {
        return thirdlyBoardColor;
    }

    /**
     * 第三张牌花色类型(字典花色类型枚举)
     */
    public void setThirdlyBoardColor(Byte thirdlyBoardColor) {
        this.thirdlyBoardColor = thirdlyBoardColor;
    }

    /**
     * 第三张牌值
     */
    public Integer getThirdlyBoardValue() {
        return thirdlyBoardValue;
    }

    /**
     * 第三张牌值
     */
    public void setThirdlyBoardValue(Integer thirdlyBoardValue) {
        this.thirdlyBoardValue = thirdlyBoardValue;
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
        sb.append(", firstBoardValue=").append(firstBoardValue);
        sb.append(", secondBoardColor=").append(secondBoardColor);
        sb.append(", secondBoardValue=").append(secondBoardValue);
        sb.append(", thirdlyBoardColor=").append(thirdlyBoardColor);
        sb.append(", thirdlyBoardValue=").append(thirdlyBoardValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
