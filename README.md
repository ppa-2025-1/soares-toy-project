# Projeto Toy - Arquitetura de Microsserviços

Este é um projeto de exemplo que implementa uma arquitetura de microsserviços para um sistema de gerenciamento de usuários e chamados (tickets). O projeto foi refatorado de uma arquitetura monolítica para demonstrar a separação de responsabilidades e a comunicação entre serviços.

## Visão Geral da Arquitetura

O sistema é composto por dois microsserviços principais:

* **`ms-user`**: Responsável por todo o ciclo de vida dos usuários, incluindo autenticação (se implementada), perfis e papéis (roles).
* **`ms-chamado`**: Responsável por gerenciar os chamados de suporte. É um serviço desacoplado que apenas armazena uma referência (`userId`) ao usuário que abriu o chamado.

### Fluxo de Comunicação

1.  Um cliente (ex: uma aplicação web) faz uma requisição `POST` para o endpoint `/api/v1/users` do `ms-user` para criar um novo usuário.
2.  O `ms-user` valida os dados, salva o novo usuário em seu próprio banco de dados e obtém o `ID` gerado.
3.  Imediatamente após salvar, o `ms-user` utiliza um `WebClient` para fazer uma chamada de API interna para o endpoint `POST /api/v1/chamados` do `ms-chamado`.
4.  O `ms-chamado` recebe a requisição, cria um chamado padrão ("Criar e-mail para novo usuário") e o associa ao `userId` recebido.

## Como Executar o Projeto

Para executar o ambiente completo, você precisará iniciar ambos os microsserviços.

1.  **Navegue até o diretório do `ms-user`**:
    ```bash
    cd ms-user
    ./gradlew bootRun
    ```
    O serviço de usuário estará disponível em `http://localhost:8080`.

2.  **Abra um novo terminal e navegue até o diretório do `ms-chamado`**:
    ```bash
    cd ms-chamado
    ./gradlew bootRun
    ```
    O serviço de chamados estará disponível em `http://localhost:8081`.

Com ambos os serviços em execução, você pode criar um novo usuário no `ms-user` e observar o chamado correspondente sendo criado automaticamente no `ms-chamado`.