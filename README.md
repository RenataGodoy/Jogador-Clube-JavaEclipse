# Cadastro de Jogadores e Clubes

Este projeto é uma aplicação Java que utiliza a biblioteca Swing para criar uma interface gráfica que permite o cadastro de jogadores e clubes. O objetivo principal é fornecer uma forma simples e eficiente de gerenciar informações de jogadores associados a clubes. Este projeto foi desenvolvido como parte da AV2 realizada em sala na aula de Programação de Computadores 3.

## Tecnologias Utilizadas

- Java: A linguagem de programação principal utilizada para desenvolver a aplicação.
- Swing: Biblioteca para construção da interface gráfica.
- Git: Controle de versão utilizado para gerenciar o código-fonte do projeto.

## Funcionalidades

- Cadastrar Clube: Permite ao usuário cadastrar um novo clube, inserindo informações como nome e cidade.
- Cadastrar Jogador: Permite ao usuário cadastrar um novo jogador.
- Consultar Clubes: Mostra uma lista de todos os clubes cadastrados, permitindo visualizar as informações armazenadas.
- Consultar Jogadores: Mostra uma lista de todos os jogadores cadastrados, permitindo visualizar as informações armazenadas.
- Excluir Clube: Possibilita a exclusão de um clube do sistema.
- Excluir Jogador: Possibilita a exclusão de um jogador do sistema.

## Estrutura do Projeto

O projeto é dividido em pacotes, cada um com sua responsabilidade:

- `model`: Contém as classes de modelo (por exemplo, `Clube`, `Jogador`).
- `controller`: Contém as classes controladoras que gerenciam a lógica do aplicativo (por exemplo, `CtrlCadastrarClube`, `CtrlCadastrarJogador`).
- `viewer`: Contém as classes de visualização (GUI) que criam a interface do usuário (por exemplo, `JanelaCadastrarClube`, `JanelaCadastrarJogador`).
