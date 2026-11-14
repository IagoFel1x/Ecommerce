# Ecommerce

Sistema de e-commerce em **Java** com banco de dados **MySQL**, organizado em camadas (MVC + DAO). Hoje o sistema lista produtos e busca por ID a partir de um menu no terminal.

## Estrutura

```
Ecommerce/
├── ecommerce.sql          # Criação do banco e dados de exemplo
└── Ecommerce/             # Projeto Maven
    ├── pom.xml
    └── src/main/java/
        ├── principal/     # Principal.java (main e menu)
        ├── controller/    # ProdutoController
        ├── database/      # ConexaoBD (interface) e ConexaoMySQL
        ├── model/         # Produto e ProdutoDAO
        └── view/          # ProdutoView
```

## Banco de dados

O arquivo `ecommerce.sql` cria o banco `ecommerce` com as tabelas:

| Tabela | Descrição |
|--------|-----------|
| `produtos` | Catálogo: nome, descrição, preço e estoque |
| `transacoes` | Pagamentos: valor, método, data e status |
| `emails` | Registro de e-mails enviados |

O script também insere 5 produtos de exemplo.

## Tecnologias

- Java 17+
- Maven
- MySQL 8
- `mysql-connector-j` 9.4.0

## Como executar

1. Crie o banco:

```bash
mysql -u root -p < ecommerce.sql
```

2. Informe as credenciais por variáveis de ambiente (nenhuma senha fica no código):

| Variável | Padrão |
|----------|--------|
| `ECOMMERCE_DB_URL` | `jdbc:mysql://localhost:3306/ecommerce` |
| `ECOMMERCE_DB_USER` | `root` |
| `ECOMMERCE_DB_PASSWORD` | *(vazia)* |

No PowerShell:

```powershell
$env:ECOMMERCE_DB_USER = "root"
$env:ECOMMERCE_DB_PASSWORD = "sua_senha"
```

No Linux/macOS:

```bash
export ECOMMERCE_DB_USER=root
export ECOMMERCE_DB_PASSWORD=sua_senha
```

3. Compile e execute:

```bash
cd Ecommerce
mvn compile exec:java
```

## Próximos passos

- Cadastro, atualização e remoção de produtos
- Registro de transações e envio de e-mails (as tabelas já existem no banco)

## Autor

[Iago Cordeiro Felix](https://github.com/IagoFel1x)
