create table conta_filial (id varchar(255) not null, data_criacao date, nome varchar(255), saldo decimal(19,2), status integer, pessoa varchar(255), parent varchar(255) not null, primary key (id))
create table conta_matriz (id varchar(255) not null, data_criacao date, nome varchar(255), saldo decimal(19,2), status integer, pessoa varchar(255), primary key (id))
create table pessoa_fisica (id varchar(255) not null, data_nascimento date, nome varchar(255), primary key (id))
create table pessoa_juridica (id varchar(255) not null, nome_fantasia varchar(255), razao_social varchar(255), primary key (id))
