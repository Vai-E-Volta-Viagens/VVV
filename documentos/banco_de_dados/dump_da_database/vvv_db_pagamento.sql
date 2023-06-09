-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vvv_db
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `IdPag` int(11) NOT NULL AUTO_INCREMENT,
  `Parcelamento` int(11) NOT NULL,
  `FormaPag` varchar(45) NOT NULL,
  `PagamentoFeito` tinyint(4) DEFAULT NULL,
  `Cliente_CPF` int(11) NOT NULL,
  `alocacao_idAloc` int(11) NOT NULL,
  `Proprietaria_idPropriet` int(11) NOT NULL,
  PRIMARY KEY (`IdPag`),
  KEY `fk_Pagamento_Cliente1_idx` (`Cliente_CPF`),
  KEY `fk_Pagamento_alocacao1_idx` (`alocacao_idAloc`),
  KEY `fk_Pagamento_Proprietaria1_idx` (`Proprietaria_idPropriet`),
  CONSTRAINT `fk_Pagamento_Cliente1` FOREIGN KEY (`Cliente_CPF`) REFERENCES `cliente` (`CPF`),
  CONSTRAINT `fk_Pagamento_Proprietaria1` FOREIGN KEY (`Proprietaria_idPropriet`) REFERENCES `proprietaria` (`idPropriet`),
  CONSTRAINT `fk_Pagamento_alocacao1` FOREIGN KEY (`alocacao_idAloc`) REFERENCES `alocacao` (`idAloc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-16 17:57:40
