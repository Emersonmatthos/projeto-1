/* Lógico_2: */

CREATE TABLE cliente (
    id_cliente int PRIMARY KEY,
    nome_cliente varchar(80),
    email varchar(80)
);

CREATE TABLE passagens (
    id_passagens int PRIMARY KEY,
    data_passagem varchar(80),
    valor_passagens varchar(80),
    fk_cliente_id_cliente int,
    fk_destinos_id_destinos int
);

CREATE TABLE destinos (
    id_destinos int PRIMARY KEY,
    cidade_destinos varchar(80),
    estados_destinos varchar(80)
);
 
ALTER TABLE passagens ADD CONSTRAINT FK_passagens_2
    FOREIGN KEY (fk_cliente_id_cliente)
    REFERENCES cliente (id_cliente)
    ON DELETE CASCADE;
 
ALTER TABLE passagens ADD CONSTRAINT FK_passagens_3
    FOREIGN KEY (fk_destinos_id_destinos)
    REFERENCES destinos (id_destinos)
    ON DELETE CASCADE;