DROP DATABASE IF EXISTS TheLegendOfJava;

CREATE DATABASE TheLegendOfJava;

USE TheLegendOfJava;

CREATE TABLE winner(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    map_name VARCHAR(50) NOT NULL,
    elapsed_time VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO winner (name, map_name, elapsed_time) VALUES
('Pere', "Tutorial", "00:14:24"),
('Artem', "La cueva de los kesse", "00:14:00"),
('Manu', "La cueva de los kesse", "00:05:24"),
('Santi', "Bosque Kokori", "00:15:24");