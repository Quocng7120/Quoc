/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : testingsystem

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 17/01/2022 20:57:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `AccountID` tinyint UNSIGNED NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `FirstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DepartmentID` tinyint UNSIGNED NULL DEFAULT NULL,
  `CreateDate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `password` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`AccountID`) USING BTREE,
  UNIQUE INDEX `Email`(`Email`) USING BTREE,
  UNIQUE INDEX `Username`(`Username`) USING BTREE,
  INDEX `DepartmentID`(`DepartmentID`) USING BTREE,
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'haidang29productions@gmail.com', 'dangblack', 'Dang', 'Nguyen Hai', 5, '2020-03-05 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (2, 'account1@gmail.com', 'quanganh', 'Anh', 'Tong Quang', 1, '2020-03-05 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (3, 'account2@gmail.com', 'vanchien', 'Chien', 'Nguyen Van', 2, '2020-03-07 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (4, 'account3@gmail.com', 'cocoduongqua', 'Do', 'Duong', 3, '2020-03-08 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (5, 'account4@gmail.com', 'doccocaubai', 'Thang', 'Nguyen Chien', 4, '2020-03-10 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (6, 'dapphatchetngay@gmail.com', 'khabanh', 'Kha', 'Ngo Ba', 6, '2021-10-01 23:36:44', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (7, 'songcodaoly@gmail.com', 'huanhoahong', 'Huan', 'Bui Xuan', 7, '2021-10-01 23:36:44', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (8, 'sontungmtp@gmail.com', 'tungnui', 'Tung', 'Nguyen Thanh', 8, '2020-04-07 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (9, 'duongghuu@gmail.com', 'duongghuu', 'Huu', 'Duong Van', 9, '2020-04-07 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');
INSERT INTO `account` VALUES (10, 'vtiaccademy@gmail.com', 'vtiaccademy', 'Ai', 'Vi Ti', NULL, '2020-04-09 00:00:00', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `DepartmentID` tinyint UNSIGNED NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author_id` tinyint UNSIGNED NULL DEFAULT NULL,
  `CreateDate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `ModifiedDate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`DepartmentID`) USING BTREE,
  UNIQUE INDEX `DepartmentName`(`DepartmentName`) USING BTREE,
  INDEX `author_id`(`author_id`) USING BTREE,
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `account` (`AccountID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 'Marketing', 1, '2020-03-05 00:00:00', '2021-10-07 23:36:06');
INSERT INTO `department` VALUES (2, 'Sale', 3, '2020-03-05 00:00:00', '2020-03-05 00:00:00');
INSERT INTO `department` VALUES (3, 'Bảo vệ', 4, '2020-03-07 00:00:00', '2020-03-07 00:00:00');
INSERT INTO `department` VALUES (4, 'Nhân sự', 3, '2020-03-08 00:00:00', '2021-10-07 23:33:32');
INSERT INTO `department` VALUES (5, 'Kỹ thuật', 2, '2021-10-01 23:36:44', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (6, 'Tài chính', 1, '2020-04-07 00:00:00', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (7, 'Phó giám đốc', 1, '2020-04-07 00:00:00', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (8, 'Giám đốc', 5, '2020-03-05 00:00:00', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (9, 'Thư kí', 4, '2020-03-08 00:00:00', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (10, 'Bán hàng', 1, '2020-03-10 00:00:00', '2021-10-07 23:19:31');
INSERT INTO `department` VALUES (53, 'Department 1', 3, '2021-10-09 02:24:10', '2021-10-09 02:24:10');
INSERT INTO `department` VALUES (54, 'Department 2', 3, '2021-10-09 02:24:12', '2021-10-09 02:24:12');
INSERT INTO `department` VALUES (55, 'department 3', 3, '2021-10-09 02:24:16', '2021-10-09 02:24:16');
INSERT INTO `department` VALUES (58, 'Department 5', 3, '2021-10-09 21:20:11', '2021-10-09 21:20:11');

SET FOREIGN_KEY_CHECKS = 1;
