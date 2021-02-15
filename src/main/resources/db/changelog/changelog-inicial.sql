--liquibase formatted sql

--changeset hiko:1
--comment: creación de las tablas iniciales

-- tabla que registra los datos del estudiante
 CREATE TABLE estudiante (
	id INT PRIMARY KEY AUTO_INCREMENT,
    numero_identificacion VARCHAR(40) NOT NULL UNIQUE, 
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE
 );
 
-- tabla que registra la cantidad de puestos del parqueadero
 CREATE TABLE puesto (
 	id INT PRIMARY KEY AUTO_INCREMENT,
    lugar VARCHAR(50) NOT NULL,
    disponibilidad BOOLEAN  NOT NULL DEFAULT TRUE
);

-- tabla que registra la asignacion del puesto que ocupa determinado estudiante
CREATE TABLE puesto_estudiante (
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_estudiante INT NOT NULL,
    FOREIGN KEY(id_estudiante) REFERENCES estudiante(id),
    id_puesto INT NOT NULL,
    FOREIGN KEY(id_puesto) REFERENCES puesto(id),
    estado BOOLEAN NOT NULL DEFAULT TRUE
    );

--changeset hiko:2
--comment: datos de la tabla puesto

INSERT INTO puesto (lugar) VALUES
("Puesto Uno"),
("Puesto Dos"),
("Puesto Tres"),
("Puesto Cuatro"),
("Puesto Cinco"),
("Puesto Seis"),
("Puesto Siente"),
("Puesto Ocho"),
("Puesto Nueve"),
("Puesto Diez");

INSERT INTO estudiante (numero_identificacion, nombre, apellido, telefono) VALUES
("1080185723", "Carlos Humberto", "Caceres Molano", "3024678589"),
("1075287422", "Miguel Antonio", "Puentes Lozada", "3024678583"),
("1084685723", "Fernando", "Ipuz Montalbo", "3154678589"),
("1080186783", "Armin", "Pool Fernandez", "3184678589");



