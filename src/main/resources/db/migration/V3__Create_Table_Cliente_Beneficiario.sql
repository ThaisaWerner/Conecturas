CREATE SEQUENCE seq_cliente_beneficiario;

CREATE TABLE IF NOT EXISTS cliente_beneficiario (
   id integer NOT NULL DEFAULT nextval('seq_cliente_beneficiario'),
    nome  VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    senha VARCHAR(255),
    endereco VARCHAR(255),
    cpf VARCHAR(255),
    PRIMARY KEY (id)
);

ALTER SEQUENCE seq_cliente_beneficiario
OWNED BY cliente_beneficiario.id;