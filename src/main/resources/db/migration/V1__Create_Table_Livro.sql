CREATE SEQUENCE seq_livros;

CREATE TABLE IF NOT EXISTS livro (
    id integer NOT NULL DEFAULT nextval('seq_livros'),
    titulo  VARCHAR(255) NOT NULL,
    genero_literario VARCHAR(255),
    descricao VARCHAR(255),
    preco DECIMAL,
    autor VARCHAR(255),
    classificacao_etaria VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER SEQUENCE seq_livros
OWNED BY livro.id;