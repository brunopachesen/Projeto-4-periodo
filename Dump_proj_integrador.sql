-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proj_integrador
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `tb_automovel`
--

create database proj_integrador;

use proj_integrador;

DROP TABLE IF EXISTS `tb_automovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_automovel` (
  `id_auto` int(11) NOT NULL AUTO_INCREMENT,
  `id_mod` int(11) NOT NULL,
  `cor` varchar(20) DEFAULT NULL,
  `chassi` varchar(20) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_auto`),
  KEY `id_mod` (`id_mod`),
  CONSTRAINT `tb_automovel_ibfk_1` FOREIGN KEY (`id_mod`) REFERENCES `tb_modelo` (`id_mod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_automovel`
--

LOCK TABLES `tb_automovel` WRITE;
/*!40000 ALTER TABLE `tb_automovel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_automovel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cidade`
--

DROP TABLE IF EXISTS `tb_cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cidade` (
  `id_cid` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cid` varchar(40) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cidade`
--

LOCK TABLES `tb_cidade` WRITE;
/*!40000 ALTER TABLE `tb_cidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente` (
  `id_cli` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cli` varchar(40) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `id_auto` int(11) NOT NULL,
  `id_end` int(11) NOT NULL,
  PRIMARY KEY (`id_cli`),
  KEY `id_auto` (`id_auto`),
  KEY `id_end` (`id_end`),
  CONSTRAINT `tb_cliente_ibfk_1` FOREIGN KEY (`id_auto`) REFERENCES `tb_automovel` (`id_auto`),
  CONSTRAINT `tb_cliente_ibfk_2` FOREIGN KEY (`id_end`) REFERENCES `tb_endereco` (`id_end`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_concessionaria`
--

DROP TABLE IF EXISTS `tb_concessionaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_concessionaria` (
  `id_conc` int(11) NOT NULL AUTO_INCREMENT,
  `nome_conc` varchar(40) DEFAULT NULL,
  `cnpj` varchar(15) DEFAULT NULL,
  `id_end` int(11) NOT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `id_cid` int(11) NOT NULL,
  PRIMARY KEY (`id_conc`),
  KEY `id_cid` (`id_cid`),
  KEY `id_end` (`id_end`),
  CONSTRAINT `tb_concessionaria_ibfk_1` FOREIGN KEY (`id_cid`) REFERENCES `tb_cidade` (`id_cid`),
  CONSTRAINT `tb_concessionaria_ibfk_2` FOREIGN KEY (`id_end`) REFERENCES `tb_endereco` (`id_end`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_concessionaria`
--

LOCK TABLES `tb_concessionaria` WRITE;
/*!40000 ALTER TABLE `tb_concessionaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_concessionaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_endereco` (
  `id_end` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `id_cid` int(11) NOT NULL,
  PRIMARY KEY (`id_end`),
  KEY `id_cid` (`id_cid`),
  CONSTRAINT `tb_endereco_ibfk_1` FOREIGN KEY (`id_cid`) REFERENCES `tb_cidade` (`id_cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fornecedor`
--

DROP TABLE IF EXISTS `tb_fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_fornecedor` (
  `id_forn` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(15) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `id_end` int(11) NOT NULL,
  PRIMARY KEY (`id_forn`),
  KEY `id_end` (`id_end`),
  CONSTRAINT `tb_fornecedor_ibfk_1` FOREIGN KEY (`id_end`) REFERENCES `tb_endereco` (`id_end`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fornecedor`
--

LOCK TABLES `tb_fornecedor` WRITE;
/*!40000 ALTER TABLE `tb_fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_modelo`
--

DROP TABLE IF EXISTS `tb_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_modelo` (
  `id_mod` int(11) NOT NULL AUTO_INCREMENT,
  `nome_mod` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_mod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_modelo`
--

LOCK TABLES `tb_modelo` WRITE;
/*!40000 ALTER TABLE `tb_modelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_montadora`
--

DROP TABLE IF EXISTS `tb_montadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_montadora` (
  `id_mont` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `cnpj` varchar(15) DEFAULT NULL,
  `tel` varchar(10) DEFAULT NULL,
  `id_end` int(11) NOT NULL,
  `id_cid` int(11) NOT NULL,
  PRIMARY KEY (`id_mont`),
  KEY `id_cid` (`id_cid`),
  KEY `id_end` (`id_end`),
  CONSTRAINT `tb_montadora_ibfk_1` FOREIGN KEY (`id_cid`) REFERENCES `tb_cidade` (`id_cid`),
  CONSTRAINT `tb_montadora_ibfk_2` FOREIGN KEY (`id_end`) REFERENCES `tb_endereco` (`id_end`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_montadora`
--

LOCK TABLES `tb_montadora` WRITE;
/*!40000 ALTER TABLE `tb_montadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_montadora` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-22 20:44:08
