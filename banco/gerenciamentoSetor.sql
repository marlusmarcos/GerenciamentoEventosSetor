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
