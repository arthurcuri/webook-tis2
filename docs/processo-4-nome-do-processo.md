### 3.3.4 Processo 4 – Processo Gerenciamento de Usuário

![Processo Gerenciamento de Usuário](images/processoGU2.png "Modelo BPMN do Processo 4.")


#### Detalhamento das atividades

_Descreva aqui cada uma das propriedades das atividades do processo 3. 
Devem estar relacionadas com o modelo de processo apresentado anteriormente._


**Iniciar gerenciamento de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Não tem         | Não tem          | Não tem        | Não tem           |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Botão adicionar      | Início processo de cadastro de usuario   | Default           |
| Botão remover        | Início do processo alteração de usuario  | Default           |
| Botão alterar        | Inicio processo de remoção de usuario    | Default           |
| Botão voltar         | Retorna para tela anterior               | Default           |


**Enviar dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | ---               |
| Data de nascimento| Caixa de Texto | Apenas Numeros | ---               |
| CPF             |   Caixa de Texto | Apenas Numeros | ---               |
| Maior idade     | Seleção Unica    | Sem Restrição  | ---               |
| Foto RG         | Arquivo          | Sem Restrição  | ---               |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão adicionar      | Fim do processo                | Default           |

**Verificar informações**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Nome            | Caixa de Texto   | Apenas Letras  | ---               |
| Data de nascimento| Data           | Apenas Numeros | ---               |
| CPF             |   Caixa de Texto | Apenas Numeros | ---               |
| Maior idade     | Seleção Unica    | Sem Restrição  | ---               |
| Foto RG         | Arquivo          | Sem Restrição  | ---               |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Aprovar dados         | Fim do processo               | Default           |
| Reprovar dados        | Fim do processo               | Default           |

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

**Remover dados de usuários**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Usuários cadastrados| Seleção múltipla| Sem restrição | Nome do usuário cadastrado |
| Data de nascimento  | Data            | Apenas Numeros| ---                        |



| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| Botão voltar         | Retorna para tela anterior     | Default           |
| Botão remover        | Fim do processo                | Default           |
