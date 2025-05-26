# TaskMananger

**TaskMananger** é uma aplicação de terminal desenvolvida em Java com o objetivo de gerenciar tarefas pessoais de forma simples e intuitiva. O projeto permite cadastrar, visualizar, editar e remover tarefas, além de armazenar os dados localmente em um arquivo JSON.

## 🧹 Funcionalidades

* **Cadastro de Tarefas:** Adicione tarefas com título, descrição, data de vencimento e status (pendente, em andamento, concluída).
* **Visualização no Terminal:** Liste todas as tarefas cadastradas em um formato claro e organizado.
* **Edição e Exclusão:** Atualize ou remova tarefas diretamente pelo terminal.
* **Persistência de Dados:** Os dados são armazenados localmente em um arquivo JSON, mantendo o histórico mesmo após fechar o programa.

## 💠 Tecnologias Utilizadas

* **Java 17+**
* **Gson (para manipulação de JSON)**

## 📁 Estrutura do Projeto

```
taskmananger/
├── src/
│   └── main/
│         ├──java/
│         │    ├── model/         # Classes de dados (Tarefa, etc.)
│         │    ├── controller/    # Lógica de negócio
│         │    └── util/          # Utilitários (leitura e gravação de arquivos)
│         │
│         │   
│         └──resoucers/
│               └──data/
└── README.md
```

## 🚀 Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/imwiily/TaskManager.git
   ```
2. Importe o projeto em sua IDE Java preferida ou compile com `javac` no terminal.
3. Certifique-se de que a biblioteca Gson esteja adicionada ao classpath.
4. Execute a classe principal (ex: `TaskMasterApp.java`).

## 📌 Requisitos

* JDK 17 ou superior
* Biblioteca Gson (adicionada via Maven, Gradle ou manualmente)

## 📃 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).