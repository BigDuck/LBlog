/*
Navicat MySQL Data Transfer

Source Server         : wp
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : lblog

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-09-07 16:47:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(50) NOT NULL,
  `article_content` varchar(1000) DEFAULT NULL,
  `article_user` int(11) NOT NULL,
  `article_type` int(11) NOT NULL,
  `article_date` datetime DEFAULT NULL,
  `article_photo` varchar(100) DEFAULT NULL,
  `article_other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `article_user` (`article_user`),
  KEY `article_type` (`article_type`),
  CONSTRAINT `blog_article_ibfk_1` FOREIGN KEY (`article_user`) REFERENCES `blog_user` (`user_id`),
  CONSTRAINT `blog_article_ibfk_2` FOREIGN KEY (`article_type`) REFERENCES `blog_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('1', '海贼王', '尾田荣一郎', '1', '1', '2015-09-03 10:09:52', null, '测试文章');
INSERT INTO `blog_article` VALUES ('3', '干物妹小埋', '搞笑动漫', '1', '4', '2015-09-04 13:41:35', null, null);
INSERT INTO `blog_article` VALUES ('4', '夏目友人帐', '高中生夏目有灵异体质，能看见别人所看不到的。当他得到祖母的遗物“友人帐”之后，不论白天或晚上，开始有各式各样的妖怪，纷纷找上门！\r\n\r\n原来夏目的祖母铃子，也和夏目一样有灵异体质，大家都对她敬而远之。铃子因为十分寂寞，便到处向妖怪下战书，并要战败的妖怪交出名字，订立服从的契约。而夏目拿到的，正是这本写有众多妖怪名字，能够号令百妖，力量引人觊觎的“友人帐”！ 夏目在得知事情原委之后，决心要将“友人帐”上的名字， 一一还给被祖母击败的妖怪。而想要不费吹灰之力拿到友人帐的妖怪“猫咪老师”，则自愿当保镳，保护夏目和“友人帐”，共同踏上妖怪之旅！', '1', '3', '2015-09-04 00:00:00', null, '');
INSERT INTO `blog_article` VALUES ('5', '新生报到', '这才发现我们真的老了，看到他们阳光下的笑容，那是我们逝去的青春啊。', '1', '2', '2015-09-05 00:00:00', null, '百年梦醒皆成空');

-- ----------------------------
-- Table structure for blog_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_type`;
CREATE TABLE `blog_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) NOT NULL,
  `type_other` varchar(255) DEFAULT NULL,
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_type
-- ----------------------------
INSERT INTO `blog_type` VALUES ('1', '动漫杂谈', '不同动漫的胡扯');
INSERT INTO `blog_type` VALUES ('2', '生活趣谈', null);
INSERT INTO `blog_type` VALUES ('3', '治愈动漫', null);
INSERT INTO `blog_type` VALUES ('4', '幽默搞笑', null);
INSERT INTO `blog_type` VALUES ('5', '学习趣事', null);

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_psw` varchar(50) NOT NULL,
  `user_mail` varchar(20) DEFAULT NULL,
  `user_lv` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1', 'wpj', '123456', '757671834@qq.com', '100');
