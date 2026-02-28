## Requisitos Funcionais

| ID     | Descrição |
|--------|-----------|
| RF-001 | O sistema deve permitir o cadastro de novos usuários |
| RF-002 | O usuário pode se tornar autor |
| RF-003 | Usuários com perfil de autor podem cadastrar, editar e remover obras |
| RF-004 | O sistema deve permitir o upload de imagens associadas às obras |
| RF-005 | O sistema deve permitir que o usuário autenticado consulte seu próprio perfil |
| RF-006 | O sistema deve permitir a consulta pública do perfil de autores |
---

## Regras de Negócio

| ID     | Descrição |
|--------|-----------|
| RN-001 | Todo usuário recém-cadastrado deve possuir o papel de leitor |
| RN-002 | Para publicar obras, o usuário deve possuir perfil de autor |
| RN-003 | Para se tornar autor, o usuário deve informar CPF ou CNPJ |
| RN-004 | O perfil de autor é exclusivo e vinculado a um único usuário |

---

## Requisitos Não Funcionais

| ID      | Descrição |
|---------|-----------|
| RNF-001 | O sistema deve possuir autenticação e autorização para usuários registrados |
| RNF-002 | O sistema deve garantir a segurança e integridade dos dados pessoais (CPF/CNPJ) |  	                



## Clean Arch

Para o estruturar o sistema escolhi utilizar Clean Arch

dividi o sistema em 4 camdas

- Infra
- Adapters
- Application
- domain

especificar as camdads depois

## Anotações

### 20/01/2026
A implementação do UserDetailsService depende diretamente da UserEntityRepository, o que acaba ocasionando um exceção a clean arch

Percebo que a um queda de performance nas requisições, estão levando 600ms para serem feitas. Não sei se o problema é em relação ao JAVA 25 + Spring 4 ou
a arquitetura tem muitas camadas e injeções para serem feitas.

Tomei a decisão de deixar as dtos chegarem nos usecases para não diminuir performance, infringindo a regra de denpendencia.