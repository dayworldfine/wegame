//package com.wegame.wegameliveserviceall.entity;
//
//import com.wegame.wegameliveserviceall.base.BaseEntity;
//import lombok.Data;
//import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// *      接受消息
// */
//@Data
//@Entity
//@Table(name = "t_in_message")
//public class InMessage extends BaseEntity<String> {
//
//
//    private static final long serialVersionUID = -7125330153932881065L;
//
//    @Enumerated(value = EnumType.ORDINAL)
//    @Column(name = "TYPE",length = 50)
//    private Message_TYPE type;
//
//    @Column(name = "FROMID", length = 50)
//    private String fromId;
//
//    @Column(name = "TOID", length = 50)
//    private String toId;
//
//    @Column(name = "CONTENT", length = 50)
//    private String content;
//
//    @Column(name = "TIME",length = 50)
//    private String time;
//
//    public InMessage(){}
//
//    public InMessage(String content) {
//        this.content = content;
//    }
//
//    public enum Message_TYPE {
//        /**
//         * 系统
//         */
//        system(0,"系统"),
//        /**
//         * 用户
//         */
//        user(1,"用户");
//        private int index;
//
//        private String name;
//
//
//        Message_TYPE(int index, String name) {
//            this.index = index;
//            this.name = name;
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
//}
