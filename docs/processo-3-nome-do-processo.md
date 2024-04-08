### 3.3.3 Processo 3 – Processo Gerenciamento de Livros

![Processo Gerenciamento de Livros](images/processoGL2.png "Modelo BPMN do Processo 3.")


#### Detalhamento das atividades

### 3.3.4 Processo 4 – Processo Gerenciamento de Usuário

![Processo Gerenciamento de Usuário](images/processoGU2.png "Modelo BPMN do Processo 4.")


#### Detalhamento das atividades

Iniciar gerenciamento de livros
O usuário irá acessar a tela de gerenciamento de livro, nela haverá 4 botões uma que irá levar para a tela de adicionar uma livro, um que leve para a tela de remoção de livros, um que irá levar para a página de alteração e um botão para voltar

Preencher informações  do livro (nome, seçao, autor)
O usuário então é redirecionado para a tela de cadastro de livro nela haverá 3 campos de texto: um para inserir o Nome do livro, outro para a seção do livro e outro para o nome do Autor. Também haverá um botão para voltar e outro para cadastrar.

Escolher qual livro deseja remover
O usuário então é redirecionado para uma tela com um campo de seleção múltipla com todos os livros cadastrados ele então poderá selecionar um ou mais para serem removidos. Nela haverá um campo com seleção múltipla contendo todos os livros cadastrados. Também haverá um botão para voltar e outro para remover.

Escolher qual livro deseja informar
O usuário então é redirecionado para uma tela com um capo para seleção única contendo todos os livros cadastrados, ao selecionar um livro 3 novos campos de área de texto irão aparecer sendo eles o Nome, a Seção e o Autor do livros selecionado com os valores que foram cadastrados ele então poderá alterar os campos. Também haverá um botão para voltar e outro para alterar.

**Iniciar gerenciamento de livros**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |


| **Comandos**         |  **Destino**                   | **Tipo** |
| Botão adicionar      | Início processo de cadastro de livro     | Default           |
| Botão remover        | Início Do processo alteração             | Default           |
| Botão alterar        | Inicio Processo de remoção               | Default           |
| Botão voltar         | Retorna para tela anterior               | Default           |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |


**Preencher informações  do livro (nome, seçao, autor)**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| Nome Livro      | Caixa de Texto   | Sem Restrição  | ---               |
| Seção Livro     | Caixa de Texto   | Apenas Letras  | ---               |
| Nome Autor      | Caixa de Texto   | Apenas Letras  | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão cadastro       | Fim do processo                | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |

**Escolher qual livro deseja remover**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| Livros Cadastrados | Seleção múltipla | Sem restrição  | Nome Livro Cadastrado |
| [Nome do campo] | [tipo de dados]  |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão remover        | Fim do processo                | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |

**Escolher qual livro deseja informar**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| Livros Cadastrados | Caixa de Texto   | Sem Restrição  | Nome Livro Cadastrado |
| Nome Livro         | Caixa de Texto   | Sem Restrição  | ---               |
| Seção Livro        | Caixa de Texto   | Apenas Letras  | ---               |
| Nome Autor         | Caixa de Texto   | Apenas Letras  | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão alterar        | Fim do processo                | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |


