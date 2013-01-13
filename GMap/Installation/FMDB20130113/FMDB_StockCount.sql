CREATE DATABASE  IF NOT EXISTS `fmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `FMDB`;
-- MySQL dump 10.13  Distrib 5.5.24, for osx10.5 (i386)
--
-- Host: 127.0.0.1    Database: FMDB
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `StockCount`
--

DROP TABLE IF EXISTS `StockCount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StockCount` (
  `Stock_Type_S_ID` smallint(6) NOT NULL,
  `Grazing_G_ID` int(11) NOT NULL,
  `SC_Count` char(10) NOT NULL,
  PRIMARY KEY (`Stock_Type_S_ID`,`Grazing_G_ID`),
  KEY `fk_StockCount_Grazing1` (`Grazing_G_ID`),
  KEY `fk_StockCount_Stock_Type1_idx` (`Stock_Type_S_ID`),
  CONSTRAINT `fk_StockCount_Grazing1` FOREIGN KEY (`Grazing_G_ID`) REFERENCES `Grazing` (`G_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_StockCount_Stock_Type1` FOREIGN KEY (`Stock_Type_S_ID`) REFERENCES `Stock_Type` (`S_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StockCount`
--

LOCK TABLES `StockCount` WRITE;
/*!40000 ALTER TABLE `StockCount` DISABLE KEYS */;
INSERT INTO `StockCount` VALUES (1,1,'111'),(2,1,'222'),(2,4,'444'),(3,1,'asds'),(4,1,'3123'),(5,3,'test'),(6,2,'sss'),(8,1,'sdsd');
/*!40000 ALTER TABLE `StockCount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-14  0:17:54
