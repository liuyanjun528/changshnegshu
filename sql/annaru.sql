/*
SQLyog 企业版 - MySQL GUI v8.14
MySQL - 5.7.13 : Database - information_publish
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`information_publish` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `information_publish`;

/*Table structure for table `doctor_info` */

DROP TABLE IF EXISTS `doctor_info`;

CREATE TABLE `doctor_info` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `name` varchar(32) NOT NULL COMMENT '医生姓名',
  `picture` varchar(100) NOT NULL COMMENT '医生照片',
  `job_title` varchar(32) NOT NULL COMMENT '医生职称',
  `intro` varchar(1024) DEFAULT NULL COMMENT '医生简介',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='医生信息';

/*Data for the table `doctor_info` */

insert  into `doctor_info`(`id`,`name`,`picture`,`job_title`,`intro`,`create_user`,`create_time`,`update_time`) values ('005ec1042ef6fb98aba18781514f4970','陶勇军','/upload/EB63C3F58E624CAF9EE951B8BF2F75EC.JPG','医师',NULL,'1','2019-04-16 16:53:28','2019-04-16 16:53:28'),('0563da24ab8fa225d28e199129eac34a','廖慧芝','/upload/761535585ABC47EFB9CC6D176A872673.jpg','医师',NULL,'1','2019-04-16 16:48:10','2019-04-16 16:48:10'),('0d74413a802109c342a68f2d97f462e8','沈珍','/upload/44BF3FD340D7438CADC0A246E776F199.JPG','医师',NULL,'1','2019-04-16 16:51:01','2019-04-16 16:51:01'),('11a904e180628a190da556587e39912d','张思琴','/upload/77CAEFD1815D4E6497432C523CA742F2.jpg','医师',NULL,'1','2019-04-16 16:58:06','2019-04-16 16:58:06'),('1b5a494ebe25f9e1d02b1188289ea1bb','徐迎佳','/upload/9C1BD3467F0F4E83B7F3E86E11BDC3A5.jpg','医师',NULL,'1','2019-04-16 16:56:02','2019-04-16 16:56:02'),('1daf53c12c41464f8adc57acf1966f59','计毅仙','/upload/7EC99E79A61540C3AAC2E379EED1C79A.JPG','医师',NULL,'1','2019-04-16 16:45:51','2019-04-16 16:45:51'),('2065bca795ef0f2796525a70ec6aca80','夏冬梅','/upload/A6A46F8F2B604E65BDBDB7A545DB13BA.JPG','医师',NULL,'1','2019-04-16 16:55:32','2019-04-16 16:55:32'),('28d81b1a472b7cdae9d05cd68ce975c1','严雅','/upload/9A5525C6F8F44EFD83596390E343A667.jpg','医师',NULL,'1','2019-04-16 16:56:52','2019-04-16 16:56:52'),('2c97b91a54c5e7c7b8172d3ac08c0cc7','王丰','/upload/DDB66595AB984DE1B87EE3C89EF22E89.jpg','医师',NULL,'1','2019-04-16 16:53:56','2019-04-16 16:53:56'),('30f7e95d99a3c742bd418de4e3a2f74a','张志','/upload/276F6EC05E154C9BADF228830036417C.jpg','医师',NULL,'1','2019-04-16 16:58:36','2019-04-16 16:58:36'),('384fa8edf8f86b91e7518845cbf5a3d0','甘保安','/upload/AF8C0473DC73485E8E4172768F6A362F.JPG','医师',NULL,'1','2019-04-16 16:44:34','2019-04-16 16:44:34'),('39151a000d2e107c7dff4110f3e69489','蒋秀君','/upload/480BC0B8A986414DAA50A15D35F840AF.jpg','医师',NULL,'1','2019-04-16 16:46:35','2019-04-16 16:46:35'),('3c59612589ceee9cfa5d188dd1bd9479','许丽华','/upload/D50A4BED23A24DDE83F67501F055AD15.JPG','医师',NULL,'1','2019-04-16 16:56:30','2019-04-16 16:56:30'),('3d335e76b9730a1381d872dea8718d51','李东','/upload/D8F3E26FA58D46D889AEDCC4F07D1CA0.JPG','医师',NULL,'1','2019-04-16 16:47:22','2019-04-16 16:47:22'),('3de2dd1c1352ac011fca5f5fb28d7237','薛白玉','/upload/28C04D189F614C42B458F3C59D71D0DD.jpg','医师',NULL,'1','2019-04-16 16:56:42','2019-04-16 16:56:42'),('3ebedaa4ed98f5f1256449247da78c6e','陶华','/upload/866B75BFA4CB44D6BEECDEEE8BE34557.jpg','医师',NULL,'1','2019-04-16 16:53:13','2019-04-16 16:53:13'),('4b55c7af117ddb972e90a87bb478c8a6','王小明','/upload/6E6B4289B67E43178C335A0CB81425F5.JPG','医师',NULL,'1','2019-04-16 16:54:34','2019-04-16 16:54:34'),('50817b89e72a1130a87775dc392de943','金马兰','/upload/6A080194D62B423A8AD3E7884A7B922F.jpg','医师',NULL,'1','2019-04-16 16:47:06','2019-04-16 16:47:06'),('53437c37c7ec6466798a898b9b7f3453','何忠蓉','/upload/07A6204C2F154E8CAFA384C717C26D97.JPG','医师',NULL,'1','2019-04-16 16:45:05','2019-04-16 16:45:05'),('54075bd6358a6de29e6b56f7a674482d','孙玲娣','/upload/3D3CF0DA27974CCFB590A84CA6352732.JPG','医师',NULL,'1','2019-04-16 16:52:40','2019-04-16 16:52:40'),('54ad108ab31f3f594d39658b5e253cd8','张国萍','/upload/1BC0CFFE80DA4950A6274A288581A1DA.JPG','医师',NULL,'1','2019-04-16 16:57:27','2019-04-16 16:57:27'),('56bebd361b0e827c7dc6e7a28eaf49e4','李娜','/upload/D895467C5FBF4FD6B541EBC31A6B5064.jpg','医师',NULL,'1','2019-04-16 16:48:26','2019-04-16 16:48:26'),('56d60ff50acd53ff6d7ae3082b357ca5','陆海峰','/upload/D3CECABDAE144DDBB7A2BB60687CF851.JPG','医师',NULL,'1','2019-04-16 16:49:38','2019-04-16 16:49:38'),('57871063a0dbc148de919b205b838087','沈丽萍','/upload/3D9A4469F087493DBBE90F84989DB09F.JPG','医师',NULL,'1','2019-04-16 16:50:42','2019-04-16 16:50:42'),('5c1d7616a8ad55c8ed79df624290192b','朱苗苗','/upload/8E584D16E1574E0FA76A91F72A3B560D.jpg','医师',NULL,'1','2019-04-16 16:58:48','2019-04-16 16:58:48'),('662a2e6cf42a112a9cb6ac1a60973453','林桂芳','/upload/C725ED337FE14342B5B2DB7AA540DF3B.jpg','医师',NULL,'1','2019-04-16 16:48:38','2019-04-16 16:48:38'),('6630ae465e11cdabed28eb820b382f4e','李忠诚','/upload/7B7BDC7DCF9543558FB9FD75D9124485.jpg','医师',NULL,'1','2019-04-16 16:47:50','2019-04-16 16:47:50'),('68ac655ebc68f1622955a2dd21ad31cb','朱秀英','/upload/29F33A68CBEB402B894B88E08417FF76.JPG','医师',NULL,'1','2019-04-16 16:59:00','2019-04-16 16:59:00'),('697a7851fa5a40aed6eabcc7bc8e5885','王慧英','/upload/959F93AEFAA443B5A5012478B985996A.jpg','医师',NULL,'1','2019-04-16 16:54:20','2019-04-16 16:54:20'),('6a1697d7c73e748c9df7c85fb58d0e63','孙洪波','/upload/AAB77BB3C5D84977BDAAAB2886AB12B7.JPG','医师',NULL,'1','2019-04-16 16:52:23','2019-04-16 16:52:23'),('6aa47a0d363195f93ec04231e2874b14','张霞萍','/upload/610AD74CD74C4ABABF27B592D747B121.JPG','医师',NULL,'1','2019-04-16 16:58:24','2019-04-16 16:58:24'),('70ab0d6ccbcc6056602a6e383b217727','翁东承','/upload/523537B25D55439B9A8112C3E10A8B11.JPG','医师',NULL,'1','2019-04-16 16:54:48','2019-04-16 16:54:48'),('73ca687ddb1a5143d3c3cadc9765e6a3','姚依','/upload/EF21DF656EFF4CA082B21831E5D010F5.jpg','医师',NULL,'1','2019-04-16 16:57:04','2019-04-16 16:57:04'),('7569e6dd0119c1e907df1c89a31f0827','陈继东','/upload/7D5CBB126D5C49D6A5B8C029E21C00F6.JPG','医师',NULL,'1','2019-04-16 16:43:56','2019-04-16 16:43:56'),('7cd1983d93c3e7fc14f793404b02352d','欧雯','/upload/AED5DC95BE3B4B2CA5DA0194D5851D3A.JPG','医师',NULL,'1','2019-04-16 16:50:16','2019-04-16 16:50:16'),('80315d4b58aa52bad185611a5d035290','蒋宏','/upload/BBE4C660D8FF40A98F61687EAE40376C.JPG','医师',NULL,'1','2019-04-16 16:46:05','2019-04-16 16:46:05'),('8590c4697dfe8dd4b92d0a80258428f0','袁毅英','/upload/C1943616A6BD4ABABAD80D21C9B3BF60.JPG','医师',NULL,'1','2019-04-16 16:57:16','2019-04-16 16:57:16'),('88d2ba0053ce81731a543233e5e67a9e','杜军','/upload/CE555450C2DC469E9A394DCECF401714.jpg','医师',NULL,'1','2019-04-16 16:44:05','2019-04-16 16:44:05'),('88f9300cb11b87d0af4b9c155f418eed','陆凤芳','/upload/DEA4B0A1E11F4EB9B13BC41FFD757DED.jpg','医师',NULL,'1','2019-04-16 16:49:17','2019-04-16 16:49:17'),('8bab16b2fb20fc19bda9989c0ed19086','唐孝先','/upload/D03B7DE96E624C87BB61131EA7255F4A.JPG','医师',NULL,'1','2019-04-16 16:52:59','2019-04-16 16:52:59'),('8d8727509e03f5e785ae8805b824604b','徐军华','/upload/49AD090DEF8540A483AA7D0A2E9BDFD3.JPG','医师',NULL,'1','2019-04-16 16:55:48','2019-04-16 16:55:48'),('8f66cfb4d508445be118cdee72e3cfb3','陈辉','/upload/A09F7EFE1A8A42E8A57FEFF4F11D516A.jpg','医师',NULL,'1','2019-04-16 16:43:46','2019-04-16 16:43:46'),('8fb83f3df28f0b666330ca2925b173d6','黄胜兰','/upload/21EA2075D59B43069C2D5EE43EDA14FC.jpg','医师',NULL,'1','2019-04-16 16:45:26','2019-04-16 16:45:26'),('8fc31ea269d02e3f8f7b5f4d2e9c2b01','施静慧','/upload/EA7F5981ADDB4BE7B10C583CB09F646F.jpg','医师',NULL,'1','2019-04-16 16:52:12','2019-04-16 16:52:12'),('919352d0e2555a4be08b137c7ee84375','施静慧','/upload/0EF819662BAE4566A91DA126AB950635.jpg','医师',NULL,'1','2019-04-16 16:51:55','2019-04-16 16:51:55'),('9c32ee9a3cf84f9b60d847ed4e098caf','诸娟英','/upload/8AF6DA37020A411C9492DAB060ACCB62.JPG','医师','医生简介','1','2019-04-16 16:59:21','2019-04-25 13:19:46'),('9c54af0cf9ee155c795d58d31b7c8c14','刘杰','/upload/04748C7DCC734D828318412A9F125320.jpg','医师',NULL,'1','2019-04-16 16:48:52','2019-04-16 16:48:52'),('9c74631b46b4f497e2dae8ffeb38582c','富晓玫','/upload/981636D0986542AEA068A45137D1B588.jpg','医师',NULL,'1','2019-04-16 16:44:24','2019-04-16 16:44:24'),('a2cc4fc1a183ac5ae8fd7a269ad1c0ac','施国伟','/upload/4B18380F64A9412292D72ABB19871CF8.jpg','医师',NULL,'1','2019-04-16 16:51:17','2019-04-16 16:51:17'),('a3c03c1cd4fcf7261b0bc0476084e45b','万娟','/upload/D4B82913970345899DD8CB7F35B25FAC.jpg','医师',NULL,'1','2019-04-16 16:53:42','2019-04-16 16:53:42'),('a3f80eee8041ec32fb42385196e576fa','吴吉英','/upload/3DAFE4733DC14B67A7BE31855E30A407.JPG','医师',NULL,'1','2019-04-16 16:55:00','2019-04-16 16:55:00'),('a5e564988e46e5539134597bd43f426f','陆银余','/upload/2DDE747F2C164A638F27458E8BCFC5E8.JPG','医师',NULL,'1','2019-04-16 16:49:48','2019-04-16 16:49:48'),('a8f9ed17819d9112e290d97a0caa5f31','钱湘绮','/upload/B02C8EC463CD4DDAAE7EC1007FBEE055.jpg','医师',NULL,'1','2019-04-16 16:50:31','2019-04-16 16:50:31'),('ad2010f77d26f883b52f4056503e8b06','付淑平','/upload/CB743A0F7F17448499A7105B8D9A14C8.jpg','医师',NULL,'1','2019-04-16 16:44:14','2019-04-16 16:44:14'),('adb0974e1349a8b87330ed1027961aaf','李明飞','/upload/D56DC8021E634F29AD225EFBC1DAFA81.JPG','医师',NULL,'1','2019-04-16 16:47:38','2019-04-16 16:47:38'),('b1dad6f0d2c741e519806d341e163c96','张慧','/upload/7D9B979A8361408FBEBE9B230A3EDF73.JPG','医师',NULL,'1','2019-04-16 16:57:43','2019-04-16 16:57:43'),('b8827e5551174d08901de2cb28f2ba05','何立浩','/upload/F9096DF2C840474783EDF7D93F94DF3B.jpg','医师',NULL,'1','2019-04-16 16:44:54','2019-04-16 16:44:54'),('c0cb060d5579b2582a934767b141bd0d','朱玉华','/upload/AF048357491D410CAE67F5F726004AD6.jpg','医师',NULL,'1','2019-04-16 16:59:10','2019-04-16 16:59:10'),('c0e6687a90e0c7e51879f56a8e865f3d','吴智聪','/upload/A60DB3F59D77460FAF65290CCD368F92.jpg','医师',NULL,'1','2019-04-16 16:55:22','2019-04-16 16:55:22'),('d0eb22c840d6fd2462c50651131c67c9','金娟','/upload/43E6B55620DB45328308B180F03B6D3F.JPG','医师',NULL,'1','2019-04-16 16:46:55','2019-04-16 16:46:55'),('d101f3dc4c5a739ae447d4603c212385','黄晨瑜','/upload/2C3D78468ABC4320B8159AA37CDB6EF8.JPG','医师',NULL,'1','2019-04-16 16:45:15','2019-04-16 16:45:15'),('d7f42960af24f4c5b3114548b5b9e440','张璐','/upload/EBE195A9B2044503A78439C4BD0F7360.JPG','医师',NULL,'1','2019-04-16 16:57:56','2019-04-16 16:57:56'),('dd578183426ad5df914beb9d349647a3','许宾','/upload/D0189F2DA63A49EA826CBD49851817A6.jpg','医师',NULL,'1','2019-04-16 16:56:16','2019-04-16 16:56:16'),('e3f45489fcad6770f09a962121a7803e','罗权平','/upload/5A416086E0EA41928793B620382C96DA.jpg','医师',NULL,'1','2019-04-16 16:50:03','2019-04-16 16:50:03'),('ef62461f3144c1e4efee4ca569a69edf','王凤宝','/upload/7E5B003CCBE1425FB80B1792F2723B11.JPG','医师',NULL,'1','2019-04-16 16:54:09','2019-04-16 16:54:09'),('f4f17856b2e40f4169d5254be7cb19e8','计美蓉','/upload/D9B6DA26F0F645CAAB9D0AB02D58FDBC.JPG','医师',NULL,'1','2019-04-16 16:45:35','2019-04-16 16:45:35'),('f58f9b2b7d6a03d025de7b9e277a8446','高春燕','/upload/BE9FFBDA73774EA7B4AF20046EEC4FD3.jpg','医师',NULL,'1','2019-04-16 16:44:44','2019-04-16 16:44:44'),('f738859c8a737ec89842e26b416c1453','曾令雄','/upload/F46063A973B44A1DA5E131161EB14A4D.JPG','医师',NULL,'1','2019-04-16 16:43:37','2019-04-16 16:43:37'),('f7f670e2a3747d279a1716f2e249f4dc','刘军','/upload/89C335F571DA417F844FA54D9529DEB8.jpg','医师',NULL,'1','2019-04-16 16:49:05','2019-04-16 16:49:05'),('fbd5926faa1528a41f89733372c99707','蒋卫娟','/upload/220E6E29E79F43ECB01D6ABB5E0C3970.JPG','医师',NULL,'1','2019-04-16 16:46:21','2019-04-16 16:46:21');

/*Table structure for table `lcd_big_config` */

DROP TABLE IF EXISTS `lcd_big_config`;

CREATE TABLE `lcd_big_config` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_ip` varchar(20) NOT NULL COMMENT '大屏IP',
  `children_ip` varchar(500) DEFAULT NULL COMMENT '所有小屏IP，逗号分隔',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='叫号大屏ip配置';

/*Data for the table `lcd_big_config` */

insert  into `lcd_big_config`(`id`,`parent_ip`,`children_ip`,`create_time`,`update_time`) values ('5e2a868c817b2b107ff8826503b1dc63','10.98.236.247','kq0201,kq0202,kq0203','2019-04-16 17:03:47','2019-04-22 16:08:19'),('91d8f222a9ac3ff231539105e1c80720','10.98.236.241','10.98.236.230,10.98.236.231,10.98.236.232,10.98.236.233,10.98.236.234','2019-04-03 10:21:04','2019-04-16 17:00:59'),('92d8f222a9ac3ff231539105e1c80720','10.98.236.242','10.98.236.230,10.98.236.231,10.98.236.232,10.98.236.233,10.98.236.234','2019-04-04 13:36:26','2019-04-16 17:01:47'),('93d8f222a9ac3ff231539105e1c80720','10.98.236.243','10.98.236.235,10.98.236.236,10.98.236.237,10.98.236.238','2019-04-09 14:11:08','2019-04-16 17:02:21'),('ab93b06d799f9ba94708cf124b97ab95','10.98.236.246','10.98.236.239,10.98.236.240','2019-04-16 17:02:48','2019-04-22 09:25:43');

/*Table structure for table `lcd_log` */

DROP TABLE IF EXISTS `lcd_log`;

CREATE TABLE `lcd_log` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '(0:info，1:error)',
  `address` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT=' 连接日志';

/*Data for the table `lcd_log` */

insert  into `lcd_log`(`id`,`type`,`address`,`content`,`create_time`) values ('c67e316e675afd29c871fcbe8926b773',1,'10.98.236.240','failed to connect to /10.98.247.141 (port 7001): connect failed: ETIMEDOUT (Connection timed out)位置:2','2019-04-25 13:08:26');

/*Table structure for table `lcd_show` */

DROP TABLE IF EXISTS `lcd_show`;

CREATE TABLE `lcd_show` (
  `xpdz` varchar(50) DEFAULT NULL COMMENT '小屏地址',
  `ysxm` varchar(50) DEFAULT NULL COMMENT '医生姓名',
  `ysgh` varchar(50) DEFAULT NULL COMMENT '医生工号',
  `fjmc` varchar(50) DEFAULT NULL COMMENT '房间名称',
  `ysgy` varchar(500) DEFAULT NULL COMMENT '医生格言',
  `pdhm` varchar(50) DEFAULT NULL COMMENT '排队号码',
  `brxm` varchar(50) DEFAULT NULL COMMENT '病人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT '0' COMMENT '状态(0：正常、1：失效)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='叫号管理';

/*Data for the table `lcd_show` */

insert  into `lcd_show`(`xpdz`,`ysxm`,`ysgh`,`fjmc`,`ysgy`,`pdhm`,`brxm`,`create_time`,`update_time`,`status`) values ('175','周胜云','402','全科','','','停诊','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.238.61','李娜','834','诊室1','','288','金世祥','2019-04-25 00:00:00','2019-04-25 13:48:05',0),('10.98.238.64','金娟','898','诊室4','','285','陈冬娣','2019-04-25 00:00:00','2019-04-25 13:46:21',0),('1','张亮','310','','','','','2019-04-25 00:00:00','2019-04-25 13:37:25',0),('10.98.238.63','李忠诚','891','诊室3','','262','卢小弟','2019-04-25 00:00:00','2019-04-25 13:20:13',0),('10.98.238.65','徐军华','860','诊室5','','257','王传玉','2019-04-25 00:00:00','2019-04-25 13:12:55',0),('10.98.238.62','杜军','007','诊室2','','263','巫锦琪','2019-04-25 00:00:00','2019-04-25 13:20:51',0),('10.98.247.59','张国萍','868','智测室','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.247.58','富晓玫','885','儿童保健','','557','温昊辰','2019-04-25 00:00:00','2019-04-25 10:42:00',0),('10.98.247.53','','','预防接种','','141','李凌薇','2019-04-25 00:00:00','2019-04-25 10:52:29',0),('10.98.236.230','陶华','631','全科1','','141','陆振平','2019-04-25 00:00:00','2019-04-25 13:16:59',0),('10.98.236.231','严雅','875','全科2','','155','沈再英','2019-04-25 00:00:00','2019-04-25 13:35:23',0),('10.98.236.232','严雅','875','全科3','','158','何四妹','2019-04-25 00:00:00','2019-04-25 13:47:28',0),('kq0201','李义','636','口腔1','','34','陈显印','2019-04-25 00:00:00','2019-04-25 13:18:29',0),('10.98.236.237','陈辉','068','专家门诊','','3','蒋凤仪','2019-04-25 00:00:00','2019-04-25 13:47:05',0),('10.98.236.236','刘杰','056','儿科诊室','','4','王羿栩','2019-04-25 00:00:00','2019-04-25 10:08:38',0),('10.98.236.233','','888','','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('kq0202','曾令雄','883','口腔2','','36','蒋书赛','2019-04-25 00:00:00','2019-04-25 13:33:47',0),('10.98.236.239','庄婵娟','076','妇科','','2','朱桂琴','2019-04-25 00:00:00','2019-04-25 08:43:31',0),('10.98.247.62','','','','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.247.64','','','','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.247.63','','','','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.247.52','','','预防接种','','147','AMMAR','2019-04-25 00:00:00','2019-04-25 11:00:34',0),('10.98.247.54','','','预防接种','','148','符晴晴','2019-04-25 00:00:00','2019-04-25 13:22:35',0),('10.98.247.65','','','','','','','2019-04-25 00:00:00','2019-04-25 00:00:00',0),('10.98.247.57','陆凤芳','632','儿童保健','','552','彭子睿','2019-04-25 00:00:00','2019-04-25 10:51:21',0),('10.98.247.61','罗权平','628','儿科','','','停诊','2019-04-25 00:00:00','2019-04-25 08:39:56',0),('10.98.247.55','蒋秀君','1083','儿童保健','','553','张家榕','2019-04-25 00:00:00','2019-04-25 10:29:54',0),('10.98.236.240','计毅仙','823','妇保科','','3','赵玲玲','2019-04-25 00:00:01','2019-04-25 09:30:23',0);

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`CRON_EXPRESSION`,`TIME_ZONE_ID`) values ('HDWDubboScheduler','TASK_2ee2fb6c1b37459bcd031615a7be2c10','DEFAULT','0/1 * * * * ?','Asia/Shanghai'),('HDWDubboScheduler','TASK_79db017f209d3806cca3a4b7d6f0ff5a','DEFAULT','0 0 0 * * ?','Asia/Shanghai'),('HDWDubboScheduler','TASK_833a39d41131784603441a13e9ce5a87','DEFAULT','0/1 * * * * ? ','Asia/Shanghai'),('HDWDubboScheduler','TASK_ab894f32c09899c2cc2178bbdfa375d5','DEFAULT','0 0 0 * * ?','Asia/Shanghai'),('HDWDubboScheduler','TASK_c67ac3b4cd5d1123f4eec41c93eb0b84','DEFAULT','0/1 * * * * ? ','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`) USING BTREE,
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

insert  into `qrtz_fired_triggers`(`SCHED_NAME`,`ENTRY_ID`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`INSTANCE_NAME`,`FIRED_TIME`,`SCHED_TIME`,`PRIORITY`,`STATE`,`JOB_NAME`,`JOB_GROUP`,`IS_NONCONCURRENT`,`REQUESTS_RECOVERY`) values ('HDWDubboScheduler','WIN-1E3KUD3IUCN15561693646021556169372326','TASK_2ee2fb6c1b37459bcd031615a7be2c10','DEFAULT','WIN-1E3KUD3IUCN1556169364602',1556171302133,1556171303000,5,'ACQUIRED',NULL,NULL,'0','0');

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`,`DESCRIPTION`,`JOB_CLASS_NAME`,`IS_DURABLE`,`IS_NONCONCURRENT`,`IS_UPDATE_DATA`,`REQUESTS_RECOVERY`,`JOB_DATA`) values ('HDWDubboScheduler','TASK_2ee2fb6c1b37459bcd031615a7be2c10','DEFAULT',NULL,'com.annaru.upms.handle.job.utils.ScheduleJobExecutor','0','1','0','0','??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0i?fXxt\0\r0/1 * * * * ?t\0 2ee2fb6c1b37459bcd031615a7be2c10t\0\rsendBigScreent\0\0t\0\'把小屏的叫号消息推送到大屏sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_79db017f209d3806cca3a4b7d6f0ff5a','DEFAULT',NULL,'com.annaru.upms.handle.job.utils.ScheduleJobExecutor','0','1','0','0','??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0i?UPxt\00 0 0 * * ?t\0 79db017f209d3806cca3a4b7d6f0ff5at\0\nclearEmptyt\0\0t\0!清除数据库当天叫号数据sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_833a39d41131784603441a13e9ce5a87','DEFAULT',NULL,'com.annaru.upms.handle.job.utils.ScheduleJobExecutor','0','1','0','0','??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0iכ58xt\00/1 * * * * ? t\0 833a39d41131784603441a13e9ce5a87t\0sendSmallScreent\0\0t\0推消息到客户端sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_ab894f32c09899c2cc2178bbdfa375d5','DEFAULT',NULL,'com.annaru.upms.handle.job.utils.ScheduleJobExecutor','0','1','0','0','??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0jR?t\00 0 0 * * ?t\0 ab894f32c09899c2cc2178bbdfa375d5t\0clearScheduleJobLogt\0\0t\0*清空数据库定时任务的所有日志sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_c67ac3b4cd5d1123f4eec41c93eb0b84','DEFAULT',NULL,'com.annaru.upms.handle.job.utils.ScheduleJobExecutor','0','1','0','0','??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0iט^?xt\00/1 * * * * ? t\0 c67ac3b4cd5d1123f4eec41c93eb0b84t\0\rcheckUpdateDbt\0\0t\0\"检查主从数据库 进行比较sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`SCHED_NAME`,`LOCK_NAME`) values ('HDWDubboScheduler','STATE_ACCESS'),('HDWDubboScheduler','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`SCHED_NAME`,`INSTANCE_NAME`,`LAST_CHECKIN_TIME`,`CHECKIN_INTERVAL`) values ('HDWDubboScheduler','WIN-1E3KUD3IUCN1556169364602',1556171293433,15000);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`) USING BTREE,
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`JOB_NAME`,`JOB_GROUP`,`DESCRIPTION`,`NEXT_FIRE_TIME`,`PREV_FIRE_TIME`,`PRIORITY`,`TRIGGER_STATE`,`TRIGGER_TYPE`,`START_TIME`,`END_TIME`,`CALENDAR_NAME`,`MISFIRE_INSTR`,`JOB_DATA`) values ('HDWDubboScheduler','TASK_2ee2fb6c1b37459bcd031615a7be2c10','DEFAULT','TASK_2ee2fb6c1b37459bcd031615a7be2c10','DEFAULT',NULL,1556171303000,1556171302000,5,'ACQUIRED','CRON',1555394443000,0,NULL,2,'??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTaskpt\0\r0/1 * * * * ?t\0 2ee2fb6c1b37459bcd031615a7be2c10t\0\rsendBigScreent\0\0t\0!推消息到客户端（大屏）sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_79db017f209d3806cca3a4b7d6f0ff5a','DEFAULT','TASK_79db017f209d3806cca3a4b7d6f0ff5a','DEFAULT',NULL,1556208000000,-1,5,'WAITING','CRON',1555394443000,0,NULL,2,'??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0i?UPxt\00 0 0 * * ?t\0 79db017f209d3806cca3a4b7d6f0ff5at\0\nclearEmptyt\0\0t\0!清除数据库当天叫号数据sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_833a39d41131784603441a13e9ce5a87','DEFAULT','TASK_833a39d41131784603441a13e9ce5a87','DEFAULT',NULL,1556171303000,1556171302000,5,'WAITING','CRON',1555394443000,0,NULL,2,'??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTaskpt\00/1 * * * * ? t\0 833a39d41131784603441a13e9ce5a87t\0sendSmallScreent\0\0t\0!推消息到客户端（小屏）sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_ab894f32c09899c2cc2178bbdfa375d5','DEFAULT','TASK_ab894f32c09899c2cc2178bbdfa375d5','DEFAULT',NULL,1556208000000,-1,5,'PAUSED','CRON',1556169733000,0,NULL,2,'??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTaskpt\00 0 0 * * ?t\0 ab894f32c09899c2cc2178bbdfa375d5t\0clearScheduleJobLogt\0\0t\0*清空数据库定时任务的所有日志sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0'),('HDWDubboScheduler','TASK_c67ac3b4cd5d1123f4eec41c93eb0b84','DEFAULT','TASK_c67ac3b4cd5d1123f4eec41c93eb0b84','DEFAULT',NULL,1556171303000,1556171302000,5,'WAITING','CRON',1555394443000,0,NULL,2,'??0sr\0org.quartz.JobDataMap???迩??\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap????(\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap??(v\n?\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap??`?\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"com.annaru.upms.entity.ScheduleJob\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdq\0~\0	L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0callTasksr\0java.util.Datehj?KYt\0\0xpw\0\0iט^?xt\00/1 * * * * ? t\0 c67ac3b4cd5d1123f4eec41c93eb0b84t\0\rcheckUpdateDbt\0\0t\0\"检查主从数据库 进行比较sr\0java.lang.Integer⠤???8\0I\0valuexr\0java.lang.Number?????\0\0xp\0\0\0\0x\0');

/*Table structure for table `t_schedule_job` */

DROP TABLE IF EXISTS `t_schedule_job`;

CREATE TABLE `t_schedule_job` (
  `job_id` varchar(32) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';

/*Data for the table `t_schedule_job` */

insert  into `t_schedule_job`(`job_id`,`bean_name`,`method_name`,`params`,`cron_expression`,`status`,`remark`,`create_time`) values ('2ee2fb6c1b37459bcd031615a7be2c10','callTask','sendBigScreen','','0/1 * * * * ?',0,'推消息到客户端（大屏）','2019-04-03 16:20:55'),('79db017f209d3806cca3a4b7d6f0ff5a','callTask','clearEmpty','','0 0 0 * * ?',0,'清除数据库当天叫号数据','2019-04-02 17:46:26'),('833a39d41131784603441a13e9ce5a87','callTask','sendSmallScreen','','0/1 * * * * ? ',0,'推消息到客户端（小屏）','2019-04-01 14:34:27'),('ab894f32c09899c2cc2178bbdfa375d5','callTask','clearScheduleJobLog','','0 0 0 * * ?',1,'清空数据库定时任务的所有日志','2019-04-25 13:22:13'),('c67ac3b4cd5d1123f4eec41c93eb0b84','callTask','checkUpdateDb','','0/1 * * * * ? ',0,'检查主从数据库 进行比较','2019-04-01 14:31:21');

/*Table structure for table `t_schedule_job_log` */

DROP TABLE IF EXISTS `t_schedule_job_log`;

CREATE TABLE `t_schedule_job_log` (
  `log_id` varchar(32) NOT NULL COMMENT '任务日志id',
  `job_id` varchar(32) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

/*Data for the table `t_schedule_job_log` */

/*Table structure for table `t_sys_dic` */

DROP TABLE IF EXISTS `t_sys_dic`;

CREATE TABLE `t_sys_dic` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `parent_id` varchar(32) NOT NULL COMMENT '父变量ID',
  `var_code` varchar(255) DEFAULT NULL COMMENT '变量代码',
  `var_name` varchar(255) DEFAULT NULL COMMENT '变量名称',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '记录修改时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '记录创建者（用户）',
  `update_user` varchar(255) DEFAULT NULL COMMENT '记录最后修改者（用户）',
  `is_sync` tinyint(4) DEFAULT NULL COMMENT '数据是否同步(0:是,1:否)',
  PRIMARY KEY (`id`),
  KEY `index_dic_code` (`var_code`) USING BTREE,
  KEY `index_dic_name` (`var_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';

/*Data for the table `t_sys_dic` */

insert  into `t_sys_dic`(`id`,`parent_id`,`var_code`,`var_name`,`create_time`,`update_time`,`create_user`,`update_user`,`is_sync`) values ('103','9','2018103','油气运输管道','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('104','9','2018104','校园(含校车)','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('105','9','2018105','医疗卫生','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('106','9','2018106','文体广电','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('107','9','2018107','旅游','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('108','9','2018108','商贸(含成品油)','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('109','9','2018109','国土(含地质灾害)','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('110','9','2018110','老旧危房(含社区物业)','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('111','9','2018111','水利','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('112','9','2018112','快递邮递','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('113','9','2018113','民政、社会福利事业','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('114','9','2018114','渔业','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('16','0','20184049','区域','2018-05-07 20:28:52','2018-05-07 20:28:54','admin','admin',NULL),('201','86','0101','生产使用','2018-05-09 10:46:32','2018-05-09 10:46:32','admin','admin',NULL),('203','86','0102','经营存储','2018-05-09 10:47:20','2018-05-09 10:47:20','admin','admin',NULL),('205','86','0103','烟花爆竹','2018-05-09 10:48:01','2018-05-09 10:48:01','admin','admin',NULL),('207','86','0104','油库储存','2018-05-09 10:48:25','2018-05-09 10:48:25','admin','admin',NULL),('209','85','0201','露天矿山','2018-05-09 10:48:51','2018-05-09 10:48:51','admin','admin',NULL),('211','85','0202','地下矿山','2018-05-09 10:49:27','2018-05-09 10:49:27','admin','admin',NULL),('212','90','0301','大型游乐','2018-05-09 16:16:07','2018-05-09 16:16:10',NULL,NULL,NULL),('213','90','0302','专用车辆','2018-05-09 16:16:38','2018-05-09 16:16:41',NULL,NULL,NULL),('214','90','0303','电梯','2018-05-09 16:17:01','2018-05-09 16:17:03',NULL,NULL,NULL),('215','90','0304','工业管道','2018-05-09 16:17:26','2018-05-09 16:17:28',NULL,NULL,NULL),('216','90','0305','锅炉','2018-05-09 16:17:53','2018-05-09 16:17:55',NULL,NULL,NULL),('217','90','0306','客运索道','2018-05-09 16:18:23','2018-05-09 16:18:25',NULL,NULL,NULL),('218','90','0307','起重机械','2018-05-09 16:18:53','2018-05-09 16:18:55',NULL,NULL,NULL),('219','90','0308','气瓶充装站','2018-05-09 16:19:23','2018-05-09 16:19:25',NULL,NULL,NULL),('220','90','0309','压力容器','2018-05-09 16:19:45','2018-05-09 16:19:48',NULL,NULL,NULL),('59','16','2018059','鄂城区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('60','16','2018060','华容区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('61','16','2018061','梁子湖区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('62','16','2018062','葛店经济开发区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('63','16','2018063','鄂州经济开发区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('64','16','2018064','凤凰街办','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('65','16','2018065','古楼街办','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('66','16','2018066','西山街办','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('67','16','2018067','梧桐湖新区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('68','16','2018068','三江港新区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('69','16','2018069','红莲湖新区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('70','16','2018070','花湖经济开发区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('71','16','2018071','鄂城新区','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('85','9','2018085','非煤矿山','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('86','9','2018086','石油化工、烟花爆竹','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('87','9','2018087','民爆物品','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('88','9','2018088','城乡建设管理','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('89','9','2018089','综合交通运输','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('9','0','2017052','行业','2018-05-07 20:27:53','2018-06-14 19:19:12','admin','admin',NULL),('90','9','2018090','特种设备','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('91','9','2018091','消防安全','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL),('92','9','2018092','工业(含四大行业)','2018-05-07 10:10:10','2018-05-07 10:10:10','admin','admin',NULL);

/*Table structure for table `t_sys_log` */

DROP TABLE IF EXISTS `t_sys_log`;

CREATE TABLE `t_sys_log` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `type` tinyint(4) DEFAULT NULL COMMENT '日志类型（0:系统日志，1：操作日志）',
  `operation` varchar(255) DEFAULT NULL COMMENT '用户操作',
  `class_name` varchar(1024) DEFAULT NULL COMMENT '类名',
  `method` varchar(1024) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(1024) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(19) DEFAULT NULL COMMENT '执行时长',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志表';

/*Data for the table `t_sys_log` */

/*Table structure for table `t_sys_resource` */

DROP TABLE IF EXISTS `t_sys_resource`;

CREATE TABLE `t_sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(19) DEFAULT NULL COMMENT '父级资源ID',
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `description` varchar(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` varchar(32) DEFAULT NULL COMMENT '资源图标',
  `seq` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `resource_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '资源类别(0：菜单，1：按钮)',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态(0：开，1：关）',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后修改时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '记录创建用户',
  `update_user` varchar(255) DEFAULT NULL COMMENT '记录最后修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `t_sys_resource` */

insert  into `t_sys_resource`(`id`,`parent_id`,`name`,`url`,`description`,`icon`,`seq`,`resource_type`,`status`,`create_time`,`update_time`,`create_user`,`update_user`) values (1,0,'系统配置','','系统管理','config',2,0,0,'2018-12-17 15:23:40','2018-12-17 15:23:40',NULL,'admin'),(11,1,'资源管理','sys/menu','资源管理','menu',3,1,0,'2018-12-17 19:11:42','2018-12-17 19:11:43',NULL,'admin'),(12,1,'角色管理','sys/role','角色管理','role',2,1,0,'2018-12-17 19:11:24','2018-12-17 19:11:25',NULL,'admin'),(13,1,'用户管理','sys/user','用户管理','admin',1,1,0,'2018-12-17 19:11:13','2018-12-17 19:11:14',NULL,'admin'),(111,11,'列表','sys/menu/list','资源列表','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(112,11,'添加','sys/menu/save','资源添加','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(113,11,'编辑','sys/menu/update','资源编辑','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(114,11,'删除','sys/menu/delete','资源删除','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(115,11,'选择','sys/menu/select','菜单选择',NULL,4,2,0,'2018-12-14 16:44:29','2018-12-14 16:44:32',NULL,NULL),(116,11,'信息','sys/menu/info','菜单信息',NULL,5,2,0,'2018-12-14 16:45:04','2018-12-14 16:45:06',NULL,NULL),(121,12,'列表','sys/role/list','角色列表','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(122,12,'添加','sys/role/save','角色添加','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(123,12,'编辑','sys/role/update','角色编辑','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(124,12,'删除','sys/role/delete','角色删除','',0,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(125,12,'选择','sys/role/select','角色选择',NULL,5,2,0,'2018-12-14 13:52:39','2018-12-14 13:52:42',NULL,NULL),(126,12,'信息','sys/role/info','角色信息',NULL,6,2,0,'2018-12-14 14:32:15','2018-12-14 14:32:15',NULL,NULL),(131,13,'列表','sys/user/list','用户列表','',1,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(132,13,'添加','sys/user/save','用户添加','',2,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(133,13,'编辑','sys/user/update','用户编辑','',3,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(134,13,'删除','sys/user/delete','用户删除','',4,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(135,13,'信息','sys/user/info','用户信息',NULL,5,2,0,'2018-12-14 14:05:39','2018-12-14 14:05:41',NULL,NULL),(227,1,'操作日志','sys/log','操作日志','log',29,1,0,'2018-12-15 19:36:23','2018-12-15 19:36:23',NULL,'admin'),(228,1,'Druid监控','http://localhost:8281/druid','Druid监控','sql',30,1,0,'2019-01-18 16:23:10','2019-01-18 16:23:11',NULL,'admin'),(234,1,'字典管理','sys/dic','字典管理','menu',4,1,0,'2018-12-17 19:12:03','2018-12-17 19:12:04',NULL,'admin'),(235,234,'数据字典列表','sys/dic/list','数据字典列表','',0,2,0,'2018-12-13 19:37:23','2018-12-13 19:37:23',NULL,NULL),(236,234,'添加','sys/dic/save','数据字典添加','',1,2,0,'2018-12-13 19:37:03','2018-12-13 19:37:03',NULL,NULL),(237,234,'编辑','sys/dic/update','数据字典编辑','',2,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(238,234,'删除','sys/dic/delete','数据字典删除','',3,2,0,'2018-12-13 19:32:40','2018-12-13 19:32:40',NULL,NULL),(239,1,'定时任务','sys/schedule',NULL,'job',5,1,0,'2018-12-15 19:10:38',NULL,'admin',NULL),(240,239,'列表','sys/schedule/list',NULL,'',1,2,0,'2018-12-15 19:15:10',NULL,'admin',NULL),(241,239,'添加','sys/schedule/save',NULL,'',2,2,0,'2018-12-15 19:16:20',NULL,'admin',NULL),(242,239,'编辑','sys/schedule/update','定时任务编辑','',3,2,0,'2018-12-15 19:22:18',NULL,'admin',NULL),(243,239,'删除','sys/schedule/delete','定时任务删除','',4,2,0,'2018-12-15 19:23:09',NULL,'admin',NULL),(244,239,'信息','sys/schedule/info','定时任务信息','',5,2,0,'2018-12-15 19:23:33',NULL,'admin',NULL),(245,239,'暂停','sys/schedule/pause','定时任务暂停','',6,2,0,'2018-12-15 19:25:39',NULL,'admin',NULL),(246,239,'恢复','sys/schedule/resume','定时任务恢复','',7,2,0,'2018-12-15 19:26:19',NULL,'admin',NULL),(247,239,'立即执行','sys/schedule/run','定时任务立即执行','',8,2,0,'2018-12-15 19:27:46',NULL,'admin',NULL),(248,239,'日志','sys/schedule/log','定时任务日志','',9,2,0,'2018-12-15 19:28:40',NULL,'admin',NULL),(268,1,'API接口','http://localhost:8281/swagger-ui.html','API接口','config',31,1,0,'2019-01-18 16:24:28',NULL,'admin',NULL),(269,0,'叫号管理','','吴泾叫号管理','tixing',5,0,0,'2019-04-02 17:42:04','2019-04-02 17:42:08','admin','admin'),(270,269,'叫号大屏ip配置','lcd/lcdBigConfig',NULL,'config',0,1,0,'2019-04-22 14:11:16','2019-04-22 14:11:17',NULL,'admin'),(271,270,'列表','lcdBigConfig/list',NULL,'',1,2,0,'2019-04-02 17:56:50','2019-04-02 17:56:50',NULL,NULL),(272,270,'新增','lcdBigConfig/save',NULL,'',2,2,0,'2019-04-02 17:56:53','2019-04-02 17:56:53',NULL,NULL),(273,270,'修改','lcdBigConfig/update',NULL,'',3,2,0,'2019-04-02 17:56:56','2019-04-02 17:56:56',NULL,NULL),(274,270,'删除','lcdBigConfig/delete',NULL,'',4,2,0,'2019-04-02 17:56:59','2019-04-02 17:56:59',NULL,NULL),(275,270,'信息','lcdBigConfig/info',NULL,'',5,2,0,'2019-04-02 17:57:02','2019-04-02 17:57:02',NULL,NULL),(276,270,'选择','lcdBigConfig/select',NULL,'',6,2,0,'2019-04-02 17:57:10','2019-04-02 17:57:10',NULL,NULL),(277,0,'医生管理','','医生信息管理','pinglun',10,0,0,'2019-04-08 20:53:55',NULL,'admin',NULL),(278,277,'医生信息','lcd/doctorInfo',NULL,'config',6,1,0,'2019-04-08 20:58:24','2019-04-08 20:58:27',NULL,'admin'),(279,278,'列表','doctorInfo/list',NULL,'',1,2,0,NULL,NULL,NULL,NULL),(280,278,'新增','doctorInfo/save',NULL,'',2,2,0,NULL,NULL,NULL,NULL),(281,278,'修改','doctorInfo/update',NULL,'',3,2,0,NULL,NULL,NULL,NULL),(282,278,'删除','doctorInfo/delete',NULL,'',4,2,0,NULL,NULL,NULL,NULL),(283,278,'信息','doctorInfo/info',NULL,'',5,2,0,NULL,NULL,NULL,NULL),(284,278,'选择','doctorInfo/select',NULL,'',6,2,0,NULL,NULL,NULL,NULL),(285,269,'小屏连接','lcd/lcdSmallConnection','小屏当前连接设备信息','pinglun',5,1,0,'2019-04-12 10:55:31',NULL,'admin',NULL),(286,269,'大屏连接','lcd/lcdBigConnection','大屏当前连接设备信息','pinglun',10,1,0,'2019-04-12 10:56:24',NULL,'admin',NULL),(287,285,'列表','lcdShow/lcdSmallList','小屏列表','',1,2,0,'2019-04-12 11:02:01','2019-04-12 11:02:02','admin','admin'),(288,286,'列表','lcdShow/lcdBigList','大屏列表','',1,2,0,'2019-04-12 11:02:18','2019-04-12 11:02:19','admin','admin'),(290,269,' 连接日志','lcd/lcdLog','连接日志','bianji',15,1,0,'2019-04-22 14:11:03','2019-04-22 14:14:59',NULL,NULL),(291,290,'列表','lcdLog/list',NULL,'',1,2,0,NULL,NULL,NULL,NULL),(292,290,'新增','lcdLog/save',NULL,'',2,2,0,NULL,NULL,NULL,NULL),(293,290,'修改','lcdLog/update',NULL,'',3,2,0,NULL,NULL,NULL,NULL),(294,290,'删除','lcdLog/delete',NULL,'',4,2,0,NULL,NULL,NULL,NULL),(295,290,'信息','lcdLog/info',NULL,'',5,2,0,NULL,NULL,NULL,NULL),(296,290,'选择','lcdLog/select',NULL,'',6,2,0,NULL,NULL,NULL,NULL);

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态(0：开启，1：关闭)',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后修改时间',
  `create_user_id` bigint(19) DEFAULT NULL COMMENT '记录创建者ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`id`,`name`,`seq`,`description`,`status`,`create_time`,`update_time`,`create_user_id`) values ('1','admin',1,'超级管理员',0,'2019-04-08 20:55:49','2019-04-08 20:55:52',1),('2','应用管理员',2,'应用管理员',0,'2018-12-19 16:27:34','2018-12-19 16:27:35',1),('3','安全管理',3,'安全管理',0,'2018-12-19 20:20:44','2018-12-19 20:20:45',1),('4','安全专业人员',4,'安全专业人员',0,'2018-12-14 14:58:20','2018-12-14 14:58:20',1),('5','安检岗位',5,'安检岗位',0,'2018-12-14 14:58:22','2018-12-14 14:58:22',1);

/*Table structure for table `t_sys_role_resource` */

DROP TABLE IF EXISTS `t_sys_role_resource`;

CREATE TABLE `t_sys_role_resource` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `resource_id` bigint(19) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`),
  KEY `idx_role_resource_ids` (`role_id`,`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `t_sys_role_resource` */

insert  into `t_sys_role_resource`(`id`,`role_id`,`resource_id`) values ('93f89e033cfd3b6995f1f46319d610ab','1',1),('a1cde5d8f1f76253c835c6f5c5d14e0b','1',11),('6e4db8a72b6b138f5857aaf7248d4738','1',12),('7fc4e7002e6a07ef51954f16160f2670','1',13),('3e0f32a98d7dd305f37713cf4d0a6be7','1',111),('fba84feb1f9ebf830457498f39a1a49d','1',112),('a954e8d732c55f36a87e0a5163dd7531','1',113),('4c31edd2bf728071d309de3957f9af14','1',114),('20e66d4bd044c9b5ff8c5d00f4b9eb64','1',115),('bcd690d86d780404c7b306263dd544bb','1',116),('9ae0e2960022f7a5531e5ce362662154','1',121),('4ba62ab12508f5928fb8a2146f0041da','1',122),('2116f44cfe2ab35a306408e985915ede','1',123),('161a2a8c09e5ce55ec220b7b23fd6438','1',124),('e186f1454825d136244880b98de3b04c','1',125),('13f42182750719f09992948917499f0a','1',126),('3c2d857cee36d6c1a301f9f14ec250bf','1',131),('367c28af4fd317a596e10d8756f0b5cb','1',132),('4d943f336f006d889f93305960e90251','1',133),('4b82c4df787ad04d1170e2807aff33e6','1',134),('3d974edffd0cb0ecba2e3f0c6f81c27b','1',135),('79da29fc405a8c38d1966f7c6f0ff603','1',227),('d585e124480a0f6f97a3eef9d2ada6d5','1',228),('13f389821c414ca2807960ad27aba905','1',234),('8e7dddb46f5b386c25d1d81d875c6bfc','1',235),('8da603fc873c80c4310cd782c3f816b2','1',236),('d72add7b8abde78d117802ce4c374b19','1',237),('1b6e82579879ca07401659c28e1024d8','1',238),('bac52cc8a8f80b0919360caec82f654b','1',239),('98d3ddf40b1d10a18859aa7d28c9c7d3','1',240),('cdd0c2598857b05cf81462bdd06120d5','1',241),('2320e897b09cb68d7ff15b303ce9cac4','1',242),('b26d6593e3a5bf39cbb9df0627ca7d16','1',243),('7ede24c96fe2cd88704a39e5148d8ec4','1',244),('cbfb52184fcf08ee8ef897b16babe9e6','1',245),('99fc65c3ea315d9fe7d7627fbe46f445','1',246),('bcb5ff1eed8bac25ee7b6d51fb409eb0','1',247),('ba8382ac6064457e7d1caa644a2fa89e','1',248),('7fded83481850ddfc6551ba8a698488d','1',268),('e797829257ef812bfb7c9d25d013abcd','1',269),('1a0b2cbd5a5bace7ef18c3d060d83a7b','1',270),('1a26a2d1d62a63e7f760feae8999ec8a','1',271),('ebfda07cf788513bc73041c7b1853faf','1',272),('6db907a21e01a55a085cb7472d417573','1',273),('0809d799e0054bc88ecb9610d6cb3a19','1',274),('c1f8b0e30f822c2e2dbcd757a8756839','1',275),('9c1bf115c4cf71c143957d378712bd73','1',276),('621b7100f2ba583725e2200a3e63756b','1',277),('0b4a9b0fa7626f001de02c2fa5703c96','1',278),('9c937ce751da910d70d1f0195b1f9d28','1',279),('9f2fb3dc50840f99de0111d0df9fcf2b','1',280),('b1305723ed2d6113a282b75701d2676c','1',281),('35963db2b856a53d286b252a19b1bf1f','1',282),('4df4f9769d5dad576dda171b7357eb6d','1',283),('5829e5554befe92096982b5fb3642087','1',284),('88803','2',11),('88796','2',12),('88790','2',13),('88804','2',111),('88805','2',112),('88806','2',113),('88807','2',114),('88808','2',115),('88809','2',116),('88797','2',121),('88798','2',122),('88799','2',123),('88800','2',124),('88801','2',125),('88802','2',126),('88791','2',131),('88792','2',132),('88793','2',133),('88794','2',134),('88795','2',135),('88832','2',227),('88833','2',228),('88810','2',234),('88811','2',235),('88812','2',236),('88813','2',237),('88814','2',238),('88815','2',239),('88816','2',240),('88817','2',241),('88818','2',242),('88819','2',243),('88820','2',244),('88821','2',245),('88822','2',246),('88823','2',247),('88824','2',248),('88783','2',249),('88784','2',250),('88785','2',251),('88786','2',252),('88787','2',253),('88788','2',254),('88789','2',255),('88825','2',256),('88826','2',258),('88827','2',259),('88828','2',260),('88829','2',261),('88830','2',262),('88831','2',263),('89157','3',1),('89121','3',11),('89114','3',12),('89108','3',13),('89122','3',111),('89123','3',112),('89124','3',113),('89125','3',114),('89126','3',115),('89127','3',116),('89115','3',121),('89116','3',122),('89117','3',123),('89118','3',124),('89119','3',125),('89120','3',126),('89109','3',131),('89110','3',132),('89111','3',133),('89112','3',134),('89113','3',135),('89153','3',227),('89154','3',228),('89128','3',234),('89129','3',235),('89130','3',236),('89131','3',237),('89132','3',238),('89133','3',239),('89134','3',240),('89135','3',241),('89136','3',242),('89137','3',243),('89138','3',244),('89139','3',245),('89140','3',246),('89141','3',247),('89142','3',248),('89155','3',249),('89156','3',250),('89104','3',251),('89105','3',252),('89106','3',253),('89107','3',254),('89143','3',256),('89158','3',257),('89144','3',258),('89145','3',259),('89146','3',260),('89147','3',261),('89148','3',262),('89149','3',263),('89150','3',264),('89151','3',265),('89152','3',266);

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `login_name` varchar(64) NOT NULL COMMENT '登陆名',
  `name` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(36) DEFAULT NULL COMMENT '密码加密盐',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别(0:男，1：女)',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态(0：正常，1：不正常)',
  `expired` tinyint(4) DEFAULT '0' COMMENT '过期字段（0-不过期，1-过期）',
  `is_leader` tinyint(4) DEFAULT NULL COMMENT '是否领导（0-是，1-否）',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后修改时间',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '记录创建用户ID',
  PRIMARY KEY (`id`),
  KEY `index_user_login_name` (`login_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`id`,`login_name`,`name`,`password`,`salt`,`sex`,`phone`,`email`,`status`,`expired`,`is_leader`,`create_time`,`update_time`,`create_user_id`) values ('1','admin','admin','b2ccd2d71e04f7dd479d79c5fe886c8f','b4752b4b73034de06afb2db30fe19061',0,'18627026982','tuminglong@126.com',0,0,0,'2018-12-19 20:22:33','2018-12-19 21:27:49',NULL);

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `idx_user_role_ids` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `t_sys_user_role` */

insert  into `t_sys_user_role`(`id`,`user_id`,`role_id`) values ('249','1','1'),('372','100','9'),('1293','1000','25'),('1295','1002','25'),('1297','1004','25'),('1299','1006','25'),('1301','1008','25'),('2524','101','2'),('2523','101','9'),('1303','1010','25'),('1305','1012','25'),('1307','1014','25'),('1309','1016','25'),('1311','1018','25'),('1313','1020','25'),('1315','1022','25'),('1317','1024','25'),('1319','1026','25'),('1321','1028','25'),('376','103','9'),('1323','1030','25'),('1325','1032','25'),('1327','1034','25'),('1329','1036','25'),('1331','1038','25'),('1333','1040','25'),('1335','1042','25'),('1337','1044','25'),('1339','1046','25'),('1341','1048','25'),('2457','105','8'),('2459','105','9'),('1343','1050','25'),('1345','1052','22'),('1347','1054','23'),('1349','1056','22'),('1351','1058','22'),('1353','1060','22'),('1355','1062','23'),('1357','1064','23'),('1359','1066','23'),('1361','1068','23'),('1363','1070','23'),('1365','1072','23'),('1367','1074','23'),('1369','1076','23'),('1371','1078','23'),('1373','1080','23'),('1375','1082','23'),('1377','1084','23'),('1379','1086','23'),('1381','1088','22'),('1383','1090','25'),('1385','1092','25'),('1387','1094','25'),('1389','1096','25'),('1391','1098','25'),('1393','1100','25'),('1395','1102','25'),('1397','1104','23'),('1399','1106','23'),('1401','1108','25'),('1403','1110','25'),('1405','1112','25'),('1407','1114','25'),('1409','1116','25'),('1411','1118','25'),('1413','1120','25'),('1415','1122','25'),('1417','1124','23'),('1419','1126','25'),('1421','1128','25'),('1423','1130','25'),('1425','1132','25'),('1427','1134','25'),('1429','1136','25'),('1431','1138','25'),('403','114','8'),('1433','1140','25'),('1435','1142','25'),('1437','1144','23'),('1439','1146','25'),('1441','1148','25'),('1443','1150','25'),('1445','1152','25'),('1447','1154','25'),('1449','1156','25'),('1451','1158','25'),('1453','1160','25'),('1455','1162','25'),('1457','1164','25'),('1459','1166','25'),('1461','1168','25'),('1463','1170','25'),('1465','1172','25'),('1467','1174','25'),('1469','1176','25'),('1471','1178','25'),('411','118','22'),('1473','1180','25'),('1475','1182','25'),('1477','1184','25'),('1479','1186','25'),('1481','1188','25'),('1483','1190','25'),('1485','1192','25'),('1487','1194','25'),('1489','1196','25'),('1491','1198','25'),('2529','120','22'),('1493','1200','25'),('1495','1202','25'),('1497','1204','25'),('1499','1206','25'),('1501','1208','25'),('1503','1210','25'),('1505','1212','25'),('1507','1214','25'),('1509','1216','25'),('1511','1218','25'),('415','122','22'),('1513','1220','25'),('1515','1222','25'),('1517','1224','25'),('1519','1226','25'),('1521','1228','25'),('1523','1230','22'),('1525','1232','25'),('1527','1234','25'),('1529','1236','25'),('1531','1238','25'),('417','124','22'),('1533','1240','25'),('1535','1242','25'),('1537','1244','25'),('1539','1246','25'),('1541','1248','25'),('1543','1250','25'),('1545','1252','25'),('1547','1254','25'),('1549','1256','25'),('1551','1258','25'),('419','126','22'),('1553','1260','25'),('1555','1262','23'),('1557','1264','25'),('1559','1266','25'),('1561','1268','25'),('1563','1270','25'),('1565','1272','25'),('1567','1274','25'),('1569','1276','25'),('1571','1278','25'),('421','128','22'),('1573','1280','25'),('1575','1282','25'),('1577','1284','23'),('1579','1286','25'),('1581','1288','25'),('1583','1290','25'),('1585','1292','25'),('1587','1294','25'),('1589','1296','25'),('1591','1298','25'),('423','130','22'),('1593','1300','25'),('1595','1302','25'),('1597','1304','25'),('1599','1306','25'),('1601','1308','25'),('1603','1310','25'),('1605','1312','25'),('1607','1314','25'),('1609','1316','25'),('1611','1318','25'),('425','132','22'),('1613','1320','25'),('1615','1322','25'),('1617','1324','23'),('1619','1326','23'),('1621','1328','23'),('1623','1330','23'),('1625','1332','23'),('1627','1334','25'),('1629','1336','25'),('1631','1338','25'),('427','134','22'),('1633','1340','25'),('1635','1342','25'),('1637','1344','25'),('1639','1346','25'),('1641','1348','25'),('1643','1350','25'),('1645','1352','25'),('1647','1354','25'),('1649','1356','23'),('1651','1358','25'),('429','136','22'),('1653','1360','25'),('1655','1362','25'),('1657','1364','25'),('1659','1366','25'),('1661','1368','25'),('1663','1370','25'),('1665','1372','25'),('1667','1374','25'),('1669','1376','25'),('1671','1378','25'),('431','138','22'),('1673','1380','25'),('1675','1382','25'),('1677','1384','25'),('1679','1386','25'),('1681','1388','25'),('1683','1390','25'),('1685','1392','25'),('1687','1394','25'),('1689','1396','23'),('1691','1398','25'),('433','140','22'),('1693','1400','25'),('1695','1402','25'),('1697','1404','25'),('1699','1406','25'),('1701','1408','25'),('1703','1410','25'),('1705','1412','25'),('1707','1414','25'),('1709','1416','25'),('1711','1418','25'),('435','142','22'),('1713','1420','25'),('1715','1422','25'),('1717','1424','25'),('1719','1426','22'),('1721','1428','23'),('1723','1430','22'),('1725','1432','22'),('1727','1434','22'),('1729','1436','22'),('1731','1438','22'),('437','144','22'),('1733','1440','22'),('1735','1442','25'),('1737','1444','25'),('1739','1446','25'),('1741','1448','25'),('1743','1450','25'),('1745','1452','25'),('1747','1454','25'),('1749','1456','25'),('1751','1458','25'),('439','146','22'),('1753','1460','25'),('1755','1462','25'),('1757','1464','25'),('1759','1466','25'),('1761','1468','25'),('1763','1470','25'),('1765','1472','25'),('1767','1474','25'),('1769','1476','25'),('1771','1478','25'),('441','148','22'),('1773','1480','23'),('1775','1482','23'),('1777','1484','25'),('1779','1486','25'),('1781','1488','25'),('1783','1490','25'),('1785','1492','25'),('1787','1494','25'),('1789','1496','25'),('1791','1498','25'),('443','150','22'),('1793','1500','25'),('1795','1502','25'),('1797','1504','25'),('1799','1506','25'),('1801','1508','25'),('1803','1510','25'),('1805','1512','25'),('1807','1514','25'),('1809','1516','22'),('1811','1518','25'),('445','152','22'),('1813','1520','22'),('1815','1522','23'),('1817','1524','22'),('2460','1526','8'),('2461','1527','1'),('2519','1528','1'),('2463','1529','1'),('2465','1530','1'),('2467','1531','1'),('2469','1532','1'),('2471','1533','1'),('2473','1534','1'),('2475','1535','1'),('2477','1536','1'),('2479','1537','1'),('2481','1538','1'),('2483','1539','1'),('447','154','22'),('2485','1540','1'),('2487','1541','1'),('2489','1542','1'),('2491','1543','1'),('2493','1544','1'),('2495','1545','1'),('2497','1546','1'),('2499','1547','1'),('2501','1548','1'),('2503','1549','1'),('2505','1550','1'),('2507','1551','1'),('2509','1552','1'),('2511','1553','1'),('2513','1554','1'),('2515','1555','1'),('449','156','22'),('451','158','22'),('453','160','22'),('455','162','25'),('457','164','25'),('459','166','25'),('461','168','25'),('463','170','25'),('465','172','22'),('467','174','22'),('469','176','22'),('471','178','23'),('473','180','23'),('475','182','22'),('477','184','23'),('479','186','23'),('481','188','23'),('483','190','23'),('485','192','23'),('487','194','23'),('489','196','23'),('491','198','23'),('493','200','23'),('495','202','23'),('497','204','23'),('499','206','23'),('501','208','23'),('503','210','23'),('505','212','23'),('507','214','23'),('509','216','23'),('511','218','23'),('513','220','23'),('515','222','23'),('517','224','23'),('519','226','23'),('521','228','23'),('523','230','23'),('525','232','23'),('527','234','23'),('529','236','23'),('531','238','23'),('533','240','23'),('535','242','22'),('537','244','23'),('539','246','22'),('541','248','22'),('543','250','22'),('545','252','22'),('547','254','22'),('549','256','22'),('551','258','23'),('553','260','22'),('555','262','22'),('557','264','22'),('559','266','22'),('561','268','22'),('563','270','23'),('565','272','23'),('567','274','23'),('569','276','23'),('571','278','23'),('573','280','23'),('575','282','23'),('577','284','23'),('579','286','23'),('581','288','23'),('583','290','25'),('585','292','25'),('587','294','25'),('589','296','25'),('591','298','25'),('593','300','25'),('595','302','25'),('597','304','25'),('599','306','25'),('601','308','25'),('603','310','25'),('605','312','25'),('607','314','25'),('609','316','25'),('611','318','25'),('613','320','25'),('615','322','25'),('617','324','25'),('619','326','25'),('621','328','25'),('623','330','25'),('625','332','25'),('627','334','25'),('629','336','25'),('631','338','25'),('633','340','25'),('635','342','25'),('637','344','25'),('639','346','25'),('641','348','25'),('643','350','25'),('645','352','25'),('647','354','25'),('649','356','25'),('651','358','25'),('653','360','25'),('655','362','25'),('657','364','25'),('659','366','25'),('661','368','25'),('663','370','25'),('665','372','25'),('667','374','25'),('669','376','25'),('671','378','25'),('673','380','25'),('675','382','25'),('677','384','25'),('679','386','25'),('681','388','25'),('683','390','25'),('685','392','25'),('687','394','25'),('689','396','25'),('691','398','25'),('693','400','25'),('695','402','25'),('697','404','25'),('699','406','25'),('701','408','25'),('703','410','25'),('705','412','25'),('707','414','25'),('709','416','25'),('711','418','25'),('713','420','25'),('715','422','25'),('717','424','25'),('719','426','25'),('721','428','25'),('723','430','25'),('725','432','25'),('727','434','25'),('729','436','25'),('731','438','25'),('733','440','23'),('735','442','23'),('737','444','22'),('739','446','22'),('741','448','22'),('743','450','22'),('745','452','23'),('747','454','23'),('749','456','23'),('751','458','23'),('753','460','23'),('755','462','23'),('757','464','25'),('759','466','25'),('761','468','23'),('763','470','25'),('765','472','25'),('767','474','25'),('769','476','25'),('771','478','25'),('773','480','25'),('775','482','25'),('777','484','25'),('779','486','25'),('781','488','25'),('783','490','25'),('785','492','25'),('787','494','23'),('789','496','25'),('791','498','25'),('793','500','25'),('795','502','25'),('797','504','25'),('799','506','25'),('801','508','25'),('803','510','25'),('805','512','25'),('807','514','25'),('809','516','25'),('811','518','25'),('813','520','25'),('815','522','25'),('817','524','23'),('819','526','25'),('821','528','25'),('823','530','25'),('825','532','25'),('827','534','25'),('829','536','25'),('831','538','25'),('833','540','25'),('835','542','25'),('837','544','25'),('839','546','25'),('841','548','25'),('843','550','25'),('845','552','25'),('847','554','25'),('849','556','22'),('851','558','25'),('853','560','23'),('855','562','25'),('857','564','25'),('859','566','25'),('861','568','25'),('151','57','8'),('863','570','25'),('865','572','25'),('867','574','25'),('869','576','25'),('871','578','25'),('873','580','25'),('875','582','25'),('877','584','25'),('879','586','25'),('881','588','25'),('153','59','8'),('883','590','25'),('885','592','25'),('887','594','23'),('889','596','25'),('891','598','25'),('893','600','25'),('895','602','25'),('897','604','25'),('899','606','25'),('901','608','25'),('239','61','8'),('903','610','25'),('905','612','25'),('907','614','25'),('909','616','25'),('911','618','25'),('913','620','25'),('915','622','25'),('917','624','25'),('919','626','25'),('921','628','25'),('923','630','25'),('925','632','25'),('927','634','25'),('929','636','25'),('931','638','25'),('933','640','25'),('935','642','25'),('937','644','22'),('939','646','25'),('941','648','22'),('943','650','23'),('945','652','22'),('947','654','25'),('949','656','25'),('951','658','25'),('953','660','25'),('955','662','25'),('957','664','25'),('959','666','25'),('961','668','25'),('2527','67','2'),('2528','67','9'),('963','670','25'),('965','672','25'),('967','674','22'),('969','676','23'),('971','678','22'),('973','680','22'),('975','682','22'),('977','684','22'),('979','686','23'),('981','688','23'),('983','690','25'),('985','692','25'),('987','694','25'),('989','696','25'),('991','698','25'),('993','700','25'),('995','702','25'),('997','704','25'),('999','706','25'),('1001','708','25'),('221','71','1'),('1003','710','25'),('1005','712','23'),('1007','714','25'),('1009','716','25'),('1011','718','25'),('1013','720','25'),('1015','722','25'),('1017','724','25'),('1019','726','25'),('1021','728','23'),('217','73','1'),('1023','730','25'),('1025','732','25'),('1027','734','25'),('1029','736','25'),('1031','738','25'),('1033','740','23'),('1035','742','23'),('1037','744','25'),('1039','746','25'),('1041','748','25'),('1043','750','25'),('1045','752','25'),('1047','754','25'),('1049','756','25'),('1051','758','25'),('1053','760','25'),('1055','762','25'),('1057','764','25'),('1059','766','25'),('1061','768','25'),('1063','770','25'),('1065','772','25'),('1067','774','25'),('1069','776','25'),('1071','778','25'),('1073','780','25'),('1075','782','25'),('1077','784','25'),('1079','786','25'),('1081','788','25'),('1083','790','25'),('1085','792','25'),('1087','794','25'),('1089','796','23'),('1091','798','25'),('1093','800','25'),('1095','802','25'),('1097','804','25'),('1099','806','25'),('1101','808','25'),('256','81','1'),('1103','810','25'),('1105','812','25'),('1107','814','25'),('1109','816','23'),('1111','818','23'),('1113','820','23'),('1115','822','25'),('1117','824','22'),('1119','826','25'),('1121','828','25'),('1123','830','25'),('1125','832','25'),('1127','834','25'),('1129','836','25'),('1131','838','25'),('1133','840','25'),('1135','842','25'),('1137','844','25'),('1139','846','25'),('1141','848','23'),('1143','850','25'),('1145','852','25'),('1147','854','25'),('1149','856','25'),('1151','858','25'),('1153','860','25'),('1155','862','25'),('1157','864','25'),('1159','866','25'),('1161','868','25'),('1163','870','25'),('1165','872','25'),('1167','874','25'),('1169','876','25'),('1171','878','25'),('1173','880','25'),('1175','882','25'),('1177','884','25'),('1179','886','25'),('1181','888','25'),('399','89','9'),('1183','890','25'),('1185','892','25'),('1187','894','25'),('1189','896','25'),('1191','898','25'),('1193','900','25'),('1195','902','25'),('1197','904','25'),('1199','906','25'),('1201','908','25'),('1203','910','25'),('1205','912','25'),('1207','914','25'),('1209','916','25'),('1211','918','25'),('1213','920','25'),('1215','922','25'),('1217','924','25'),('1219','926','25'),('1221','928','25'),('1223','930','25'),('1225','932','25'),('1227','934','25'),('1229','936','25'),('1231','938','25'),('1233','940','25'),('1235','942','25'),('1237','944','25'),('1239','946','25'),('1241','948','25'),('1243','950','25'),('1245','952','25'),('1247','954','25'),('1249','956','25'),('1251','958','25'),('1253','960','25'),('1255','962','25'),('1257','964','25'),('1259','966','25'),('1261','968','25'),('1263','970','25'),('1265','972','25'),('1267','974','25'),('1269','976','25'),('1271','978','25'),('1273','980','25'),('1275','982','25'),('1277','984','25'),('1279','986','25'),('1281','988','25'),('400','99','9'),('1283','990','25'),('1285','992','25'),('1287','994','25'),('1289','996','25'),('1291','998','25');

/*Table structure for table `t_sys_user_token` */

DROP TABLE IF EXISTS `t_sys_user_token`;

CREATE TABLE `t_sys_user_token` (
  `user_id` varchar(32) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

/*Data for the table `t_sys_user_token` */

insert  into `t_sys_user_token`(`user_id`,`token`,`expire_time`,`update_time`) values ('1','429b7553d3bed573da60eb6211ad66ff','2019-04-25 13:48:40','2019-04-25 13:18:40');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
