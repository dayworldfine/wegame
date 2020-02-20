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

@Data
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
     * 房间
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOMID",nullable = false)
    private Room room;

    /**
     * 用户
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "USERID",nullable = false)
    private User user;

    /**
     * 座位
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "SEATID",nullable = false)
    private Seat seat;

    /**
     * 牌局
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "GAMBLING",nullable = false)
    private Gambling gambling;
}
