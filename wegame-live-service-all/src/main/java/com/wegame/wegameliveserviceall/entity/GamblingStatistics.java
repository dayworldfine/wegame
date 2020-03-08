package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName：GamblingStatistics
 * @Description: 牌局统计
 * @Author：13738700108
 * @Data 2020/2/15 1:51
 * @Version: v1.0
 **/

//@Data
@Entity
@Table(name = "t_gambling_statistics")
@org.hibernate.annotations.Table(appliesTo = "t_gambling_statistics",comment="牌局统计")
public class GamblingStatistics extends BaseEntity<String> {

    private static final long serialVersionUID = -4963635808380190129L;

    /**
     * 积分
     */
    @Column(name = "INTEGRAL",columnDefinition = "int(8) comment '积分'")
    private int integral;

    /**
     * 开始时间
     */
    @Column(name = "STARTTIME",columnDefinition = "varchar(20) comment '开始时间'")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "ENDTIME",columnDefinition = "varchar(50) comment '结束时间'")
    private String endTime;

    /**
     * 房间序号
     */
    @Column(name = "ROOMSERIAL",columnDefinition = "int(4) comment '房间序号'")
    private int roomSerial;

    /**
     * 用户编码
     */
    @Column(name = "USERCODE",columnDefinition = "int(4) comment '用户编码'")
    private int userCode;

    /**
     * 座位序号
     */
    @Column(name = "SEATSERIAL",columnDefinition = "int(4) comment '座位序号'")
    private int seatSerial;

    /**
     * 牌局
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "GAMBLING",nullable = false)
    private Gambling gambling;

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Gambling getGambling() {
        return gambling;
    }

    public void setGambling(Gambling gambling) {
        this.gambling = gambling;
    }

    public int getRoomSerial() {
        return roomSerial;
    }

    public void setRoomSerial(int roomSerial) {
        this.roomSerial = roomSerial;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getSeatSerial() {
        return seatSerial;
    }

    public void setSeatSerial(int seatSerial) {
        this.seatSerial = seatSerial;
    }
}
