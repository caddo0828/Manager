/*
Navicat MySQL Data Transfer

Source Server         : im
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : im

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2019-03-17 19:00:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` varchar(30) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1500799', 'caddo', '123456', '女', '江西');
INSERT INTO `manager` VALUES ('19970043087', '老腰', '111111', '女', '杭州');
INSERT INTO `manager` VALUES ('15801012525', 'mike', '000000', '男', '北京');
INSERT INTO `manager` VALUES ('19970043089', '黑子', '888888', '女', '成都');
INSERT INTO `manager` VALUES ('1008611', '可乐', '222222', '男', '江西');
INSERT INTO `manager` VALUES ('13979984297', 'solar', '0828', '女', '杭州');
INSERT INTO `manager` VALUES ('1597920', 'daddy', 'daddy123456', '男', '北京');
INSERT INTO `manager` VALUES ('15007992569', 'elina', 'tq6020162483', '女', '北京');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `name` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('.net设计规范', '50', '计算机');
INSERT INTO `products` VALUES ('网管员必备宝典', '20', '计算机');
INSERT INTO `products` VALUES ('学会宽容', '25', '文学');
INSERT INTO `products` VALUES ('杜拉拉升职记', '54', '原版');
INSERT INTO `products` VALUES ('时空穿行', '42', '科技');
INSERT INTO `products` VALUES ('雪中悍刀行', '59', '小说');
INSERT INTO `products` VALUES ('Java基础入门', '44.5', '计算机');
INSERT INTO `products` VALUES ('赢在影响力', '89', '励志');
INSERT INTO `products` VALUES ('大勇和小花的欧洲日记', '26', '生活百科');
INSERT INTO `products` VALUES ('Java Web程序开发入门', '44.5', '计算机');
INSERT INTO `products` VALUES ('谁动了我的奶酪', '26', '少儿');
INSERT INTO `products` VALUES ('别做正常的傻瓜', '18', '励志');
INSERT INTO `products` VALUES ('培育男孩', '25', '生活');
INSERT INTO `products` VALUES ('培育男孩', '20', '生活');
INSERT INTO `products` VALUES ('经济案例解析', '35', '经营');
INSERT INTO `products` VALUES ('美国纽约摄影学院摄影教材', '45', '艺术');
INSERT INTO `products` VALUES ('系统分析师教程', '54', '考试');
INSERT INTO `products` VALUES ('中国国家地理', '20', '学术');
INSERT INTO `products` VALUES ('活着', '55', '文学');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20162483', '老腰', '21', '女', 'tan_qi@sohu.com', '1997-08-28');
INSERT INTO `user` VALUES ('20162446', '刘踞正', '22', '男', 'liujuzheng@sohu.com', '1996-04-19');
INSERT INTO `user` VALUES ('20162400', '赵琴', '21', '女', '1064252564@qq.com', '1998-01-12');
INSERT INTO `user` VALUES ('20162585', '谭琪', '21', '女', '2108163365@qq.com', '1997-08-28');
INSERT INTO `user` VALUES ('20162479', '游思雨', '21', '女', '2105155@sohu.com', '1997-11-12');
INSERT INTO `user` VALUES ('20162300', '吴思成乐', '22', '男', '1879005533@sohu.com', '1998-17-15');
