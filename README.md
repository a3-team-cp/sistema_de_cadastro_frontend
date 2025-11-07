# 🛠️ Sistema de Cadastro Frontend

## 👥 Integrantes

| Nome Completo               | Usuário GitHub       | RA          |
|-----------------------------|----------------------|--------------|
| Diego Wobeto Maglia Muller  | diegowmmuller        | 10724265729  |
| Lorenzo Bruscato            | LorenzoBruscato      | 10724262961  |
| Murilo Vieira Moura         | Murilo               | 10724269339  |
| Henrique Bernardes Rosa     | HenriqueBrosa        | 10724263295  |

Este é um software desenvolvido em conjunto para **gerenciar um sistema de controle de estoque**, composto por duas partes principais:

- **Backend:** Responsável pela conexão com o banco de dados MySQL, onde são realizadas todas as operações de persistência, como cadastro, atualização, listagem e exclusão de produtos e categorias.  
- **Frontend:** Este repositório corresponde ao **frontend** do sistema, desenvolvido em **Java**, com foco na interface gráfica e interação do usuário com as funcionalidades do sistema.

O sistema permite cadastrar, listar, atualizar e excluir produtos e categorias de forma simples e eficiente, além de gerar relatórios em PDF, integrando-se diretamente ao backend para manipulação dos dados.


---

## 📦 Requisitos Funcionais e Regras de Negócio

**RF01 - Cadastro de Produtos**  
O sistema deve permitir cadastrar produtos, informando: Nome, Preço unitário, Unidade, Quantidade em estoque, Quantidade mínima em estoque, Quantidade máxima em estoque e Categoria.

**Regras relacionadas:**
- RN05 – Cada produto deve obrigatoriamente estar vinculado a uma categoria existente.
- RN06 – O nome do produto deve conter entre 1 e 100 caracteres.
- RN07 – O preço do produto deve ser maior que zero.
- RN08 – A unidade do produto deve ser informada em valores fixos (ex: 1 = kg, 2 = litro, 3 = ml).
- RN09 – A quantidade mínima deve ser menor ou igual à quantidade máxima.
- RN10 – A quantidade em estoque deve estar entre a quantidade mínima e máxima permitida.
- RN11 – Não é permitido cadastrar dois produtos com o mesmo nome e categoria.

---

**RF02 - Cadastro de Categorias**  
O sistema deve permitir cadastrar categorias, informando: Nome, Tamanho (Pequeno, Médio, Grande) e Embalagem (Lata, Vidro, Plástico).

**Regras relacionadas:**
- RN01 – O nome da categoria deve ser único (não pode haver duas categorias com o mesmo nome).
- RN02 – O tamanho da categoria deve ser selecionado entre os valores permitidos pelo ENUM.
- RN03 – A embalagem da categoria deve ser selecionada entre os valores definidos pelo ENUM.

---

**RF03 - Operações de Inclusão, Alteração, Exclusão e Listagem**  
O sistema deve permitir operações de inclusão, alteração, exclusão e listagem de produtos e categorias.

**Regras relacionadas:**
- RN04 – Não é permitido excluir uma categoria que esteja associada a um ou mais produtos.
- RN12 – Não é permitido excluir um produto se ele estiver sendo utilizado em algum relatório ativo (se aplicável).

---

**RF04 - Cadastro de Produtos com Categoria Vinculada**  
O sistema deve permitir o cadastro de produtos já vinculando cada um a uma categoria existente.

**Regras relacionadas:**
- RN05 (repetida para reforço).

---

**RF05 - Reajuste de Preço**  
Permite reajustar o percentual de preço em todos os produtos.  
- Sem regras listadas.

---

**RF06 - Exibir Produtos e Categorias**  
O sistema deve exibir todos os produtos e categorias cadastrados.  
- Sem regras listadas.

---

**RF07 - Geração de Relatórios**  
O sistema deve gerar relatórios nos formatos Excel, DOC ou PDF.

**Regras relacionadas:**
- RN13 – Produtos com estoque abaixo da quantidade mínima devem ser destacados (visualmente ou em relatório).
- RN14 – O usuário deve escolher o formato do relatório (Excel, DOC ou PDF) antes da geração.
- RN15 – O nome do arquivo do relatório deve ser definido pelo usuário.
- RN16 – O relatório deve conter a data de geração e a lista completa de produtos ou categorias conforme a opção escolhida.
- RN17 – O caminho de salvamento do relatório deve ser um diretório válido no sistema de arquivos.

---

## 📦 Requisitos Não Funcionais

- RNF01 – O sistema deve emitir relatórios em até 3 segundos.
- RNF02 – O sistema deve possuir uma interface gráfica de fácil entendimento.
- RNF03 – O sistema deve garantir a privacidade dos dados dos usuários.
- RNF04 – O sistema deve ser compatível com qualquer versão do sistema operacional Windows.

---

## 🧱 Estrutura do Banco de Dados

**Tabela: categoria**

| Campo     | Tipo        | Descrição                                      |
| ---------- | ------------ | --------------------------------------------- |
| id         | INT          | Identificador único (auto incremento)         |
| nome       | VARCHAR(100) | Nome da categoria                             |
| tamanho    | ENUM         | Tamanho da categoria (‘PEQUENO’, ‘MEDIO’, ‘GRANDE’) |
| embalagem  | ENUM         | Tipo de embalagem (‘PLASTICO’, ‘LATA’, ‘VIDRO’) |
| ativo      | BOOLEAN      | Indica se a categoria está ativa (padrão: TRUE) |

---

**Tabela: produto**

| Campo              | Tipo          | Descrição                                               |
| ------------------ | ------------- | ------------------------------------------------------- |
| id                 | INT           | Identificador único (auto incremento)                   |
| nome               | VARCHAR(100)  | Nome do produto                                         |
| preco_unitario     | DECIMAL(10,2) | Preço unitário do produto                               |
| unidade            | VARCHAR(100)  | Unidade de medida (kg, litro, ml, etc.)                 |
| quantidade         | INT           | Quantidade atual em estoque                             |
| quantidade_minima  | INT           | Quantidade mínima permitida                             |
| quantidade_maxima  | INT           | Quantidade máxima permitida                             |
| categoria_id       | INT           | Chave estrangeira que referencia a tabela categoria     |
| ativo              | BOOLEAN       | Indica se o produto está ativo (soft delete, padrão: TRUE) |

---

**Tabela: registro**

| Campo        | Tipo         | Descrição                                                               |
| ------------- | ------------- | ----------------------------------------------------------------------- |
| id            | INT          | Identificador único (auto incremento)                                   |
| data          | TIMESTAMP    | Data e hora da movimentação                                            |
| produto_id    | INT          | Chave estrangeira que referencia o produto movimentado                 |
| quantidade    | INT          | Quantidade movimentada                                                 |
| movimentacao  | ENUM         | Tipo de movimentação (‘NENHUM’, ‘ENTRADA’, ‘SAIDA’)                    |
| status        | ENUM         | Estado da movimentação (‘ACIMA’, ‘ABAIXO’, ‘DENTRO’, ‘ADICIONADO’, ‘NOMEALTERADO’, ‘DELETADO’, ‘NENHUM’) |

---

🗄️ **Relações entre tabelas**
- Cada **produto** pertence a uma **categoria** (`categoria_id` → `categoria.id`).
- Cada **registro** está associado a um **produto** (`produto_id` → `produto.id`).

---

💡 **Observação:**  
O campo `ativo` nas tabelas `categoria` e `produto` permite a implementação de *soft delete*, ou seja, exclusões lógicas sem remover os dados do banco.

---

## ⚙️ Tecnologias Utilizadas

- **Java 21** — Linguagem principal do projeto  
- **Maven 3.9.9** — Gerenciador de dependências e build  
- **MySQL 8.0.42** — Banco de dados relacional  
- **JDBC 9.2.0** — Conexão entre Java e MySQL  
- **Jackson Databind 2.16.0** — Manipulação e conversão de objetos JSON  
- **iTextPDF 5.5.13.3** — Geração de relatórios e documentos em PDF  
- **IDE:** NetBeans 21


## ⚙️ Configurando o Banco de Dados MySQL

- Para rodar o programa é necessário fazer o download do **MySQL Workbench 8.0**.  
- Acesse o arquivo [`banco.sql`](banco.sql) para criar o banco de dados.  
- **Usuário:** root  
- **Senha:** 1234567  

---

## 🔗 Link do Backend

- [Sistema de Cadastro Backend](https://github.com/a3-team-cp/sistema_de_cadastro_backend)
