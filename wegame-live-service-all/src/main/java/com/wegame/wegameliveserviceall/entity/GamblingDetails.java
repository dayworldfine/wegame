package com.wegame.wegameliveserviceall.entity;

import com.wegame.wegameliveserviceall.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName：GamblingDetails
 * @Description: 牌局详情
 * @Author：13738700108
 * @Data 2020/2/15 3:44
 * @Version: v1.0
 **/

//@Data
@Entity
@Table(name = "t_gambling_details")
@org.hibernate.annotations.Table(appliesTo = "t_gambling_details",comment="牌局详情")
public class GamblingDetails extends BaseEntity<String> {

    private static final long serialVersionUID = -1441334324346381254L;

    /**
     * 轮次
     */
    @Column(name = "ROUND",nullable = false,columnDefinition = "int(2) comment '轮次'")
    private int round;

    /**
     * 操作筹码加减
     */
    @Column(name = "OPERATINGLEVERAGE",nullable = false,columnDefinition = "int(2) comment '操作筹码加减'")
    private int operatingLeverage;

    /**
     * 比牌用户id
     */
    @Column(name = "COMPAREUSER",columnDefinition = "varchar(20) default '0' comment '比牌用户id'")
    private String compareUser;

    /**
     * 操作类型
     */
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "DOTYPE",nullable = false)
    private GAMBLINGDETAILS_DOTYPE doType;

    /**
     * 用户编码
     */
    @Column(name = "USERCODE",columnDefinition = "int(4) comment '用户编码'")
    private int userCode;

    /**
     * 座位序号
     */
    @Column(name = "SEATSERIAL",nullable = false,columnDefinition = "int(4) default 0 comment '座位序号'")
    private int seatSerial;

    public enum GAMBLINGDETAILS_DOTYPE{
        /**
         * 弃牌
         */
        disCard(0,"弃牌"),

        /**
         * 看牌
         */
        lookCard(1,"看牌"),

        /**
         * 比牌
         */
        compareCard(2,"比牌"),

        /**
         * 跟(加)注
         */
        followCard(3,"跟(加)注");

        private  int index;

        private  String name;

        GAMBLINGDETAILS_DOTYPE(int index, String name){
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

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getOperatingLeverage() {
        return operatingLeverage;
    }

    public void setOperatingLeverage(int operatingLeverage) {
        this.operatingLeverage = operatingLeverage;
    }

    public String getCompareUser() {
        return compareUser;
    }

    public void setCompareUser(String compareUser) {
        this.compareUser = compareUser;
    }

    public GAMBLINGDETAILS_DOTYPE getDoType() {
        return doType;
    }

    public void setDoType(GAMBLINGDETAILS_DOTYPE doType) {
        this.doType = doType;
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
