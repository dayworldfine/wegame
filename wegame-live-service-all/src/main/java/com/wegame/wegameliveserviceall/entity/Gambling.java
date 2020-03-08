package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName：Gambling
 * @Description: 牌局表
 * @Author：13738700108
 * @Data 2020/2/14 21:08
 * @Version: v1.0
 **/

//@Data
@Entity
@Table(name = "t_gambling")
@org.hibernate.annotations.Table(appliesTo = "t_gambling",comment="牌局")
public class Gambling extends BaseEntity<String> {

    private static final long serialVersionUID = 365428039220848548L;

    /**
     * 状态
     */
    @Column(name = "STATUS",columnDefinition = "int(2) comment '状态'")
    private GAMBLING_STATUS status;

    /**
     * 房间序号
     */
    @Column(name = "ROOMSERIAL",columnDefinition = "int(2) comment '房间序号'")
    private int roomSerial;

    /**
     * 庄家座位
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SEATID",nullable = false)
    private Seat seat;

    /**
     * 牌局統計
     */
    @OneToMany(mappedBy = "gambling",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<GamblingStatistics> gamblingStatistics;


    public enum GAMBLING_STATUS{
        /**
         * 已结束
         */
        over(0,"已结束"),

        /**
         * 进行中
         */
        underway(1,"进行中");

        private int index;

        private String name;

        GAMBLING_STATUS(int index,String name){
            this.index=index;
            this.name=name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public GAMBLING_STATUS getStatus() {
        return status;
    }

    public void setStatus(GAMBLING_STATUS status) {
        this.status = status;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Set<GamblingStatistics> getGamblingStatistics() {
        return gamblingStatistics;
    }

    public void setGamblingStatistics(Set<GamblingStatistics> gamblingStatistics) {
        this.gamblingStatistics = gamblingStatistics;
    }

    public int getRoomSerial() {
        return roomSerial;
    }

    public void setRoomSerial(int roomSerial) {
        this.roomSerial = roomSerial;
    }



}
