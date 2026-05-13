# Sistema de Gestao de Projetos

Sistema Java para gerenciamento de projetos, usuarios, tarefas e equipes, desenvolvido com arquitetura MVC e interacao via terminal.

O projeto permite cadastrar usuarios com diferentes perfis, criar projetos com gerente responsavel, vincular tarefas a projetos e usuarios, montar equipes e acompanhar o progresso das tarefas de cada projeto.

## Tecnologias utilizadas

- Java 11 ou superior
- Programacao orientada a objetos
- Arquitetura MVC
- Interface por console

## Funcionalidades

- Cadastro e listagem de usuarios
- Definicao de perfil do usuario como `ADMINISTRADOR`, `GERENTE` ou `COLABORADOR`
- Criacao e listagem de projetos
- Associacao de gerente responsavel ao projeto
- Criacao e listagem de tarefas por projeto
- Associacao de responsavel para cada tarefa
- Criacao de equipes
- Inclusao de usuarios em equipes
- Listagem de equipes e seus membros
- Visualizacao do progresso e dos detalhes de um projeto
- Validacao basica de entradas no terminal

## Arquitetura

O sistema segue uma estrutura MVC:

- `Model`: representa as entidades e enums do sistema.
- `Controller`: concentra as regras de criacao, busca, listagem e validacao.
- `View`: organiza os menus do terminal e recebe os dados informados pelo usuario.

### Modelos principais

- `Usuario`: armazena dados pessoais, credenciais, cargo e perfil.
- `Projeto`: armazena dados do projeto, datas, status, gerente e tarefas.
- `Tarefa`: armazena nome, descricao, prazo, status e usuario responsavel.
- `Equipe`: armazena nome, descricao e membros.
- `Perfil`: define os perfis de usuario disponiveis.
- `StatusProjeto`: define os status possiveis de um projeto.

## Estrutura de pastas

```text
sistema-gestao-projetos/
|-- src/
|   |-- Controller/
|   |   `-- SistemaController.java
|   |-- Model/
|   |   |-- Equipe.java
|   |   |-- Perfil.java
|   |   |-- Projeto.java
|   |   |-- StatusProjeto.java
|   |   |-- Tarefa.java
|   |   `-- Usuario.java
|   `-- View/
|       |-- EquipeView.java
|       |-- Main.java
|       |-- ProjetoView.java
|       |-- TarefaView.java
|       `-- UsuarioView.java
`-- README.md
```

## Como executar

### 1. Clone o repositorio

```bash
git clone https://github.com/indiazinh011-prog/sistema-gestao-projetos.git
cd sistema-gestao-projetos
```

### 2. Compile o projeto

```bash
javac -d out $(find src -name '*.java')
```

### 3. Execute o sistema

```bash
java -cp out View.Main
```

## Menu principal

Ao executar o projeto, o terminal apresenta as seguintes opcoes:

```text
1 - Usuarios
2 - Projetos
3 - Tarefas
4 - Equipes
0 - Sair
```

Cada opcao abre um submenu especifico para cadastro, listagem ou consulta dos dados relacionados.

## Regras de uso

- Para criar um projeto, e necessario cadastrar pelo menos um usuario para atuar como gerente.
- Para criar uma tarefa, e necessario ter pelo menos um projeto e um usuario cadastrados.
- As tarefas sao criadas inicialmente com o status `Pendente`.
- O progresso do projeto considera as tarefas marcadas como `Concluido`, incluindo a versao acentuada desse termo.
- Os dados sao mantidos apenas em memoria durante a execucao do programa.

## Melhorias ja aplicadas

- Refatoracao de colaborador para usuario
- Inclusao de perfis de usuario
- Inclusao de equipes e membros
- Inclusao de status para projetos
- Separacao das telas de terminal por entidade
- Validacao basica de entradas
- Mensagens mais claras para sucesso e erro

## Possiveis melhorias futuras

- Permitir atualizar o status de tarefas pelo menu
- Permitir alterar o status de projetos pelo menu
- Salvar dados em arquivo ou banco de dados
- Adicionar busca de projetos, tarefas, usuarios e equipes
- Criar testes automatizados
- Melhorar a formatacao das listagens no terminal
