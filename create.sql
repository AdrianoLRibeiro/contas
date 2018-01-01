create table conta_filial (id varchar(255) not null, data_criacao date, nome varchar(255), status integer, parent varchar(255), primary key (id))
create table conta_matriz (id varchar(255) not null, data_criacao date, nome varchar(255), status integer, primary key (id))
create table pessoa_fisica (cpf varchar(255) not null, data_nascimento date, nome varchar(255), conta varchar(255), primary key (cpf))
create table pessoa_juridica (cnpj varchar(255) not null, nome_fantasia varchar(255), razao_social varchar(255), conta varchar(255), primary key (cnpj))
