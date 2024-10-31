--liquibase formatted sql
--changeset xd_pxrt:1 logicalFilePath:1.0.0/uuid-ext.sql

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
