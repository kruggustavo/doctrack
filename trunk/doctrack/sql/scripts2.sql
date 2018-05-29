use doctrack;

DROP TABLE IF EXISTS `areas`;
CREATE TABLE `areas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL DEFAULT '',
  `idDependencia` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idDependencia` (`idDependencia`),
  CONSTRAINT `areas_ibfk_1` FOREIGN KEY (`idDependencia`) REFERENCES `dependencias` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `dependencias`;
CREATE TABLE `dependencias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `interno` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `distritos`;
CREATE TABLE `distritos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `distritos` VALUES (1,'Encarnacion');

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

INSERT INTO `funcionarios` VALUES (1,'Celso Ramirez','centro encarnacion','44452','00005','celso@gmail.com');

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

INSERT INTO `superviciones` VALUES (1,'5','carlos antonio lopez','5552','suemail@gmail.com',1,1);

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE `tipodocumento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `tipodocumento` VALUES (1,'nota ac'),(2,'nueva nota');

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

INSERT INTO `tramitantes` VALUES (1,'Juan Perez','su casa','000','0005','juan@gmail.com'),(2,'nuevo tramitantes','su casa','552','545','suemail@gmail.com');

DROP TABLE IF EXISTS `documentos`;
CREATE TABLE `documentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL DEFAULT '',
  `fechaentrada` datetime NOT NULL,
  `observacion` varchar(255) NOT NULL DEFAULT '',
  `idSupervicion` bigint(20) NOT NULL,
  `idTramitante` bigint(20) NOT NULL,
  `numero_doc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `fk_idSupervicion` (`idSupervicion`),
  KEY `fk_idTramitante` (`idTramitante`),
  CONSTRAINT `fk_idSupervicion` FOREIGN KEY (`idSupervicion`) REFERENCES `superviciones` (`id`),
  CONSTRAINT `fk_idTramitante` FOREIGN KEY (`idTramitante`) REFERENCES `tramitantes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `documentos` VALUES (1,'documento prueba','2018-05-29 01:30:00','sin obs',1,1,'00025/18');

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


DROP TABLE IF EXISTS `resolucion`;
CREATE TABLE `resolucion` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL,
  `numero` varchar(50) NOT NULL DEFAULT '',
  `resuelve` varchar(255) NOT NULL DEFAULT '',
  `visto` varchar(255) NOT NULL DEFAULT '',
  `idFuncionario` bigint(20) NOT NULL,
  `idSeguimiento` bigint(20) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idSeguimiento` (`idSeguimiento`),
  CONSTRAINT `resolucion_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `resolucion_ibfk_2` FOREIGN KEY (`idSeguimiento`) REFERENCES `seguimiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usuarios`;
DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) NOT NULL DEFAULT '',
  `Ingresa_documentos` enum('Si','No') not null DEFAULT 'No',
  `Transferir_documentos` enum('Si','No') not null DEFAULT 'No',
  `Cambiar_estado` enum('Si','No') not null DEFAULT 'No',
  `Cerrar_estado` enum('Si','No') not null DEFAULT 'No',
  `Generar_resoluciones` enum('Si','No') not null DEFAULT 'No',
  `Visualizar_informes` enum('Si','No') not null DEFAULT 'No',
  `Administra_configuraciones` enum('Si','No') not null DEFAULT 'No',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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