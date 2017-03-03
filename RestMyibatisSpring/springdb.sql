/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : springdb

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-03 21:06:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `usertable`
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_psw` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('11', '666', '666', '0');
INSERT INTO `usertable` VALUES ('12', '777', '777', null);
INSERT INTO `usertable` VALUES ('13', '888', '888', '0');
INSERT INTO `usertable` VALUES ('15', '111', '222', null);
INSERT INTO `usertable` VALUES ('16', 'Marvi', '111', null);
INSERT INTO `usertable` VALUES ('18', '111', '111', null);
INSERT INTO `usertable` VALUES ('19', 'haha', 'haha', null);
INSERT INTO `usertable` VALUES ('20', 'hehe', 'hehe', null);
INSERT INTO `usertable` VALUES ('21', 'qqq', 'qqq', null);
