### 3.3.2 Processo 2 – Processo Devolução

![Processo Devolução](images/processoDevolucao.png "Modelo BPMN do Processo 2.")



#### **Detalhamento das atividades**
**Registrar a devolução do livro na biblioteca** - Bibliotecário entra na tela do registro da devolução de livros. A tela possui 4 botões, um que leva à pagina anterior, um que leva a uma tela que registra que uma multa foi paga devido à danos no livro. Além desses botões, nessa mesma tela temos a opção de verificar se o livro está com atraso na devolução ou não, preenchendo as informações do cliente ou do proprio livro (é possivel pelos 2 caminhos). E os ultimos 2 botões levam a outras 2 telas diferentes, que são a de pagamento de multa e a do pagamento do empréstimo do livro.

**Cobrar taxa extra** - Bibliotecário apenas acessará essa tela a partir da tela do registro da devolução do livro, caso o livro tenha voltado com defeitos que não possuia antes. Essa tela possibilitará deixar registrado o ocorrido com o valor que será cobrado ao usuário pelos danos. Ela terá apenas um botão para dar sequência ao processo.

**Pagar multa de atraso** - O usuário receberá as informações de devolução enviadas peo bibliotecário. Neste caso, apresentará uma tela informando o valor de multa que será adicionado ao preço do empréstimo, para o pagamento em conjunto na tela seguinte.

**Pagar o empréstimo do livro** - Após todo o processo verificado e executado, o usuário recebe uma tela com o preço inteiro a ser pago, já considerando as taxas de dano e multa, caso apresente alguma delas, e as meios de pagamento a serem utilizados. Após a conclusão do mesmo, o usuário apresenta o comprovante e o livro é disponibilizado novamente no sistema.



**Registrar a devolção do livro**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
|  Botão Cobrar da taxa extra | Cobrar taxa extra ou devolução do livro  | (default) |
| Botão de Pagar multa de atraso     |        Pagar multa de atraso                        |           (default)        |
| Botão de Pagar empréstimo do livro           |         Pagar o empréstimo do livro      | (default)          |
| Botão de voltar à tela antecessora        | Leva à tela antecessora  |         (default)          |

___________________________________________________________________________________________________________________________________

**Cobrar taxa extra ou devolução do livro**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Valor taxa extra  | Número       | ---            | ---               |
| Motivo de taxa extra | Campo de texto  |    Não tem      |            ---   |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão de confirmar cobrança | Registrar a devolução do livro na biblioteca | (default) |              

___________________________________________________________________________________________________________________________________

**Pagar multa de atraso**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Valor multa     | Número          | ---            | ---               |
| Opções de pagamento | Seleção única  |         Não tem      |            ---   |
| Numero cartão | Número |  Após escolher cartão de débito/crédito   |         ---   | 
| Data de vencimento | Número |  Após escolher cartão de débito/crédito   |         ---   |      
| Código de segurança | Número |  Após escolher cartão de débito/crédito   |         ---   | 
| Nome do dono do cartão | Campo de texto |  Após escolher cartão de débito/crédito   |         ---   | 
| QR Code do PIX | Imagem |  Após escolher PIX   |         ---   |                                                                  

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão de confirmar pagamento ("Ja paguei")| Registrar a devolução do livro na biblioteca | (default) |    

___________________________________________________________________________________________________________________________________

**Pagar o empréstimo do livro**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Valor empréstimo      | Número        | ---            | ---               |
| Opções de pagamento | Seleção única  |         Não tem      |            ---   |
| Numero cartão | Número |  Após escolher cartão de débito/crédito   |         ---   | 
| Data de vencimento | Número |  Após escolher cartão de débito/crédito   |         ---   |      
| Código de segurança | Número |  Após escolher cartão de débito/crédito   |         ---   | 
| Nome do dono do cartão | Campo de texto |  Após escolher cartão de débito/crédito   |         ---   | 
| QR Code do PIX | Imagem |  Após escolher PIX   |         ---   |                                                                  

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão de confirmar pagamento ("Ja paguei")| Registrar a devolução do livro na biblioteca | (default) |    

