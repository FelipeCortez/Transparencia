Guia rápido para contribuir
===========================

Para Unix
---------
Caso não tenha o git instalado:

```bash
$ sudo apt-get install git
```

Se você não tem os arquivos do repositório, navegue (usando `cd`) para um
diretório (`cd ~/Desenvolvimento/`, por exemplo). O comando seguinte
baixará o repositório para um novo diretório no seu computador (no exemplo,
`~/Desenvolvimento/Transparencia`).

```bash
$ git clone https://github.com/CFelipe/Transparencia.git
```

Se você fez alterações em um ou mais arquivos e deseja enviá-los ao
repositório, adicione-os à área de preparação com

```bash
$ git add um_arquivo outro_arquivo
```

E então faça um commit:

```bash
$ git commit -m "Resumo das suas mudanças"
```

As mudanças ainda estarão apenas no seu computador. Para atualizar o
repositório remoto (online), configure seu usuário e email:

```bash
$ git config --global user.name "Seu nome"
$ git config --global user.email seuemail@exemplo.com
```

E simplesmente envie as alterações com

```bash
$ git push origin master
```

Para baixar as últimas versões dos arquivos do repositório remoto, use

```bash
$ git pull
```
