-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: locadora
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `Actor`
--

DROP TABLE IF EXISTS `Actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actor`
--

LOCK TABLES `Actor` WRITE;
/*!40000 ALTER TABLE `Actor` DISABLE KEYS */;
INSERT INTO `Actor` VALUES (2,'Ator novato'),(3,'Ator vey de guerra');
/*!40000 ALTER TABLE `Actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Classe`
--

DROP TABLE IF EXISTS `Classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maximumRentalTime` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Classe`
--

LOCK TABLES `Classe` WRITE;
/*!40000 ALTER TABLE `Classe` DISABLE KEYS */;
INSERT INTO `Classe` VALUES (2,15,'Lançamento',29);
/*!40000 ALTER TABLE `Classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthDate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'1900-01-01','Edilson Cichon','M'),(2,'1994-07-05','Fernanda Cichon da Hora','F'),(4,'1992-10-10','Thiago Colosio','M'),(5,'1992-10-10','Rafael Angelo','M'),(6,'1992-10-10','pablo vitar','O'),(28,'2018-05-16','Fernandilson','M'),(29,'2018-05-16','Edilsnanda','F'),(36,'2018-05-17','Fernandilson','M'),(37,'2018-05-17','Edilsnanda','F'),(38,'2018-05-17','Ronaldinho filho','M');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Director`
--

DROP TABLE IF EXISTS `Director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Director` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Director`
--

LOCK TABLES `Director` WRITE;
/*!40000 ALTER TABLE `Director` DISABLE KEYS */;
INSERT INTO `Director` VALUES (1,'Valcir Carrasco');
/*!40000 ALTER TABLE `Director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aquisitionDate` date DEFAULT NULL,
  `numberSerie` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `title_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8tseee7qq7jg5q03lkv5uwgaw` (`title_id`),
  CONSTRAINT `FK_8tseee7qq7jg5q03lkv5uwgaw` FOREIGN KEY (`title_id`) REFERENCES `Title` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` VALUES (1,'2018-04-01','9876','blueray',1),(2,'2017-01-10','1A2B3C','blueray',3),(3,'2000-01-01','A1B2C3','dvd',2);
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `expectedReturnDate` date DEFAULT NULL,
  `fine` double NOT NULL,
  `locationDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `valueItem` double NOT NULL,
  `customer_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d4g4wxvrelw8h442ddhytnmvn` (`customer_id`),
  KEY `FK_9tusjklf04fdoowp53qdn8ppn` (`item_id`),
  CONSTRAINT `FK_9tusjklf04fdoowp53qdn8ppn` FOREIGN KEY (`item_id`) REFERENCES `Item` (`id`),
  CONSTRAINT `FK_d4g4wxvrelw8h442ddhytnmvn` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Location`
--

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;
INSERT INTO `Location` VALUES (1,29,'2018-05-15',0,'2018-05-15','2018-01-16',29,6,1);
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Title`
--

DROP TABLE IF EXISTS `Title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Title` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sinopse` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `director_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5cf8infyl2po79lriq8them04` (`category_id`),
  KEY `FK_44qhneihp5hmt48ovxikqy3hs` (`classe_id`),
  KEY `FK_s2rdn571wy2pmcwm4lgtbq80d` (`director_id`),
  CONSTRAINT `FK_44qhneihp5hmt48ovxikqy3hs` FOREIGN KEY (`classe_id`) REFERENCES `Classe` (`id`),
  CONSTRAINT `FK_5cf8infyl2po79lriq8them04` FOREIGN KEY (`category_id`) REFERENCES `title_category` (`id`),
  CONSTRAINT `FK_s2rdn571wy2pmcwm4lgtbq80d` FOREIGN KEY (`director_id`) REFERENCES `Director` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Title`
--

LOCK TABLES `Title` WRITE;
/*!40000 ALTER TABLE `Title` DISABLE KEYS */;
INSERT INTO `Title` VALUES (1,'O Mecanismo','Série que desmacara todos os políticos brasileiros.',2017,4,2,1),(2,'Os Vingadores','descrição da sinópse',2017,3,2,1),(3,'Breaking Bad','Seriado americano antigo, porém muito bom.',2017,2,2,1);
/*!40000 ALTER TABLE `Title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor_title`
--

DROP TABLE IF EXISTS `actor_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actor_title` (
  `actor_id` int(11) NOT NULL,
  `title_id` int(11) NOT NULL,
  KEY `FK_luxypkdhvhd38lyr8hdycjqmr` (`title_id`),
  KEY `FK_wiul4cdikwyvg7ladgt3c97i` (`actor_id`),
  CONSTRAINT `FK_luxypkdhvhd38lyr8hdycjqmr` FOREIGN KEY (`title_id`) REFERENCES `Actor` (`id`),
  CONSTRAINT `FK_wiul4cdikwyvg7ladgt3c97i` FOREIGN KEY (`actor_id`) REFERENCES `Title` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_title`
--

LOCK TABLES `actor_title` WRITE;
/*!40000 ALTER TABLE `actor_title` DISABLE KEYS */;
/*!40000 ALTER TABLE `actor_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_dependent`
--

DROP TABLE IF EXISTS `customer_dependent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_dependent` (
  `customer_id` int(11) NOT NULL,
  `partner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK_j2515chfji10f3ny0onygnnmi` (`partner_id`),
  CONSTRAINT `FK_d5963cmtme37f5brsobxthw12` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`),
  CONSTRAINT `FK_j2515chfji10f3ny0onygnnmi` FOREIGN KEY (`partner_id`) REFERENCES `customer_partner` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_dependent`
--

LOCK TABLES `customer_dependent` WRITE;
/*!40000 ALTER TABLE `customer_dependent` DISABLE KEYS */;
INSERT INTO `customer_dependent` VALUES (28,1),(29,1),(36,2),(37,2),(38,4);
/*!40000 ALTER TABLE `customer_dependent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_partner`
--

DROP TABLE IF EXISTS `customer_partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_partner` (
  `address` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `FK_nsx53i46cuk1cvdeu2dy8ajn5` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_partner`
--

LOCK TABLES `customer_partner` WRITE;
/*!40000 ALTER TABLE `customer_partner` DISABLE KEYS */;
INSERT INTO `customer_partner` VALUES ('{\"cep\":\"29705-711\",\"street\":\"Rua Vitório Cosme\",\"district\":\"Santa Helena\",\"city\":\"Colatina\",\"uf\":\"ES\",\"number\":\"271\"}','13953108743',1),('{\"cep\":\"29705-710\",\"street\":\"Rua Vitório Cosme\",\"district\":\"Santa Helena\",\"city\":\"Colatina\",\"uf\":\"ES\"}','12919267085',2),('{\"cep\":\"29705-710\",\"street\":\"Rua Vitório Cosme\",\"district\":\"Santa Helena\",\"city\":\"Colatina\",\"uf\":\"ES\"}','12919267085',4),('{\"cep\":\"29705-710\",\"street\":\"Rua Vitório Cosme\",\"district\":\"Santa Helena\",\"city\":\"Colatina\",\"uf\":\"ES\"}','12919267085',5),('{\"cep\":\"29705-710\",\"street\":\"Rua Vitório Cosme\",\"district\":\"Santa Helena\",\"city\":\"Colatina\",\"uf\":\"ES\"}','13953108743',6);
/*!40000 ALTER TABLE `customer_partner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `title_category`
--

DROP TABLE IF EXISTS `title_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `title_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title_category`
--

LOCK TABLES `title_category` WRITE;
/*!40000 ALTER TABLE `title_category` DISABLE KEYS */;
INSERT INTO `title_category` VALUES (1,'Ação'),(2,'Comédia'),(3,'Terror'),(4,'Suspense'),(5,'Romance');
/*!40000 ALTER TABLE `title_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-24 18:06:23
