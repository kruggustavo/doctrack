# Host: localhost  (Version 5.5.21)
# Date: 2018-06-02 17:00:20
# Generator: MySQL-Front 6.0  (Build 2.20)


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
# Structure for table "distritos"
#

DROP TABLE IF EXISTS `distritos`;
CREATE TABLE `distritos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "distritos"
#

INSERT INTO `distritos` VALUES (1,'Encarnacion');

#
# Structure for table "funcionarios"
#

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE `funcionarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(50) NOT NULL DEFAULT '',
  `direccion` varchar(50) DEFAULT '',
  `ci` varchar(50) DEFAULT '',
  `telefono` varchar(50) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "funcionarios"
#

INSERT INTO `funcionarios` VALUES (1,'Celso Ramirez','centro encarnacion','44452','00005','celso@gmail.com');

#
# Structure for table "logs"
#

DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_hora` datetime NOT NULL,
  `idUsuario` mediumint(9) DEFAULT NULL,
  `nivel` varchar(30) DEFAULT '',
  `mensaje` varchar(150) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "logs"
#

INSERT INTO `logs` VALUES (1,'2018-06-02 16:58:30',1,'INFO','Inicio de sesion');

#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) NOT NULL DEFAULT '',
  `Ingresa_documentos` enum('Si','No') NOT NULL DEFAULT 'No',
  `Transferir_documentos` enum('Si','No') NOT NULL DEFAULT 'No',
  `Cambiar_estado` enum('Si','No') NOT NULL DEFAULT 'No',
  `Cerrar_estado` enum('Si','No') NOT NULL DEFAULT 'No',
  `Generar_resoluciones` enum('Si','No') NOT NULL DEFAULT 'No',
  `Visualizar_informes` enum('Si','No') NOT NULL DEFAULT 'No',
  `Administra_configuraciones` enum('Si','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "roles"
#

INSERT INTO `roles` VALUES (1,'Administrador','No','No','No','No','No','No','Si');

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
# Structure for table "tipodocumento"
#

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE `tipodocumento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tipodocumento"
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
# Structure for table "documentos"
#

DROP TABLE IF EXISTS `documentos`;
CREATE TABLE `documentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL DEFAULT '',
  `fechaentrada` datetime NOT NULL,
  `observacion` varchar(255) NOT NULL DEFAULT '',
  `idSupervicion` bigint(20) NOT NULL,
  `idTramitante` bigint(20) NOT NULL,
  `idTipodoc` bigint(20) NOT NULL,
  `numero_doc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `fk_idSupervicion` (`idSupervicion`),
  KEY `fk_idTramitante` (`idTramitante`),
  KEY `fk_idTipodoc` (`idTipodoc`),
  CONSTRAINT `fk_idSupervicion` FOREIGN KEY (`idSupervicion`) REFERENCES `superviciones` (`id`),
  CONSTRAINT `fk_idTipodoc` FOREIGN KEY (`idTipodoc`) REFERENCES `tipodocumento` (`id`),
  CONSTRAINT `fk_idTramitante` FOREIGN KEY (`idTramitante`) REFERENCES `tramitantes` (`id`)
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
  `idSeguimiento` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idDependencia` (`idDependencia`),
  KEY `idArea` (`idArea`),
  KEY `idSeguimiento` (`idSeguimiento`),
  CONSTRAINT `gestiondocumentos_ibfk_1` FOREIGN KEY (`idDependencia`) REFERENCES `dependencias` (`id`),
  CONSTRAINT `gestiondocumentos_ibfk_2` FOREIGN KEY (`idArea`) REFERENCES `areas` (`id`),
  CONSTRAINT `gestiondocumentos_ibfk_3` FOREIGN KEY (`idSeguimiento`) REFERENCES `seguimiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "gestiondocumentos"
#


#
# Structure for table "respuesta"
#

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL,
  `numero` varchar(50) NOT NULL DEFAULT '',
  `dirigidoa` varchar(255) NOT NULL DEFAULT '',
  `remitente` varchar(255) NOT NULL DEFAULT '',
  `asunto` varchar(255) NOT NULL DEFAULT '',
  `redaccion` varchar(255) NOT NULL DEFAULT '',
  `idFuncionario` bigint(20) NOT NULL,
  `idSeguimiento` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idSeguimiento` (`idSeguimiento`),
  CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`idSeguimiento`) REFERENCES `seguimiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "respuesta"
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "usuarios"
#

INSERT INTO `usuarios` VALUES (1,'','admin','123',1);
