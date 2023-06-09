--liquibase formatted sql

--changeset mmichalenok:1
CREATE TABLE IF NOT EXISTS revision
(
    id SERIAL PRIMARY KEY,
    timestamp BIGINT NOT NULL
);

--changeset mmichalenok:2
CREATE TABLE IF NOT EXISTS users_aud
(
    id  BIGINT,
    rev INT REFERENCES revision (id),
    revtype SMALLINT,
    username VARCHAR(64) NOT NULL UNIQUE,
    birth_date DATE,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    role VARCHAR(64),
    company_id INT
);