-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medicalcenterdb
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedules` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `is_working_day` bit(1) DEFAULT NULL,
  `health_worker_id` bigint DEFAULT NULL,
  `formatted_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpt1107row2cdhgeqwuda8n70j` (`health_worker_id`),
  CONSTRAINT `FKpt1107row2cdhgeqwuda8n70j` FOREIGN KEY (`health_worker_id`) REFERENCES `health_workers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,'2021-11-15',_binary '',1,'15-10-2021'),(2,'2021-11-16',_binary '',1,'16-10-2021'),(3,'2021-11-17',_binary '\0',1,NULL),(4,'2021-11-18',_binary '',1,'18-10-2021'),(5,'2021-11-19',_binary '',1,'19-10-2021'),(6,'2021-11-20',_binary '',1,'20-10-2021'),(7,'2021-11-21',_binary '',1,'21-10-2021'),(8,'2021-11-22',_binary '\0',1,NULL),(9,'2021-11-23',_binary '\0',1,NULL),(10,'2021-11-14',_binary '\0',2,NULL),(11,'2021-11-15',_binary '\0',2,NULL),(12,'2021-11-16',_binary '\0',2,NULL),(13,'2021-11-17',_binary '',2,NULL),(14,'2021-11-18',_binary '',2,NULL),(15,'2021-12-14',_binary '\0',7,NULL),(16,'2021-12-15',_binary '',7,'15-11-2021'),(17,'2021-12-16',_binary '',7,'16-11-2021'),(18,'2021-12-17',_binary '',7,'17-11-2021'),(19,'2021-12-18',_binary '',7,'18-11-2021'),(20,'2021-12-19',_binary '',7,'19-11-2021'),(21,'2021-12-20',_binary '',7,'20-11-2021'),(22,'2021-12-14',_binary '',14,'14-11-2021'),(23,'2021-12-15',_binary '',14,'15-11-2021'),(24,'2021-12-16',_binary '',14,'16-11-2021'),(25,'2021-12-17',_binary '\0',14,NULL),(26,'2021-12-18',_binary '',14,'18-11-2021'),(27,'2021-12-19',_binary '',14,'19-11-2021'),(28,'2021-12-20',_binary '\0',14,NULL);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:21:23
