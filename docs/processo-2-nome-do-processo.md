### 3.3.2 Processo 2 – Processo Devolução

![Processo Devolução](images/processoDevolucao2.png "Modelo BPMN do Processo 2.")



#### **Detalhamento das atividades**
**Registrar a devolução do livro na biblioteca** - Bibliotecario entra na tela do registro da devolução de livros. A tela possui 4 botões, um que leva à pagina anterior, um que leva a uma tela que registra que uma multa foi paga devido à danos no livro. Além desses botões, nessa mesma tela temos a opção de verificar se o livro está com atraso na devolução ou não, preenchendo as informações do cliente ou do proprio livro (é possivel pelos 2 caminhos). E os ultimos 2 botões levam a outras 2 telas diferentes, que são a de pagamento de multa e a do pagamento do empréstimo do livro.

**Cobrar taxa extra** - Bibliotecario apenas acessará essa tela a partir da tela do registro da devolução do livro caso o livro tenha voltado com defeitos que não possuia antes. Essa tela possibilitará deixar registrado o ocorrido com o livro caso ocorram futuras duvidas em relação ao ocorrido. Além de tudo, essa tela possuirá apenas um botão para que o bibliotecario possa retornar à tela de registro de devolção.

**Pagar multa de atraso** - Essa tela so será acessada pelo bilbiotecario a partir da tela de devolução de livros caso o usuário tenha atraso na data de devolução do livro. A tela possuirá as opções de pagamento do cliente com o valor já calculado pelo proprio software na tela. Essa tela possuirá apenas um botão para que o bibliotecario possa voltar à tela de devolução de livro apos o pagamento da multa.

**Pagar o empréstimo do livro** - Após todo o processo verificado e executado, o bilbiotecario passará obrigatoriamente por essa tela para que o cliente possa pagar o valor do empréstimo do livro. Essa possuirá o valor ja calculado do empréstimo pelo software e oferecerá as opções de pagamento disponíveis ao usuário. A tela possuirá apenas um botão para confirmar que o pagamento foi executado. O botão será ativado manualmente pelo bibliotecario apenas após a confirmação de pagamento feita pelo cliente.








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

**Nome da atividade 1**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| ***Exemplo:***  |                  |                |                   |
| login           | Caixa de Texto   | formato de e-mail |                |
| senha           | Caixa de Texto   | mínimo de 8 caracteres |           |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| ***Exemplo:***       |                                |                   |
| entrar               | Fim do Processo 1              | default           |
| cadastrar            | Início do proceso de cadastro  |                   |


**Nome da atividade 2**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|                 |                  |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|                      |                                |                   |
