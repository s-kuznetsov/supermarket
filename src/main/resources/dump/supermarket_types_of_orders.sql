-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `types_of_orders`
--

DROP TABLE IF EXISTS `types_of_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types_of_orders` (
  `id_order_type` int(11) NOT NULL AUTO_INCREMENT,
  `order_type` varchar(45) NOT NULL,
  `cost` double NOT NULL,
  PRIMARY KEY (`id_order_type`),
  UNIQUE KEY `id_order_type_UNIQUE` (`id_order_type`),
  UNIQUE KEY `order_type_UNIQUE` (`order_type`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_of_orders`
--

LOCK TABLES `types_of_orders` WRITE;
/*!40000 ALTER TABLE `types_of_orders` DISABLE KEYS */;
INSERT INTO `types_of_orders` VALUES (1,'Хлеб',300),(2,'Творог',200),(3,'Тарелка',900),(4,'Сметана',400),(5,'Форель',500),(6,'Скумбрия',300),(7,'Колбаса \"Докторская\"',800),(8,'Вино',1300),(9,'Вода \"Сенежская\"',50),(10,'Чипсы \"Lays\"',100),(11,'Рис',200),(12,'Гречка',300),(13,'Мыло',300),(14,'Шампунь',900);
/*!40000 ALTER TABLE `types_of_orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
