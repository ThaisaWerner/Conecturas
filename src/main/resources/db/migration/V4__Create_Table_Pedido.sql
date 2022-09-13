 CREATE TABLE IF NOT EXISTS pedido (
    id INT AUTO_INCREMENT,
    total  INT NOT NULL,
    descricao VARCHAR(255),
    hora Date,
    formaPagamento VARCHAR(255),
    id_cliente_doador INT,
    id_cliente_beneficiario INT,
    
    PRIMARY KEY (id)
);