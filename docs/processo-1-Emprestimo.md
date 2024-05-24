### 3.3.1 Processo 1 – Processo Empréstimo

![Processo Empréstimo](images/novoProcessoEmprestimo.png "Modelo BPMN do Processo 1.")


#### Detalhamento das atividades

**Selecionar o livro escolhido pelo usuário -** Usuário entra na tela principal, também chamada de landing page, que apresenta uma barra de pesquisa que filtra o livro buscado pelo nome e um botão para buscar o livro digitado no sistema. Além disso, terá um botão principal que ocupará boa parte da tela de apresentação inicial. Ao clicar no botão, descerá a tela mostrando em cards as opções de livro com um botão embaixo de cada card permitindo com que o usuário escolha qual livro pegará emprestado.

**Registrar Empréstimo e data de devolução -** Essa tela so será acessada pelo bilbiotecário após prencheer a tela de definição da data de devolução. Nela o bibliotecário seguirá preenchendo as informações necessárias pra concluir o processo, sendo elas: CPF do Usuário que requisitou o empréstimo, livro escolhido, data de retirada, o prazo definido na tela anterior e por fim o preço desse empréstimo. Após concluir esses passos, o bibliotecário terá 2 botões, o de voltar a tela anterior, caso tenha cometido erros no preenchimento da data, e o de registrar a conclusão final do empréstimo. 

____________________________________________________________________________________________________________________________________________________________________

**Selecionar o livro escolhido pelo usuário**

| Campo       | Tipo         | Restrições | Valor default |
| ---             | ---              | ---            | ---               |
| Título do Livro     | Caixa de Texto   | Sem Restrição  | Titulo do livro cadastrado          |
| Nome do Autor      | Caixa de Texto      | Apenas Letras  | Nome do autor cadastrado             |
| ISBN | Número  | 13 Caracteres           | IBNN do livro cadastrado                 |
| Editora | Caixa de Texto   | Apenas Letras  | Editora do livro cadastrado                 |
| Seção do Livro     | Caixa de Texto   | Apenas Letras  | Seção do livro cadastrado                 |
| Preço | Número   | ---   | Preço do livro cadastrado                 |
| Ações |  Caixa de Texto        | Não alteravel | Emprestar |

| Comandos         |  Destino                   | Tipo          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão emprestar      | Registrar empréstimo e data de devolução       | ---               |


____________________________________________________________________________________________________________________________________________________________________

**Registrar Empréstimo e data de devolução**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| CPF do Usuário          | Número   | 12 Caracteres | ---               |
| Livro Escolhido          | Caixa de Texto   | Apenas letras | ---               |
| Data de Retirada          | Data   | --- |  ---              |
| Prazo pra Devolução          | Data   | Não editável |   ---          |
| Preço         | Número   | ---  | ---               |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão Voltar               | Retorna para a tela anterior          | Default           |
| Botão Registrar               | Fim do processo          | Default           |


