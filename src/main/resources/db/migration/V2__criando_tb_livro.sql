CREATE TABLE tb_livro (
    id BIGINT auto_increment PRIMARY KEY,
    nome VARCHAR (255) UNIQUE not null,
    id_cliente BIGINT not null,
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id)

);
