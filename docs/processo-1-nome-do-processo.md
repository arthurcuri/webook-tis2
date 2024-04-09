### 3.3.1 Processo 1 – Processo Empréstimo

![Processo Empréstimo](images/processoEmprestimo2.png "Modelo BPMN do Processo 1.")


#### Detalhamento das atividades

_Descreva aqui cada uma das propriedades das atividades do processo 1. 
Devem estar relacionadas com o modelo de processo apresentado anteriormente._


**Requisitar Empréstimo**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Pesquisa           | Área de Texto   | Apenas letras |  ---              |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Ver Livros               | Tela com as opções de livro              | default           |
| Botão Buscar               | Livro digitado na busca              | default           |
| Botão Escolher Livro             | Verificar quantidade de livros              | default           |


**Definir Data de Devolução**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Data Devolução                 |   Data               |       Somente datas futuras        |     ---              |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão Registrar Data                     |  Tela de Registrar Empréstimo                              |  default                 |


**Registrar Empréstimo**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| CPF do Usuário          | Número   | 12 Caracteres | ---               |
| Livro Escolhido          | Caixa de Texto   | Apenas letras | ---               |
| Data de Retirada          | Data   | --- |  ---              |
| Prazo pra Devolução          | Data   |  Valor não editável |                |
| Preço         | Número   | ---  | ---               |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Voltar               | Retorna para a tela anterior          | default           |
| Botão Registrar               | Tela final de conclusão do empréstimo           | default           |


**Verificar Quantidade de Livros**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Informações do Empréstimo         | Tabela   | Valores não editáveis |    Livro Escolhido, Quantidade            |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Voltar               | Retorna para a tela anterior          | default           |
| Botão Concluir               | Fim do Processo          | ---           |
