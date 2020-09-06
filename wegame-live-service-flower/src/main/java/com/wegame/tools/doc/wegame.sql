/*
 Navicat Premium Data Transfer

 Source Server         : wang
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : wegame

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 06/09/2020 22:53:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_gambling
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling`;
CREATE TABLE `t_gambling`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `room_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '房间id',
  `gambling_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态(字典牌局状态枚举)',
  `integral_fundus` bigint(0) NOT NULL DEFAULT 1 COMMENT '积分底注\r\n\r\n',
  `integral_sum` bigint(0) NOT NULL COMMENT '牌局总积分',
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '牌局' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_gambling
-- ----------------------------
INSERT INTO `t_gambling` VALUES (213, 213, 12123, 1, 1, 1, 0, 0);

-- ----------------------------
-- Table structure for t_gambling_board
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_board`;
CREATE TABLE `t_gambling_board`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `gambling_message_id` bigint(0) NULL DEFAULT NULL COMMENT '牌局信息id',
  `board_size` bigint(0) NOT NULL DEFAULT 0 COMMENT '牌值大小',
  `board_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '牌值类型(字典牌值类型枚举)',
  `is_special` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否特殊牌(字段常规判断枚举)',
  `is_a32` tinyint(0) NOT NULL DEFAULT 0 COMMENT 'A32也是顺子(字段常规判断枚举)',
  `first_board_color` tinyint(0) NOT NULL DEFAULT 0 COMMENT '第一张牌花色类型(字典花色类型枚举)',
  `first_board_value` int(0) NOT NULL DEFAULT 0 COMMENT '第一张牌值',
  `second_board_color` tinyint(0) NOT NULL DEFAULT 0 COMMENT '第二张牌花色类型(字典花色类型枚举)',
  `second_board_value` int(0) NOT NULL DEFAULT 0 COMMENT '第二张牌值',
  `thirdly_board_color` tinyint(0) NOT NULL DEFAULT 0 COMMENT '第三张牌花色类型(字典花色类型枚举)',
  `thirdly_board_value` int(0) NOT NULL DEFAULT 0 COMMENT '第三张牌值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gambling_msg_id`(`gambling_message_id`) USING BTREE,
  CONSTRAINT `t_gambling_board_ibfk_1` FOREIGN KEY (`gambling_message_id`) REFERENCES `t_gambling_message` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '牌局信息关联牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_gambling_board
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling_details
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_details`;
CREATE TABLE `t_gambling_details`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `gambling_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '牌局id',
  `compare_user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '比牌用户id',
  `operation_type` tinyint(0) NOT NULL DEFAULT 0 COMMENT '操作类型(见字典表操作类型枚举)',
  `operating_leverage` bigint(0) NOT NULL DEFAULT 0 COMMENT '操作筹码加减',
  `round` int(0) NOT NULL DEFAULT 0 COMMENT '轮次',
  `seat_id` int(0) NOT NULL DEFAULT 0 COMMENT '座位id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '同用户同轮次排序',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gambling_id`(`gambling_id`) USING BTREE,
  CONSTRAINT `t_gambling_details_ibfk_1` FOREIGN KEY (`gambling_id`) REFERENCES `t_gambling` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '牌局详情' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_gambling_details
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling_message
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_message`;
CREATE TABLE `t_gambling_message`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `gambling_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '牌局id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `seat_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '座位id',
  `is_banker` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否庄家座位(字典常规判断枚举)',
  `is_user` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否有玩家(字典常规判断枚举)',
  `see_card_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '看牌状态(字段常规判断枚举)',
  `game_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '牌局游戏状态(字典牌局游戏状态枚举)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gambling_id`(`gambling_id`) USING BTREE,
  CONSTRAINT `t_gambling_message_ibfk_1` FOREIGN KEY (`gambling_id`) REFERENCES `t_gambling` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_gambling_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_gambling_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_gambling_statistics`;
CREATE TABLE `t_gambling_statistics`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `integral` bigint(0) NOT NULL DEFAULT 0 COMMENT '积分计算',
  `gambling_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '牌局id',
  `seat_id` int(0) NOT NULL DEFAULT 0 COMMENT '座位id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `is_win` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否胜利(字段常规判断字段)',
  `start_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '开始时间',
  `end_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKleemt4eo6t0voyy6awr7pn1rb`(`gambling_id`) USING BTREE,
  CONSTRAINT `t_gambling_statistics_ibfk_1` FOREIGN KEY (`gambling_id`) REFERENCES `t_gambling` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '牌局统计' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_gambling_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `room_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '房间名称',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态(字段房间状态枚举)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房间' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (1, 123, 123, 1, '', 1);

-- ----------------------------
-- Table structure for t_seat
-- ----------------------------
DROP TABLE IF EXISTS `t_seat`;
CREATE TABLE `t_seat`  (
  `id` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `seat_status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '座位状态(字典座位状态枚举)',
  `room_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '房间id',
  `user_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4j5dgwc0sptm9dqdreb6mq0qv`(`room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '座位' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_seat
-- ----------------------------
INSERT INTO `t_seat` VALUES (1, 123, 123, 1, 2, 1, 21312);
INSERT INTO `t_seat` VALUES (2, 213, 2132, 1, 2, 1, 32);
INSERT INTO `t_seat` VALUES (3, 12323, 12323, 1, 2, 1, 123);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `version` bigint(0) NOT NULL DEFAULT 1 COMMENT '版本',
  `head_portrait` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像',
  `integral` bigint(0) NOT NULL DEFAULT 0 COMMENT '积分',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` bigint(0) NOT NULL DEFAULT 0 COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123214 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (123, 111, 112, 1, 'touxiang', 123, '123', 'wbh', 'E10ADC3949BA59ABBE56E057F20F883E', 12);
INSERT INTO `t_user` VALUES (123213, 222, 222, 1, 'xiaohao', 123, '123', 'whua', 'E10ADC3949BA59ABBE56E057F20F883E', 12);

SET FOREIGN_KEY_CHECKS = 1;
