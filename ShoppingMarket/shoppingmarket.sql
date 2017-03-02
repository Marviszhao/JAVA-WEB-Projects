/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : shoppingmarket

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-01 21:56:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sm_judge`
-- ----------------------------
DROP TABLE IF EXISTS `sm_judge`;
CREATE TABLE `sm_judge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judge_content` varchar(255) DEFAULT NULL,
  `judge_star` int(11) DEFAULT NULL,
  `stock_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `judge_secret` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_judge
-- ----------------------------
INSERT INTO `sm_judge` VALUES ('1', '哈哈哈哈，真不错', '5', '103', '3', '1');
INSERT INTO `sm_judge` VALUES ('6', '不好用，卡卡卡', '2', '104', '3', '1');
INSERT INTO `sm_judge` VALUES ('7', '很不错', '5', '113', '3', '2');
INSERT INTO `sm_judge` VALUES ('8', '好吃', '3', '112', '3', '1');
INSERT INTO `sm_judge` VALUES ('9', '还是这个味道', '3', '110', '3', '2');
INSERT INTO `sm_judge` VALUES ('10', '乔丹鞋真不错，哈哈哈', '4', '107', '3', '1');
INSERT INTO `sm_judge` VALUES ('11', '好用是好用就是太贵了。', '4', '108', '3', '2');
INSERT INTO `sm_judge` VALUES ('12', '好穿，真不错，很不错！', '4', '106', '3', '2');
INSERT INTO `sm_judge` VALUES ('14', '还行吧', '5', '108', '10', '2');
INSERT INTO `sm_judge` VALUES ('15', '有点贵', '5', '110', '10', '1');
INSERT INTO `sm_judge` VALUES ('16', '垃圾', '5', '104', '7', '1');
INSERT INTO `sm_judge` VALUES ('17', '抵制日货', '5', '105', '7', '1');
INSERT INTO `sm_judge` VALUES ('18', '还行，苹果现在创新动力不足了', '4', '103', '7', '2');

-- ----------------------------
-- Table structure for `sm_stock`
-- ----------------------------
DROP TABLE IF EXISTS `sm_stock`;
CREATE TABLE `sm_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_name` varchar(255) DEFAULT NULL,
  `stock_price` double DEFAULT NULL,
  `stock_descrip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_stock
-- ----------------------------
INSERT INTO `sm_stock` VALUES ('103', '苹果7', '5288', 'iPhone 7 全新上市，功能最强大的智能机');
INSERT INTO `sm_stock` VALUES ('104', '小米手机', '799', '小米手机4A 全网通，性价比之王');
INSERT INTO `sm_stock` VALUES ('105', '夏普（SHARP）LCD-60SU465A 60英寸', '5899', '日本原装液晶面板 4K超高清 智能液晶电视');
INSERT INTO `sm_stock` VALUES ('106', '森马', '155', '森马换季新品打折');
INSERT INTO `sm_stock` VALUES ('107', '乔丹', '399', '乔丹精品篮球鞋，校园清新风');
INSERT INTO `sm_stock` VALUES ('108', 'MAC Pro ', '12999.7', '苹果新款笔记本超薄 15寸');
INSERT INTO `sm_stock` VALUES ('109', '小米电源', '99', '小米大容量移动电源，10040mah');
INSERT INTO `sm_stock` VALUES ('110', '王守义', '6.5', '王守义十三香，正宗好品质');
INSERT INTO `sm_stock` VALUES ('111', '苹果', '4.5', '新鲜红富士苹果，好吃又好看');
INSERT INTO `sm_stock` VALUES ('112', '香蕉', '3.98', '进口菲律宾大香蕉，香甜可口');
INSERT INTO `sm_stock` VALUES ('113', '大数据', '88', '大数据从入门到放弃，一个大数据时代开发的心路历程');

-- ----------------------------
-- Table structure for `sm_user`
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_user
-- ----------------------------
INSERT INTO `sm_user` VALUES ('3', 'Marvis', '111', null, null, '1');
INSERT INTO `sm_user` VALUES ('7', 'zhaozhifei', '111', null, null, '0');
INSERT INTO `sm_user` VALUES ('8', 'shiyanjie', '111', null, null, '0');
INSERT INTO `sm_user` VALUES ('9', 'xiaosong', '111111', null, null, '0');
INSERT INTO `sm_user` VALUES ('10', '赵志飞', '111', '1', '15729215172', '1');
INSERT INTO `sm_user` VALUES ('11', '啊啊啊', '222', '1', '2222', '1');
INSERT INTO `sm_user` VALUES ('12', '水电费', '222', '111', '111', '222');
INSERT INTO `sm_user` VALUES ('13', 'Marvis', '111', null, null, '0');

-- ----------------------------
-- Table structure for `sm_user_stock_con`
-- ----------------------------
DROP TABLE IF EXISTS `sm_user_stock_con`;
CREATE TABLE `sm_user_stock_con` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `stock_id` int(11) DEFAULT NULL,
  `stock_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_user_stock_con
-- ----------------------------
INSERT INTO `sm_user_stock_con` VALUES ('1', '3', '103', '4');
INSERT INTO `sm_user_stock_con` VALUES ('2', '3', '104', '2');
INSERT INTO `sm_user_stock_con` VALUES ('3', '3', '113', '1');
INSERT INTO `sm_user_stock_con` VALUES ('4', '3', '112', '1');
INSERT INTO `sm_user_stock_con` VALUES ('5', '3', '111', '2');
INSERT INTO `sm_user_stock_con` VALUES ('6', '3', '110', '2');
INSERT INTO `sm_user_stock_con` VALUES ('7', '3', '106', '2');
INSERT INTO `sm_user_stock_con` VALUES ('8', '3', '107', '2');
INSERT INTO `sm_user_stock_con` VALUES ('9', '3', '105', '2');
INSERT INTO `sm_user_stock_con` VALUES ('10', '3', '108', '1');
INSERT INTO `sm_user_stock_con` VALUES ('11', '7', '103', '1');
INSERT INTO `sm_user_stock_con` VALUES ('12', '7', '104', '1');
INSERT INTO `sm_user_stock_con` VALUES ('13', '7', '105', '1');
INSERT INTO `sm_user_stock_con` VALUES ('14', '7', '106', '1');
INSERT INTO `sm_user_stock_con` VALUES ('15', '10', '108', '1');
INSERT INTO `sm_user_stock_con` VALUES ('16', '10', '110', '1');
INSERT INTO `sm_user_stock_con` VALUES ('17', '10', '111', '1');
INSERT INTO `sm_user_stock_con` VALUES ('18', '10', '112', '1');
