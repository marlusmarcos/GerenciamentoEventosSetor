-- Tabela de Área
CREATE TABLE Area (
    id SERIAL PRIMARY KEY,
    numero INTEGER UNIQUE
);

-- Tabela de Setor
CREATE TABLE Setor (
    id SERIAL PRIMARY KEY,
    numero INTEGER UNIQUE,
    area_id INTEGER REFERENCES Area(id)
);

-- Tabela de Congregação
CREATE TABLE Congregacao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    setor_id INTEGER REFERENCES Setor(id)
);

-- Tabela de Pessoa
CREATE TABLE Pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    congregacao_id INTEGER REFERENCES Congregacao(id)
);

-- Tabela de Evento
CREATE TABLE Evento (
    id SERIAL PRIMARY KEY,
    descricao TEXT,
    data DATE,
    valor_por_pessoa DECIMAL(10, 2)
);

-- Tabela de PessoaPagamento
CREATE TABLE PessoaPagamento (
    id SERIAL PRIMARY KEY,
    pessoa_id INTEGER REFERENCES Pessoa(id),
    evento_id INTEGER REFERENCES Evento(id),
    valor_recebido DECIMAL(10, 2),
    valor_total DECIMAL(10, 2)
);

-- Gatilho para atualizar o valor total pago por pessoa
CREATE OR REPLACE FUNCTION atualizar_valor_total_pago()
RETURNS TRIGGER AS $$
DECLARE
    valor_anterior DECIMAL(10, 2);
BEGIN
    -- Salva o valor anterior da coluna valor_total
    valor_anterior := COALESCE(OLD.valor_total, 0);

    -- Atualiza o valor total pago na tabela PessoaPagamento
    NEW.valor_total := valor_anterior + NEW.valor_recebido;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualizar_valor_total_pago
AFTER INSERT OR UPDATE OF valor_recebido ON PessoaPagamento
FOR EACH ROW
EXECUTE PROCEDURE atualizar_valor_total_pago(); -- Corrigindo a chamada da função
-- inserts para povoar o banco e testar
-- nomes fictícios kkk
-- functions repetidas, ainda vou analisar com mais calma
insert into area (numero) values (4);
insert into setor (numero) values (10);
insert into congregacao (nome, setor_id) values ('Santarem Bairro Polo', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Matheus', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Luan', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Mikael M.', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Mayla', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Mikelly', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Micael kalebe', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Daniel Filipe', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Sara', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Noemi', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Noemia', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Vitor', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Marlus', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Raquel', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('Sarah', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('weloizy', 1);
INSERT INTO pessoa (nome, congregacao_id) VALUES ('João Edivan', 1);

-- adicionando evento
insert into evento (descricao, data, valor_por_pessoa) values ('Vigília Central 22/03', TO_DATE('2024-03-22', 'YYYY-MM-DD'), 8);


-- Gatilho para atualizar o valor total pago por pessoa
CREATE OR REPLACE FUNCTION atualizar_valor_total_pago()
RETURNS TRIGGER AS $$
DECLARE
    valor_anterior DECIMAL(10, 2);
BEGIN
    -- Salva o valor anterior da coluna valor_total
    valor_anterior := COALESCE(OLD.valor_total, 0);

    -- Atualiza o valor total pago na tabela PessoaPagamento
    NEW.valor_total := valor_anterior + NEW.valor_recebido;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualizar_valor_total_pago
AFTER INSERT OR UPDATE OF valor_recebido ON PessoaPagamento
FOR EACH ROW
EXECUTE PROCEDURE atualizar_valor_total_pago(); -- Corrigindo a chamada da função

INSERT INTO PessoaPagamento (pessoa_id, evento_id, valor_recebido)
VALUES 
    (1, 1, 8),
    (2, 1, 8),
    (3, 1, 8);


SELECT e.descricao AS nome_evento,
       COUNT(pp.pessoa_id) AS quantidade_pessoas_pagaram,
       SUM(pp.valor_recebido) AS valor_total_pago
FROM Evento e
LEFT JOIN PessoaPagamento pp ON e.id = pp.evento_id
GROUP BY e.descricao;
