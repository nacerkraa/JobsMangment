create database mag_db;

CREATE TABLE `User` (id bigint(20) NOT NULL AUTO_INCREMENT, nom varchar(255), prenom varchar(255), email varchar(255) NOT NULL UNIQUE, motPasse varchar(255), phone int(10), sexe varchar(15), age varchar(255), location varchar(255), type varchar(255), PRIMARY KEY (id));