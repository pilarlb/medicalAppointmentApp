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
-- Table structure for table `health_specialties`
--

DROP TABLE IF EXISTS `health_specialties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_specialties` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `specialty` varchar(255) NOT NULL,
  `healthworker_id` bigint DEFAULT NULL,
  `health_specialties` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKptfpkqblmiw2qdjjcxiwuv193` (`healthworker_id`),
  KEY `FKbua2ii6hfku7tr5pp2s31j8oi` (`health_specialties`),
  CONSTRAINT `FKbua2ii6hfku7tr5pp2s31j8oi` FOREIGN KEY (`health_specialties`) REFERENCES `health_workers` (`id`),
  CONSTRAINT `FKptfpkqblmiw2qdjjcxiwuv193` FOREIGN KEY (`healthworker_id`) REFERENCES `health_workers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_specialties`
--

LOCK TABLES `health_specialties` WRITE;
/*!40000 ALTER TABLE `health_specialties` DISABLE KEYS */;
INSERT INTO `health_specialties` VALUES (1,'Allergy and immunology',1,NULL),(2,'Anesthesiology',2,NULL),(3,'Dermatology',3,NULL),(4,'Diagnostic radiology',4,NULL),(5,'Emergency medicine',5,NULL),(6,'Family medicine',6,NULL),(7,'Internal medicine',7,NULL),(8,'Neurology',8,NULL),(9,'Medical genetics',9,NULL),(10,'Nuclear medicinee',10,NULL),(11,'Obstetrics and gynecology',11,NULL),(12,'Ophthalmology',12,NULL),(13,'Pathology',13,NULL),(14,'Pediatrics',14,NULL),(15,'Physical medicine and rehabilitation',15,NULL),(16,'Preventive medicine',16,NULL),(17,'Psychiatry',17,NULL),(18,'Radiation oncology',18,NULL),(19,'Urology',19,NULL),(20,'Neurology',1,NULL),(21,'Neurology',2,NULL),(22,'Family medicine',1,NULL),(23,'Family medicine',2,NULL),(24,'Family medicine',3,NULL),(25,'Psychiatry',18,NULL),(26,'Psychiatry',19,NULL),(27,'Psychiatry',16,NULL);
/*!40000 ALTER TABLE `health_specialties` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:21:24
