# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table administrador (
  id                        bigint auto_increment not null,
  usuario                   varchar(255),
  senha                     varchar(255),
  constraint pk_administrador primary key (id))
;

create table gastos (
  id                        bigint auto_increment not null,
  parlamentar_id            bigint,
  valor                     float,
  justificativa             varchar(255),
  documento_prova           varchar(255),
  descricao                 varchar(255),
  data                      varchar(255),
  lei                       varchar(255),
  origem_do_dinheiro        varchar(255),
  constraint pk_gastos primary key (id))
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
  parlamentar_id            bigint,
  constraint pk_processo primary key (id))
;

create table sessao (
  data_hora                 datetime not null,
  descricao                 varchar(255),
  ata                       varchar(255),
  carater                   varchar(255),
  presidente                varchar(255),
  constraint pk_sessao primary key (data_hora))
;


create table sessao_parlamentar (
  sessao_data_hora               datetime not null,
  parlamentar_id                 bigint not null,
  constraint pk_sessao_parlamentar primary key (sessao_data_hora, parlamentar_id))
;
alter table gastos add constraint fk_gastos_parlamentar_1 foreign key (parlamentar_id) references parlamentar (id) on delete restrict on update restrict;
create index ix_gastos_parlamentar_1 on gastos (parlamentar_id);
alter table processo add constraint fk_processo_parlamentar_2 foreign key (parlamentar_id) references parlamentar (id) on delete restrict on update restrict;
create index ix_processo_parlamentar_2 on processo (parlamentar_id);



alter table sessao_parlamentar add constraint fk_sessao_parlamentar_sessao_01 foreign key (sessao_data_hora) references sessao (data_hora) on delete restrict on update restrict;

alter table sessao_parlamentar add constraint fk_sessao_parlamentar_parlamentar_02 foreign key (parlamentar_id) references parlamentar (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table administrador;

drop table gastos;

drop table parlamentar;

drop table sessao_parlamentar;

drop table processo;

drop table sessao;

SET FOREIGN_KEY_CHECKS=1;

