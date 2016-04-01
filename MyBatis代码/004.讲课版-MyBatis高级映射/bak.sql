/*
Navicat MySQL Data Transfer

Source Server         : 祥云37MSS阶段
Source Server Version : 50627
Source Host           : 127.0.0.1:3308
Source Database       : t1

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-03-25 16:36:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('100', '锦绣');
INSERT INTO `class` VALUES ('200', '祥云');
INSERT INTO `class` VALUES ('300', '超越');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) DEFAULT NULL,
  `fk_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk_class_id` (`fk_class_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`fk_class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '悟空', '100');
INSERT INTO `student` VALUES ('2', '林冲', '200');
INSERT INTO `student` VALUES ('3', '诸葛亮', '300');
