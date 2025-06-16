# 📍 Projeto Catálogo de Filmes

## 📋 Descrição
Este projeto é uma aplicação simples, mas completa, voltada para o cadastro e gerenciamento de um catálogo pessoal de filmes. Com um visual moderno e com transições suaves entre as páginas, o sistema serve tanto como exercício de aprendizagem de CRUD + MVC quanto como base para projetos maiores.

## 🛠️ Funcionalidades
- O usuário pode cadastrar filmes.
- O usuário pode visualizar a lista de filmes cadastrados.
- O usuário pode excluir um filme cadastrado.
- O usuário pode editar as informações de qualquer filme cadastrado.

## 💻 Tecnologias e ferramentas utilizadas
- Java 21 + Maven
- Spring Boot
- Thymeleaf
- CSS3
- HTML5
- JavaScript
- PostgreSQL
- Visual Studio Code

## 📁 Estrutura do projeto
```plaintext
projeto_mvc/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/projeto/projeto_mvc/
│   │   │        ├── controller/
│   │   │            └── FilmeController.java (Controller principal com os endpoints)
│   │   │        ├── model/
│   │   │        │   ├── Filme.java (Classe de modelo do filme)
│   │   │        │   ├── FilmeDAO.java (Acesso ao banco para crud)
│   │   │        │   └── FilmeService.java (Regras de negócio)
│   │   │        └── ProjetoMvcApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── styles/
│   │   │   │   ├── images/
│   │   │   │   └── js/
│   │   │   │   │   ├──formulario.js
│   │   │   │   │   ├──listar.js
│   │   │   │   │   └──transitions.js
│   │   │   └── templates/
│   │   │   │   ├── index.html
│   │   │   │   ├── formulario.html
│   │   │   │   ├── listar.html
│   │   │   │   └── sucesso.html
│   │   │   ├── application.yaml
│   │   │   └── schema-postgresql.sql (Script para criação da tabela de filme no PostgreSQL)
└── pom.xml
...
```

## ▶️ Como executar o projeto
### Pré-requisitos
- Java 21
- Maven
- PostgreSQL
- Crie um banco de dados chamado filmes no PostgreSQL.
- Execute o script /resources/schema-postgresql.sql para criar a tabela.
- Configure o acesso ao banco no application.yaml com sua URL, usuário e senha.

```bash
# 1. Clone o repositório
git clone https://github.com/marcellarc/projeto-mvc.git

# 2. Acesse o diretório do projeto
cd projeto-mvc

# 3. Rode o projeto no ProjetoMvcApplication.java

# 4. Inicie o servidor de desenvolvimento
http://localhost:8080/

```

## 👩‍💻 Feito por
[@Marcella Ricoy](https://github.com/marcellarc)
[@Beatriz Sibilio](https://github.com/beatrizsibilio)