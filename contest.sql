-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: contest
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `answer_options`
--

DROP TABLE IF EXISTS `answer_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer_options` (
  `id_option` int NOT NULL,
  `id_question` int NOT NULL,
  `option_description` varchar(100) DEFAULT NULL,
  `is_true` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_option`,`id_question`),
  KEY `idx_id_question` (`id_question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_options`
--

LOCK TABLES `answer_options` WRITE;
/*!40000 ALTER TABLE `answer_options` DISABLE KEYS */;
INSERT INTO `answer_options` VALUES (1,1,'Paris',1),(1,2,'Leonardo da Vinci',1),(1,3,'Nile',1),(1,4,'1896',1),(1,5,'H2O',1),(1,6,'William Shakespeare',1),(1,7,'Kilimanjaro',1),(1,8,'Pacific',1),(1,9,'China',1),(1,10,'Mercury',1),(1,11,'Canberra',1),(1,12,'George Orwell',1),(1,13,'Fe',1),(1,14,'1945',1),(1,15,'â€œDon Quixoteâ€?',1),(1,16,'Cellular respiration',1),(1,17,'Vincent van Gogh',1),(1,18,'Mississippi',1),(1,19,'Pretoria',1),(1,20,'Albert Einstein',1),(1,21,'92',1),(1,22,'Gabriel GarcÃ­a MÃ¡rquez',1),(1,23,'Russia',1),(1,24,'476 AD',1),(1,25,'28',1),(2,1,'Madrid',0),(2,2,'Vincent van Gogh',0),(2,3,'Amazon',0),(2,4,'1900',0),(2,5,'CO2',0),(2,6,'Charles Dickens',0),(2,7,'Everest',0),(2,8,'Atlantic',0),(2,9,'India',0),(2,10,'Venus',0),(2,11,'Melbourne',0),(2,12,'Aldous Huxley',0),(2,13,'Ag',0),(2,14,'1919',0),(2,15,'â€œLa Celestinaâ€?',0),(2,16,'Photosynthesis',0),(2,17,'Pablo Picasso',0),(2,18,'Amazon',0),(2,19,'Johannesburg',0),(2,20,'Isaac Newton',0),(2,21,'94',0),(2,22,'Julio CortÃ¡zar',0),(2,23,'Canada',0),(2,24,'1 AD',0),(2,25,'12',0),(3,1,'Lyon',0),(3,2,'Pablo Picasso',0),(3,3,'Yangtze',0),(3,4,'1920',0),(3,5,'O2',0),(3,6,'Jane Austen',0),(3,7,'Aconcagua',0),(3,8,'Indian',0),(3,9,'Japan',0),(3,10,'Mars',0),(3,11,'Sydney',0),(3,12,'Ray Bradbury',0),(3,13,'Au',0),(3,14,'1950',0),(3,15,'â€œLife Is a Dreamâ€?',0),(3,16,'Fermentation',0),(3,17,'Claude Monet',0),(3,18,'Nile',0),(3,19,'Cape Town',0),(3,20,'Niels Bohr',0),(3,21,'90',0),(3,22,'Mario Vargas Llosa',0),(3,23,'China',0),(3,24,'1492 AD',0),(3,25,'0',0),(4,1,'Nice',0),(4,2,'Michelangelo',0),(4,3,'Mississippi',0),(4,4,'1932',0),(4,5,'CH4',0),(4,6,'Mark Twain',0),(4,7,'Mont Blanc',0),(4,8,'Arctic',0),(4,9,'South Korea',0),(4,10,'Jupiter',0),(4,11,'Brisbane',0),(4,12,'Margaret Atwood',0),(4,13,'Cu',0),(4,14,'1930',0),(4,15,'â€œFuenteovejunaâ€?',0),(4,16,'Osmosis',0),(4,17,'Salvador DalÃ­',0),(4,18,'Yukon',0),(4,19,'Durban',0),(4,20,'Max Planck',0),(4,21,'96',0),(4,22,'Jorge Luis Borges',0),(4,23,'United States',0),(4,24,'893 AD',0),(4,25,'31',0);
/*!40000 ALTER TABLE `answer_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_history`
--

DROP TABLE IF EXISTS `game_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_history` (
  `id_history` int NOT NULL AUTO_INCREMENT,
  `id_player` varchar(15) DEFAULT NULL,
  `id_question` int DEFAULT NULL,
  `id_option` int DEFAULT NULL,
  `id_round` int DEFAULT NULL,
  PRIMARY KEY (`id_history`),
  KEY `id_player` (`id_player`),
  KEY `id_question` (`id_question`),
  KEY `id_option` (`id_option`),
  KEY `id_round` (`id_round`),
  CONSTRAINT `game_history_ibfk_1` FOREIGN KEY (`id_player`) REFERENCES `player` (`id`),
  CONSTRAINT `game_history_ibfk_2` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id_question`),
  CONSTRAINT `game_history_ibfk_3` FOREIGN KEY (`id_option`) REFERENCES `answer_options` (`id_option`),
  CONSTRAINT `game_history_ibfk_4` FOREIGN KEY (`id_round`) REFERENCES `round` (`id_round`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_history`
--

LOCK TABLES `game_history` WRITE;
/*!40000 ALTER TABLE `game_history` DISABLE KEYS */;
INSERT INTO `game_history` VALUES (5,'1',1,2,1),(7,'1',1,2,1),(10,'1',1,1,1),(11,'1',9,1,2),(12,'1',14,1,3),(13,'1',17,1,4),(14,'1',21,1,5),(15,'1',5,1,1),(16,'1',6,1,2),(17,'1',13,1,3),(18,'1',20,1,4),(19,'2',2,1,1),(20,'2',9,1,2),(21,'2',12,1,3),(22,'2',16,1,4),(23,'2',23,1,5),(24,'1',2,1,1),(25,'1',4,1,1),(26,'1',8,1,2),(27,'43011765',1,1,1),(28,'1',2,1,1),(29,'1',3,1,1),(30,'1',9,1,2),(31,'1',13,1,3),(32,'1',20,1,4),(33,'1',21,1,5);
/*!40000 ALTER TABLE `game_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `id` varchar(15) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES ('1','lucho'),('1152215754','Luis Molina'),('2','Prueba'),('43011765','Carlos Valderrama'),('98123478','Sofia Vergara'),('98123489','Rick Sanchez'),('98123789','Rick Sanchez');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id_question` int DEFAULT NULL,
  `question_description` varchar(100) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  KEY `id_question` (`id_question`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `answer_options` (`id_question`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'What is the capital of France?','Very easy'),(2,'Who painted the Mona Lisa?','Very easy'),(3,'What is the longest river in the world?','Very easy'),(4,'In which year were the first modern Olympic Games held?','Very easy'),(5,'What is the chemical symbol for water?','Very easy'),(6,'Who wrote â€œRomeo and Julietâ€??','Easy'),(7,'What is the tallest mountain in Africa?','Easy'),(8,'Which ocean is the largest in the world?','Easy'),(9,'In which country is the Great Wall of China located?','Easy'),(10,'Which planet is closest to the sun?','Easy'),(11,'What is the capital of Australia?','Medium'),(12,'Who wrote â€œ1984â€??','Medium'),(13,'What is the chemical symbol for iron?','Medium'),(14,'In which year was the United Nations (UN) founded?','Medium'),(15,'What is the most famous work by Miguel de Cervantes?','Medium'),(16,'What is the process by which cells obtain energy from glucose?','Difficult'),(17,'Who painted â€œStarry Nightâ€??','Difficult'),(18,'What is the longest river in North America?','Difficult'),(19,'What is the capital of South Africa?','Difficult'),(20,'Which scientist developed the theory of relativity?','Difficult'),(21,'What is the atomic number of uranium?','Very difficult'),(22,'Who wrote â€œOne Hundred Years of Solitudeâ€??','Very difficult'),(23,'Which country has the largest land area in the world?','Very difficult'),(24,'When did the Western Roman Empire fall?','Very difficult'),(25,'How many Olympic medals did Michael Phelps win?','Very difficult');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `round` (
  `id_round` int NOT NULL,
  `prize` int DEFAULT NULL,
  PRIMARY KEY (`id_round`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `round`
--

LOCK TABLES `round` WRITE;
/*!40000 ALTER TABLE `round` DISABLE KEYS */;
INSERT INTO `round` VALUES (1,100),(2,200),(3,300),(4,400),(5,500);
/*!40000 ALTER TABLE `round` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 10:08:11
