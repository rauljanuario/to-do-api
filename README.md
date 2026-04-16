# 📋 API de Tarefas

> API REST de lista de tarefas desenvolvida com foco no estudo e implementação do **Spring Security**.

---

## 🧰 Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 25 |
| Spring Boot | 3 |
| Spring Security | — |
| Maven | — |
| Flyway | — |
| PostgreSQL | — |

---

## 🚀 Funcionalidades

- Autenticação e autorização com **Spring Security**
- Gerenciamento de tarefas (criar, listar, atualizar, deletar)
- Migrações de banco de dados com **Flyway**
- Persistência com **PostgreSQL**

---

## 📁 Estrutura do Projeto

```
api-de-tarefas/
├── .mvn/wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       └── db/migration/     # Scripts Flyway
│   └── test/
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

---

## ⚙️ Pré-requisitos

- Java 25
- Maven 3.9+
- PostgreSQL rodando localmente

---

## 🛠️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/rauljanuario/api-de-tarefas.git
cd api-de-tarefas
```

### 2. Configure o banco de dados

Crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE tasks;
```

Configure as variáveis no `application.properties` (ou `application.yml`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
api.security.token.secret=sua_jwtkey_aqui

spring.flyway.enabled=true
```

### 3. Execute o projeto

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 🔐 Segurança

Esta API utiliza **Spring Security** para proteger os endpoints. Os recursos públicos e autenticados são configurados via `SecurityFilterChain`.

> A autenticação é realizada via [descreva aqui o método: HTTP Basic, JWT, etc.].

---

## 📌 Endpoints

| Método | Rota | Descrição | Autenticação |
|--------|------|-----------|:---:|
| `POST` | `/auth/register` | Cria novos usuários | ❌ |
| `POST` | `/auth/login` | Realiza login | ❌ |
| `GET` | `/tarefas` | Lista todas as tarefas | ✅ |
| `POST` | `/tarefas` | Cria uma nova tarefa | ✅ |
| `PUT` | `/tarefas/{id}` | Atualiza uma tarefa | ✅ |
| `DELETE` | `/tarefas/{id}` | Remove uma tarefa | ✅ |


---

## 🗄️ Migrations (Flyway)

As migrations ficam em `src/main/resources/db/migration/` e são executadas automaticamente ao iniciar a aplicação, seguindo a convenção de nomenclatura do Flyway:

```
V1__create_table_usuarios.sql
V2__create_table_tarefas.sql
```

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

---


<p align="center">Feito com ☕ e Spring Boot</p>
