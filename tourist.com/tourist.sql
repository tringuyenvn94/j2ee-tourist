/*
Navicat MySQL Data Transfer

Source Server         : Mydatabase
Source Server Version : 50153
Source Host           : localhost:3306
Source Database       : tourist

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2011-06-15 17:47:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `articletitle` varchar(255) DEFAULT NULL,
  `articlethumbnail` varchar(1024) DEFAULT NULL,
  `articlesummary` varchar(500) DEFAULT NULL,
  `articlebody` text,
  `articledate` bigint(20) DEFAULT NULL,
  `articlespecial` int(11) DEFAULT NULL,
  `articlepublished` int(11) DEFAULT '1',
  PRIMARY KEY (`articleid`),
  KEY `fk_relationship_7` (`categoryid`),
  CONSTRAINT `fk_relationship_7` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', 'Thiên đường Phuket', '', '<p style=\"text-align: justify;\"><strong><span style=\"font-size: small;\">Biển xanh như ngọc. C&aacute;t trắng mịn m&agrave;ng. Những v&aacute;ch đ&aacute; sừng sững giữa trời nước m&ecirc;nh m&ocirc;ng. Những hang động đ&aacute; v&ocirc;i huyền hoặc. Những rạn san h&ocirc; lung linh sắc m&agrave;u&hellip; Tất cả l&agrave;m n&ecirc;n một thi&ecirc;n đường mang t&ecirc;n Phuket.</span></strong></p>', '<p style=\"text-align: center;\"><img height=\"306\" width=\"500\" alt=\"\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket.jpg\" /></p>\r\n<p><span style=\"font-size: small;\">Với tổng diện t&iacute;ch gần 600 km2, l&agrave; h&ograve;n đảo lớn nhất <a href=\"http://datviettour.com.vn/tour-nuoc-ngoai/3/du-lich-thai-lan\">Th&aacute;i Lan</a>, Phuket c&oacute; địa h&igrave;nh đa dạng: biển, rừng nguy&ecirc;n sinh, n&uacute;i, hang động&hellip; c&ugrave;ng những cảnh đẹp l&agrave;m say l&ograve;ng du kh&aacute;ch. Chẳng c&oacute; g&igrave; lạ khi Phuket &ndash; h&ograve;n ngọc miền Nam Th&aacute;i Lan - lu&ocirc;n được đ&aacute;nh gi&aacute; l&agrave; một trong những điểm đến hấp dẫn nhất của ch&acirc;u &Aacute;. </span></p>\r\n<p style=\"text-align: center;\"><img height=\"318\" width=\"500\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket1.jpg\" alt=\"\" /></p>\r\n<p style=\"text-align: center;\">&nbsp;<span style=\"font-size: small;\">Đảo Phi Phi</span></p>\r\n<p style=\"text-align: justify;\"><span style=\"font-size: small;\">Nằm kề b&ecirc;n h&ograve;n đảo ch&iacute;nh Phuket, quần đảo Phi Phi như một điểm nhấn cho bức tranh đầy sắc m&agrave;u của Phuket th&ecirc;m to&agrave;n vẹn. Phi Phi gồm 6 đảo nhỏ, nổi bật nhất l&agrave; đảo Phi Phi Don v&agrave; Phi Phi Ley, mỗi đảo l&agrave; một n&eacute;t đẹp ri&ecirc;ng. Phi Phi Don dịu d&agrave;ng e ấp với những b&atilde;i c&aacute;t mịn m&agrave;ng. Phi Phi Ley h&ugrave;ng vĩ, dữ dội với những v&aacute;ch đ&aacute; sừng sững chung quanh đảo. B&ecirc;n cạnh vẻ đẹp trinh nguy&ecirc;n v&agrave; hoang sơ, Phi Phi c&ograve;n tự h&agrave;o l&agrave; nơi c&oacute; bầu kh&ocirc;ng kh&iacute; tinh khiết nhất Th&aacute;i Lan. Đến đ&acirc;y, ngo&agrave;i việc tha hồ đắm m&igrave;nh trong những b&atilde;i biển sạch nhất h&agrave;nh tinh, du kh&aacute;ch c&ograve;n thỏa ch&iacute; với những tr&ograve; chơi mạo hiểm &ndash; kh&aacute;m ph&aacute; như: lặn ngắm san h&ocirc;, d&ugrave; lượn, ch&egrave;o thuyền kayak kh&aacute;m ph&aacute; c&aacute;c hang động đ&aacute; v&ocirc;i kỳ b&iacute;&hellip;</span></p>\r\n<p style=\"text-align: center;\"><img height=\"679\" width=\"500\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket2.jpg\" alt=\"\" /></p>\r\n<p style=\"text-align: center;\"><img height=\"359\" width=\"500\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket3.jpg\" alt=\"\" /></p>\r\n<p><span style=\"font-size: small;\">Hấp dẫn kh&ocirc;ng k&eacute;m l&agrave; vịnh Phang Nga. Đến đ&acirc;y, du kh&aacute;ch sẽ c&oacute; một trải nghiệm kh&oacute; qu&ecirc;n: đi thuyền d&agrave;i (một loại thuyền truyền thống của Th&aacute;i Lan) tham quan phong cảnh vịnh với cả trăm h&ograve;n đảo lớn nhỏ. Nơi đ&acirc;y c&oacute; đảo James Bond (t&ecirc;n cũ l&agrave; Khao Phingkan). Thập ni&ecirc;n 60 của thế kỷ trước, c&aacute;c nh&agrave; l&agrave;m phim Hollywood đ&atilde; chọn nơi đ&acirc;y l&agrave;m bối cảnh để quay tập phim &ldquo;The man with the golden gun&rdquo; trong loạt phim về điệp vi&ecirc;n 007. Sau đ&oacute;, để thu h&uacute;t kh&aacute;ch du lịch, người Th&aacute;i đổi lu&ocirc;n t&ecirc;n h&ograve;n đảo th&agrave;nh James Bond.</span></p>\r\n<p style=\"text-align: center;\"><img height=\"310\" width=\"500\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket4.jpg\" alt=\"\" /></p>\r\n<p style=\"text-align: justify;\"><span style=\"font-size: small;\">Kh&ocirc;ng chỉ thu h&uacute;t kh&aacute;ch <a href=\"http://datviettour.com.vn\">du lịch</a> bằng thi&ecirc;n nhi&ecirc;n hoang sơ v&agrave; kỳ th&uacute;, Phuket c&ograve;n l&agrave; nơi tập trung c&aacute;c resort v&agrave; c&aacute;c khu giải tr&iacute; sang trọng, nhộn nhịp bậc nhất tr&ecirc;n đất Th&aacute;i. Cuộc sống về đ&ecirc;m của Phuket cũng nhộn nhịp chẳng k&eacute;m thủ đ&ocirc; Bangkok với c&aacute;c khu thương mại sầm uất, c&aacute;c chương tr&igrave;nh biểu diễn ca m&uacute;a nhạc, c&aacute;c show xiếc th&uacute;&hellip; </span></p>\r\n<p style=\"text-align: center;\"><img height=\"310\" width=\"500\" src=\"/tourist.com/uploads/image/Tin%20tuc/phuket/phuket5.jpg\" alt=\"\" /></p>\r\n<p style=\"text-align: justify;\"><span style=\"font-size: small;\">Nhiều người đ&atilde; từng xem bộ phim nổi tiếng The Beach sản xuất năm 2000, lấy bối cảnh ch&iacute;nh l&agrave; một b&atilde;i biển thuộc quần đảo Phi Phi. Richard &ndash; nh&acirc;n vật ch&iacute;nh do Leonardo DiCaprio thủ vai &ndash; đ&atilde; đi t&igrave;m cho ri&ecirc;ng m&igrave;nh một thi&ecirc;n đường: kh&ocirc;ng điện, kh&ocirc;ng internet, chẳng nhộn nhịp x&ocirc; bồ; chỉ c&oacute; con người h&ograve;a m&igrave;nh c&ugrave;ng cỏ c&acirc;y, c&aacute;t, gi&oacute;, nắng, s&oacute;ng biển; hoang sơ v&agrave; trinh nguy&ecirc;n đến tột c&ugrave;ng. Phim ảnh chỉ l&agrave; hư cấu, nhưng chỉ cần một lần đến với Phuket, với Phi Phi, với Phang Nga, du kh&aacute;ch sẽ nhận ra một điều: vẫn c&ograve;n những thi&ecirc;n đường c&oacute; thật tr&ecirc;n tr&aacute;i đất n&agrave;y &hellip;</span></p>\r\n<p style=\"text-align: justify;\"><strong><a href=\"http://datviettour.com.vn\">Du lịch Đất Việt</a></strong> St</p>', '1307984400000', '0', '1');
INSERT INTO `article` VALUES ('2', '1', 'abc', '', '<p>asdsd</p>', '<p>asdasd</p>', '1308133557684', '0', '1');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryparentid` int(11) DEFAULT '0',
  `categoryname` varchar(255) DEFAULT NULL,
  `categorytype` int(11) DEFAULT NULL,
  `categoryordering` int(11) DEFAULT NULL,
  `categorypublished` int(11) DEFAULT '1',
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '0', 'Tin tức', '1', '1', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` bigint(20) NOT NULL AUTO_INCREMENT,
  `touristid` bigint(20) DEFAULT NULL,
  `commenttitle` varchar(255) DEFAULT NULL,
  `commentbody` text,
  `commentdate` bigint(20) DEFAULT NULL,
  `commentusername` varchar(255) DEFAULT NULL,
  `commentuseremail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `fk_relationship_8` (`touristid`),
  CONSTRAINT `fk_relationship_8` FOREIGN KEY (`touristid`) REFERENCES `tourist` (`touristid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `destination`
-- ----------------------------
DROP TABLE IF EXISTS `destination`;
CREATE TABLE `destination` (
  `destinationid` int(11) NOT NULL AUTO_INCREMENT,
  `townid` int(11) DEFAULT NULL,
  `destinationname` varchar(255) DEFAULT NULL,
  `destinationimage` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`destinationid`),
  KEY `fk_relationship_2` (`townid`),
  CONSTRAINT `fk_relationship_2` FOREIGN KEY (`townid`) REFERENCES `town` (`townid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of destination
-- ----------------------------

-- ----------------------------
-- Table structure for `nation`
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `nationid` int(11) NOT NULL AUTO_INCREMENT,
  `nationname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nationid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES ('1', 'Việt Nam');
INSERT INTO `nation` VALUES ('2', 'Singapore');
INSERT INTO `nation` VALUES ('3', 'Nhật Bản');
INSERT INTO `nation` VALUES ('4', 'Thái Lan');
INSERT INTO `nation` VALUES ('5', 'Úc');
INSERT INTO `nation` VALUES ('6', 'Pháp');

-- ----------------------------
-- Table structure for `placevisit`
-- ----------------------------
DROP TABLE IF EXISTS `placevisit`;
CREATE TABLE `placevisit` (
  `placevisitid` bigint(20) NOT NULL AUTO_INCREMENT,
  `touristid` bigint(20) DEFAULT NULL,
  `destinationid` int(11) DEFAULT NULL,
  `placevisitordering` int(11) DEFAULT NULL,
  PRIMARY KEY (`placevisitid`),
  KEY `fk_relationship_3` (`destinationid`),
  KEY `fk_relationship_4` (`touristid`),
  CONSTRAINT `fk_relationship_3` FOREIGN KEY (`destinationid`) REFERENCES `destination` (`destinationid`),
  CONSTRAINT `fk_relationship_4` FOREIGN KEY (`touristid`) REFERENCES `tourist` (`touristid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of placevisit
-- ----------------------------

-- ----------------------------
-- Table structure for `registration`
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `registrationid` bigint(20) NOT NULL AUTO_INCREMENT,
  `touristid` bigint(20) DEFAULT NULL,
  `registrationusername` varchar(255) DEFAULT NULL,
  `registrationusercode` varchar(50) DEFAULT NULL,
  `registrationuseraddress` varchar(255) DEFAULT NULL,
  `registrationuserphone` varchar(50) DEFAULT NULL,
  `registrationuseremail` varchar(255) DEFAULT NULL,
  `registrationnummember` int(11) DEFAULT NULL,
  `registrationdatestart` bigint(20) DEFAULT NULL,
  `registrationdate` bigint(20) DEFAULT NULL,
  `registrationapproved` int(11) DEFAULT '0',
  PRIMARY KEY (`registrationid`),
  KEY `fk_relationship_9` (`touristid`),
  CONSTRAINT `fk_relationship_9` FOREIGN KEY (`touristid`) REFERENCES `tourist` (`touristid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registration
-- ----------------------------

-- ----------------------------
-- Table structure for `tourist`
-- ----------------------------
DROP TABLE IF EXISTS `tourist`;
CREATE TABLE `tourist` (
  `touristid` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `touristtitle` varchar(255) DEFAULT NULL,
  `touristimage` varchar(255) DEFAULT NULL,
  `touristsummary` varchar(500) DEFAULT NULL,
  `touristbody` text,
  `touristprice` decimal(12,0) DEFAULT NULL,
  `touristnumday` int(11) DEFAULT NULL,
  `touristnumnight` int(11) DEFAULT NULL,
  `touristdate` bigint(20) DEFAULT NULL,
  `touristspecial` int(11) DEFAULT NULL,
  `touristpublished` int(11) DEFAULT '1',
  PRIMARY KEY (`touristid`),
  KEY `fk_relationship_6` (`categoryid`),
  CONSTRAINT `fk_relationship_6` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tourist
-- ----------------------------

-- ----------------------------
-- Table structure for `town`
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `townid` int(11) NOT NULL AUTO_INCREMENT,
  `nationid` int(11) DEFAULT NULL,
  `townname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`townid`),
  KEY `fk_relationship_1` (`nationid`),
  CONSTRAINT `fk_relationship_1` FOREIGN KEY (`nationid`) REFERENCES `nation` (`nationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------
