/*
Navicat MySQL Data Transfer

Source Server         : wbh
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : wegame

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2020-05-11 16:56:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_board
-- ----------------------------
DROP TABLE IF EXISTS `t_board`;
CREATE TABLE `t_board` (
  `id` varchar(255) DEFAULT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `first_board_color` int(11) DEFAULT NULL COMMENT '第一张牌花色',
  `first_board_value` int(11) DEFAULT NULL COMMENT '第一张牌值',
  `second_board_color` int(11) DEFAULT NULL COMMENT '第二张牌花色',
  `second_board_value` int(11) DEFAULT NULL COMMENT '第二张牌值',
  `thirdly_board_color` int(11) DEFAULT NULL COMMENT '第三张牌花色',
  `thirdly_board_value` int(11) DEFAULT NULL COMMENT '第三张牌值',
  `size` bigint(64) DEFAULT NULL COMMENT '牌值大小',
  `type` int(4) DEFAULT NULL COMMENT '牌值类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_board
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling`;
CREATE TABLE `t_gambling` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `room_serial` int(2) DEFAULT NULL COMMENT '房间序号',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `seat_id` varchar(32) NOT NULL COMMENT '庄家座位序号',
  PRIMARY KEY (`id`),
  KEY `FKeqspca6c7uficafr3gyg6t4ni` (`seat_id`),
  CONSTRAINT `FKeqspca6c7uficafr3gyg6t4ni` FOREIGN KEY (`seat_id`) REFERENCES `t_seat` (`id`)
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
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `compare_user` varchar(20) DEFAULT '0' COMMENT '比牌用户id',
  `do_type` int(11) NOT NULL COMMENT '操作类型',
  `operating_leverage` int(2) NOT NULL COMMENT '操作筹码加减',
  `round` int(2) NOT NULL COMMENT '轮次',
  `seat_serial` int(4) NOT NULL DEFAULT '0' COMMENT '座位序号',
  `user_code` int(4) DEFAULT NULL COMMENT '用户编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局详情';

-- ----------------------------
-- Records of t_gambling_details
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_statistics`;
CREATE TABLE `t_gambling_statistics` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `end_time` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `integral` int(8) DEFAULT NULL COMMENT '积分',
  `room_serial` int(4) DEFAULT NULL COMMENT '房间序号',
  `seat_serial` int(4) DEFAULT NULL COMMENT '座位序号',
  `start_time` varchar(20) DEFAULT NULL COMMENT '开始时间',
  `user_code` int(4) DEFAULT NULL COMMENT '用户编码',
  `gambling` varchar(32) NOT NULL COMMENT '牌局',
  PRIMARY KEY (`id`),
  KEY `FKleemt4eo6t0voyy6awr7pn1rb` (`gambling`),
  CONSTRAINT `FKleemt4eo6t0voyy6awr7pn1rb` FOREIGN KEY (`gambling`) REFERENCES `t_gambling` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='牌局统计';

-- ----------------------------
-- Records of t_gambling_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `room_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `serial` int(10) DEFAULT NULL COMMENT '序号',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
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
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `serial` int(8) NOT NULL COMMENT '序号',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `room_id` varchar(32) NOT NULL COMMENT '房间id',
  `user_code` int(4) DEFAULT NULL COMMENT '用户编码',
  `see_card` int(2) NOT NULL DEFAULT '0' COMMENT '看牌情况',
  PRIMARY KEY (`id`),
  KEY `FK4j5dgwc0sptm9dqdreb6mq0qv` (`room_id`),
  CONSTRAINT `FK4j5dgwc0sptm9dqdreb6mq0qv` FOREIGN KEY (`room_id`) REFERENCES `t_room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='座位';

-- ----------------------------
-- Records of t_seat
-- ----------------------------
INSERT INTO `t_seat` VALUES ('123', '123', '123', '1', '1', '2', '123', '123', '0');
INSERT INTO `t_seat` VALUES ('1232', '12323', '12323', '1', '8', '2', '123', '222', '0');
INSERT INTO `t_seat` VALUES ('213', '213', '2132', '1', '3', '2', '123', '123', '0');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_date` varchar(16) NOT NULL COMMENT '创建日期',
  `last_modified_time` varchar(16) NOT NULL COMMENT '最后修改日期',
  `version` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本',
  `code` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `head_portrait` varchar(50) DEFAULT NULL COMMENT '头像',
  `integral` int(20) DEFAULT NULL COMMENT '积分',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '账号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `CODE` (`code`),
  UNIQUE KEY `UK_7beptvcnra9kr1tgj6y9iym24` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('123', '111', '112', '1', '123', 'touxiang', '123', '123', 'E10ADC3949BA59ABBE56E057F20F883E', '12', 'wbh');
INSERT INTO `t_user` VALUES ('123213', '222', '222', '1', '222', 'xiaohao', '123', '123', 'E10ADC3949BA59ABBE56E057F20F883E', '12', 'whua');
