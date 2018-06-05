# Host: localhost  (Version 5.5.21)
# Date: 2018-06-05 15:02:18
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "dependencias"
#

INSERT INTO `dependencias` VALUES (1,'Equipo Técnico','sincorreo@gmail.com','001'),(2,'Asesoria Juridica','asesoria@gamil,com','000');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "areas"
#

INSERT INTO `areas` VALUES (1,'Nivel Inicial',1),(2,'Segundo Ciclo',1);

#
# Structure for table "distritos"
#

DROP TABLE IF EXISTS `distritos`;
CREATE TABLE `distritos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "distritos"
#

INSERT INTO `distritos` VALUES (1,'Encarnación'),(2,'Cambyreta');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "funcionarios"
#

INSERT INTO `funcionarios` VALUES (1,'Celso Ramirez','centro encarnacion','44452','00005','celso@gmail.com'),(2,'u','','','','');

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
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;

#
# Data for table "logs"
#

INSERT INTO `logs` VALUES (1,'2018-06-02 16:58:30',1,'INFO','Inicio de sesion'),(2,'2018-06-02 17:16:45',1,'INFO','Inicio de sesion'),(3,'2018-06-02 19:19:10',1,'INFO','Inicio de sesion'),(4,'2018-06-02 20:23:43',1,'INFO','Inicio de sesion'),(5,'2018-06-02 20:36:38',1,'INFO','Inicio de sesion'),(6,'2018-06-02 20:38:56',1,'INFO','Inicio de sesion'),(7,'2018-06-02 20:44:42',1,'INFO','Inicio de sesion'),(8,'2018-06-02 20:54:40',1,'INFO','Inicio de sesion'),(9,'2018-06-02 21:02:32',1,'INFO','Inicio de sesion'),(10,'2018-06-02 21:09:48',1,'INFO','Inicio de sesion'),(11,'2018-06-02 21:28:02',1,'INFO','Inicio de sesion'),(12,'2018-06-02 21:31:39',1,'INFO','Inicio de sesion'),(13,'2018-06-02 22:01:34',1,'INFO','Inicio de sesion'),(14,'2018-06-02 22:08:54',1,'INFO','Inicio de sesion'),(15,'2018-06-02 23:23:47',1,'INFO','Inicio de sesion'),(16,'2018-06-02 23:42:22',1,'INFO','Inicio de sesion'),(17,'2018-06-03 00:07:46',1,'INFO','Inicio de sesion'),(18,'2018-06-03 00:24:21',1,'INFO','Inicio de sesion'),(19,'2018-06-03 00:36:42',1,'INFO','Inicio de sesion'),(20,'2018-06-03 01:36:25',1,'INFO','Inicio de sesion'),(21,'2018-06-03 01:42:13',1,'INFO','Inicio de sesion'),(22,'2018-06-03 10:29:11',1,'INFO','Inicio de sesion'),(23,'2018-06-03 11:09:51',1,'INFO','Inicio de sesion'),(24,'2018-06-03 11:15:12',1,'INFO','Inicio de sesion'),(25,'2018-06-03 11:18:46',1,'INFO','Inicio de sesion'),(26,'2018-06-03 11:23:34',1,'INFO','Inicio de sesion'),(27,'2018-06-03 11:26:40',1,'INFO','Inicio de sesion'),(28,'2018-06-03 11:50:00',1,'INFO','Inicio de sesion'),(29,'2018-06-03 15:48:54',1,'INFO','Inicio de sesion'),(30,'2018-06-03 15:53:31',1,'INFO','Inicio de sesion'),(31,'2018-06-03 15:55:19',1,'INFO','Inicio de sesion'),(32,'2018-06-03 16:43:17',1,'INFO','Inicio de sesion'),(33,'2018-06-03 17:49:02',1,'INFO','Inicio de sesion'),(34,'2018-06-03 17:51:56',1,'INFO','Inicio de sesion'),(35,'2018-06-03 17:56:57',1,'INFO','Inicio de sesion'),(36,'2018-06-03 18:02:59',1,'INFO','Inicio de sesion'),(37,'2018-06-03 19:14:33',1,'INFO','Inicio de sesion'),(38,'2018-06-03 19:18:34',1,'INFO','Inicio de sesion'),(39,'2018-06-03 19:20:50',1,'INFO','Inicio de sesion'),(40,'2018-06-03 19:21:37',1,'INFO','Inicio de sesion'),(41,'2018-06-03 19:33:32',1,'INFO','Inicio de sesion'),(42,'2018-06-03 22:13:19',1,'INFO','Inicio de sesion'),(43,'2018-06-03 22:14:25',1,'INFO','Inicio de sesion'),(44,'2018-06-03 22:29:35',1,'INFO','Inicio de sesion'),(45,'2018-06-03 22:30:57',1,'INFO','Inicio de sesion'),(46,'2018-06-03 22:37:49',1,'INFO','Inicio de sesion'),(47,'2018-06-03 22:41:24',1,'INFO','Inicio de sesion'),(48,'2018-06-03 22:43:07',1,'INFO','Inicio de sesion'),(49,'2018-06-03 22:53:07',1,'INFO','Inicio de sesion'),(50,'2018-06-03 22:55:40',1,'INFO','Inicio de sesion'),(51,'2018-06-03 22:57:22',1,'INFO','Inicio de sesion'),(52,'2018-06-03 23:04:04',1,'INFO','Inicio de sesion'),(53,'2018-06-03 23:09:58',1,'INFO','Inicio de sesion'),(54,'2018-06-03 23:45:16',1,'INFO','Inicio de sesion'),(55,'2018-06-04 08:50:59',1,'INFO','Inicio de sesion'),(56,'2018-06-04 09:06:43',1,'INFO','Inicio de sesion'),(57,'2018-06-04 09:32:58',1,'INFO','Inicio de sesion'),(58,'2018-06-04 09:45:37',1,'INFO','Inicio de sesion'),(59,'2018-06-04 09:47:50',1,'INFO','Inicio de sesion'),(60,'2018-06-04 09:51:39',1,'INFO','Inicio de sesion'),(61,'2018-06-04 09:58:33',1,'INFO','Inicio de sesion'),(62,'2018-06-04 09:59:27',1,'INFO','Inicio de sesion'),(63,'2018-06-04 11:26:39',1,'INFO','Inicio de sesion'),(64,'2018-06-04 11:29:48',1,'INFO','Inicio de sesion'),(65,'2018-06-04 11:36:20',1,'INFO','Inicio de sesion'),(66,'2018-06-04 12:05:18',1,'INFO','Inicio de sesion'),(67,'2018-06-04 12:13:15',1,'INFO','Inicio de sesion'),(68,'2018-06-04 12:22:06',1,'INFO','Inicio de sesion'),(69,'2018-06-04 14:48:18',1,'INFO','Inicio de sesion'),(70,'2018-06-04 14:57:52',1,'INFO','Inicio de sesion'),(71,'2018-06-04 14:58:16',1,'DEBUG','Fill 1: created for Cherry'),(72,'2018-06-04 14:58:16',1,'DEBUG','created delayed actions 1 for filler 1'),(73,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry class net.sf.jasperreports.extensions.DefaultExtensionsRegistry'),(74,'2018-06-04 14:58:16',1,'DEBUG','Loading registries for cache key WebappClassLoader (delegate=true; repositories=WEB-INF/classes/)'),(75,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for date.range.clause.functions using factory class net.sf.jasperreports.types.date.DateRangeQueryClauseExtensions'),(76,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for repository using factory class net.sf.jasperreports.repo.DefaultRepositoryExtensionsRegistryFactory'),(77,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for parts using factory class net.sf.jasperreports.parts.PartComponentsExtensionsRegistryFactory'),(78,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for simple.font.families using factory class net.sf.jasperreports.engine.fonts.SimpleFontExtensionsRegistryFactory'),(79,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for castor.mapping using factory class net.sf.jasperreports.util.CastorMappingExtensionsRegistryFactory'),(80,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for governor using factory class net.sf.jasperreports.governors.GovernorExtensionsRegistryFactory'),(81,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for sql.clause.functions using factory class net.sf.jasperreports.engine.query.SQLQueryClauseFunctionsExtensions'),(82,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for jackson.mapping using factory class net.sf.jasperreports.web.util.JacksonMappingExtensionsRegistryFactory'),(83,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for default using factory class net.sf.jasperreports.extensions.DefaultExtensionsRegistryFactory'),(84,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for components using factory class net.sf.jasperreports.components.ComponentsExtensionsRegistryFactory'),(85,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for simple.font.families using factory class net.sf.jasperreports.engine.fonts.SimpleFontExtensionsRegistryFactory'),(86,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for date.range.clause.functions using factory class net.sf.jasperreports.types.date.DateRangeQueryClauseExtensions'),(87,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for repository using factory class net.sf.jasperreports.repo.DefaultRepositoryExtensionsRegistryFactory'),(88,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for parts using factory class net.sf.jasperreports.parts.PartComponentsExtensionsRegistryFactory'),(89,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for simple.font.families using factory class net.sf.jasperreports.engine.fonts.SimpleFontExtensionsRegistryFactory'),(90,'2018-06-04 14:58:16',1,'DEBUG','Instantiating extensions registry for castor.mapping using factory class net.sf.jasperreports.util.CastorMappingExtensionsRegistryFactory'),(91,'2018-06-04 14:58:17',1,'DEBUG','Instantiating extensions registry for governor using factory class net.sf.jasperreports.governors.GovernorExtensionsRegistryFactory'),(92,'2018-06-04 14:58:17',1,'DEBUG','Instantiating extensions registry for sql.clause.functions using factory class net.sf.jasperreports.engine.query.SQLQueryClauseFunctionsExtensions'),(93,'2018-06-04 14:58:17',1,'DEBUG','Instantiating extensions registry for jackson.mapping using factory class net.sf.jasperreports.web.util.JacksonMappingExtensionsRegistryFactory'),(94,'2018-06-04 14:58:17',1,'DEBUG','Instantiating extensions registry for default using factory class net.sf.jasperreports.extensions.DefaultExtensionsRegistryFactory'),(95,'2018-06-04 14:58:17',1,'DEBUG','Instantiating extensions registry for components using factory class net.sf.jasperreports.components.ComponentsExtensionsRegistryFactory'),(96,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: BACKGROUND} for band 1403707550'),(97,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: TITLE} for band 936769574'),(98,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: COLUMN_HEADER} for band 1847741474'),(99,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: DETAIL} for band 1013660439'),(100,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: COLUMN_FOOTER} for band 1176168624'),(101,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: PAGE_FOOTER} for band 404904895'),(102,'2018-06-04 14:58:17',1,'DEBUG','Origin {reportName: null, groupName: null,bandType: SUMMARY} for band 1694777453'),(103,'2018-06-04 14:58:17',1,'DEBUG','Filler 1 - pageHeight: 842, columnFooterOffsetY: 790, lastPageColumnFooterOffsetY: 815'),(104,'2018-06-04 14:58:17',1,'DEBUG','Fill 1: filling report'),(105,'2018-06-04 14:58:17',1,'DEBUG','Fill 1: Creating sql query executer'),(106,'2018-06-04 14:58:17',1,'DEBUG','DB is MySQL version 5.5.21 (5/5)'),(107,'2018-06-04 14:58:17',1,'DEBUG','driver is MySQL-AB JDBC Driver version mysql-connector-java-5.1.23 ( Revision: ${bzr.revision-id} ) (5/1)'),(108,'2018-06-04 14:58:17',1,'DEBUG','jdbc 4/0'),(109,'2018-06-04 14:58:17',1,'DEBUG','connection URL is jdbc:mysql://localhost:3306/doctrack?zeroDateTimeBehavior=convertToNull'),(110,'2018-06-04 14:58:18',1,'DEBUG','JDBC timezone parameter is null'),(111,'2018-06-04 14:58:18',1,'DEBUG','JDBC timezone property is null'),(112,'2018-06-04 14:58:18',1,'DEBUG','JDBC parameters timezone parameter is null'),(113,'2018-06-04 14:58:18',1,'DEBUG','JDBC parameters timezone property is null'),(114,'2018-06-04 14:58:18',1,'DEBUG','parameters timezone null'),(115,'2018-06-04 14:58:18',1,'DEBUG','JDBC fields timezone parameter is null'),(116,'2018-06-04 14:58:18',1,'DEBUG','JDBC fields timezone property is null'),(117,'2018-06-04 14:58:18',1,'DEBUG','fields timezone null'),(118,'2018-06-04 14:58:18',1,'DEBUG','Parameter #1 (fechaInicio of type java.util.Date): Mon Jun 04 00:00:00 PYT 2018'),(119,'2018-06-04 14:58:18',1,'DEBUG','setting date parameter 1 as Mon Jun 04 00:00:00 PYT 2018 (1528084800000) with calendar null'),(120,'2018-06-04 14:58:18',1,'DEBUG','Parameter #2 (fechaFin of type java.util.Date): Mon Jun 04 00:00:00 PYT 2018'),(121,'2018-06-04 14:58:18',1,'DEBUG','setting date parameter 2 as Mon Jun 04 00:00:00 PYT 2018 (1528084800000) with calendar null'),(122,'2018-06-04 14:58:18',1,'DEBUG','Parameter #3 (distrito of type java.lang.String): %'),(123,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.base.JRBaseStyle@67090652'),(124,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.base.JRBaseStyle@1ad542e5'),(125,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.base.JRBaseStyle@17cf34e8'),(126,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.base.JRBaseStyle@2a962e02'),(127,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.base.JRBaseStyle@4badde2d'),(128,'2018-06-04 14:58:18',1,'DEBUG','Fill 1: no data'),(129,'2018-06-04 14:58:18',1,'DEBUG','Fill 1: all sections'),(130,'2018-06-04 14:58:18',1,'DEBUG','Fill 1: adding page 1'),(131,'2018-06-04 14:58:18',1,'DEBUG','Fill 1: title at 20'),(132,'2018-06-04 14:58:18',1,'DEBUG','5c3301e7-a737-4c59-8a2f-a6c79fd1adb8: pattern timezone property net.sf.jasperreports.pattern.timezone is null, resolved to null'),(133,'2018-06-04 14:58:18',1,'DEBUG','5c3301e7-a737-4c59-8a2f-a6c79fd1adb8: formatted value Mon Jun 04 14:58:18 PYT 2018 (java.util.Date/1528138698647) to lunes 04 junio 2018'),(134,'2018-06-04 14:58:18',1,'DEBUG','creating element font infos cache of size 2000'),(135,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateFrame@2bd317'),(136,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@787b8a45'),(137,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@7c804480'),(138,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@768db325'),(139,'2018-06-04 14:58:18',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@2f293aef'),(140,'2018-06-04 14:58:18',1,'DEBUG','created net.sf.jasperreports.engine.fill.JRTemplateText@2f293aef for (null, null)'),(141,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateFrame@7d15d9bf'),(142,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@78c96226'),(143,'2018-06-04 14:58:19',1,'DEBUG','created net.sf.jasperreports.engine.fill.JRTemplateText@78c96226 for (null, {java.util.Date, EEEEE dd MMMMM yyyy,null,null,null})'),(144,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: BAND, group: null, band: 936769574}'),(145,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: BAND, group: null, band: 695965820}'),(146,'2018-06-04 14:58:19',1,'DEBUG','Fill 1: column header at 87'),(147,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@5dffd812'),(148,'2018-06-04 14:58:19',1,'DEBUG','Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@5dffd812 for object net.sf.jasperreports.engine.fill.JRTemplateText@1a5dcbd2'),(149,'2018-06-04 14:58:19',1,'DEBUG','Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@5dffd812 for object net.sf.jasperreports.engine.fill.JRTemplateText@42f0485e'),(150,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateLine@a1f34e5'),(151,'2018-06-04 14:58:19',1,'DEBUG','Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@5dffd812 for object net.sf.jasperreports.engine.fill.JRTemplateText@7982e7c1'),(152,'2018-06-04 14:58:19',1,'DEBUG','Found existing instance net.sf.jasperreports.engine.fill.JRTemplateText@5dffd812 for object net.sf.jasperreports.engine.fill.JRTemplateText@4fb9d230'),(153,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: BAND, group: null, band: 1847741474}'),(154,'2018-06-04 14:58:19',1,'DEBUG','Fill 1: column footer at 108'),(155,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: BAND, group: null, band: 1176168624}'),(156,'2018-06-04 14:58:19',1,'DEBUG','Fill 1: page footer at 797'),(157,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateFrame@ae16063'),(158,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@4c82d7bc'),(159,'2018-06-04 14:58:19',1,'DEBUG','created net.sf.jasperreports.engine.fill.JRTemplateText@4c82d7bc for (net.sf.jasperreports.engine.base.JRBaseStyle@17cf34e8, null)'),(160,'2018-06-04 14:58:19',1,'DEBUG','Added object net.sf.jasperreports.engine.fill.JRTemplateText@6eeb0385'),(161,'2018-06-04 14:58:19',1,'DEBUG','created net.sf.jasperreports.engine.fill.JRTemplateText@6eeb0385 for (net.sf.jasperreports.engine.base.JRBaseStyle@17cf34e8, null)'),(162,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: BAND, group: null, band: 404904895}'),(163,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: COLUMN, group: null, band: 0}'),(164,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: PAGE, group: null, band: 0}'),(165,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: REPORT, group: null, band: 0}'),(166,'2018-06-04 14:58:19',1,'DEBUG','1 running actions for page net.sf.jasperreports.engine.base.JRBasePrintPage@48937853 at 0'),(167,'2018-06-04 14:58:19',1,'DEBUG','1 running delayed actions on {type: MASTER, group: null, band: 0}'),(168,'2018-06-04 14:58:19',1,'DEBUG','Fill 1: ended'),(169,'2018-06-04 14:58:19',1,'DEBUG','Fill 1: closing query executer'),(170,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block DEVANAGARI'),(171,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block BENGALI'),(172,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block TELUGU'),(173,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block TAMIL'),(174,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block GUJARATI'),(175,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block KANNADA'),(176,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block MALAYALAM'),(177,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block ORIYA'),(178,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block GURMUKHI'),(179,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block SINHALA'),(180,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block TIBETAN'),(181,'2018-06-04 14:58:20',1,'DEBUG','glyph renderer block KHMER'),(182,'2018-06-04 17:20:16',1,'INFO','Inicio de sesion'),(183,'2018-06-04 17:22:44',1,'INFO','Inicio de sesion'),(184,'2018-06-04 17:26:00',1,'INFO','Inicio de sesion'),(185,'2018-06-04 17:54:10',1,'INFO','Inicio de sesion'),(186,'2018-06-04 18:33:14',1,'INFO','Inicio de sesion'),(187,'2018-06-04 19:20:22',1,'INFO','Inicio de sesion'),(188,'2018-06-04 20:19:09',1,'INFO','Inicio de sesion'),(189,'2018-06-04 20:24:17',1,'INFO','Inicio de sesion'),(190,'2018-06-05 10:49:11',1,'INFO','Inicio de sesion'),(191,'2018-06-05 10:53:37',1,'INFO','Inicio de sesion'),(192,'2018-06-05 10:56:40',1,'INFO','Inicio de sesion'),(193,'2018-06-05 11:02:41',1,'INFO','Inicio de sesion'),(194,'2018-06-05 11:11:09',1,'INFO','Inicio de sesion'),(195,'2018-06-05 11:13:30',1,'INFO','Inicio de sesion'),(196,'2018-06-05 11:16:55',1,'INFO','Inicio de sesion'),(197,'2018-06-05 11:24:18',1,'INFO','Inicio de sesion'),(198,'2018-06-05 11:25:22',1,'INFO','Creacion rol de usuario `Administrador`'),(199,'2018-06-05 11:25:53',1,'INFO','Creacion rol de usuario `Administrador`'),(200,'2018-06-05 11:27:09',1,'INFO','Creacion rol de usuario `Administrador`'),(201,'2018-06-05 11:33:00',1,'INFO','Inicio de sesion'),(202,'2018-06-05 13:23:06',1,'INFO','Inicio de sesion'),(203,'2018-06-05 13:36:37',1,'INFO','Inicio de sesion'),(204,'2018-06-05 13:42:34',1,'INFO','Inicio de sesion'),(205,'2018-06-05 13:47:43',1,'INFO','Inicio de sesion'),(206,'2018-06-05 14:01:11',1,'INFO','Inicio de sesion'),(207,'2018-06-05 14:17:17',1,'INFO','Inicio de sesion'),(208,'2018-06-05 14:22:54',1,'INFO','Inicio de sesion'),(209,'2018-06-05 14:30:28',1,'INFO','Inicio de sesion'),(210,'2018-06-05 14:33:08',1,'INFO','Inicio de sesion'),(211,'2018-06-05 14:38:06',1,'INFO','Inicio de sesion'),(212,'2018-06-05 14:39:20',1,'INFO','Inicio de sesion'),(213,'2018-06-05 14:44:46',1,'INFO','Inicio de sesion'),(214,'2018-06-05 14:47:26',1,'INFO','Inicio de sesion'),(215,'2018-06-05 14:52:02',1,'INFO','Inicio de sesion'),(216,'2018-06-05 14:54:27',1,'INFO','Inicio de sesion');

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

INSERT INTO `roles` VALUES (1,'Administrador','Si','Si','Si','Si','Si','Si','Si');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "superviciones"
#

INSERT INTO `superviciones` VALUES (1,'1','Carlos A. López','00000','sinemail',1,1),(2,'2','Encarnación','(0000) 000-000','sup2@gmail.co1',1,1);

#
# Structure for table "tipodocumento"
#

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE `tipodocumento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "tipodocumento"
#

INSERT INTO `tipodocumento` VALUES (1,'Primer tipo de documento'),(2,'Nota');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "tramitantes"
#

INSERT INTO `tramitantes` VALUES (1,'Tramitante de Pruebas','su direccion de prueba','0000000-1','(0000) 000-000','correo@deprueba');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "documentos"
#

INSERT INTO `documentos` VALUES (1,'probar Documento','2018-06-03 23:05:26','sin obs',1,1,1,'0000129'),(2,'segundo documento','2018-06-03 23:10:24','sin obs',1,1,1,'0000130'),(3,'probar doc con respuesta','2018-06-05 11:33:53','sin obs',1,1,1,'55255'),(4,'a responder','2018-06-05 13:38:32','gfds',1,1,1,'236'),(5,'con nuevo campo','2018-06-05 13:42:51','gfrvd',1,1,1,'55432'),(6,'conseguimiento','2018-06-05 14:07:19','fdcs',1,1,1,'2222'),(7,'probar seguimiento','2018-06-05 14:39:43','rfed',1,1,1,'55252');

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
  `NuevoCampo` enum('Si','No') NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id`),
  KEY `idDocumento` (`idDocumento`),
  CONSTRAINT `seguimiento_ibfk_1` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "seguimiento"
#

INSERT INTO `seguimiento` VALUES (1,'2018-06-03 23:05:26','2018-06-03 23:05:26','Concluido','probar Documento',1,'Si'),(2,'2018-06-03 23:10:24','2018-06-05 11:28:19','Concluido','segundo documento',2,'Si'),(3,'2018-06-05 13:42:51','2018-06-05 14:47:44','Concluido','con nuevo campo',5,'Si'),(4,'2018-06-05 14:07:19','2018-06-05 14:07:19','Recibido','conseguimiento',6,'No'),(5,'2018-06-05 14:39:43','2018-06-05 14:39:43','Recibido','probar seguimiento',7,'No');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "gestiondocumentos"
#

INSERT INTO `gestiondocumentos` VALUES (1,'2018-06-03 23:05:26','asunto prueba','sin obs','Procesado',1,1,1),(2,'2018-06-03 10:33:00','asunto2','sin obs','Procesado',1,2,1),(3,'2018-06-03 10:36:00','asunto prueba2','sin obs','Procesado',1,1,2),(4,'2018-06-03 10:37:00','asunto2 prueba2','sin obs','Procesado',1,2,2),(5,'2018-06-04 12:13:34','srfe','rewds','Concluido',1,1,1),(6,'2018-06-04 17:28:40','sin obs probar','sin obs probar','Concluido',1,2,2),(7,'2018-06-05 14:23:31','dxfd','fdgfd','Procesado',1,1,3),(8,'2018-06-05 14:30:41','fds','fd','Concluido',1,2,3);

#
# Structure for table "respuesta"
#

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL,
  `numero` varchar(50) NOT NULL DEFAULT '',
  `dirigidoa` varchar(255) NOT NULL DEFAULT '',
  `asunto` varchar(255) NOT NULL DEFAULT '',
  `idFuncionario` bigint(20) NOT NULL,
  `idSeguimiento` bigint(20) NOT NULL,
  `idTipoDoc` bigint(20) NOT NULL,
  `redaccion` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idSeguimiento` (`idSeguimiento`),
  KEY `idTipoDoc` (`idTipoDoc`),
  CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`id`),
  CONSTRAINT `respuesta_ibfk_2` FOREIGN KEY (`idSeguimiento`) REFERENCES `seguimiento` (`id`),
  CONSTRAINT `respuesta_ibfk_3` FOREIGN KEY (`idTipoDoc`) REFERENCES `tipodocumento` (`id`)
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
