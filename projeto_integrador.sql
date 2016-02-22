create database proj_integrador;
use proj_integrador;

create table tb_cidade
(
	id_cid int not null auto_increment primary key,
    nome_cid varchar(40),
    uf varchar(2)
);

create table tb_automovel
(
	id_auto int not null auto_increment primary key,
    id_mod int not null,
    cor varchar(20),
    chassi varchar(20),
    ano int,
    foreign key (id_mod) references tb_modelo(id_mod)

);

create table tb_modelo
(
	id_mod int not null auto_increment primary key,
    nome_mod varchar(20)
);

create table tb_cliente
(
	id_cli int not null auto_increment primary key,
    nome_cli varchar(40),
	tel varchar(10),
    id_auto int not null,
    id_end int not null,
    foreign key (id_auto) references tb_automovel(id_auto),
    foreign key (id_end) references tb_endereco(id_end)
);

create table tb_montadora
(
	id_mont int not null auto_increment primary key,
    nome varchar(40),
    cnpj varchar(15),    
    tel varchar(10),
    id_end int not null,
    id_cid int not null,
    foreign key (id_cid) references tb_cidade (id_cid),
    foreign key (id_end) references tb_endereco (id_end) 
);

create table tb_fornecedor
(
	id_forn int not null auto_increment primary key,
    cnpj varchar(15),
    tel varchar(10),
    id_end int not null, 
    foreign key (id_end) references tb_endereco(id_end) 
);

create table tb_concessionaria 
(
	id_conc int not null auto_increment primary key,
    nome_conc varchar(40),
    cnpj varchar(15),
    id_end int not null,
    tel varchar(10),
	id_cid int not null,
    foreign key (id_cid) references tb_cidade(id_cid),
    foreign key (id_end) references tb_endereco(id_end) 
);

create table tb_endereco
(
	id_end int not null auto_increment primary key, 
    rua varchar(50), 
    num int not null, 
    id_cid int not null,
    foreign key (id_cid) references tb_cidade (id_cid)

);