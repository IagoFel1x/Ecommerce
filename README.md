# Ecommerce

Sistema de e-commerce em **Java** com banco de dados **MySQL**, organizado em camadas (MVC).

## Estrutura

```
Ecommerce/
├── ecommerce.sql          # Script de criação do banco e dados de exemplo
└── Ecommerce/             # Projeto Maven
    ├── pom.xml
    └── src/main/java/
        ├── Priincipal/    # Ponto de entrada
        ├── controller/
        ├── database/      # Conexão com o MySQL
        ├── model/
        └── view/
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

- Java 8+
- Maven
- MySQL
- `mysql-connector-j` 9.4.0

## Como executar

1. Crie o banco rodando o script no MySQL:

```bash
mysql -u root -p < ecommerce.sql
```

2. Ajuste usuário e senha da conexão na classe do pacote `database`.
3. Compile e execute:

```bash
cd Ecommerce
mvn clean package
```

## Observações

- O pacote `Priincipal` tem erro de digitação (deveria ser `Principal`) e foge da convenção de nomes de pacotes Java (minúsculas).
- Evite deixar a senha do banco fixa no código; prefira variáveis de ambiente.

## Autor

[Iago Cordeiro Felix](https://github.com/IagoFel1x)
