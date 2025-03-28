-- Создается база данных, если она не существует
CREATE DATABASE IF NOT EXISTS jpa_tutorial;

-- Используется база данных с названием jpa_tutorial
USE jpa_tutorial;

-- Создается таблица "persons"
CREATE TABLE IF NOT EXISTS persons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL
    );

-- Выборочно, возможны исходные данные
-- INSERT INTO persons (first_name, last_name, age) VALUES ('John', 'Doe', 30);
