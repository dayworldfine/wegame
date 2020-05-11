package com.wegame.model;

import java.io.Serializable;

public class Board implements Serializable {
    /**
     * ID
	 * 2020-05-11T16:28:03.519
     */
    private String id;

    /**
     * 创建日期
	 * 2020-05-11T16:28:03.519
     */
    private String createDate;

    /**
     * 最后修改日期
	 * 2020-05-11T16:28:03.519
     */
    private String lastModifiedTime;

    /**
     * 版本
	 * 2020-05-11T16:28:03.519
     */
    private Long version;

    /**
     * 第一张牌花色
	 * 2020-05-11T16:28:03.520
     */
    private Integer firstBoardColor;

    /**
     * 第一张牌值
	 * 2020-05-11T16:28:03.520
     */
    private Integer firstBoardValue;

    /**
     * 第二张牌花色
	 * 2020-05-11T16:28:03.520
     */
    private Integer secondBoardColor;

    /**
     * 第二张牌值
	 * 2020-05-11T16:28:03.520
     */
    private Integer secondBoardValue;

    /**
     * 第三张牌花色
	 * 2020-05-11T16:28:03.520
     */
    private Integer thirdlyBoardColor;

    /**
     * 第三张牌值
	 * 2020-05-11T16:28:03.520
     */
    private Integer thirdlyBoardValue;

    /**
     * 牌值大小
	 * 2020-05-11T16:28:03.520
     */
    private Long size;

    /**
     * 牌值类型
	 * 2020-05-11T16:28:03.520
     */
    private Integer type;

    /**
     * 2020-05-11T16:28:03.520
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
     * 第一张牌花色
     */
    public Integer getFirstBoardColor() {
        return firstBoardColor;
    }

    /**
     * 第一张牌花色
     */
    public void setFirstBoardColor(Integer firstBoardColor) {
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
     * 第二张牌花色
     */
    public Integer getSecondBoardColor() {
        return secondBoardColor;
    }

    /**
     * 第二张牌花色
     */
    public void setSecondBoardColor(Integer secondBoardColor) {
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
     * 第三张牌花色
     */
    public Integer getThirdlyBoardColor() {
        return thirdlyBoardColor;
    }

    /**
     * 第三张牌花色
     */
    public void setThirdlyBoardColor(Integer thirdlyBoardColor) {
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

    /**
     * 牌值大小
     */
    public Long getSize() {
        return size;
    }

    /**
     * 牌值大小
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 牌值类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 牌值类型
     */
    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", firstBoardColor=").append(firstBoardColor);
        sb.append(", firstBoardValue=").append(firstBoardValue);
        sb.append(", secondBoardColor=").append(secondBoardColor);
        sb.append(", secondBoardValue=").append(secondBoardValue);
        sb.append(", thirdlyBoardColor=").append(thirdlyBoardColor);
        sb.append(", thirdlyBoardValue=").append(thirdlyBoardValue);
        sb.append(", size=").append(size);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}