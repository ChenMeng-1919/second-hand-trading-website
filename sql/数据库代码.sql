/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.60 : Database - xx-shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xx-shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xx-shop`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`admin_name`,`password`) values 
(1,'admin','123456');

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` bigint(20) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `banner_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `banner_price` double(10,2) DEFAULT NULL COMMENT '价格',
  `banner_detail` varchar(255) DEFAULT NULL COMMENT '详情',
  `banner_number` int(11) DEFAULT NULL COMMENT '库存',
  `img1` varchar(255) DEFAULT NULL,
  `img2` varchar(255) DEFAULT NULL,
  `img3` varchar(255) DEFAULT NULL,
  `sell_status` tinyint(4) DEFAULT NULL COMMENT '是否卖出',
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

insert  into `banner`(`id`,`category_id`,`seller_id`,`banner_name`,`banner_price`,`banner_detail`,`banner_number`,`img1`,`img2`,`img3`,`sell_status`,`created`,`updated`) values 
(1,1,1,'小米电视 4C 全新',699.00,'人工智能系统',3,'/assets/xximg/lunbotu3.jpg',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `buy_count` int(11) DEFAULT NULL COMMENT '购买数量',
  `goods_price` double DEFAULT NULL COMMENT '商品价格',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `goods_img` varchar(255) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`),
  KEY `用户ID` (`user_id`),
  KEY `商品ID` (`goods_id`),
  CONSTRAINT `用户ID` FOREIGN KEY (`user_id`) REFERENCES `xx_user` (`id`),
  CONSTRAINT `商品ID` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`category_name`) values 
(1,'二手手机'),
(2,'数码'),
(3,'二手图书'),
(4,'家用电器'),
(5,'服装'),
(6,'生活百货'),
(7,'运动户外'),
(8,'整车/车品'),
(10,'美妆');

/*Table structure for table `category_two` */

DROP TABLE IF EXISTS `category_two`;

CREATE TABLE `category_two` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `two_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `主分类ID` (`category_id`),
  CONSTRAINT `主分类ID` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `category_two` */

insert  into `category_two`(`id`,`category_id`,`two_name`) values 
(1,1,'iphone'),
(2,1,'小米'),
(3,1,'华为'),
(4,1,'魅族'),
(5,1,'一加'),
(7,1,'努比亚'),
(8,5,'女装'),
(9,5,'男装'),
(10,2,'索尼照相机'),
(11,2,'华为平板'),
(12,4,'小米电视'),
(13,4,'华为电子秤');

/*Table structure for table `express` */

DROP TABLE IF EXISTS `express`;

CREATE TABLE `express` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快递ID',
  `express_name` varchar(20) DEFAULT NULL COMMENT '快递名称',
  `express_price` double DEFAULT NULL COMMENT '快递价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `express` */

insert  into `express`(`id`,`express_name`,`express_price`) values 
(1,'顺丰快递',30),
(2,'中通快递',20),
(4,'EMS快递',15),
(5,'免运费',0);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '价格',
  `original_price` double DEFAULT NULL COMMENT '原价格',
  `goods_detail` varchar(255) DEFAULT NULL COMMENT '描述',
  `goods_number` int(11) DEFAULT NULL COMMENT '数量',
  `heat` int(11) DEFAULT NULL COMMENT '热度',
  `picture1` varchar(255) DEFAULT NULL COMMENT '图片1',
  `picture2` varchar(255) DEFAULT NULL COMMENT '图片2',
  `picture3` varchar(255) DEFAULT NULL COMMENT '图片3',
  `picture4` varchar(255) DEFAULT NULL COMMENT '图片4',
  `picture5` varchar(255) DEFAULT NULL COMMENT '图片5',
  `jb_status` tinyint(4) DEFAULT NULL COMMENT '精选1 白菜2',
  `sell_status` tinyint(4) DEFAULT NULL COMMENT '售出0 还有1',
  `created` date DEFAULT NULL COMMENT '上架时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `分类ID` (`category_id`),
  KEY `卖家ID` (`seller_id`),
  KEY `商品名` (`goods_name`),
  CONSTRAINT `分类ID` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `卖家ID` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`category_id`,`seller_id`,`goods_name`,`price`,`original_price`,`goods_detail`,`goods_number`,`heat`,`picture1`,`picture2`,`picture3`,`picture4`,`picture5`,`jb_status`,`sell_status`,`created`,`updated`) values 
(1,1,1,'华为 P30',2380,3099,'【二手95新】华为 P30 拍照游戏手机 全网通4G 双卡双待 亮黑色 8GB+128GB',40,80,'/assets/xximg/huawei301.jpg','/assets/xximg/huawei302.jpg','/assets/xximg/huawei303.jpg','/assets/xximg/huawei304.jpg','/assets/xximg/huawei305.jpg',2,1,'2019-10-11','2019-10-18'),
(2,1,2,'小米9',1899,2999,'【二手95新】小米9 手机骁龙855水滴全面屏4800万三摄拍照游戏智能 4G全网通 双卡双待 幻彩蓝 8GB+128GB',30,70,'/assets/xximg/xiaomi91.png','/assets/xximg/xiaomi92.jpg','/assets/xximg/xiaomi93.jpg','/assets/xximg/xiaomi94.jpg','/assets/xximg/xiaomi95.jpg',1,1,'2019-10-03','2019-10-17'),
(3,1,1,'小米8 青春版',849,1599,'【二手9成新】小米8 青春版 手机 镜面渐变AI双摄 拍照游戏智能全面屏 4G全网通 深空灰 6GB+64GB',20,20,'/assets/xximg/xiaomi81.png','/assets/xximg/xiaomi82.jpg','/assets/xximg/xiaomi83.jpg','/assets/xximg/xiaomi84.jpg','/assets/xximg/xiaomi85.jpg',1,1,'2019-09-27','2019-10-16'),
(4,1,1,'iPhone X ',3599,5299,'【二手95新】Apple iPhone X XR 苹果X 二手手机双卡双待 黑色 全网通 128G',30,70,'/assets/xximg/iPhoneX1.jpg','/assets/xximg/iPhoneX2.jpg','/assets/xximg/iPhoneX3.jpg','/assets/xximg/iPhoneX4.jpg','/assets/xximg/iPhoneX5.jpg',2,0,'2019-10-01','2019-10-12'),
(5,1,1,'一加7Pro',2759,3599,'【二手9成新】一加7Pro OnePlus 1+7pro二手安卓全面屏拍照游戏手机 骁龙855 星雾蓝 【赠WARP闪充套装】 8GB+256GB 全网通 在保',15,75,'/assets/xximg/1+71.jpg','/assets/xximg/1+72.jpg','/assets/xximg/1+73.jpg','/assets/xximg/1+74.jpg','/assets/xximg/1+75.jpg',2,1,'2019-10-01','2019-10-16'),
(6,1,2,'iPhone XR ',3499,4899,'【二手9成新】苹果XR 手机 Apple iPhone X xr 国行全网通 二手手机 双卡双待 珊瑚色 128G 全网通',60,80,'/assets/xximg/iphoneXR1.jpg','/assets/xximg/iphoneXR2.jpg','/assets/xximg/iphoneXR3.jpg','/assets/xximg/iphoneXR4.jpg','/assets/xximg/iphoneXR5.jpg',1,1,'2019-11-28','2019-11-28'),
(7,1,1,'iPhone7',1999,3299,'【二手9成新】苹果7Plus手机 Apple iPhone7Plus 苹果7P 二手手机 磨砂黑 128G 全网通',20,60,'/assets/xximg/iPhone71.jpg','/assets/xximg/iPhone72.jpg','/assets/xximg/iPhone73.jpg','/assets/xximg/iPhone74.jpg','/assets/xximg/iPhone75.jpg',1,1,'2020-05-21','2020-05-21'),
(8,4,1,'小米电视4C',699,799,'人工智能系统  高清液晶屏  64位处理器  海量影视内容  立体声扬声器  1GB+4GB 内存',5,90,'/assets/xximg/xiaomiTV1.jpg','/assets/xximg/xiaomiTV1.jpg','/assets/xximg/xiaomiTV1.jpg','/assets/xximg/xiaomiTV1.jpg','/assets/xximg/xiaomiTV1.jpg',1,1,'2020-05-05','2020-05-13'),
(9,2,1,'佳能EOS 90D',6899,7599,'【二手99新】佳能（Canon）EOS 90D 单反相机 单反机身 EOS 90D 机身 国行在保',2,40,'/assets/xximg/camera1.jpg','/assets/xximg/camera2.jpg','/assets/xximg/camera3.jpg','/assets/xximg/camera4.jpg','/assets/xximg/camera5.jpg',1,1,'2020-04-08','2020-05-01'),
(10,2,1,'华为平板MatePad Pro',2949,3899,'【二手95新】华为平板MatePad Pro 10.8英寸麒麟990影音游戏办公全面屏学生平板电脑 夜阑灰 6G+128G wifi版',3,70,'/assets/xximg/hwPad1.jpg','/assets/xximg/hwPad2.jpg','/assets/xximg/hwPad2.jpg','/assets/xximg/hwPad2.jpg','/assets/xximg/hwPad2.jpg',1,1,'2020-03-18',NULL),
(11,3,1,'Java核心技术 卷I 基础知识（原书第11版）',98,149,'CoreJava第11版，Jolt大奖获奖作品，与Java编程思想、EffectiveJava、深入理解Java虚拟机堪称：Java四大名著',50,60,'/assets/xximg/book11.jpg','/assets/xximg/book12.jpg','/assets/xximg/book12.jpg','/assets/xximg/book12.jpg','/assets/xximg/book12.jpg',1,1,'2019-07-19',NULL),
(13,3,1,'Java从入门到项目实战',49,99,'65小时全程视频教学，著名软件技术讲师20年Java经验集成之作，配套源代码、课件、自测题、面试题，赠Java工程师学习路线、职业规划、自我修养视频课',50,60,'/assets/xximg/book21.jpg','/assets/xximg/book22.jpg','/assets/xximg/book22.jpg','/assets/xximg/book22.jpg','/assets/xximg/book22.jpg',1,1,'2019-11-30',NULL),
(14,3,1,'Effective Java中文版（原书第3版）',78,119,'Java之父力荐；Jolt大奖作品升级；与Java核心技术、Java编程思想、深入理解Java虚拟机堪称Java四大名著。正版图书双色印刷，阅读体验更佳',50,60,'/assets/xximg/book31.jpg','/assets/xximg/book32.jpg','/assets/xximg/book32.jpg','/assets/xximg/book32.jpg','/assets/xximg/book32.jpg',1,1,'2019-07-27',NULL),
(15,1,1,'aqazqzaz',1111,1111,'<p>dasds</p>',11,NULL,'','',NULL,NULL,NULL,NULL,NULL,'2020-05-23','2020-05-23'),
(16,1,1,'aqazqzaz',1111,1111,'<p>dasds</p>',11,NULL,'','',NULL,NULL,NULL,NULL,NULL,'2020-05-23','2020-05-23');

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `express_id` bigint(20) DEFAULT NULL COMMENT '快递ID',
  `express_name` varchar(20) DEFAULT NULL COMMENT '快递名称',
  `express_price` double DEFAULT NULL COMMENT '快递价格',
  `goods_img` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `buy_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` double DEFAULT NULL COMMENT '商品价格',
  `goods_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`id`),
  KEY `订单ID` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=159019934280333 DEFAULT CHARSET=utf8;

/*Data for the table `order_detail` */

insert  into `order_detail`(`id`,`order_id`,`goods_id`,`seller_id`,`express_id`,`express_name`,`express_price`,`goods_img`,`buy_count`,`goods_price`,`goods_name`) values 
(159019932163231,159019932163183,6,2,4,'EMS快递',15,'/assets/xximg/iphoneXR1.jpg',1,3499,'iPhone XR '),
(159019934280332,159019934280375,6,2,5,'免运费',0,'/assets/xximg/iphoneXR1.jpg',1,3499,'iPhone XR ');

/*Table structure for table `seller` */

DROP TABLE IF EXISTS `seller`;

CREATE TABLE `seller` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '卖家ID',
  `seller_name` varchar(20) DEFAULT NULL COMMENT '卖家名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `city` varchar(10) DEFAULT NULL COMMENT '所在城市',
  `reputation` varchar(10) DEFAULT NULL COMMENT '信誉程度',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `seller` */

insert  into `seller`(`id`,`seller_name`,`password`,`email`,`phone`,`city`,`reputation`,`created`,`updated`) values 
(1,'闲大王','111111','123456@qq.com','18959294361','苏州','良好',NULL,'2020-02-29'),
(2,'二蛋','12412','123456@qq.com','18959294363','苏州','良好','2019-10-22','2019-10-22'),
(4,'ZHIHUI JIN','123123',NULL,'15370764634','苏州',NULL,'2020-05-21','2020-05-21');

/*Table structure for table `shop_order` */

DROP TABLE IF EXISTS `shop_order`;

CREATE TABLE `shop_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `express_id` bigint(20) DEFAULT NULL COMMENT '快递ID',
  `order_price` double DEFAULT NULL COMMENT '订单价格',
  `order_remarks` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `status` tinyint(4) DEFAULT NULL COMMENT '1完成  2未完成',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `over_time` date DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`),
  KEY `用户的ID` (`user_id`),
  KEY `快递ID` (`express_id`),
  CONSTRAINT `用户的ID` FOREIGN KEY (`user_id`) REFERENCES `xx_user` (`id`),
  CONSTRAINT `快递ID` FOREIGN KEY (`express_id`) REFERENCES `express` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159019934280376 DEFAULT CHARSET=utf8;

/*Data for the table `shop_order` */

insert  into `shop_order`(`id`,`user_id`,`express_id`,`order_price`,`order_remarks`,`status`,`created`,`over_time`) values 
(159019932163183,24,4,3514,NULL,1,'2020-05-23',NULL),
(159019934280375,24,5,3499,NULL,1,'2020-05-23','2020-05-23');

/*Table structure for table `xx_user` */

DROP TABLE IF EXISTS `xx_user`;

CREATE TABLE `xx_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `realname` varchar(10) DEFAULT NULL COMMENT '姓名',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `postcode` bigint(20) DEFAULT NULL COMMENT '邮编',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `xx_user` */

insert  into `xx_user`(`id`,`username`,`password`,`realname`,`email`,`phone`,`address`,`postcode`,`created`,`updated`) values 
(24,'灰太狼','123123','张三','1026981384@qq.com','15370764636','厦门市软件园三期D03公寓楼AAA',NULL,NULL,'2020-05-23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
