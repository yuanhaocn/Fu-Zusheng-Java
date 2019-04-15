/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.18-log : Database - oa
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oa`;

/*Table structure for table `tb_advice` */

DROP TABLE IF EXISTS `tb_advice`;

CREATE TABLE `tb_advice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createDate` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_advice` */

/*Table structure for table `tb_dept` */

DROP TABLE IF EXISTS `tb_dept`;

CREATE TABLE `tb_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `remark` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_dept` */

/*Table structure for table `tb_doc` */

DROP TABLE IF EXISTS `tb_doc`;

CREATE TABLE `tb_doc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `remark` text,
  `title` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqotp8dpcld7dkdg84wnh0sbyn` (`uid`),
  CONSTRAINT `FKqotp8dpcld7dkdg84wnh0sbyn` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_doc` */

/*Table structure for table `tb_employee` */

DROP TABLE IF EXISTS `tb_employee`;

CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `cardId` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `gender` int(11) NOT NULL,
  `hobby` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `party` varchar(10) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `postCode` varchar(10) DEFAULT NULL,
  `qqNum` varchar(12) DEFAULT NULL,
  `race` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `speciality` varchar(20) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20rb7xemki9d1uelw062oj32x` (`did`),
  KEY `FKqw823gjf4xdm6hnf69oe5ec7h` (`jid`),
  KEY `FKjqdy99v1y0j83xutkf7umtwwl` (`uid`),
  CONSTRAINT `FK20rb7xemki9d1uelw062oj32x` FOREIGN KEY (`did`) REFERENCES `tb_dept` (`id`),
  CONSTRAINT `FKjqdy99v1y0j83xutkf7umtwwl` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `FKqw823gjf4xdm6hnf69oe5ec7h` FOREIGN KEY (`jid`) REFERENCES `tb_job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_employee` */

/*Table structure for table `tb_job` */

DROP TABLE IF EXISTS `tb_job`;

CREATE TABLE `tb_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `remanrk` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_job` */

/*Table structure for table `tb_sign` */

DROP TABLE IF EXISTS `tb_sign`;

CREATE TABLE `tb_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `flag` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlll66hyar28qupsy32umn3bms` (`uid`),
  CONSTRAINT `FKlll66hyar28qupsy32umn3bms` FOREIGN KEY (`uid`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_sign` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` date DEFAULT NULL,
  `loginame` varchar(16) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`createDate`,`loginame`,`password`,`status`,`username`) values (1,'2017-10-09','administrator','1234567',1,'administrator');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
