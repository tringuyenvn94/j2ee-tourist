/*
Navicat MySQL Data Transfer

Source Server         : Mydatabase
Source Server Version : 50153
Source Host           : localhost:3306
Source Database       : tourist

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2011-06-13 23:18:57
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
  `articlesummary` varchar(500) DEFAULT NULL,
  `articlebody` text,
  `articledate` bigint(20) DEFAULT NULL,
  `articlethumbnail` varchar(1024) DEFAULT NULL,
  `articlepublished` int(11) DEFAULT '1',
  PRIMARY KEY (`articleid`),
  KEY `fk_relationship_7` (`categoryid`),
  CONSTRAINT `fk_relationship_7` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', 'Thiên đường Phuket', '<p style=\"text-align: justify; \"><strong><span style=\"font-size: small; \">Biển xanh như ngọc. Cát trắng mịn màng. Những vách đá sừng sững giữa trời nước mênh mông. Những hang động đá vôi huyền hoặc. Những rạn san hô lung linh sắc màu… Tất cả làm nên một thiên đường mang tên Phuket.</span></strong></p>', '<p style=\"text-align: center; \"><img width=\"500\" height=\"306\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket.jpg\" /></p>\r\n<p><span style=\"font-size: small; \">Với tổng diện tích gần 600 km2, là hòn đảo lớn nhất <a href=\"http://datviettour.com.vn/tour-nuoc-ngoai/3/du-lich-thai-lan\">Thái Lan</a>, Phuket có địa hình đa dạng: biển, rừng nguyên sinh, núi, hang động… cùng những cảnh đẹp làm say lòng du khách. Chẳng có gì lạ khi Phuket – hòn ngọc miền Nam Thái Lan - luôn được đánh giá là một trong những điểm đến hấp dẫn nhất của châu Á. </span></p>\r\n<p style=\"text-align: center; \"><img width=\"500\" height=\"318\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket1.jpg\" /></p>\r\n<p style=\"text-align: center; \">&#160;<span style=\"font-size: small; \">Đảo Phi Phi</span></p>\r\n<p style=\"text-align: justify; \"><span style=\"font-size: small; \">Nằm kề bên hòn đảo chính Phuket, quần đảo Phi Phi như một điểm nhấn cho bức tranh đầy sắc màu của Phuket thêm toàn vẹn. Phi Phi gồm 6 đảo nhỏ, nổi bật nhất là đảo Phi Phi Don và Phi Phi Ley, mỗi đảo là một nét đẹp riêng. Phi Phi Don dịu dàng e ấp với những bãi cát mịn màng. Phi Phi Ley hùng vĩ, dữ dội với những vách đá sừng sững chung quanh đảo. Bên cạnh vẻ đẹp trinh nguyên và hoang sơ, Phi Phi còn tự hào là nơi có bầu không khí tinh khiết nhất Thái Lan. Đến đây, ngoài việc tha hồ đắm mình trong những bãi biển sạch nhất hành tinh, du khách còn thỏa chí với những trò chơi mạo hiểm – khám phá như: lặn ngắm san hô, dù lượn, chèo thuyền kayak khám phá các hang động đá vôi kỳ bí…</span></p>\r\n<p style=\"text-align: center; \"><img width=\"500\" height=\"679\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket2.jpg\" /></p>\r\n<p style=\"text-align: center; \"><img width=\"500\" height=\"359\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket3.jpg\" /></p>\r\n<p><span style=\"font-size: small; \">Hấp dẫn không kém là vịnh Phang Nga. Đến đây, du khách sẽ có một trải nghiệm khó quên: đi thuyền dài (một loại thuyền truyền thống của Thái Lan) tham quan phong cảnh vịnh với cả trăm hòn đảo lớn nhỏ. Nơi đây có đảo James Bond (tên cũ là Khao Phingkan). Thập niên 60 của thế kỷ trước, các nhà làm phim Hollywood đã chọn nơi đây làm bối cảnh để quay tập phim “The man with the golden gun” trong loạt phim về điệp viên 007. Sau đó, để thu hút khách du lịch, người Thái đổi luôn tên hòn đảo thành James Bond.</span></p>\r\n<p style=\"text-align: center; \"><img width=\"500\" height=\"310\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket4.jpg\" /></p>\r\n<p style=\"text-align: justify; \"><span style=\"font-size: small; \">Không chỉ thu hút khách <a href=\"http://datviettour.com.vn\">du lịch</a> bằng thiên nhiên hoang sơ và kỳ thú, Phuket còn là nơi tập trung các resort và các khu giải trí sang trọng, nhộn nhịp bậc nhất trên đất Thái. Cuộc sống về đêm của Phuket cũng nhộn nhịp chẳng kém thủ đô Bangkok với các khu thương mại sầm uất, các chương trình biểu diễn ca múa nhạc, các show xiếc thú… </span></p>\r\n<p style=\"text-align: center; \"><img width=\"500\" height=\"310\" alt=\"\" src=\"/demo_tourist/uploads/image/Tin%20tuc/phuket/phuket5.jpg\" /></p>\r\n<p style=\"text-align: justify; \"><span style=\"font-size: small; \">Nhiều người đã từng xem bộ phim nổi tiếng The Beach sản xuất năm 2000, lấy bối cảnh chính là một bãi biển thuộc quần đảo Phi Phi. Richard – nhân vật chính do Leonardo DiCaprio thủ vai – đã đi tìm cho riêng mình một thiên đường: không điện, không internet, chẳng nhộn nhịp xô bồ; chỉ có con người hòa mình cùng cỏ cây, cát, gió, nắng, sóng biển; hoang sơ và trinh nguyên đến tột cùng. Phim ảnh chỉ là hư cấu, nhưng chỉ cần một lần đến với Phuket, với Phi Phi, với Phang Nga, du khách sẽ nhận ra một điều: vẫn còn những thiên đường có thật trên trái đất này …</span></p>\r\n<p style=\"text-align: justify; \"><strong><a href=\"http://datviettour.com.vn\">Du lịch Đất Việt</a></strong> St</p>', '1307873728574', null, '1');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryparentid` int(11) DEFAULT '0',
  `categoryname` varchar(255) DEFAULT NULL,
  `categoryordering` int(11) DEFAULT NULL,
  `catergorypublished` int(11) DEFAULT '1',
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '0', 'Tin tức', '1', '1');

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
