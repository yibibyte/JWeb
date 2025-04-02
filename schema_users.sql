CREATE TABLE users (
    login VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INTEGER CHECK (age >= 0),
    email VARCHAR(100) UNIQUE NOT NULL
);