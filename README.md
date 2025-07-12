# user-api-ticket

## Concern (preocupação)

Arquitetura com Separação em Camadas é uma aplicação do  _Separation of Concerns Principle_.

_Cross-Cutting Concerns_ (Preocupações Transversais)


Thin Controller / Fat Model (entidade, serviço, business, domain, ..., regras!) -- MVC
-- controller "magro" / modelo "gordo"


## Implementar
1. Chamado: ação (ex.: instalar, criar), objeto (ex.: computador, e-mail), detalhamento (instalar computador na sala 1010, criar e-mail), situação (deve ser enum: novo, andamento, resolvido, cancelado), usuário (ex.: 125) e todos os campos comuns (BaseEntity)  
1.1. Deve permitir: abrir (novo) - POST, consultar pelo ID - GET, consultar todos - GET, alterar a situação (resolvido e cancelado não pode mudar) - PATCH  
1.2. Quando um usuário for criado, precisa abrir um chamado automático para criar um email
2. Notificação
