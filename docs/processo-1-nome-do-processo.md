### 3.3.1 Processo 1 – Processo Empréstimo

![Processo Empréstimo](images/processoEmprestimo2.png "Modelo BPMN do Processo 1.")


#### Detalhamento das atividades

_Descreva aqui cada uma das propriedades das atividades do processo 1. 
Devem estar relacionadas com o modelo de processo apresentado anteriormente._

_Os tipos de dados a serem utilizados são:_

_* **Área de texto** - campo texto de múltiplas linhas_

_* **Caixa de texto** - campo texto de uma linha_

_* **Número** - campo numérico_

_* **Data** - campo do tipo data (dd-mm-aaaa)_

_* **Hora** - campo do tipo hora (hh:mm:ss)_

_* **Data e Hora** - campo do tipo data e hora (dd-mm-aaaa, hh:mm:ss)_

_* **Imagem** - campo contendo uma imagem_

_* **Seleção única** - campo com várias opções de valores que são mutuamente exclusivas (tradicional radio button ou combobox)_

_* **Seleção múltipla** - campo com várias opções que podem ser selecionadas mutuamente (tradicional checkbox ou listbox)_

_* **Arquivo** - campo de upload de documento_

_* **Link** - campo que armazena uma URL_

_* **Tabela** - campo formado por uma matriz de valores_


**Requisitar Empréstimo**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Pesquisa           | Área de Texto   | Apenas letras |    X            |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Ver Livros               | Tela com as opções de livro              | default           |
| Botão Buscar               | Livro digitado na busca              | default           |
| Botão Escolher Livro             | Verificar quantidade de livros              | default           |


**Definir Data de Devolução**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Data Devolucao                 |   Data               |       Somente datas futuras        |      X             |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão Registrar Data                     |  Tela de Registrar Empréstimo                              |  default                 |


**Registrar Empréstimo**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome do Usuario          | Caixa de Texto   | Apenas letras |    Usuario Cadastrado            |
| Livro Escolhido          | Caixa de Texto   | Apenas letras |                |
| Data de Retirada          | Data   |  |    X            |
| Prazo pra devolucao          | Data   |  Valor não editável |    X            |
| Preco         | Numero   |  |    X            |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Voltar               | Retorna para a tela anterior          | default           |
| Botão Registrar               | Tela final de conclusão do emprestimo           | default           |


**Verificar Quantidade de Livros**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Informações do Empréstimo         | Tabela   | Valores não editáveis |    Livro Escolhido, Quantidade            |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Voltar               | Retorna para a tela anterior          | default           |
| Botão Concluir               | Fim do Processo          | X           |
