--liquibase formatted sql

--changeset nfisher:1
CREATE TABLE public.user
(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT FALSE
);

--rollback DROP TABLE user;