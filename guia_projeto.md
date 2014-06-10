# Portal da Transparência

O sistema está sendo desenvolvido usando Java com o [Play Framework][play]
(v2.2.2).

[play]: http://www.playframework.com/ (Play Framework)

## Configuração (para Ubuntu)

### Configurando o banco de dados
Se você ainda não tem o MySQL instalado:

```bash
$ sudo apt-get install mysql-server
```

Ao ser requisitada a senha, use `admin`. A senha é utilizada na configuração do
projeto (`transparencia/conf/application.conf`).

Ao finalizar a instalação, faça o login no shell do MySQL

```bash
$ mysql -u root -p
```

Insira a senha `admin` e, se tudo der certo, crie o banco de dados do projeto
com

```sql
CREATE DATABASE transparencia;
```

### Sincronizando o ORM
O banco de dados criado deve ser sincronizado com os modelos do projeto. Com o
Play instalado, vá ao diretório principal do projeto e execute:

```bash
$ play
$ run
```

Abra o projeto no browser (`http://localhost:9000`) e clique no botão que diz
`Apply this script now!`. Depois disso, o projeto deve estar rodando
corretamente.

### Usando o sistema
Antes de começar a usar o sistema, deve ser criada uma conta de admin. Para
fazer isso, faça o login no shell do MySQL e rode as queries:

```sql
USE transparencia;
INSERT INTO administrador VALUES (NULL, "admin", "admin")
```

Assim, é possível fazer o login no painel de controle em
`localhost:9000/administrador`. O CRUD é feito nesse painel de controle.

Na página principal, é possível ver a lista de parlamentares cadastrados e as
sessões.
