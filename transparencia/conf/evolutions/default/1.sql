# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table administrador (
  id                        bigint auto_increment not null,
  usuario                   varchar(255),
  senha                     varchar(255),
  constraint pk_administrador primary key (id))
;

create table parlamentar (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  data_nascimento           datetime,
  partido                   varchar(255),
  formacao                  varchar(255),
  cidade                    varchar(255),
  gabinete                  varchar(255),
  salario                   float,
  foto                      varchar(255),
  biografia                 varchar(255),
  constraint pk_parlamentar primary key (id))
;

create table processo (
  id                        bigint auto_increment not null,
  descricao                 varchar(255),
  acusacoes                 varchar(255),
  processo                  varchar(255),
  status                    varchar(255),
  defesa                    varchar(255),
  texto_defesa              varchar(255),
  orgao_de_investigacao     varchar(255),
  constraint pk_processo primary key (id))
;

create table sessao (
  id                        bigint auto_increment not null,
  data_hora                 datetime,
  descricao                 varchar(255),
  ata                       varchar(255),
  carater                   varchar(255),
  presidente                varchar(255),
  constraint pk_sessao primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table administrador;

drop table parlamentar;

drop table processo;

drop table sessao;

SET FOREIGN_KEY_CHECKS=1;

