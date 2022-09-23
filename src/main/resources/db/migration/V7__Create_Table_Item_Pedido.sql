CREATE TABLE item_pedido (
    id_pedido INT  NOT NULL,
    id_livro INT NOT NULL,
    PRIMARY KEY (id_pedido, id_livro),
    CONSTRAINT constr_item_pedido_pedido_fk
        FOREIGN KEY(id_pedido) REFERENCES pedido (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT constr_item_pedido_livro_fk
            FOREIGN KEY(id_livro) REFERENCES livro (id)
            ON DELETE CASCADE ON UPDATE CASCADE
);