--liquibase formatted sql
--changeset xd_pxrt:1  logicalFilePath:1.0.0/create-user-table.sql
CREATE TABLE IF NOT EXISTS usero (
    id                UUID           DEFAULT uuid_generate_v4(),
    username          VARCHAR(15)    NOT NULL,
    password          VARCHAR(15)    NOT NULL,
    email             VARCHAR        NOT NULL,
    birthday          DATE,

    CONSTRAINT pk_user_id PRIMARY KEY (id)
);

--rollback DROP TABLE user
