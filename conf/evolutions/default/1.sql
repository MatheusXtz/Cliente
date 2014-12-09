# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cliente (
  id_cliente                bigint not null,
  nome                      varchar(255),
  constraint pk_cliente primary key (id_cliente))
;

create sequence cliente_seq;




# --- !Downs

drop table if exists cliente cascade;

drop sequence if exists cliente_seq;

