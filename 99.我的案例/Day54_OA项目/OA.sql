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

/*Table structure for table `tb_dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) DEFAULT NULL,
  `remark` VARCHAR(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_dept` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createDate` DATE DEFAULT NULL,
  `loginName` VARCHAR(16) DEFAULT NULL,
  `password` VARCHAR(50) DEFAULT NULL,
  `status` INT(11) NOT NULL,
  `username` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

INSERT  INTO `user`(`id`,`createDate`,`loginName`,`password`,`status`,`username`) VALUES (1,'2017-10-09','admin','123',1,'admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/*Table structure for table `tb_advice` */

DROP TABLE IF EXISTS `advice`;

CREATE TABLE `advice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` TEXT,
  `createDate` DATETIME DEFAULT NULL,
  `title` VARCHAR(50) DEFAULT NULL,
  `uid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `advice_user_frk` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_advice` */

/*Table structure for table `tb_job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) DEFAULT NULL,
  `remark` VARCHAR(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_job` */

/*Table structure for table `tb_doc` */

DROP TABLE IF EXISTS `doc`;

CREATE TABLE `doc` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createDate` DATETIME DEFAULT NULL,
  `fileName` VARCHAR(100) DEFAULT NULL,
  `remark` TEXT,
  `title` VARCHAR(50) DEFAULT NULL,
  `uid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqotp8dpcld7dkdg84wnh0sbyn` (`uid`),
  CONSTRAINT `FKqotp8dpcld7dkdg84wnh0sbyn` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_doc` */

/*Table structure for table `tb_employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) DEFAULT NULL,
  `birthday` DATETIME DEFAULT NULL,
  `cardId` VARCHAR(100) DEFAULT NULL,
  `createDate` DATETIME DEFAULT NULL,
  `education` VARCHAR(10) DEFAULT NULL,
  `email` VARCHAR(30) DEFAULT NULL,
  `gender` INT(11) NOT NULL,
  `hobby` VARCHAR(50) DEFAULT NULL,
  `name` VARCHAR(50) DEFAULT NULL,
  `party` VARCHAR(10) DEFAULT NULL,
  `phone` VARCHAR(11) DEFAULT NULL,
  `qqNum` VARCHAR(12) DEFAULT NULL,
  `race` VARCHAR(20) DEFAULT NULL,
  `remark` VARCHAR(100) DEFAULT NULL,
  `speciality` VARCHAR(20) DEFAULT NULL,
  `did` INT(11) DEFAULT NULL,
  `jid` INT(11) DEFAULT NULL,
  `uid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20rb7xemki9d1uelw062oj32x` (`did`),
  KEY `FKqw823gjf4xdm6hnf69oe5ec7h` (`jid`),
  KEY `FKjqdy99v1y0j83xutkf7umtwwl` (`uid`),
  CONSTRAINT `FK20rb7xemki9d1uelw062oj32x` FOREIGN KEY (`did`) REFERENCES `dept` (`id`),
  CONSTRAINT `FKjqdy99v1y0j83xutkf7umtwwl` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqw823gjf4xdm6hnf69oe5ec7h` FOREIGN KEY (`jid`) REFERENCES `job` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_employee` */


/*Table structure for table `tb_sign` */

DROP TABLE IF EXISTS `sign`;

CREATE TABLE `sign` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `createTime` DATETIME DEFAULT NULL,
  `flag` INT(11) NOT NULL,
  `uid` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlll66hyar28qupsy32umn3bms` (`uid`),
  CONSTRAINT `FKlll66hyar28qupsy32umn3bms` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `tb_sign` */


