-- DROP DATABASE IF EXISTS agenda_pro;
-- CREATE DATABASE agenda_pro;
-- USE agenda_pro;

DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS estadistica;
DROP TABLE IF EXISTS marca;
DROP TABLE IF EXISTS usuario;

CREATE TABLE categoria (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    CONSTRAINT PK_categoria PRIMARY KEY (id)
);

CREATE TABLE estadistica (
    id INT,
    cantidad INT NOT NULL,
    CONSTRAINT PK_estadistica PRIMARY KEY (id)
);

CREATE TABLE marca (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    CONSTRAINT PK_marca PRIMARY KEY (id)
);

CREATE TABLE producto (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    cantidad INTEGER NOT NULL,
    precio FLOAT(53) NOT NULL,
    fecha_creacion TIMESTAMP(6) NOT NULL,
    categoria_id INTEGER,
    marca_id INTEGER,
    CONSTRAINT PK_producto PRIMARY KEY (id),
    CONSTRAINT FK_producto_y_categoria FOREIGN KEY (categoria_id)
       REFERENCES categoria (id),
    CONSTRAINT FK_producto_y_marca FOREIGN KEY (marca_id)
       REFERENCES marca (id)
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255) UNIQUE NOT NULL,
    clave VARCHAR(255) NOT NULL,
    rol VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL,
    CONSTRAINT PK_usuario PRIMARY KEY (id)
);