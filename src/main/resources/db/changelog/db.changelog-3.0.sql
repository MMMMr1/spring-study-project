--liquibase formatted sql

--changeset mmichalenok:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset mmichalenok:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64);
