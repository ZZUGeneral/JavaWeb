/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : rest

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2019-04-26 08:24:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminId` int(10) NOT NULL,
  `Name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(30) CHARACTER SET utf8 NOT NULL,
  UNIQUE KEY `AdminId` (`AdminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'aa', '123456');
INSERT INTO `admin` VALUES ('2', 'bb', '123456');
INSERT INTO `admin` VALUES ('3', 'cc', '123456');
INSERT INTO `admin` VALUES ('4', 'dd', '123456');
INSERT INTO `admin` VALUES ('5', 'ee', '123456');
INSERT INTO `admin` VALUES ('6', 'ff', '123456');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `CartId` int(11) NOT NULL,
  `FoodId` int(10) DEFAULT NULL,
  `Number` int(10) DEFAULT NULL,
  PRIMARY KEY (`CartId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `FoodId` int(10) NOT NULL,
  `Name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Price` float NOT NULL,
  `MemberPrice` float NOT NULL,
  `Type` varchar(20) CHARACTER SET utf8 NOT NULL,
  `FoodExplain` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Material` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8 NOT NULL,
  `specialty` int(10) NOT NULL,
  PRIMARY KEY (`FoodId`),
  UNIQUE KEY `FoodId` (`FoodId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '西湖醋鱼', '50', '45', '汤菜', '临川牛莲花血鸭属赣菜系萍乡菜一支，是江西省萍乡市莲花县的一道特色名菜。这道菜选用土生土长的鸭子，加上当地的上等茶油、米酒、红辣椒，莲花血鸭色美味香、鲜嫩可口，最重要的是辣到过瘾，让人吃过就无法忘怀。', '原料：草鱼900克 配料：醋50克、黄酒25克、酱油75克、白糖60克、姜1块、葱适量、水淀粉50克等', '111.png', '0');
INSERT INTO `food` VALUES ('2', '宫保鸡丁', '50', '45', '炒菜', '在临川上顿渡这个千年小镇里，牛杂是一道鲜、脆、辣、爽嫩而不油腻的菜肴，许多人慕名前来吃牛杂。临川牛杂品种繁多，如牛肚、牛肠、牛肝牛筋、牛骨、牛脚等均可加入红辣椒，辣椒末等多种调料熬煮或爆炒，一盘下去，绝对让你酣畅淋漓。', '原料：鸡、脯肉、花生米 配料：干辣椒、色拉油、酱油、料酒、食盐、植物油、味精、花椒、淀粉等', '222.png', '0');
INSERT INTO `food` VALUES ('3', '粉狮子头', '60', '55', '炒菜', '新余麻辣鸭头是江西传统的汉族名吃，是通过多种香料浸泡，然后经过风干或烤制等工序精致而成。麻辣鸭头香鲜美味，回味十足，有啃头，虽然很辣，但总是让人停不下筷子，吃了还想吃。吃起来麻麻的，酥酥的，鸭肉鲜美酥软，咬开脑壳，那脑髓特好吃，特有一番嚼头。', '原料：猪肉 、粉条、生菜 配料：料酒、小葱、姜、猪油、盐、淀粉、食盐、酱料等', '333.png', '0');
INSERT INTO `food` VALUES ('4', '醉糟鸡', '60', '55', '蒸菜', '鄱湖胖鱼头是一道江西省九江市的特色传统名菜，属于赣菜系浔阳菜一支。因其鲜辣微酸、肥嫩鲜美、营养丰富且主材胖鱼头乃是产自中国最大淡水湖暨江西人民的母亲湖鄱阳湖。', '原 配料：嫩鸡肉、萝卜 配料：辣椒红糟、五香粉、白糖、绍酒、高粱酒、精盐、白醋、味精、鸡汤等', '444.png', '0');
INSERT INTO `food` VALUES ('5', '东坡肉', '50', '45', '炒菜', '东坡肉相传为北宋词人苏东坡（四川眉山人）所创制，最早发源地是四川眉山。原型是徐州回赠肉， 为徐州“东坡四珍”之一。追本穷源，苏轼的这种红烧肉最早在徐州的创制，在黄州时得到进一步提高，在杭州时闻名全国。', '东坡肉，又名滚肉、东坡焖肉，是眉山和江南地区特色传统名菜。东坡肉在浙菜、川菜、鄂菜等菜系中都有，且各地做法也有不同，有先煮后烧的，有先煮后蒸的，有直接焖煮收汁的。主料都是半肥半瘦的猪肉。', 'p123.jpg', '1');
INSERT INTO `food` VALUES ('6', '萍乡小炒肉', '45', '40', '炒菜', '萍乡人是出了名的爱吃辣，煮粥、炖汤都要放辣椒，萍乡小炒肉是典型的萍乡汉族风味名菜，鲜香辣味美。绝对让你吃到辣椒的一种纯粹感，那种酷辣和酷麻，让你眼冒金星，吃罢有头重脚轻的感觉。', '猪肉', '6', '0');
INSERT INTO `food` VALUES ('7', '夫妻肺片', '55', '50', '炒菜', '夫妻肺片(Sliced beef and ox organs in chili sauce)，是一道四川成都名菜，由郭朝华、张田政夫妻创制而成。牛头皮、牛心、牛舌、牛肚、牛肉为主料，进行卤制，而后切片。再配以辣椒油、花椒面等辅料制成红油浇在上面。其制作精细，色泽美观，质嫩味鲜，麻辣浓香，非常适口。', '牛头皮、牛心、牛舌、牛肚、牛肉为主料，进行卤制，而后切片。再配以辣椒油、花椒面等辅料制成红油浇在上面。其制作精细，色泽美观，质嫩味鲜，麻辣浓香，非常适口。', '7', '0');
INSERT INTO `food` VALUES ('8', '回锅肉', '35', '30', '炒菜', '川菜之化身，提到川菜必然想到回锅肉。它色香味俱全，颜色养眼，是下饭菜的首选。配料各有不同，除了蒜苗(青蒜)还可以用彩椒，洋葱，韭菜，锅盔等来制作回锅肉，每家都有自己的秘方。回锅肉在川菜中的地位是非常重要的，回锅肉一直被认为是川菜之首。', '猪肉', '8', '0');
INSERT INTO `food` VALUES ('9', '口水鸡', '50', '45', '炖菜', '口水鸡是一道凉菜，佐料丰富，集麻辣鲜香嫩爽于一身。有“名驰巴蜀三千里，味压江南十二州”的美称。“口水鸡”这名字初听感觉有点不雅，脑子里可能会出现一副口水滴哒的样子，之所以叫口水鸡还因为有很多花椒，吃了会麻到嘴巴瘫痪不由自主流口水。', '鸡', '9', '0');
INSERT INTO `food` VALUES ('10', '鱼香茄子', '30', '25', '炒菜', '鱼香茄子是是四川省传统的特色名菜之一。属于川菜系中比较具有代表性的鱼香味型的名菜。鱼香系列的川菜，最主要的辅料郫县豆瓣。主料配以郫县豆瓣加上其他调料烧出来的菜肴，其味厚重悠长，余味缭绕，回味无穷，故称余香。', '主料配以郫县豆瓣加上其他调料烧出来的菜肴。', '10', '0');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `NoticeId` int(15) NOT NULL,
  `Theme` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Notice` varchar(500) CHARACTER SET utf8 NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`NoticeId`),
  UNIQUE KEY `NoticeId` (`NoticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '餐厅开放通知', '本店将于。。年。。月。。日正式开业，届时热烈欢迎广大消费者莅临本店，全天将对所有的客户打八折优惠.', '2019-04-23 14:31:53');
INSERT INTO `notice` VALUES ('2', '春节放假', '通 知亲爱的xx们：春节假期即将来临，首先向大家致以节日的问候，我们对放假时间的通知如下：假期时间为x年x月x日至x年x月x日x年x月x日x点正常工作最后祝大家春节快乐，度过一个愉快的假期！ xxxxxxx年x月xx日', '2019-04-24 14:34:49');
INSERT INTO `notice` VALUES ('3', '萨芬付款', '第三个很多顾客哦隔热价格NSF打开架空客范德萨哥哥积分兑换儿科辜负大家开始很快过热', '2019-04-23 14:36:36');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `OrderNo` int(15) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `FoodId` int(10) NOT NULL,
  `Number` int(10) NOT NULL,
  `Price` float NOT NULL,
  `Statu` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`OrderNo`),
  UNIQUE KEY `OrderNo` (`OrderNo`),
  KEY `UserId` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2019-04-09 23:15:59', '1', '5', '525', '1');
INSERT INTO `orders` VALUES ('2', '2', '2019-04-01 23:16:42', '2', '4', '254', '1');
INSERT INTO `orders` VALUES ('3', '3', '2019-04-03 23:17:10', '3', '4', '289', '1');
INSERT INTO `orders` VALUES ('4', '4', '2019-04-24 23:56:11', '4', '6', '5454', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL,
  `Name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `Address` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Phone` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Type` int(2) NOT NULL DEFAULT '0',
  `Gender` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `Birthday` timestamp NULL DEFAULT NULL,
  `Password` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Nick` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserId` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '谢凯', '郑州大学菊园六号楼', '17803861986', '0', '男', '2019-04-23 14:40:43', '123456', '1');
INSERT INTO `user` VALUES ('2', '蔡志龙', '郑州大学菊园六号楼', '11111111111', '0', '女', '2019-04-02 14:42:27', '123456', 'zz');
INSERT INTO `user` VALUES ('3', '朱港亚', '郑州大学菊园六号楼', '22222222222', '1', '女', '2019-04-02 14:43:10', '123456', '2huo');
INSERT INTO `user` VALUES ('4', '李金辉', '郑州大学菊园六号楼', '33333333333', '1', '女', '2019-04-02 14:43:56', '123456', 'b');
INSERT INTO `user` VALUES ('5', '赵茹娇', '郑州大学菊园', '44444444444', '0', '女', '2019-04-08 14:45:43', '123456', 'c');
INSERT INTO `user` VALUES ('6', '王腾', '郑州大学菊园六号楼', '55555555555', '0', '男', '2019-04-02 14:46:21', '123456', 'd');
