-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: msn
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users1`
--

DROP TABLE IF EXISTS `users1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users1` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users1`
--

LOCK TABLES `users1` WRITE;
/*!40000 ALTER TABLE `users1` DISABLE KEYS */;
INSERT INTO `users1` VALUES (1,'user@mail.com','$2a$10$EOwYHVn9rYTi9XskJ0ibjepmYn6a8a1W1AfjQO2ysoCR9VmCEjE52',0),(2,'user_admin@mail.com','$2a$10$EOwYHVn9rYTi9XskJ0ibjepmYn6a8a1W1AfjQO2ysoCR9VmCEjE52',0),(3,'noc@mail.com','$2a$10$BMLqnw.MHvlTcPYEpgk.POf5uACZXnLWP5is/FwUYV3E3pdsO4Bp6',0),(4,'sva@mail.com','$2a$10$pSl3RgKHHJfcnFQj/7LHcO8Kt.gho.vHCJzek44SOOl0a058kU8Pe',0),(8,'rina@mail.com','$2a$10$oV5xx1wwwZM8q9fh23.XTe1vXuEOMwdzyHeDm3hogqBCuhA8Hp4lW',18),(9,'eri@mail.com','$2a$10$AN/hqUaTREHWKGQTJQuHW.y4l7UktY6/DeIQavTXEANSq9/Oy3Dwa',18),(10,'tamil@mail.com','$2a$10$Q5dywlK7oKxd/q7ROdHZKugYO7BV.iDjsa7MOaFjiOYvBMIi.6eGy',18),(11,'amar@mail.com','$2a$10$dvjFNPJI9h91D9DcYml4qO09nOwGvvujn2eTrWkmcW/uYIKqFnKSi',18),(12,'komo@mail.com','$2a$10$hqTImv/XMXsxf8ZkZtVPueMCzvL7fXy6hzmTCmY.8nSCJut8CTDve',18);
/*!40000 ALTER TABLE `users1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-18  0:57:08
