-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS trabalhoa3;
USE trabalhoa3;

-- Criação da tabela categoria
CREATE TABLE IF NOT EXISTS categoria (
   id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tamanho ENUM('PEQUENO', 'MEDIO', 'GRANDE') NOT NULL,
    embalagem ENUM('PLASTICO', 'LATA', 'VIDRO') NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

-- Criação da tabela produto
CREATE TABLE IF NOT EXISTS produto (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    unidade VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    quantidade_minima INT NOT NULL,
    quantidade_maxima INT NOT NULL,
    categoria_id INT,
    ativo BOOLEAN NOT NULL DEFAULT TRUE, -- soft delete
    PRIMARY KEY (id),
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

-- Criação da tabela registro
CREATE TABLE IF NOT EXISTS registro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    produto_id INT NOT NULL,
    quantidade INT NOT NULL,
    movimentacao ENUM('NENHUM', 'ENTRADA', 'SAIDA') NOT NULL,
    status ENUM('ACIMA', 'ABAIXO', 'DENTRO', 'ADICIONADO', 'NOMEALTERADO', 'DELETADO', 'NENHUM') NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
