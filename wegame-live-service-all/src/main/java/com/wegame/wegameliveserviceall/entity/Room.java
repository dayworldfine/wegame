package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @ClassName：Room
 * @Description: 房间表
 * @Author：13738700108
 * @Data 2020/2/14 17:04
 * @Version: v1.0
 **/
@Data
@Entity
@Table(name = "t_room")
@org.hibernate.annotations.Table(appliesTo = "t_room",comment="房间")
public class Room extends BaseEntity<String> {

    private static final long serialVersionUID = 7854706549625090552L;

    /**
     * 房间名
     */
    @Column(name = "NAME",nullable = false,columnDefinition = "varchar(20) default '' comment '用户名'")
    private String name;

    /**
     * 状态
     */
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "STATUS",columnDefinition = "int(2) comment '状态'")
    private ROOM_STATUS status;

    /**
     * 序号
     */
    @Column(name = "SERIAL",columnDefinition = "int(10) comment '序号'")
    private int serial;

    /**
     * 牌局统计
     */
    @OneToMany(mappedBy = "room",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<GamblingStatistics> gamblingStatistics;

    /**
     *  房间
     */
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Seat> seats;

    public enum ROOM_STATUS{
        /**
         * 未开始
         */
        notStart(0,"未开始"),

        /**
         * 进行中
         */
        underway(1,"进行中");

        private int index;

        private String name;

        ROOM_STATUS(int index, String name){
            this.index=index;
            this.name = name;
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
