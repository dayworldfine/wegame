/*
Navicat MySQL Data Transfer

Source Server         : wang
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : wegame

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-06 21:19:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_gambling
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling`;
CREATE TABLE `t_gambling` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `ROOMSERIAL` int(2) DEFAULT NULL COMMENT '房间序号',
  `STATUS` int(2) DEFAULT NULL COMMENT '状态',
  `SEATID` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKeqspca6c7uficafr3gyg6t4ni` (`SEATID`),
  CONSTRAINT `FKeqspca6c7uficafr3gyg6t4ni` FOREIGN KEY (`SEATID`) REFERENCES `t_seat` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局';

-- ----------------------------
-- Records of t_gambling
-- ----------------------------
INSERT INTO `t_gambling` VALUES ('213', '213', '12123', '1', '1', '1', '123');

-- ----------------------------
-- Table structure for t_gambling_details
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_details`;
CREATE TABLE `t_gambling_details` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `COMPAREUSER` varchar(20) DEFAULT '0' COMMENT '比牌用户id',
  `DOTYPE` int(11) NOT NULL,
  `OPERATINGLEVERAGE` int(2) NOT NULL COMMENT '操作筹码加减',
  `ROUND` int(2) NOT NULL COMMENT '轮次',
  `SEATSERIAL` int(4) NOT NULL DEFAULT '0' COMMENT '座位序号',
  `USERCODE` int(4) DEFAULT NULL COMMENT '用户编码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局详情';

-- ----------------------------
-- Records of t_gambling_details
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling_message
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_message`;
CREATE TABLE `t_gambling_message` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `BOARD` varchar(10) NOT NULL DEFAULT '0' COMMENT '看牌情况',
  `ENDING` int(11) NOT NULL,
  `SEATSERIAL` int(4) NOT NULL DEFAULT '0' COMMENT '座位序号',
  `SEECARD` int(2) NOT NULL DEFAULT '0' COMMENT '看牌情况',
  `USERCODE` int(4) DEFAULT NULL COMMENT '用户编码',
  `GAMBLINGID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK56sciy4pgn1pf19q0ru4n9iet` (`GAMBLINGID`),
  CONSTRAINT `FK56sciy4pgn1pf19q0ru4n9iet` FOREIGN KEY (`GAMBLINGID`) REFERENCES `t_gambling` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局信息';

-- ----------------------------
-- Records of t_gambling_message
-- ----------------------------
INSERT INTO `t_gambling_message` VALUES ('123', '123', '123', '1', '0', '1', '1', '0', '123', '213');
INSERT INTO `t_gambling_message` VALUES ('2323', '2323', '3232', '1', '0', '1', '2', '0', '222', '213');

-- ----------------------------
-- Table structure for t_gambling_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_statistics`;
CREATE TABLE `t_gambling_statistics` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `ENDTIME` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `INTEGRAL` int(8) DEFAULT NULL COMMENT '积分',
  `ROOMSERIAL` int(4) DEFAULT NULL COMMENT '房间序号',
  `SEATSERIAL` int(4) DEFAULT NULL COMMENT '座位序号',
  `STARTTIME` varchar(20) DEFAULT NULL COMMENT '开始时间',
  `USERCODE` int(4) DEFAULT NULL COMMENT '用户编码',
  `GAMBLING` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKleemt4eo6t0voyy6awr7pn1rb` (`GAMBLING`),
  CONSTRAINT `FKleemt4eo6t0voyy6awr7pn1rb` FOREIGN KEY (`GAMBLING`) REFERENCES `t_gambling` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局统计';

-- ----------------------------
-- Records of t_gambling_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `NAME` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `SERIAL` int(10) DEFAULT NULL COMMENT '序号',
  `STATUS` int(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间';

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES ('123', '123', '123', '1', '', '1', '1');

-- ----------------------------
-- Table structure for t_seat
-- ----------------------------
DROP TABLE IF EXISTS `t_seat`;
CREATE TABLE `t_seat` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `SERIAL` int(8) NOT NULL COMMENT '序号',
  `STATUS` int(2) DEFAULT NULL COMMENT '状态',
  `ROOMID` varchar(32) NOT NULL,
  `USERCODE` int(4) DEFAULT NULL COMMENT '用户编码',
  `SEECARD` int(2) NOT NULL DEFAULT '0' COMMENT '看牌情况',
  `BOARDA` int(2) NOT NULL COMMENT '第一张牌',
  `BOARDB` int(2) NOT NULL COMMENT '第二张牌',
  `BOARDC` int(2) NOT NULL COMMENT '第三张牌',
  PRIMARY KEY (`ID`),
  KEY `FK4j5dgwc0sptm9dqdreb6mq0qv` (`ROOMID`),
  CONSTRAINT `FK4j5dgwc0sptm9dqdreb6mq0qv` FOREIGN KEY (`ROOMID`) REFERENCES `t_room` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='座位';

-- ----------------------------
-- Records of t_seat
-- ----------------------------
INSERT INTO `t_seat` VALUES ('123', '123', '123', '1', '1', '2', '123', '123', '0', '0', '0', '0');
INSERT INTO `t_seat` VALUES ('1232', '12323', '12323', '1', '8', '2', '123', '222', '0', '0', '0', '0');
INSERT INTO `t_seat` VALUES ('213', '213', '2132', '1', '3', '2', '123', '123', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` varchar(32) NOT NULL,
  `CREATEDATE` varchar(16) NOT NULL,
  `LASTMODIFIEDTIME` varchar(16) NOT NULL,
  `VERSION` bigint(20) NOT NULL DEFAULT '1',
  `CODE` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `HEADPORTRAIT` varchar(50) DEFAULT NULL COMMENT '头像',
  `INTEGRAL` int(20) DEFAULT NULL COMMENT '积分',
  `NICKNAME` varchar(20) DEFAULT NULL COMMENT '昵称',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `PHONE` int(11) DEFAULT NULL COMMENT '手机号',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '账号',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODE` (`CODE`),
  UNIQUE KEY `UK_7beptvcnra9kr1tgj6y9iym24` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('123', '111', '112', '1', '123', 'touxiang', '123', '123', 'E10ADC3949BA59ABBE56E057F20F883E', '12', 'wbh');
INSERT INTO `t_user` VALUES ('123213', '222', '222', '1', '222', 'xiaohao', '123', '123', 'E10ADC3949BA59ABBE56E057F20F883E', '12', 'whua');
