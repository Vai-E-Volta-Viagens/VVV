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
-- Table structure for table `alocacao`
--

DROP TABLE IF EXISTS `alocacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alocacao` (
  `idAloc` int(11) NOT NULL AUTO_INCREMENT,
  `DataSolicitacao` datetime DEFAULT NULL,
  `alocacaocol` varchar(45) DEFAULT NULL,
  `Cliente_CPF` int(11) NOT NULL,
  `Confirma_IdPag` int(11) DEFAULT NULL,
  `Reserva_IdRes` int(11) NOT NULL,
  `Realiza_idFunc` int(11) DEFAULT NULL,
  `Aprova_idFunc` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAloc`),
  KEY `fk_alocacao_Cliente1_idx` (`Cliente_CPF`),
  KEY `fk_alocacao_Pagamento1_idx` (`Confirma_IdPag`),
  KEY `fk_alocacao_Reserva1_idx` (`Reserva_IdRes`),
  KEY `fk_alocacao_Funcionario1_idx` (`Realiza_idFunc`),
  KEY `fk_alocacao_Funcionario2_idx` (`Aprova_idFunc`),
  CONSTRAINT `fk_alocacao_Cliente1` FOREIGN KEY (`Cliente_CPF`) REFERENCES `cliente` (`CPF`),
  CONSTRAINT `fk_alocacao_Funcionario1` FOREIGN KEY (`Realiza_idFunc`) REFERENCES `funcionario` (`idFunc`),
  CONSTRAINT `fk_alocacao_Funcionario2` FOREIGN KEY (`Aprova_idFunc`) REFERENCES `funcionario` (`idFunc`),
  CONSTRAINT `fk_alocacao_Pagamento1` FOREIGN KEY (`Confirma_IdPag`) REFERENCES `pagamento` (`IdPag`),
  CONSTRAINT `fk_alocacao_Reserva1` FOREIGN KEY (`Reserva_IdRes`) REFERENCES `reserva` (`IdRes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alocacao`
--

LOCK TABLES `alocacao` WRITE;
/*!40000 ALTER TABLE `alocacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `alocacao` ENABLE KEYS */;
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
