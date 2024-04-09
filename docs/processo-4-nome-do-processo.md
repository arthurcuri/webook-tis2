### 3.3.4 Processo 4 – Processo Gerenciamento de Usuário

![Processo Gerenciamento de Usuário](images/processoGU2.png "Modelo BPMN do Processo 4.")


#### Detalhamento das atividades


**Iniciar gerenciamento de usuários -**
O bibliotecario irá acessar a tela de gerenciamento de usuários, nela haverá 4 botões uma que irá levar para a tela de adicionar um usuário, um que leve para a tela de remoção de usuários, um que irá levar para a página de alteração e um botão para voltar

**Enviar dados de usuários -**
O usuário deve preencher os campos da tela com seus dados, caso maior de 18 anos marcar a seleção unica e enviar foto do seu RG/Documento de Identidade, caso não marcar a seleção informada enviar RG/Documento de Identidade de um responsavel.

**Verificar informações -**
O bibliotecario irá verificar as informações enviadas para validar a documentação do usuário ou do seu responsavel.

**Editar dados de usuários -**
O bibliotecário então é redirecionado para uma tela com um campo de seleção múltipla com todos os usuarios cadastrados ele então poderá selecionar um ou mais para serem removidos. Nela haverá um campo com seleção múltipla contendo todos os usuarios cadastrados. Também haverá um botão para voltar e outro para remover.

**Remover dados de usuários**

O bibliotecário então é redirecionado para uma tela com um capo para seleção única contendo todos os livros usuarios, ao selecionar um usuario 3 novos campos de área de texto irão aparecer sendo eles o Nome, a Data e o CPF do usuário selecionado com os valores que foram cadastrados ele então poderá alterar os campos. Também haverá um botão para voltar e outro para alterar.



**Iniciar gerenciamento de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Não tem         | Não tem          | Não tem        | Não tem           |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão adicionar      | Início processo de cadastro de usuario   | Default           |
| Botão alterar        | Início do processo alteração de usuario  | Default           |
| Botão remover        | Inicio processo de remoção de usuario    | Default           |
| Botão voltar         | Retorna para tela anterior               | Default           |

___________________________________________________________________________________________________________________________________

**Enviar dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | ---               |
| Data de nascimento| Caixa de Texto | Apenas Numeros | ---               |
| CPF             |   Numero         | 12 Numeros | ---               |
| Maior idade     | Seleção Unica    | Sem Restrição  | ---               |
| Foto documento identidade | Arquivo          | Sem Restrição  | ---               |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão adicionar      | Fim do processo                | Default           |

___________________________________________________________________________________________________________________________________

**Verificar informações**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | ---               |
| Data de nascimento| Data           | Apenas Numeros | ---               |
| CPF             |   Numero | 12 Numeros | ---               |
| Maior idade     | Seleção Unica    | Sem Restrição  | ---               |
| Foto documento identidade| Arquivo          | Sem Restrição  | ---               |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Aprovar dados         | Fim do processo               | Default           |
| Reprovar dados        | Fim do processo               | Default           |

___________________________________________________________________________________________________________________________________

**Editar dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | Nome do usuário cadastrado|
| Data de nascimento| Data           | Apenas Numeros | ---               |
| CPF             |   Caixa de Texto | Apenas Numeros | ---               |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão editar         | Fim do processo                | Default           |

___________________________________________________________________________________________________________________________________
 
**Remover dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Usuários cadastrados| Seleção múltipla| Sem restrição | Nome do usuário cadastrado |
| Data de nascimento  | Data            | Apenas Numeros| ---                        |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão remover        | Fim do processo                | Default           |
