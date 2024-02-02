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
-- Table structure for table `ac_account_tb`
--

DROP TABLE IF EXISTS `ac_account_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ac_account_tb` (
  `account_acnb` varchar(255) NOT NULL,
  `account_add` varchar(255) NOT NULL,
  `account_bank` varchar(255) NOT NULL,
  `account_cd` varchar(255) NOT NULL,
  `account_etc` varchar(255) DEFAULT NULL,
  `account_nb` varchar(255) NOT NULL,
  `account_nm` varchar(255) NOT NULL,
  `account_pic` varchar(255) NOT NULL,
  `account_rep` varchar(255) NOT NULL,
  `account_sectors` varchar(255) NOT NULL,
  PRIMARY KEY (`account_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac_account_tb`
--

LOCK TABLES `ac_account_tb` WRITE;
/*!40000 ALTER TABLE `ac_account_tb` DISABLE KEYS */;
INSERT INTO `ac_account_tb` VALUES ('673-7705371755','서울시 노원구','신한은행','CPN0764320143','구매처','0764320143','BRAVOTEC','이상효','김영진','제조'),('685-0473786985','서울시 광진구','카카오뱅크','CPN0831580507',NULL,'0831580507','롯데','임지환','신격호','유통'),('783-6930006568','경기도 성남시','하나은행','CPN0896202274',NULL,'0896202274','소니','김선진','모리타아키오','제조'),('540-9279534862','서울시 성북구','국민은행','CPN1029807529','구매처','1029807529','AMD','이상효','제리샌더스','제조'),('226-6876859474','서울시 성동구','국민은행','CPN1173291319','구매처','1173291319','GIGABYTE','임지환','예페이청','제조'),('033-4551844212','서울시 구로구','하나은행','CPN1203760813',NULL,'1203760813','NAVER','임호진','이해진','IT'),('074-3127136659','경기도 김포시','하나은행','CPN1856927584','구매처','1856927584','웨스턴디지털','김선진','앨빈필립스','제조'),('888-9898204726','서울시 송파구','농협은행','CPN2266939105','구매처','2266939105','로지텍','임지환','다니엘보렉','제조'),('483-1484534403','서울시 영등포구','하나은행','CPN3058270672',NULL,'3058270672','POSCO','임호진','박태준','제조'),('098-7663007851','서울시 강서구','신한은행','CPN3184469866',NULL,'3184469866','카카오','임호진','김범수','IT'),('553-3530031122','서울시 용산구','신한은행','CPN4244014868',NULL,'4244014868','GS','박종현','허만정','유통'),('821-8168143276','서울시 강동구','우리은행','CPN4282222263','구매처','4282222263','삼성전자','임지환','이건희','제조'),('703-1720820252','서울시 마포구','하나은행','CPN4308575449','구매처','4308575449','애즈락','박종현','쉬스창','제조'),('919-6316264851','서울시 서초구','하나은행','CPN5221945160',NULL,'5221945160','KT','김영훈','김영섭','통신'),('067-6986366840','서울시 동대문구','카카오뱅크','CPN5277628939','구매처','5277628939','인텔','임지환','고든무어','제조'),('656-8255128990','서울시 도봉구','농협은행','CPN5431051314',NULL,'5431051314','APPLE','이상효','스티브잡스','IT'),('145-3669839433','서울시 관악구','국민은행','CPN5593852744',NULL,'5593852744','SKT','김영훈','유영상','통신'),('517-5649280480','서울시 강남구','우리은행','CPN5836847354','구매처','5836847354','마이크로닉스','김영훈','김종원','제조'),('951-3479499431','서울시 중구','우리은행','CPN6234714473',NULL,'6234714473','두산','박종현','박승직','건설'),('081-7901698385','서울시 중랑구','신한은행','CPN6287772501','구매처 ','6287772501','SK하이닉스','이상효','곽노정','제조'),('973-4812556890','서울시 종로구','카카오뱅크','CPN6357090862',NULL,'6357090862','CJ','박종현','이병철','유통'),('025-9153541675','경기도 하남시','농협은행','CPN6543637212','구매처','6543637212','SEASONIC','김선진','칼벤츠','제조'),('098-4649694312','서울시 강북구','신한은행','CPN6814402423','구매처','6814402423','ZOTAC','이상효','김성표','유통'),('249-8986691231','서울시 서대문구','하나은행','CPN7422636804','구매처','7422636804','다크플래시','박종현','민희진','제조'),('012-0516866831','서울시 금천구','농협은행','CPN7551487293',NULL,'7551487293','NCsoft','김영훈','김택진','IT'),('310-4668131524','경기도 용인시','우리은행','CPN8641151763',NULL,'8641151763','대한통운','김선진','강신호','유통'),('112-7155262063','서울시 은평구','국민은행','CPN8766713365','구매처','8766713365','아수스','임호진','테드수','제조'),('875-3926701002','경기도 안양시','카카오뱅크','CPN8769359993','구매처','8769359993','한성컴퓨터','임호진','한동열','제조'),('151-3927322602','서울시 양천구','농협은행','CPN8956377612','구매처','8956377612','EMTEK','임호진','박민규','유통'),('887-3826701003','경기도 군포시','카카오뱅크','CPN9469359994','구매처','9469359994','레이저','임호진','로버트크라코프','유통'),('859-4026701001','서울시 동작구','신한은행','CPN9769359992',NULL,'9769359992','LGU','김영훈','황현식','통신'),('642-0290265811','경기도 수원시 ','우리은행','RTS1010101010','소매매출','8832918761','개인거래','김선진','CUSTOMER','소매');
/*!40000 ALTER TABLE `ac_account_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-02 12:01:09
