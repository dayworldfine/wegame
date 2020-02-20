package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName：Seat
 * @Description: 座位表
 * @Author：13738700108
 * @Data 2020/2/14 18:31
 * @Version: v1.0
 **/

@Data
@Entity
@Table(name = "t_seat")
@org.hibernate.annotations.Table(appliesTo = "t_seat",comment="座位")
public class Seat extends BaseEntity<String> {

    private static final long serialVersionUID = 1769727967093187377L;

    /**
     * 序号
     */
    @Column(name = "SERIAL", nullable = false,columnDefinition = "int(8) comment '序号'")
    private int serial;

    /**
     * 状态
     */
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "STATUS",columnDefinition = "int(2)  comment '状态'")
    private SEAT_STATUS status;

    /**
     * 牌局
     */
    @OneToOne(mappedBy = "seat",fetch = FetchType.LAZY)
    private Gambling gambling;

    /**
     * 牌局统计
     */
    @OneToMany(mappedBy = "seat",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<GamblingStatistics> gamblingStatistics;

    /**
     * 牌局信息
     */
    @OneToMany(mappedBy = "seat",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<GamblingMessage> gamblingMessages;

    /**
     * 牌局详情
     */
    @OneToMany(mappedBy = "seat",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<GamblingDetails> gamblingDetails;

    /**
     * 房间id
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOMID",nullable = false)
    private Room room;

    public enum SEAT_STATUS{
        /**
         * 忙碌
         */
        busy(0,"忙碌"),

        /**
         * 空闲
         */
        leisure(1,"空闲"),

        /**
         * 已准备
         */
        prepare(2,"已准备");

        private int index;

        private String name;

        SEAT_STATUS(int index,String name){
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
}
