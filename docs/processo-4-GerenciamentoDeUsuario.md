### 3.3.4 Processo 4 – Processo Gerenciamento de Usuário

![Processo Gerenciamento de Usuário](images/processoGU.png "Modelo BPMN do Processo 4.")


#### Detalhamento das atividades


**Iniciar gerenciamento de usuários -**
O bibliotecario irá acessar a tela de gerenciamento de usuários, nela haverá 3 botões uma que irá levar para a tela de adicionar um usuário, um que leve para a tela de remoção e alteração de usuário e um botão para voltar.

**Escolher qual usuário deseja remover ou editar -**
O bibliotecário é redirecionado para uma tela que possui uma tabela contendo todos os usuários cadastrados no sistema com as informações preenchidas anteriormente.

**Preencher informações do usuário -**
O bibliotecário então é redirecionado para a tela de cadastro de livro nela haverá 3 campos de texto: um para inserir o Nome do usuário, outro para o CPF e outro para a data de nascimento. Também haverá um botão para voltar e outro para cadastrar.

**Alterar informações de usuários -**
O bibliotecário então é redirecionado para uma tela com um capo para seleção única contendo todos os usuários, ao selecionar um usuário 3 novos campos de área de texto irão aparecer sendo eles o Nome, a Data e o CPF do usuário selecionado com os valores que foram cadastrados ele então poderá alterar os campos. Também haverá um botão para voltar e outro para alterar.

**Confirmar remoção do usuário -**
O bibliotecário então é redirecionado para uma tela com um campo de seleção única com todos os usuários cadastrados ele então poderá selecionar um ou mais para serem removidos. Também haverá um botão para voltar e outro para remover.

___________________________________________________________________________________________________________________________________

**Iniciar gerenciamento de usuários**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---                         |
| Botão adicionar      | Início processo de cadastro de usuario   | Default           |
| Botão remover ou editar | Inicio processo de remoção de usuario ou edição  | Default|
| Botão voltar         | Retorna para tela anterior               | Default           |

___________________________________________________________________________________________________________________________________

**Preencher informações do usuário**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | ---               |
| Data de nascimento| Caixa de Texto | Apenas Numeros | ---               |
| CPF             |   Numero         | 12 Numeros | ---               |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão adicionar      | Fim do processo                | Default           |

__________________________________________________________________________________________________________________________________


**Alterar informações de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome do usuário | Caixa de Texto | Sem restrição | Nome do usuário cadastrado |
| CPF             |   Caixa de Texto | Apenas Numeros | CPF do usuário cadastrado               |
| Data de nascimento| Data           | Apenas Numeros | Data do usuário cadastrado               |
| ID | Caixa de texto | Não alteravel | ID da ordem de cadastramento do usuário


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão salvar alterações    | Fim do processo                | Default           |

___________________________________________________________________________________________________________________________________
 
**Escolher qual usuario deseja remover ou editar**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome do usuário | Caixa de Texto   | Não alteravel | Nome do usuário cadastrado |
| CPF             |   Caixa de Texto | Não alteravel | CPF do usuário cadastrado  |
| Data de nascimento| Data           | Não alteravel | Data do usuário cadastrado |
| ID|  Caixa de Texto        | Não alteravel | ID da ordem do usuário cadastrado |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão remover        | Leva à um alert              | Default           |
| Botão editar        | Encaminha para tela de editar usuarios  | Default          |

___________________________________________________________________________________________________________________________________

**Confirmar remoção do usuário**

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão OK| Remove o usuário | default |
| Botão cancelar | Volta á tela anterior | default |




