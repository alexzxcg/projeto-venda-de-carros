DROP SCHEMA IF EXISTS carronix CASCADE;
CREATE SCHEMA IF NOT EXISTS carronix;
SET search_path TO carronix;
CREATE TABLE IF NOT EXISTS cliente(
  codigo SERIAL,
  cpf VARCHAR(11) NOT NULL,
  rg VARCHAR(11) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  data_nascimento DATE,
  telefone_residencial VARCHAR(11),
  telefone_celular VARCHAR(11),
  email VARCHAR(255),
  renda REAL
);
ALTER TABLE cliente
ADD CONSTRAINT pk_cliente PRIMARY KEY (cpf);
INSERT INTO cliente(
    codigo,
    cpf,
    rg,
    nome,
    data_nascimento,
    telefone_residencial,
    telefone_celular,
    email,
    renda
  )
VALUES (
    1,
    '87130299088',
    '386731834',
    'Renato Kevin Cavalcanti',
    '1951-06-06',
    '2727305679',
    '27995632857',
    'rrenatokevincavalcanti@gmalato.com.br',
    10000.99
  )