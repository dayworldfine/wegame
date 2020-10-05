package com.wegame.tools.utils;

/**
 * @ClassName：EnumUtils
 * @Description: 枚举工具类
 * @Author：13738700108
 * @Data 2020/9/6 15:00
 * @Version: v1.0
 **/
public class EnumUtils {

    //常规判断枚举
    public static enum JUDGE_ENUM {
        NO("否", 0, "NO"),
        YES("是", 1, "YES");
        private String name;
        private int value;
        private String code;

        private JUDGE_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    //花色类型枚举
    public static enum FLOWER_ENUM {
        DIAMOND("方块", 0, "DIAMOND"),
        CLUB("梅花", 1, "CLUB"),
        HEART("红桃", 2, "HEART"),
        SPADE("黑桃", 3, "SPADE");
        private String name;
        private int value;
        private String code;

        private FLOWER_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    //牌值类型枚举
    public static enum PLAYER_ENUM {
        NORMAL("普通牌", 0, "NORMAL"),
        DOUBLE("对子", 1, "DOUBLE"),
        STRAIGHT("顺子", 2, "STRAIGHT"),
        FLUSH("同花", 3, "FLUSH"),
        STRAIGHT_FLUSH("同花顺", 4, "STRAIGHT_FLUSH"),
        BOMB("同花顺", 5, "BOMB");
        private String name;
        private int value;
        private String code;

        private PLAYER_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }


    //操作类型枚举
    public static enum OPERATION_ENUM {
        START_ADD("开局默认底注", 0, "START_ADD"),
        DIS_CARD("弃牌", 1, "DIS_CARD"),
        SEE_CARD("看牌", 2, "SEE_CARD"),
        COMPARE_CARD("比牌", 3, "COMPARE_CARD"),
        FOLLOW_CARD("跟注", 4, "FOLLOW_CARD"),
        ADD_CARD("加注", 5, "ADD_CARD");

        private String name;
        private int value;
        private String code;

        private OPERATION_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    //牌局状态枚举
    public static enum GAMBLING_STATUS_ENUM {
        PROCEED("进行中", 0, "PROCEED"),
        END("已结束", 1, "END");
        private String name;
        private int value;
        private String code;
        private GAMBLING_STATUS_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    }

    //座位状态枚举
    public static enum SEAT_STATUS_ENUM {
        FREE("空闲", 0, "FREE"),
        NOT_READY("坐下未准备", 1, "NOT_READY"),
        READY("坐下已准备", 2, "READY"),
        IS_GAME("有人正在游戏中",3,"IS_GAME"),
        IS_NOT_GAME("没人正在游戏中",4,"IS_NOT_GAME");
        private String name;
        private int value;
        private String code;

        private SEAT_STATUS_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    //房间状态枚举
    public static enum ROOM_STATUS_ENUM {
        FREE("空闲无人", 0, "FREE"),
        NOT_START("有人但未开始游戏", 1, "NOT_START"),
        IN_THE_GAME("正在游戏中", 2, "IN_THE_GAME");
        private String name;
        private int value;
        private String code;

        private ROOM_STATUS_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    //游戏状态枚举
    public static enum GAME_STATUS_ENUM {
        NO_BODY("此座位无人", 0, "NO_BODY"),
        DIS_BOARD("弃牌", 1, "DIS_BOARD"),
        COMPARE_LOSE("比牌输", 2, "COMPARE_LOSE"),
        NORMAL("正常", 3, "NORMAL"),
        WIN("胜利", 4, "WIN");
        private String name;
        private int value;
        private String code;

        private GAME_STATUS_ENUM(String name, int value, String code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
