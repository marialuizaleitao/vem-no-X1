# Projeto "Vem no X1" (Super Trunfo)

Desenvolvido como estudo de caso na disciplina de Desenvolvimento Backend no semestre 2024.1 do curso de Análise e Desenvolvimento de Sistemas no Senac Santa Catarina.

## Descrição do Projeto

O projeto "Vem no X1" é um jogo de cartas estilo Super Trunfo, onde os jogadores cadastrados no sistema recebem três cartas cada, com atributos de força, inteligência e velocidade. Cada partida consiste em três rounds de X1, onde o jogador e a CPU escolhem uma carta e um atributo para competir. O sistema armazena o histórico das partidas, incluindo data, jogador, cartas e resultado.

## Etapas de Desenvolvimento do Backend

- Identificação das classes, atributos e métodos
- Construção do diagrama entidade-relacionamento
- Construção do diagrama de classes
- Organização das entidades em pacotes (model.entity, model.repository, service, controller)
- Implementação dos serviços para jogadores, cartas, cartas em partida e partida
- Implementação dos controladores REST

## Funcionalidades do Sistema

- Cadastro de jogadores
- Cadastro de cartas, com validação do somatório dos atributos
- Realização de partidas, incluindo sorteio de cartas para jogador e CPU
- Armazenamento do histórico das partidas

## Algoritmo da Jogada

O algoritmo da jogada da CPU analisa as cartas disponíveis, priorizando aquelas que podem vencer ou empatar o round, ou escolhendo a pior carta disponível em caso de derrota.

A implementação inclui métodos de CRUD para jogadores, cartas, cartas em partida e partida, além de validações de integridade de dados.

---

Este projeto foi desenvolvido com foco na aplicação de conceitos de desenvolvimento backend e arquitetura de sistemas, proporcionando uma experiência de jogo dinâmica e interativa para os usuários.
