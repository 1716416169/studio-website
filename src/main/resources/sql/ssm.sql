CREATE DATABASE  IF NOT EXISTS `ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssm`;
-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ssm
-- ------------------------------------------------------
-- Server version	5.7.21-enterprise-commercial-advanced-log

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
-- Table structure for table `gm`
--

DROP TABLE IF EXISTS `gm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gm`
--

LOCK TABLES `gm` WRITE;
/*!40000 ALTER TABLE `gm` DISABLE KEYS */;
INSERT INTO `gm` VALUES (1,'root','123');
/*!40000 ALTER TABLE `gm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` longtext,
  `text` longtext,
  `k` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (11,'https://wjf-img-1257162022.cos.ap-beijing.myqcloud.com/img/3b60edaa-570d-4449-8b7b-d4333571b2d3.jpg','这是团队荣誉\n    ','/img/3b60edaa-570d-4449-8b7b-d4333571b2d3.jpg'),(12,'https://wjf-img-1257162022.cos.ap-beijing.myqcloud.com/img/cf180ef7-dea3-4d79-b7f7-5ee2d6fd6702.jpg','这是团队荣誉\n    ','/img/cf180ef7-dea3-4d79-b7f7-5ee2d6fd6702.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imgdynamic`
--

DROP TABLE IF EXISTS `imgdynamic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imgdynamic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` longtext,
  `text` longtext,
  `k` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imgdynamic`
--

LOCK TABLES `imgdynamic` WRITE;
/*!40000 ALTER TABLE `imgdynamic` DISABLE KEYS */;
INSERT INTO `imgdynamic` VALUES (7,'https://wjf-img-1257162022.cos.ap-beijing.myqcloud.com/img/4c8af855-96c5-4ec7-95ba-adc772775b92.jpg','这是动态','/img/4c8af855-96c5-4ec7-95ba-adc772775b92.jpg'),(8,'https://wjf-img-1257162022.cos.ap-beijing.myqcloud.com/img/09e15a1a-12c6-498c-b42b-0ef9aaa725a4.jpg','这是动态','/img/09e15a1a-12c6-498c-b42b-0ef9aaa725a4.jpg');
/*!40000 ALTER TABLE `imgdynamic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` bigint(110) NOT NULL AUTO_INCREMENT,
  `job` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `qq` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduce` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'java开发工程师','韦鉴峰','10086','110','119','崩崩崩真好玩'),(3,'前端开发工程师','林桢荣','10086','110','999','6666'),(4,'java开发工程师','陈兴柽','100','110','666','5555'),(5,'php工程师','沈帅','100','110','777','6666'),(6,'php工程师','梁琛峰','110','110','555','66666'),(12,'','','','','',''),(24,'','','','','',''),(25,'','','','','',''),(28,'','','','','','');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio_introduce`
--

DROP TABLE IF EXISTS `studio_introduce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio_introduce` (
  `id` int(11) NOT NULL,
  `text` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio_introduce`
--

LOCK TABLES `studio_introduce` WRITE;
/*!40000 ALTER TABLE `studio_introduce` DISABLE KEYS */;
INSERT INTO `studio_introduce` VALUES (1,'工作室介绍');
/*!40000 ALTER TABLE `studio_introduce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio_stu`
--

DROP TABLE IF EXISTS `studio_stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio_stu` (
  `id` int(11) NOT NULL,
  `text` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio_stu`
--

LOCK TABLES `studio_stu` WRITE;
/*!40000 ALTER TABLE `studio_stu` DISABLE KEYS */;
INSERT INTO `studio_stu` VALUES (1,'实习生招聘');
/*!40000 ALTER TABLE `studio_stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio_updir`
--

DROP TABLE IF EXISTS `studio_updir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio_updir` (
  `id` int(11) NOT NULL,
  `text` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio_updir`
--

LOCK TABLES `studio_updir` WRITE;
/*!40000 ALTER TABLE `studio_updir` DISABLE KEYS */;
INSERT INTO `studio_updir` VALUES (1,'研发方向');
/*!40000 ALTER TABLE `studio_updir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ssm'
--

--
-- Dumping routines for database 'ssm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18 22:05:08
