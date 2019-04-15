-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` varchar(50) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `img_url` varchar(160) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('00b56a13-a83b-424d-99e1-fc51705c6aa3','Java网络编程',90,30,'计算机','','3\\9\\9062293-1_w.jpg'),('216e2e06-ef78-4718-9d5e-ee57fe9a2f1b','JAVA编程思想',32,427,'计算机','','d\\6\\9186890-1_b.jpg'),('26efb023-f642-4ec2-827a-b51b7a14288d','java面向对象编程',15,140,'计算机','','9\\a\\20459091-1_b.jpg'),('363961e3-d7d6-4ab0-815d-bee8fea61baf','Java网络编程',50000000,99,'计算机','','3\\9\\9062293-1_w.jpg'),('4db54327-d912-40cd-ba6c-66c1712c36ea','java面向对象编程',98,58,'计算机','','d\\6\\9186890-1_b.jpg'),('54e6a09f-0bc1-4434-aef0-c67ba487eb91','EffectiveJava',66,40,'计算机','','9\\a\\20459091-1_b.jpg'),('56efa597-467d-4e95-b324-a17166adf744','java面试宝典',50,200,'计算机','																		好书\r\n						\r\n						\r\n						','d\\2\\23348683-1_w_1.jpg'),('72ee1462-3271-4c19-97c8-175a5ca81811','java编程',78,25,'计算机','入门级的','6\\1\\m.jpg'),('9d1e538c-d39f-4712-a12c-58692769fe48','JAVA编程思想',76,55,'计算机','','9\\f\\9317290-1_b.jpg'),('aeb15e04-38d9-4810-a72f-26525fade554','mqeq',11,11,'','11111',NULL),('b04841f6-3b61-4989-b687-a0db64cc533a','金牌月饼',5,100,'艺术','',NULL),('b7f62f61-9450-4304-866d-62dc16967394','超级好吃大月饼',20,100,'计算机','',NULL),('be5d9d9f-47ce-4b29-8d53-4c2176412838','百事可乐',77,30,'经营','呵呵','5\\6\\a.jpg'),('c2669606-3deb-4fd5-a58f-ea4f02b378cb','JAVA核心技术',50,50,'计算机','','e\\3\\20285763-1_w.jpg'),('cd5f2c59-53bd-488a-9a36-6b6b3fa455d1','武动乾坤',99,55,'','',NULL),('d11c7ea8-992c-4b75-9fa1-6fd9cc9d5ea4','m',2,222,'少儿','222222222222',NULL),('d130ac69-11dd-498d-b5c3-27c7469d4189','Java模式',79,20,'计算机','','d\\8\\696673-1_w.jpg'),('d2f59ad9-3c99-400d-9139-d560562fecda','mmmmm',0,0,NULL,NULL,NULL),('d55c3d7b-98f2-4463-aca5-05479c4c6a0c',NULL,0,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `activeCode` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `role` varchar(10) DEFAULT '普通用户',
  `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lisi','333','女','lisi@qq.com','13533338888','hehe','de810937-f52d-4c8f-9e01-3a429c46cea6',1,'普通用户','2016-10-12 01:58:51'),(2,'haha','111','男','m15210570036_1@163.com','13666668888','haha','2e95ab66-a796-4b01-a7d8-2b6821982966',1,'普通用户','2016-10-12 06:02:19'),(3,'kkk','111','男','m15210570036_1@163.com','13666668888','lksjdklfd','c536aeb2-2cb5-4d4d-8d6d-e0f35927b35a',1,'admin','2016-10-11 05:56:57'),(4,'wqe','wqe','男','wqe','','','62ecf798-1683-4e10-b926-503d3fc0a32d',0,'普通用户','2017-05-08 06:42:43'),(5,'令狐冲','123','男','78979@qq.com','','','7851070b-73c6-4ec4-8dde-f783897fb967',0,'普通用户','2017-05-08 07:25:47'),(6,'令狐冲','1231','男','123213@qq.com','','','74054b7b-b9e9-4c36-ad80-0e4ea4dbe0f1',0,'普通用户','2017-05-08 07:26:12'),(7,'令狐冲','111','男','123213@qq.com','12','12','a5be8a6e-2105-4eec-90e6-d510a0e94352',0,'普通用户','2017-05-08 07:26:43'),(8,'shangyalong','666666','男','m15210570036_1@163.com','13266669999','了斯柯达积分了','7acd7725-f8cf-4d01-971f-76a2d3f2a04d',0,'普通用户','2017-05-08 07:27:06'),(9,'时峰','111111','男','shifeng@126.com','','','ff9449aa-e67e-4082-8484-f767fb32ebc1',0,'普通用户','2017-05-08 07:29:03'),(10,'shangyalong','888888','女','m15210570036_1@163.com','222222','asdasdasdasdasd','2253f2e4-04b7-470c-9321-e54881c8ab08',1,'普通用户','2017-05-09 02:25:54');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` varchar(100) NOT NULL DEFAULT '',
  `money` double DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `paystate` int(11) DEFAULT NULL,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('00acc032-9225-4316-8e57-96a74dc85ba8',50000032,'北京','政治','66666666',0,'2016-10-12 05:55:11',1),('1dd62d7f-378e-41eb-91f2-dcddc960ca9d',47,'haha','hehe','111111',0,'2016-10-13 03:25:17',1),('1f678053-812c-469b-9f0e-5cfd237fb3a5',98,'sdfs','kkkkkk','6666666',0,'2017-05-10 03:25:22',10),('4befc322-7a43-44d9-94b5-7adc0d1b9cf6',47,'beijing','zhangsan','11111',0,'2016-10-13 05:31:32',1),('60140403-2a8f-4970-8ceb-e560e7ff1f67',390,'上海','小明','234',0,'2017-05-09 06:09:34',10),('6691b32a-88f9-4d11-aabd-5d0ee72905eb',47,'haha','hehe','111111',0,'2016-10-13 03:25:10',1),('69f5c8ff-212a-4b95-ba2d-5540e9e4b60b',312,'杭州','小红','777888',0,'2017-05-09 06:07:23',10),('7a61088a-ae6a-4468-9235-fb84d2feec5e',47,'天堂','神人','99999999',0,'2016-10-13 03:16:21',1),('dde53865-38d1-468f-9297-639804f7cd82',50000032,'xxx','xxx','xxx',0,'2016-10-13 03:22:03',1),('df891b7b-be59-4e12-aa2d-ce0a9347bef1',0,NULL,NULL,NULL,0,'2017-05-10 03:13:19',10),('ea166e1d-a9dc-4cf5-8e17-47b1e022b545',0,NULL,NULL,NULL,0,'2017-05-10 03:12:57',10),('ee8c8b6d-168e-4d9a-88ce-b457778f3bc4',200000045,'天丰利','马庆林','22222222',0,'2016-10-12 06:03:24',2),('f1e282d3-df3e-4108-94bb-c014126fd7ef',98,'sdfs','kkkkkk','6666666',0,'2017-05-10 03:23:20',10),('f6a9ce18-2fe0-400d-9a9d-c406fd1b1221',50000032,'sdfsdf','hehe','22222222222',0,'2016-10-13 03:23:24',1),('f88d46d6-65f8-4291-b685-c55e17c8ff2a',15,'天堂','大仙','120120120',0,'2017-05-10 03:10:40',10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `order_id` varchar(100) NOT NULL DEFAULT '',
  `book_id` varchar(100) NOT NULL DEFAULT '',
  `buynum` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`book_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES ('00acc032-9225-4316-8e57-96a74dc85ba8','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('00acc032-9225-4316-8e57-96a74dc85ba8','363961e3-d7d6-4ab0-815d-bee8fea61baf',1),('1dd62d7f-378e-41eb-91f2-dcddc960ca9d','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('1dd62d7f-378e-41eb-91f2-dcddc960ca9d','26efb023-f642-4ec2-827a-b51b7a14288d',1),('1f678053-812c-469b-9f0e-5cfd237fb3a5','4db54327-d912-40cd-ba6c-66c1712c36ea',1),('4befc322-7a43-44d9-94b5-7adc0d1b9cf6','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('4befc322-7a43-44d9-94b5-7adc0d1b9cf6','26efb023-f642-4ec2-827a-b51b7a14288d',1),('60140403-2a8f-4970-8ceb-e560e7ff1f67','72ee1462-3271-4c19-97c8-175a5ca81811',5),('6691b32a-88f9-4d11-aabd-5d0ee72905eb','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('6691b32a-88f9-4d11-aabd-5d0ee72905eb','26efb023-f642-4ec2-827a-b51b7a14288d',1),('69f5c8ff-212a-4b95-ba2d-5540e9e4b60b','72ee1462-3271-4c19-97c8-175a5ca81811',4),('7a61088a-ae6a-4468-9235-fb84d2feec5e','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('7a61088a-ae6a-4468-9235-fb84d2feec5e','26efb023-f642-4ec2-827a-b51b7a14288d',1),('dde53865-38d1-468f-9297-639804f7cd82','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('dde53865-38d1-468f-9297-639804f7cd82','363961e3-d7d6-4ab0-815d-bee8fea61baf',1),('df891b7b-be59-4e12-aa2d-ce0a9347bef1','26efb023-f642-4ec2-827a-b51b7a14288d',1),('ea166e1d-a9dc-4cf5-8e17-47b1e022b545','26efb023-f642-4ec2-827a-b51b7a14288d',1),('ee8c8b6d-168e-4d9a-88ce-b457778f3bc4','26efb023-f642-4ec2-827a-b51b7a14288d',3),('ee8c8b6d-168e-4d9a-88ce-b457778f3bc4','363961e3-d7d6-4ab0-815d-bee8fea61baf',4),('f1e282d3-df3e-4108-94bb-c014126fd7ef','4db54327-d912-40cd-ba6c-66c1712c36ea',1),('f6a9ce18-2fe0-400d-9a9d-c406fd1b1221','216e2e06-ef78-4718-9d5e-ee57fe9a2f1b',1),('f6a9ce18-2fe0-400d-9a9d-c406fd1b1221','363961e3-d7d6-4ab0-815d-bee8fea61baf',1),('f88d46d6-65f8-4291-b685-c55e17c8ff2a','26efb023-f642-4ec2-827a-b51b7a14288d',1);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

--
-- Table structure for table `user`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 17:20:41
