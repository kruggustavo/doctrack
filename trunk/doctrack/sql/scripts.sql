CREATE TABLE roles (
  id mediumint(9) NOT NULL AUTO_INCREMENT,
  Descripcion varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE usuarios (
     id MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
     Nombre_completo varCHAR(50) NOT NULL default '',
     Alias varchar(30) not null default '',
     Clave varchar(30) not null default '', 
     idRol MEDIUMINT NOT NULL,
     FOREIGN KEY (idRol) REFERENCES roles(id)
);