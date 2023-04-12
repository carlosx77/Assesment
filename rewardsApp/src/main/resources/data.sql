DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE ctransaction (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    CONSTRAINT ctransaction_fk_customer_id FOREIGN KEY (customer_id)
        REFERENCES customer (id)
);
