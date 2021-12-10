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
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `surname` varchar(255) NOT NULL,
  `has_insurance` bit(1) DEFAULT NULL,
  `insurance_company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4wg54pdu0nf8hupy4ab1ewqp1` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'9 Kensington Pass','1990-12-01','esouch0@dell.com','9476770406','Nadège','2403930675','2437','Souch',_binary '','Linkbridge'),(2,'33 Prairie Rose Plaza','1987-10-12','jgillam1@g.co','0842314792','Ophélie','1364517236',NULL,'Gillam',_binary '\0','Geba'),(3,'5576 Bunting Road','1967-11-20','mmarcone2@booking.com','8166578522','Léa','8346344175','999-3776','Marcone',_binary '','Oodoo'),(4,'50819 Mcguire Lane','1988-01-01','hcanete3@bloglines.com','2968832395','Cinéma','3123946522','60614','Canete',_binary '','Eabox'),(5,'0938 Service Pass','1978-03-01','ahallmark4@auda.org.au','2504585780','Laïla','2388328480','37550-000','Hallmark',_binary '\0','Gigazoom'),(7,'9 Kensington Pass','1965-06-11','tomasescudero@gmail.com','111111111','Tomas','2403930675','2437','Escudero Delgado',_binary '','Adeslas'),(8,'9 Kensington Pass','1990-03-10','pilarlobon@gmail.com','9088973728','Pilar','2403930675','2437','Lobon Bru',_binary '','Sanitas'),(9,'9 Kensington Pass','1990-06-30','jorgemartin@gmail.com','222222222','Jorge','2403930675','2437','Martin Perez',_binary '','Adeslas');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:21:22
