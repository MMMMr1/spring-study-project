--liquibase formatted sql

--changeset mmichalenok:1
ALTER TABLE users
ADD created_at TIMESTAMP;
ALTER TABLE users
ADD COLUMN modified_at timestamp;
ALTER TABLE users
ADD created_by VARCHAR(32);
ALTER TABLE users
ADD COLUMN modified_by VARCHAR(32);