//package com.wegame.wegameliveserviceall.entity;
//
//import com.wegame.wegameliveserviceall.base.BaseEntity;
//import lombok.Data;
//
//import javax.persistence.*;
//
///**
// * @ClassName：GamblingMessage
// * @Description: 牌局信息
// * @Author：13738700108
// * @Data 2020/2/15 3:24
// * @Version: v1.0
// **/
//
////@Data
//@Entity
//@Table(name = "t_gambling_message")
//@org.hibernate.annotations.Table(appliesTo = "t_gambling_message",comment="牌局信息")
//public class GamblingMessage extends BaseEntity<String> {
//
//    private static final long serialVersionUID = 2917430725775057391L;
//
//    /**
//     * 看牌情况(0,未看 1.已看)
//     */
//    @Column(name = "SEECARD",nullable = false,columnDefinition = "int(2) default 0 comment '看牌情况'")
//    private Boolean seeCard;
//
//    /**
//     * 牌
//     */
//    @Column(name = "BOARD",nullable = false,columnDefinition = "varchar(10) default 0 comment '看牌情况'")
//    private String board;
//
//    /**
//     * 结局
//     */
//    @Enumerated(value = EnumType.ORDINAL)
//    @Column(name = "ENDING",nullable = false)
//    private GAMBLINGMESSAGE_ENDING ending;
//
//    /**
//     * 牌局
//     */
//    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
//    @JoinColumn(name = "GAMBLINGID")
//    private Gambling gambling;
//
//    /**
//     * 座位序号
//     */
//    @Column(name = "SEATSERIAL",nullable = false,columnDefinition = "int(4) default 0 comment '座位序号'")
//    private int seatSerial;
//
//    /**
//     * 用户编码
//     */
//    @Column(name = "USERCODE",columnDefinition = "int(4) comment '用户编码'")
//    private int userCode;
//
//    public enum GAMBLINGMESSAGE_ENDING{
//        /**
//         * 输
//         */
//        lose(0,"输"),
//
//        /**
//         * 进行中
//         */
//        underway(1,"进行中"),
//
//        /**
//         * 赢
//         */
//        win(2,"赢");
//
//        private int index;
//        private String name;
//
//        GAMBLINGMESSAGE_ENDING(int index,String name){
//            this.index=index;
//            this.name=name;
//        }
//
//        public int getIndex() {
//            return index;
//        }
//
//        public void setIndex(int index) {
//            this.index = index;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    public Boolean getSeeCard() {
//        return seeCard;
//    }
//
//    public void setSeeCard(Boolean seeCard) {
//        this.seeCard = seeCard;
//    }
//
//    public GAMBLINGMESSAGE_ENDING getEnding() {
//        return ending;
//    }
//
//    public void setEnding(GAMBLINGMESSAGE_ENDING ending) {
//        this.ending = ending;
//    }
//
//    public Gambling getGambling() {
//        return gambling;
//    }
//
//    public void setGambling(Gambling gambling) {
//        this.gambling = gambling;
//    }
//
//
//    public String getBoard() {
//        return board;
//    }
//
//    public void setBoard(String board) {
//        this.board = board;
//    }
//
//    public int getSeatSerial() {
//        return seatSerial;
//    }
//
//    public void setSeatSerial(int seatSerial) {
//        this.seatSerial = seatSerial;
//    }
//
//    public int getUserCode() {
//        return userCode;
//    }
//
//    public void setUserCode(int userCode) {
//        this.userCode = userCode;
//    }
//}
