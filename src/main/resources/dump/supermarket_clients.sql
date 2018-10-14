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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(300) NOT NULL,
  `role` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client_UNIQUE` (`id_client`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Евгений','Данилкин','Викторович','89187445634','edanilkin','edanilkin','ROLE_USER','edanilkin@gmail.com'),(2,'Михаил','Макаров','NULL','89147654323','mmakarov','mmakarov','ROLE_USER','mmakarov@gmail.com'),(3,'Евгений','Смирнов','Васильевич','11111111113','esmirnov','esmirnov','ROLE_USER','esmirnov@gmail.com'),(4,'Елена','Аксенова','NULL','86348123738','eaksenova','eaksenova','ROLE_USER','eaksenova@gmail.com'),(6,'Вячеслав','Чикин','Николаевич','87174781838','vchikin','vchikin','ROLE_USER','vchikin@gmail.com'),(7,'Алексей','Курбаотов','Владиславович','81487871348','akurbatov','akurbatov','ROLE_USER','akurbatov@gmail.com'),(8,'Иван','Наделяев','NULL','81244713744','inadel','inadel','ROLE_USER','inadel@gmail.com'),(9,'Сергей','Петров','NULL','81234772478','spetrov','spetrov','ROLE_USER','spetrov@gmail.com'),(10,'Дмитрий','Медведев','NULL','89736543434','dmedvedev','dmedvedev','ROLE_USER','dmedvedev@gmail.com'),(15,'Владимир','Путин','NULL','89736543435','vputin','vputin','ROLE_USER','vputin@gmail.com'),(19,'Рамзан','Кадыров',NULL,'89736543439','rkadr','rkadr','ROLE USER','rkadr@mail.ru');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
