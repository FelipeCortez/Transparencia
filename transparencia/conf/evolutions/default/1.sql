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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table administrador;

drop table parlamentar;

SET FOREIGN_KEY_CHECKS=1;

