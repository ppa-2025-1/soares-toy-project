# Microsserviço de Usuário (`ms-user`)

Este serviço é o responsável exclusivo pelo gerenciamento de usuários, perfis e papéis (roles).

## Responsabilidades

* Criar, ler, atualizar e deletar usuários.
* Gerenciar perfis e informações associadas ao usuário.
* Ao criar um novo usuário, comunicar-se com o `ms-chamado` para solicitar a abertura de um chamado de suporte padrão.

## Endpoints da API

| Verbo  | Endpoint         | Descrição                    | Corpo da Requisição (Exemplo)                                    |
| :----- | :--------------- | :--------------------------- | :--------------------------------------------------------------- |
| `POST` | `/api/v1/users`  | Cria um novo usuário.        | `{ "name": "...", "email": "...", "password": "...", ... }`       |
| `GET`  | `/api/v1/users`  | Lista todos os usuários.     | N/A                                                              |

## Configuração

As principais configurações podem ser ajustadas no arquivo `src/main/resources/application.properties`:

* **`server.port`**: Porta onde o serviço será executado (padrão: `8080`).
* **`spring.datasource.*`**: Configurações de conexão com o banco de dados.
* **`app.user.default.roles`**: Papéis (roles) padrão que são atribuídos a um novo usuário.

A URL do `ms-chamado` é configurada na classe `MsUserApplication.java`, no bean do `WebClient`.

## Como Executar

Para executar este serviço de forma independente:

1.  **Requisitos**: JDK 17+ e Gradle.
2.  **Execute o comando**:
    ```bash
    ./gradlew bootRun
    ```