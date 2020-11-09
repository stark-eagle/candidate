/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 10/11/2020 03:09:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id1` int(11) NULL DEFAULT NULL,
  `id2` int(11) NULL DEFAULT NULL,
  `userID` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  UNIQUE INDEX `userID_idx`(`userID`) USING BTREE COMMENT '用户id'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 2, '046b6c7f-0b8a-43b9-b35d-6489e6daee91');
INSERT INTO `user` VALUES (1, 3, '104eac7a-c49f-478a-a19b-c07750897da2');
INSERT INTO `user` VALUES (1, 4, '3173f355-58e1-45d8-a3f7-1b1502916725');
INSERT INTO `user` VALUES (1, 5, '63f5b330-2d94-448c-a9cd-864972093411');
INSERT INTO `user` VALUES (1, 50, '9b52ffde-a965-49aa-a3fc-1106544bd935');

SET FOREIGN_KEY_CHECKS = 1;
