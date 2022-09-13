CREATE TABLE IF NOT EXISTS Cliente_Doador (
    id INT AUTO_INCREMENT,
    nome  VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    senha VARCHAR(255),
    endereco double,
    cpf VARCHAR(255),
    PRIMARY KEY (id)
);