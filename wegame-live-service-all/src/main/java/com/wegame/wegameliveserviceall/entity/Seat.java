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

//@Data
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
     * 用户编码
     */
    @Column(name = "USERCODE",columnDefinition = "int(4) comment '用户编码'")
    private int userCode;

    /**
     * 牌局
     */
    @OneToOne(mappedBy = "seat",fetch = FetchType.LAZY)
    private Gambling gambling;

    /**
     * 看牌情况(0,未看 1.已看)
     */
    @Column(name = "SEECARD",nullable = false,columnDefinition = "int(2) default 0 comment '看牌情况'")
    private Boolean seeCard;

    /**
     * 第一张牌
     */
    @Column(name = "BOARDA",nullable = false,columnDefinition = "int(2) comment '第一张牌'")
    private int boardA;

    /**
     * 第二张牌
     */
    @Column(name = "BOARDB",nullable = false,columnDefinition = "int(2) comment '第二张牌'")
    private int boardB;

    /**
     * 第三张牌
     */
    @Column(name = "BOARDC",nullable = false,columnDefinition = "int(2) comment '第三张牌'")
    private int boardC;


    /**
     * 房间id
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOMID",nullable = false)
    private Room room;

    public enum SEAT_STATUS{
        /**
         * 空闲
         */

        leisure(0,"空闲"),

        /**
         * 忙碌
         */
        busy(1,"忙碌"),

        /**
         * 已准备
         */
        prepare(2,"已准备"),

        /**
         * 进行中
         */
        underway(3,"进行中"),

        /**
         * 输
         */
        lose(4,"输"),

        /**
         * 赢
         */
        win(5,"赢");

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


    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public SEAT_STATUS getStatus() {
        return status;
    }

    public void setStatus(SEAT_STATUS status) {
        this.status = status;
    }

    public Gambling getGambling() {
        return gambling;
    }

    public void setGambling(Gambling gambling) {
        this.gambling = gambling;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public Boolean getSeeCard() {
        return seeCard;
    }

    public void setSeeCard(Boolean seeCard) {
        this.seeCard = seeCard;
    }

    public int getBoardA() {
        return boardA;
    }

    public void setBoardA(int boardA) {
        this.boardA = boardA;
    }

    public int getBoardB() {
        return boardB;
    }

    public void setBoardB(int boardB) {
        this.boardB = boardB;
    }

    public int getBoardC() {
        return boardC;
    }

    public void setBoardC(int boardC) {
        this.boardC = boardC;
    }
}
