CREATE SEQUENCE seq_cliente_doador;

CREATE TABLE IF NOT EXISTS cliente_doador (
    id integer NOT NULL DEFAULT nextval('seq_cliente_doador'),
    nome  VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    senha VARCHAR(255),
    cpf VARCHAR(255),
    PRIMARY KEY (id)
);

ALTER SEQUENCE seq_cliente_doador
OWNED BY cliente_doador.id;