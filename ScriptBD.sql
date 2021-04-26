CREATE database db_tienda_libros;

use  db_tienda_libros;


CREATE TABLE categoria(
id_categoria MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion VARCHAR(150) NOT NULL,
tarifa DOUBLE NOT NULL
);

CREATE TABLE libro(
id_libro MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(150) NOT NULL,
autor  VARCHAR(150) NOT NULL,
categoria MEDIUMINT NOT NULL,
cantidad_disponible INT NOT NULL,
cantidad_reservada INT NOT NULL,
FOREIGN KEY (categoria) REFERENCES categoria(id_categoria)
);


CREATE TABLE rol(
id_rol MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion VARCHAR(150) NOT NULL
);


CREATE TABLE usuario(

correo_electronico VARCHAR(150) NOT NULL PRIMARY KEY ,
contrasena VARCHAR(150) NOT NULL,
contrasena_encriptada  VARCHAR(150) NOT NULL,
rol MEDIUMINT NOT NULL,
FOREIGN KEY (rol) REFERENCES rol(id_rol)
);

CREATE TABLE cliente(
cedula BIGINT NOT NULL PRIMARY KEY,
usuario VARCHAR(150) NOT NULL,
nombre  VARCHAR(150) NOT NULL,
apellidos VARCHAR(150) NOT NULL,
telefono VARCHAR(150) NOT NULL,
direccion VARCHAR(150) NOT NULL,
edad INT NOT NULL,
FOREIGN KEY (usuario) REFERENCES usuario(correo_electronico)
);

CREATE TABLE prestamo(
id_prestamo MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cliente BIGINT NOT NULL,
libro  MEDIUMINT NOT NULL,
fecha_prestamo DATE NOT NULL,
fecha_devolucion DATE NOT NULL,
tarifa_total DOUBLE NOT NULL,
FOREIGN KEY (libro) REFERENCES libro(id_libro),
FOREIGN KEY (cliente) REFERENCES cliente(cedula)
);


drop table prestamo;
drop table cliente;
drop table libro;
drop table usuario;
drop table rol;
drop table categoria;

select * from categoria;
select * from libro;
select * from rol;
select * from usuario;
select * from cliente;
select * from prestamo;


RENAME TABLE usuarios TO usuario
