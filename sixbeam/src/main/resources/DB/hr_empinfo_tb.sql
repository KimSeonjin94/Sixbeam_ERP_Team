-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sixbeam_erp
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `hr_empinfo_tb`
--

DROP TABLE IF EXISTS `hr_empinfo_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_empinfo_tb` (
  `empinfo_birth` date DEFAULT NULL,
  `empinfo_join_dt` date DEFAULT NULL,
  `empinfo_quit_dt` date DEFAULT NULL,
  `empinfo_sex` bit(1) DEFAULT NULL,
  `empinfo_totalnoy` int DEFAULT NULL,
  `depart_cd` bigint DEFAULT NULL,
  `emp_sequence` bigint DEFAULT NULL,
  `position_cd` bigint DEFAULT NULL,
  `empinfo_account_no` varchar(255) DEFAULT NULL,
  `empinfo_addr` varchar(255) DEFAULT NULL,
  `empinfo_bank` varchar(255) DEFAULT NULL,
  `empinfo_email` varchar(255) DEFAULT NULL,
  `empinfo_etc` varchar(255) DEFAULT NULL,
  `empinfo_id` varchar(255) NOT NULL,
  `empinfo_nm` varchar(255) DEFAULT NULL,
  `empinfo_phone` varchar(255) DEFAULT NULL,
  `empinfo_pw` varchar(255) DEFAULT NULL,
  `empinfo_qr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empinfo_id`),
  KEY `FKqjqw9qqmotor8fcn98c3ufwgi` (`depart_cd`),
  KEY `FK2b0tx3wkk69vv6yyd2i32cmfy` (`position_cd`),
  CONSTRAINT `FK2b0tx3wkk69vv6yyd2i32cmfy` FOREIGN KEY (`position_cd`) REFERENCES `hr_position_tb` (`position_cd`),
  CONSTRAINT `FKqjqw9qqmotor8fcn98c3ufwgi` FOREIGN KEY (`depart_cd`) REFERENCES `hr_depart_tb` (`depart_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_empinfo_tb`
--

LOCK TABLES `hr_empinfo_tb` WRITE;
/*!40000 ALTER TABLE `hr_empinfo_tb` DISABLE KEYS */;
INSERT INTO `hr_empinfo_tb` VALUES ('1990-01-01','2024-02-01','2024-02-01',_binary '',0,NULL,NULL,NULL,'123-456-0000','Address 0','Bank 0','employee0@example.com',NULL,'20241000','임호진','123-456-0000','0',NULL),('1991-01-01','2024-02-01','2024-03-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0001','Address 1','Bank 1','employee1@example.com',NULL,'20241001','이상효','123-456-0001','1',NULL),('1992-01-01','2024-02-01','2024-04-01',_binary '',0,NULL,NULL,NULL,'123-456-0002','Address 2','Bank 2','employee2@example.com',NULL,'20241002','김선진','123-456-0002','2',NULL),('1993-01-01','2024-02-01','2024-05-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0003','Address 3','Bank 3','employee3@example.com',NULL,'20241003','임지환','123-456-0003','3',NULL),('1994-01-01','2024-02-01','2024-06-01',_binary '',0,NULL,NULL,NULL,'123-456-0004','Address 4','Bank 4','employee4@example.com',NULL,'20241004','김영훈','123-456-0004','4',NULL),('1995-01-01','2024-02-01','2024-07-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0005','Address 5','Bank 5','employee5@example.com',NULL,'20241005','박종현','123-456-0005','5',NULL),('1996-01-01','2024-02-01','2024-08-01',_binary '',0,NULL,NULL,NULL,'123-456-0006','Address 6','Bank 6','employee6@example.com',NULL,'20241006','박주성','123-456-0006','6',NULL),('1997-01-01','2024-02-01','2024-09-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0007','Address 7','Bank 7','employee7@example.com',NULL,'20241007','문성빈','123-456-0007','7',NULL),('1998-01-01','2024-02-01','2024-10-01',_binary '',0,NULL,NULL,NULL,'123-456-0008','Address 8','Bank 8','employee8@example.com',NULL,'20241008','천준호','123-456-0008','8',NULL),('1999-01-01','2024-02-01','2024-11-01',_binary '\0',0,NULL,NULL,NULL,'123-456-0009','Address 9','Bank 9','employee9@example.com',NULL,'20241009','서준하','123-456-0009','9',NULL);
/*!40000 ALTER TABLE `hr_empinfo_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-01 17:52:11
