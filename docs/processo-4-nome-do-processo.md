### 3.3.4 Processo 4 – Processo Gerenciamento de Usuário

![Processo Gerenciamento de Usuário](images/processoGU.png "Modelo BPMN do Processo 4.")


#### Detalhamento das atividades


**Iniciar gerenciamento de usuários -**
O bibliotecario irá acessar a tela de gerenciamento de usuários, nela haverá 4 botões uma que irá levar para a tela de adicionar um usuário, um que leve para a tela de remoção de usuários, um que irá levar para a página de alteração e um botão para voltar

**Enviar dados de usuários -**
O usuário deve preencher os campos da tela com seus dados.

**Verificar informações -**
O bibliotecario irá verificar as informações enviadas para validar a documentação do usuário ou do seu responsavel.

**Editar dados de usuários -**
O bibliotecário então é redirecionado para uma tela com um campo de seleção múltipla com todos os usuarios cadastrados ele então poderá selecionar um ou mais para serem removidos. Nela haverá um campo com seleção múltipla contendo todos os usuarios cadastrados. Também haverá um botão para voltar e outro para remover.

**Remover dados de usuários -**
O bibliotecário então é redirecionado para uma tela com um capo para seleção única contendo todos os livros usuarios, ao selecionar um usuario 3 novos campos de área de texto irão aparecer sendo eles o Nome, a Data e o CPF do usuário selecionado com os valores que foram cadastrados ele então poderá alterar os campos. Também haverá um botão para voltar e outro para alterar.



**Iniciar gerenciamento de usuários**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---                         |
| Botão adicionar      | Início processo de cadastro de usuario   | Default           |
| Botão remover ou editar | Inicio processo de remoção de usuario ou edição  | Default|
| Botão voltar         | Retorna para tela anterior               | Default           |

___________________________________________________________________________________________________________________________________

**Preencher dados de usuários**

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


**Editar dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome do usuário | Caixa de Texto | Sem restrição | Nome do usuário cadastrado |
| CPF             |   Caixa de Texto | Apenas Numeros | CPF do usuário cadastrado               |
| Data de nascimento| Data           | Apenas Numeros | Data do usuário cadastrado               |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão salvar alterações    | Fim do processo                | Default           |

___________________________________________________________________________________________________________________________________
 
**Remover dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome do usuário | Caixa de Texto   | Não alteravel | Nome do usuário cadastrado |
| CPF             |   Caixa de Texto | Não alteravel | CPF do usuário cadastrado  |
| Data de nascimento| Data           | Não alteravel | Data do usuário cadastrado |
| Ações |  Caixa de Texto        | Não alteravel | Remover/Editar |




| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão remover        | Fim do processo                | Default           |
| Botão editar        | Encaminha para tela de editar usuarios  | Default          |
