# Sistema de Gestao de Projetos

Projeto Java simples em arquitetura MVC para cadastro de colaboradores, projetos e tarefas via terminal.

## Funcionalidades

- cadastrar colaboradores
- criar projetos
- criar tarefas vinculadas a um projeto e a um colaborador
- listar projetos
- exibir progresso de cada projeto

## Estrutura

- `src/Model`: entidades do sistema
- `src/Controller`: regras de orquestracao
- `src/View`: interacao via console

## Como executar

Compile:

```bash
javac -d out $(find src -name '*.java')
```

Execute:

```bash
java -cp out View.Main
```

## Melhorias aplicadas

- correcao do armazenamento do prazo da tarefa
- correcao do calculo de progresso do projeto
- validacao basica de entradas
- mensagens mais claras para sucesso e erro
- protecao das listas internas do controller contra alteracoes externas
