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
-- Table structure for table `slots`
--

DROP TABLE IF EXISTS `slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slots` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `appointment_time` varchar(255) NOT NULL,
  `available` bit(1) NOT NULL,
  `schedule_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4252nby4cro5ngqt7pvjulgm6` (`schedule_id`),
  CONSTRAINT `FK4252nby4cro5ngqt7pvjulgm6` FOREIGN KEY (`schedule_id`) REFERENCES `schedules` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slots`
--

LOCK TABLES `slots` WRITE;
/*!40000 ALTER TABLE `slots` DISABLE KEYS */;
INSERT INTO `slots` VALUES (1,'15:00',_binary '',1),(2,'15:15',_binary '',1),(3,'15:30',_binary '\0',1),(4,'15:45',_binary '',1),(5,'16:00',_binary '',1),(6,'16:15',_binary '',1),(7,'16:30',_binary '\0',1),(8,'16:45',_binary '',1),(9,'17:00',_binary '',1),(10,'17:15',_binary '\0',1),(11,'17:30',_binary '',1),(12,'17:45',_binary '',1),(13,'18:00',_binary '',1),(14,'18:15',_binary '',1),(15,'18:30',_binary '\0',1),(16,'18:45',_binary '\0',1),(17,'19:00',_binary '',1),(18,'19:15',_binary '',1),(19,'19:30',_binary '',1),(20,'19:45',_binary '\0',1),(21,'20:00',_binary '',1),(22,'20:15',_binary '\0',1),(23,'20:30',_binary '',1),(24,'20:45',_binary '\0',1),(25,'9:00',_binary '',2),(26,'9:15',_binary '',2),(27,'9:30',_binary '\0',2),(28,'9:45',_binary '',2),(29,'10:00',_binary '\0',2),(30,'10:15',_binary '',2),(31,'10:30',_binary '\0',2),(32,'10:45',_binary '',2),(33,'11:00',_binary '',2),(34,'11:15',_binary '',2),(35,'11:30',_binary '',2),(36,'11:45',_binary '',2),(37,'12:00',_binary '',2),(38,'12:15',_binary '',2),(39,'12:30',_binary '',2),(40,'12:45',_binary '\0',2),(41,'13:00',_binary '',2),(42,'13:15',_binary '\0',2),(43,'13:30',_binary '',2),(44,'13:45',_binary '',2),(45,'14:00',_binary '',2),(46,'14:15',_binary '\0',2),(47,'14:30',_binary '',2),(48,'14:45',_binary '',2),(49,'9:00',_binary '',13),(50,'9:15',_binary '',13),(51,'9:30',_binary '\0',13),(52,'9:45',_binary '',13),(53,'10:00',_binary '\0',13),(54,'10:15',_binary '',13),(55,'10:30',_binary '\0',13),(56,'10:45',_binary '',13),(57,'11:00',_binary '',13),(58,'11:15',_binary '',13),(59,'11:30',_binary '',13),(60,'11:45',_binary '\0',13),(61,'12:00',_binary '',13),(62,'12:15',_binary '',13),(63,'12:30',_binary '',13),(64,'12:45',_binary '\0',13),(65,'13:00',_binary '',13),(66,'13:15',_binary '\0',13),(67,'13:30',_binary '',13),(68,'13:45',_binary '',13),(69,'14:00',_binary '',13),(70,'14:15',_binary '\0',13),(71,'14:30',_binary '',13),(72,'14:45',_binary '',13),(73,'15:00',_binary '',14),(74,'15:15',_binary '',14),(75,'15:30',_binary '\0',14),(76,'15:45',_binary '',14),(77,'16:00',_binary '',14),(78,'16:15',_binary '',14),(79,'16:30',_binary '\0',14),(80,'16:45',_binary '',14),(81,'17:00',_binary '',14),(82,'17:15',_binary '\0',14),(83,'17:30',_binary '',14),(84,'17:45',_binary '',14),(85,'18:00',_binary '',14),(86,'18:15',_binary '',14),(87,'18:30',_binary '\0',14),(88,'18:45',_binary '\0',14),(89,'19:00',_binary '',14),(90,'19:15',_binary '',14),(91,'19:30',_binary '',14),(92,'19:45',_binary '\0',14),(93,'20:00',_binary '',14),(94,'20:15',_binary '',14),(95,'20:30',_binary '',14),(96,'20:45',_binary '',14),(97,'9:00',_binary '',16),(98,'9:15',_binary '',16),(99,'9:30',_binary '\0',16),(100,'9:45',_binary '',16),(101,'10:00',_binary '\0',16),(102,'10:15',_binary '',16),(103,'10:30',_binary '\0',16),(104,'10:45',_binary '',16),(105,'11:00',_binary '',16),(106,'11:15',_binary '',16),(107,'11:30',_binary '',16),(108,'11:45',_binary '\0',16),(109,'12:00',_binary '',16),(110,'12:15',_binary '',16),(111,'12:30',_binary '',16),(112,'12:45',_binary '\0',16),(113,'13:00',_binary '',16),(114,'13:15',_binary '\0',16),(115,'13:30',_binary '',16),(116,'13:45',_binary '',16),(117,'14:00',_binary '',16),(118,'14:15',_binary '\0',16),(119,'14:30',_binary '',16),(120,'14:45',_binary '',16),(121,'15:00',_binary '\0',22),(122,'15:15',_binary '\0',22),(123,'15:30',_binary '\0',22),(124,'15:45',_binary '',22),(125,'16:00',_binary '',22),(126,'16:15',_binary '\0',22),(127,'16:30',_binary '\0',22),(128,'16:45',_binary '\0',22),(129,'17:00',_binary '',22),(130,'17:15',_binary '\0',22),(131,'17:30',_binary '\0',22),(132,'17:45',_binary '',22),(133,'18:00',_binary '',22),(134,'18:15',_binary '',22),(135,'18:30',_binary '\0',22),(136,'18:45',_binary '\0',22),(137,'19:00',_binary '',22),(138,'19:15',_binary '\0',22),(139,'19:30',_binary '\0',22),(140,'19:45',_binary '\0',22),(141,'20:00',_binary '',22),(142,'20:15',_binary '',22),(143,'20:30',_binary '',22),(144,'20:45',_binary '\0',22);
/*!40000 ALTER TABLE `slots` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:21:25
