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
-- Table structure for table `health_workers`
--

DROP TABLE IF EXISTS `health_workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_workers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `surname` varchar(255) NOT NULL,
  `practicing_from` datetime(6) DEFAULT NULL,
  `procurement_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_o309fhqj21y4wx5n533gp6tgj` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_workers`
--

LOCK TABLES `health_workers` WRITE;
/*!40000 ALTER TABLE `health_workers` DISABLE KEYS */;
INSERT INTO `health_workers` VALUES (1,'3015 Express Hill','1955-09-02','mcannam0@bing.com','AF442fILM0','Marni','7813363691','188478','Cannam','2011-03-01 11:52:47.000000','1977-03-09 09:57:46.000000'),(2,'10 Troy Pass','1987-02-14','sgrahl1@privacy.gov.au','p6wJGCL','Sybille','8492667997',NULL,'Grahl','1951-03-24 16:31:52.000000','1973-10-29 10:08:04.000000'),(3,'949 Kedzie Point','1970-07-11','jseamons2@netlog.com','wL3ObZLY6Sxb','Jourdan','3348252567',NULL,'Seamons','2013-07-05 21:02:09.000000','1961-07-03 17:59:26.000000'),(4,'2782 Crowley Alley','1977-03-31','vkinnar3@baidu.com','mSMjut1xFc','Vanna','5291961577',NULL,'Kinnar','1995-01-02 22:44:08.000000','1994-05-20 06:06:56.000000'),(5,'5 Ludington Avenue','1957-09-06','tarni4@scientificamerican.com','2kgawVzov','Tonye','4733846698','51250','Arni','1995-10-30 14:14:38.000000','1956-05-04 03:39:05.000000'),(6,'224 Hollow Ridge Avenue','1990-06-15','mdickins5@ft.com','rbtNkL','Marley','4423485385','4216','Dickins','2005-05-13 22:25:04.000000','2003-01-04 02:47:11.000000'),(7,'345 Hudson Hill','1946-05-17','ebrownlea6@typepad.com','XfKqIh4q','Eolande','5347180057','454092','Brownlea','1972-11-03 00:58:15.000000','1963-02-05 05:26:47.000000'),(8,'0 Northview Court','1976-09-28','kvittori7@google.pl','pyQNkvvnVf','Kylen','7572353148','16-120','Vittori','1958-09-25 16:54:34.000000','1965-06-11 23:21:32.000000'),(9,'0810 Ronald Regan Parkway','1931-01-06','kbennis8@angelfire.com','m3oaqvU','Konstanze','2219304040',NULL,'Bennis','1980-05-26 12:24:31.000000','1998-05-10 12:05:15.000000'),(10,'0978 West Lane','1951-01-12','hchedzoy9@cdc.gov','SCclKO','Helli','3908832643',NULL,'Chedzoy','1969-12-21 00:38:53.000000','1975-02-10 01:43:23.000000'),(11,'94 Buell Junction','1957-01-31','zjoanneta@pinterest.com','vSK2x4yz','Zia','9325118020','35409 CEDEX','Joannet','1962-05-20 16:18:09.000000','1979-06-22 00:28:04.000000'),(12,'26 Steensland Street','1967-12-20','flodwigb@prweb.com','4xiOburYWkI7','Friederike','9393086866',NULL,'Lodwig','1973-03-19 17:57:18.000000','1963-09-05 02:45:21.000000'),(13,'46941 David Court','1983-01-21','kislandc@sourceforge.net','zpI29Du0mIK','Kirsti','9663586190',NULL,'Island','2004-11-12 10:38:53.000000','1973-12-17 19:18:55.000000'),(14,'754 Roxbury Trail','1977-04-11','rcantud@naver.com','tdzZGRY5','Rafaela','5596264868',NULL,'Cantu','1973-05-17 17:44:56.000000','1958-05-22 22:18:30.000000'),(15,'747 Washington Plaza','1945-08-09','bvowellse@drupal.org','KrZbWRLU','Billi','7735809810',NULL,'Vowells','1990-09-06 20:32:28.000000','1967-05-25 02:37:58.000000'),(16,'9473 Kipling Way','1961-03-06','smaccraef@ameblo.jp','mviESaziEyW','Sioux','7812410793',NULL,'Maccrae','2014-03-23 18:21:06.000000','2009-03-29 02:10:55.000000'),(17,'3037 Lukken Alley','1940-10-15','keakinsg@examiner.com','nEOPjoBb4B8Y','Kate','4969376209',NULL,'Eakins','1985-09-27 12:59:45.000000','2004-12-30 11:20:48.000000'),(18,'32 Morning Terrace','1989-05-26','dpriorh@illinois.edu','k4fVZF3','Drucie','5948339207','10140','Prior','1980-02-08 17:18:14.000000','2007-07-27 21:36:22.000000'),(19,'3144 Onsgard Alley','1988-12-29','dgilliveri@hc360.com','JonTyC','Deedee','8861975312','77294 CEDEX','Gilliver','1986-07-22 20:32:45.000000','1983-10-25 21:05:32.000000'),(20,'853 Lawn Plaza','1953-04-19','vspriggenj@cargocollective.com','heaetG0','Violetta','5782930058',NULL,'Spriggen','1993-06-27 16:50:11.000000','1991-02-08 09:08:48.000000'),(21,'1127 Menomonie Park','1958-08-16','gbettlesk@chron.com','KJfJ62ttmHkj','Gates','1646408211',NULL,'Bettles','1973-05-27 01:29:46.000000','1957-01-05 11:55:30.000000'),(22,'8 Schiller Junction','1973-03-04','ccavaneyl@ustream.tv','s6nDhhnl','Caril','8759177521','291 81','Cavaney','1991-12-07 10:36:55.000000','1996-11-25 19:19:53.000000'),(23,'6188 Delaware Street','1930-09-27','clorainem@adobe.com','6VF99OL','Conchita','2251573602','763508','Loraine','1968-12-25 07:40:21.000000','1986-01-25 03:14:16.000000'),(24,'18365 Autumn Leaf Point','1941-09-30','bbarsonn@1688.com','ntNvgw','Bevvy','9757849042',NULL,'Barson','1982-06-06 16:17:55.000000','1951-08-20 01:41:35.000000'),(25,'44 Lighthouse Bay Alley','1967-07-22','tarkowo@g.co','hIFGAwAXMif','Tabby','7135067193','T23','Arkow','2009-09-08 09:21:10.000000','1999-04-02 02:49:20.000000'),(26,'3 Mifflin Junction','1981-05-18','fdunlopp@si.edu','lKLSPSf1f4YX','Florinda','1894972590','3525-355','Dunlop','1975-06-24 07:12:18.000000','1962-02-05 11:57:43.000000'),(27,'758 Sunbrook Street','1963-04-15','snichollq@wix.com','hcjAVAQ','Sharyl','6728730715','63-130','Nicholl','2009-01-20 12:05:54.000000','1975-12-17 08:29:23.000000'),(28,'1 Nevada Alley','1977-09-02','arignoldesr@networksolutions.com','fHJckZ','Audrye','4178998243','6407','Rignoldes','2009-08-14 12:16:41.000000','1967-01-15 14:53:29.000000'),(29,'2420 Grayhawk Hill','1938-11-08','creadwings@linkedin.com','kJ5YyG8','Caren','4993969842','916-0013','Readwing','2009-03-09 00:36:36.000000','1975-03-08 14:47:43.000000'),(30,'5425 Kensington Road','1948-09-06','lrubenovt@digg.com','8iaCR7m','Latrina','2834222114','197720','Rubenov','1962-10-04 19:21:35.000000','1982-12-31 12:36:04.000000'),(31,'3015 Express Hill','1999-09-10','plb0@bing.com','AF442fILM6','Pilar','7813363691','188478','Lobon','2011-03-01 00:00:00.000000','1977-03-09 00:00:00.000000');
/*!40000 ALTER TABLE `health_workers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 19:21:20
