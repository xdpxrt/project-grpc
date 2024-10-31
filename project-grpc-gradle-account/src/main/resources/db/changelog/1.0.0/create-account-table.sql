--liquibase formatted sql
--changeset xd_pxrt:1  logicalFilePath:1.0.0/create-account-table.sql
CREATE TABLE IF NOT EXISTS account(
    id                UUID           DEFAULT uuid_generate_v4(),
    client_id         UUID           NOT NULL,
    currency          VARCHAR(3)     NOT NULL,
    balance           DECIMAL(19, 4) NOT NULL,

    CONSTRAINT pk_account_id PRIMARY KEY (id),
    CONSTRAINT ch_account_currency_code CHECK (currency IN ('RUB', 'USD', 'EUR'))
);

--rollback DROP TABLE account