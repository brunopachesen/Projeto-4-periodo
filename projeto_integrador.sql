create database proj_integrador;
use proj_integrador;

create table tb_cidade
(
	id_cid int not null auto_increment primary key,
    nome_cid varchar(40),
    uf varchar(2)
);

create table tb_endereco
(
	id_end int not null auto_increment primary key, 
    rua varchar(50), 
    num int not null, 
    id_cid int not null,
    foreign key (id_cid) references tb_cidade (id_cid)

);

create table tb_modelo
(
	id_mod int not null auto_increment primary key,
    nome_mod varchar(20)
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

create table tb_cliente
(
	id_cli int not null auto_increment primary key,
    nome_cli varchar(40),
	tel varchar(10),
    id_auto int not null,
    id_end int not null,
    cpf varchar(11),
    foreign key (id_auto) references tb_automovel(id_auto),
    foreign key (id_end) references tb_endereco(id_end)
);

create table tb_fabrica
(
	id_fabrica int not null auto_increment primary key,
    nome varchar(40),
    cnpj varchar(15),    
    tel varchar(10),
    id_end int not null,
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
    foreign key (id_end) references tb_endereco(id_end) 
);

create table tb_cli_auto_conc
(
	
    id_cli_auto_conc int not null auto_increment primary key,
    id_cli int not null,
    id_auto int not null,
    id_conc int not null,
    
    foreign key (id_cli) references tb_cliente(id_cli),
    foreign key (id_auto) references tb_automovel(id_auto),
    foreign key (id_conc) references tb_concessionaria(id_conc)

);

create table tb_forn_fab
(
	id_forn_fab int not null auto_increment primary key,
    id_forn int not null,
    id_fabrica int not null, 
    foreign key (id_forn) references tb_fornecedor(id_forn),
    foreign key (id_fabrica) references tb_fabrica(id_fabrica)

);