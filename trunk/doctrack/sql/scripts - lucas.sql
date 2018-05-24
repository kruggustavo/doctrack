# Host: localhost  (Version 5.5.21)
# Date: 2018-05-24 14:33:57
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "areas"
#

DROP TABLE IF EXISTS `areas`;
CREATE TABLE `areas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL DEFAULT '',
  `idDependencia` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDependencia` (`idDependencia`),
  CONSTRAINT `areas_ibfk_1` FOREIGN KEY (`idDependencia`) REFERENCES `dependencias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "areas"
#


#
# Structure for table "dependencias"
#

DROP TABLE IF EXISTS `dependencias`;
CREATE TABLE `dependencias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `interno` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "dependencias"
#


#
# Structure for table "distritos"
#

DROP TABLE IF EXISTS `distritos`;
CREATE TABLE `distritos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "distritos"
#


#
# Structure for table "funcionarios"
#

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE `funcionarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) NOT NULL DEFAULT '',
  `direccion` varchar(50) NOT NULL DEFAULT '',
  `ci` varchar(50) NOT NULL DEFAULT '',
  `telefono` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "funcionarios"
#


#
# Structure for table "gestiondocumentos"
#

DROP TABLE IF EXISTS `gestiondocumentos`;
CREATE TABLE `gestiondocumentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `asunto` varchar(255) NOT NULL DEFAULT '',
  `observacion` varchar(255) NOT NULL DEFAULT '',
  `estadogestion` varchar(255) NOT NULL DEFAULT '',
  `idDependencia` bigint(20) NOT NULL,
  `idArea` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDependencia` (`idDependencia`),
  KEY `idArea` (`idArea`),
  CONSTRAINT `gestiondocumentos_ibfk_1` FOREIGN KEY (`idDependencia`) REFERENCES `dependencias` (`id`),
  CONSTRAINT `gestiondocumentos_ibfk_2` FOREIGN KEY (`idArea`) REFERENCES `areas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "gestiondocumentos"
#


#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "roles"
#


#
# Structure for table "superviciones"
#

DROP TABLE IF EXISTS `superviciones`;
CREATE TABLE `superviciones` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_supervision` varchar(50) NOT NULL DEFAULT '',
  `direccion` varchar(50) NOT NULL DEFAULT '',
  `telefono` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `idFuncionario` bigint(20) NOT NULL,
  `idDistrito` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idDistrito` (`idDistrito`),
  CONSTRAINT `superviciones_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `superviciones_ibfk_2` FOREIGN KEY (`idDistrito`) REFERENCES `distritos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "superviciones"
#


#
# Structure for table "documentos"
#

DROP TABLE IF EXISTS `documentos`;
CREATE TABLE `documentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL DEFAULT '',
  `fechaentrada` datetime NOT NULL,
  `observacion` varchar(255) NOT NULL DEFAULT '',
  `idSupervicion` bigint(20) NOT NULL,
  `idFuncionario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idSupervicion` (`idSupervicion`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`idSupervicion`) REFERENCES `superviciones` (`id`),
  CONSTRAINT `documentos_ibfk_2` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "documentos"
#


#
# Structure for table "seguimiento"
#

DROP TABLE IF EXISTS `seguimiento`;
CREATE TABLE `seguimiento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaentrada` datetime NOT NULL,
  `fechasalido` datetime NOT NULL,
  `estadogeneral` varchar(50) NOT NULL DEFAULT '',
  `descripcion` varchar(255) NOT NULL DEFAULT '',
  `idDocumento` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDocumento` (`idDocumento`),
  CONSTRAINT `seguimiento_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "seguimiento"
#


#
# Structure for table "resolucion"
#

DROP TABLE IF EXISTS `resolucion`;
CREATE TABLE `resolucion` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL,
  `numero` varchar(50) NOT NULL DEFAULT '',
  `resuelve` varchar(255) NOT NULL DEFAULT '',
  `visto` varchar(255) NOT NULL DEFAULT '',
  `idFuncionario` bigint(20) NOT NULL,
  `idSeguimiento` bigint(20) NOT NULL,
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idSeguimiento` (`idSeguimiento`),
  CONSTRAINT `resolucion_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `resolucion_ibfk_2` FOREIGN KEY (`idSeguimiento`) REFERENCES `seguimiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "resolucion"
#


#
# Structure for table "tipodocumento"
#

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE `tipodocumento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tipodocumento"
#


#
# Structure for table "adjuntos"
#

DROP TABLE IF EXISTS `adjuntos`;
CREATE TABLE `adjuntos` (
  `nombredoc_adj` varchar(255) NOT NULL DEFAULT '',
  `idTipodoc` bigint(20) NOT NULL,
  `idDocumento` bigint(20) NOT NULL,
  KEY `idTipodoc` (`idTipodoc`),
  KEY `idDocumento` (`idDocumento`),
  CONSTRAINT `adjuntos_ibfk_1` FOREIGN KEY (`idTipodoc`) REFERENCES `tipodocumento` (`id`),
  CONSTRAINT `adjuntos_ibfk_2` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "adjuntos"
#


#
# Structure for table "tramitantes"
#

DROP TABLE IF EXISTS `tramitantes`;
CREATE TABLE `tramitantes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) NOT NULL DEFAULT '',
  `direccion` varchar(50) NOT NULL DEFAULT '',
  `ci` varchar(50) NOT NULL DEFAULT '',
  `telefono` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "tramitantes"
#


#
# Structure for table "usuarios"
#

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Nombre_completo` varchar(50) NOT NULL DEFAULT '',
  `Alias` varchar(30) NOT NULL DEFAULT '',
  `Clave` varchar(30) NOT NULL DEFAULT '',
  `idRol` mediumint(9) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "usuarios"
#

