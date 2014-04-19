# Portal da Transparência

Repositório para Sistema de Transparência Pública para a Assembleia Legislativa
do Rio Grande do Norte, desenvolvido como projeto da disciplina de Engenharia
de Software na UFRN.

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

Ao finalizar a instalação, crie um novo banco de dados com

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
