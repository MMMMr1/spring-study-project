--liquibase formatted sql

--changeset mmichalenok:1
ALTER TABLE users_aud
DROP CONSTRAINT users_aud_username_key;

--changeset mmichalenok:2
ALTER TABLE users_aud
ALTER COLUMN username DROP NOT NULL;