


## Integrantes do Grupo

Kayque Ferreira dos Santos - Desenvolvedor Backend

André Alves da Silva - Desenvolvedor Backend

Gabriel de Souza Grego - Desenvolvedor Frontend (não atuou nesse código)

## Descrição

O Solinveste é um aplicativo para realizar cálculos que ajudam os usuários a optar por
implementarem a energia solar em suas residências.

## Público-Alvo

O aplicativo é voltado para usuários que desejam começar a utilizar a energia solar em suas casas.

## Problemas que a Aplicação se Propõe a Resolver

O sistema irá receber dados da conta de energia do usuário, como o valor mensal e o valor por khw e,
através disso, realizará os cálculos necessários para fornecer estimativas para o retorno de investimento, quantidade
necessária de paineis solares entre outras informações pertinentes para a implementação da energia solar.

## Instruções para Rodar a Aplicação

### Pré-requisitos

- Java 17+
- Oracle Database
- Gradle 7+
- Insomnia/Postman (para testar as APIs)
  IDE (como IntelliJ ou Eclipse)

### Configuração

1. Clone o repositório:

```
git clone https://github.com/kayquesann/solinveste.git
```

2. Vá para o arquivo `database_tables.sql` e execute ele para criar as tabelas necessárias


3. Navegue até o diretório do projeto:

```
cd solinveste
```

4. Configure as variáveis de ambiente no arquivo application.properties para a conexão com o banco de dados Oracle:

```
spring.datasource.url=${url_banco}
spring.datasource.username=${oracle_user}
spring.datasource.password=${oracle_password}
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

5. Instale as dependências e compile o projeto com o Gradle:

```
./gradlew build
```

6. Execute a aplicação

```
./gradlew bootRun
```

7. Acesse sua ferramenta de teste para interagir com a API

## Imagens da Aplicação

![Alt Text](src/main/resources/images/imagem2.png)

![Alt text](src/main/resources/images/imagem3.png)

![Alt Text](src/main/resources/images/imagem4.png)

![Alt Text](src/main/resources/images/imagem5.png)

## 📌 Rotas de Endpoints

Utilize o arquivo que está na pasta raiz do projeto:

`Solinveste API.postman_collection.json`

e importe no Postman para consumir todas as rotas e endpoints.

## Links dos Videos

Link do PITCH - https://youtu.be/8vf6YciO0nc
