# Microsserviço de Chamado (`ms-chamado`)

Este serviço gerencia o ciclo de vida de chamados (tickets) de suporte. Ele é projetado para ser um serviço independente, sem conhecimento direto sobre a estrutura interna de usuários.

## Responsabilidades

* Criar, ler, atualizar e deletar chamados.
* Manter o estado (situação) de um chamado: `NOVO`, `ANDAMENTO`, `RESOLVIDO`, `CANCELADO`.
* Associar um chamado a um `userId` (um número inteiro), sem armazenar outras informações do usuário.

## Endpoints da API

| Verbo   | Endpoint                | Descrição                        | Corpo da Requisição (Exemplo)                             |
| :------ | :---------------------- | :------------------------------- | :-------------------------------------------------------- |
| `POST`  | `/api/v1/chamados`      | Cria um novo chamado.            | `{ "acao": "...", "objeto": "...", "usuarioId": 1 }`     |
| `GET`   | `/api/v1/chamados`      | Lista todos os chamados.         | N/A                                                       |
| `GET`   | `/api/v1/chamados/{id}` | Busca um chamado pelo seu ID.    | N/A                                                       |
| `PATCH` | `/api/v1/chamados/{id}` | Atualiza a situação de um chamado. | `{ "situacao": "ANDAMENTO" }`                             |

## Configuração

As principais configurações podem ser ajustadas no arquivo `src/main/resources/application.properties`:

* **`server.port`**: Porta onde o serviço será executado (padrão: `8081`).
* **`spring.datasource.*`**: Configurações de conexão com o banco de dados.

## Como Executar

Para executar este serviço de forma independente:

1.  **Requisitos**: JDK 17+ e Gradle.
2.  **Execute o comando**:
    ```bash
    ./gradlew bootRun
    ```