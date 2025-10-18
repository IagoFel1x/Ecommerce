-- Script para criação do banco de dados e tabelas para o sistema de e-commerce

-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

-- Tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de transações (pagamentos)
CREATE TABLE IF NOT EXISTS transacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10, 2) NOT NULL,
    metodo_pagamento VARCHAR(50) NOT NULL,
    data_transacao TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);

-- Tabela de e-mails enviados
CREATE TABLE IF NOT EXISTS emails (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destinatario VARCHAR(100) NOT NULL,
    assunto VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    data_envio TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);

-- Inserção de dados de exemplo para produtos
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque) VALUES
('Smartphone XYZ', 'Smartphone com 128GB de armazenamento e 6GB de RAM', 1999.99, 50),
('Notebook ABC', 'Notebook com processador i7, 16GB de RAM e SSD de 512GB', 4599.99, 20),
('Fone de Ouvido Bluetooth', 'Fone de ouvido sem fio com cancelamento de ruído', 299.99, 100),
('Smart TV 55"', 'Smart TV LED 4K com 55 polegadas', 3299.99, 15),
('Mouse Sem Fio', 'Mouse ergonômico sem fio com bateria de longa duração', 89.99, 200);

-- Exibir tabelas criadas
SHOW TABLES;
