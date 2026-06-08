CREATE DATABASE videojuegos;

USE videojuegos;

CREATE TABLE juegos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    empresa_creadora VARCHAR(100),
    precio INT,
    fecha_salida INT,
    valoracion INT
);