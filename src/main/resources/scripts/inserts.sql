-- CARTAS
INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Lando Norris', 5, 2, 2, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Carlos Sainz', 3, 5, 2, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Alexander Albon', 2, 5, 3, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Sergio Perez', 4, 1, 1, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Charles Leclerc', 3, 4, 2, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Max Verstappen', 5, 5, 5, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Fernando Alonso', 5, 3, 4, curdate());

INSERT INTO supertrunfo.carta
(NOME, FORCA, INTELIGENCIA, VELOCIDADE, DATA_CADASTRO)
VALUES('Geroge Russel', 1, 3, 5, curdate());

-- JOGADORES
INSERT INTO supertrunfo.jogador
(ID, NOME, EMAIL, DATA_NASCIMENTO, TOTAL_PARTIDAS, PERCENTUAL_VITORIAS)
VALUES(1, 'Maria Leitão', 'malu@gmail.com', '2003-09-29', 0, 0);

INSERT INTO supertrunfo.jogador
(ID, NOME, EMAIL, DATA_NASCIMENTO, TOTAL_PARTIDAS, PERCENTUAL_VITORIAS)
VALUES(2, 'Marcela Duarte', 'marcela@gmail.com', '1996-09-24', 0, 0);

INSERT INTO supertrunfo.jogador
(ID, NOME, EMAIL, DATA_NASCIMENTO, TOTAL_PARTIDAS, PERCENTUAL_VITORIAS)
VALUES(3, 'Arthur Braga', 'arthur@gmail.com', '2015-03-11', 0, 0);