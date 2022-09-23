CREATE SEQUENCE seq_pedido;

 CREATE TABLE IF NOT EXISTS pedido (
    id integer NOT NULL DEFAULT nextval('seq_pedido'),
    descricao VARCHAR(255),
    hora Date,
    id_cliente_doador INT,
    id_cliente_beneficiario INT,
    
    PRIMARY KEY (id)
);

ALTER SEQUENCE seq_pedido
OWNED BY pedido.id;