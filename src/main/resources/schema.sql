-- Script de creación de las tablas
CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(20),
  apellido VARCHAR(20),
  edad INT
);