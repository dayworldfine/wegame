package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName：GamblingMessage
 * @Description: 牌局信息
 * @Author：13738700108
 * @Data 2020/2/15 3:24
 * @Version: v1.0
 **/

@Data
@Entity
@Table(name = "t_gambling_message")
@org.hibernate.annotations.Table(appliesTo = "t_gambling_message",comment="牌局信息")
public class GamblingMessage extends BaseEntity<String> {

    private static final long serialVersionUID = 2917430725775057391L;

    /**
     * 看牌情况(0,未看 1.已看)
     */
    @Column(name = "SEECARD",nullable = false,columnDefinition = "int(2) default 0 comment '看牌情况'")
    private Boolean seeCard;

    /**
     * 结局
     */
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "ENDING",nullable = false)
    private GAMBLINGMESSAGE_ENDING ending;

    /**
     * 牌局
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "GAMBLINGID")
    private Gambling gambling;

    /**
     * 座位
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "SEATID")
    private Seat seat;

    /**
     * 用户
     */
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "USERID")
    private User user;

    public enum GAMBLINGMESSAGE_ENDING{
        /**
         * 输
         */
        lose(0,"输"),

        /**
         * 进行中
         */
        underway(1,"进行中"),

        /**
         * 赢
         */
        win(2,"赢");

        private int index;
        private String name;

        GAMBLINGMESSAGE_ENDING(int index,String name){
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
