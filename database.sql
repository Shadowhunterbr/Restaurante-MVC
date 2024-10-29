create database restaurante;

use restaurante;
create table produtos(
id_produto int primary key auto_increment,
nome_produto varchar(50) not null,
custo_produto double not null,
preco_produto double not null,
porcentagem_compra double not null,
quantidade_vendida int, 
produto_total_vendido double

);

create table funcionarios(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(50) not null,
cargo_funcionario varchar(20) not null,
salario_funcionario double not null
);

create table vendas(
id_venda int primary key auto_increment,
total_venda_bruta double,
total_salarios double,
itens_vendidos int not null,
custo_total_produtos double not null,
lucro_liquido double  not null

);

alter table funcionarios add column login varchar(20);
alter table funcionarios add column senha varchar(20);


INSERT INTO funcionarios (nome_funcionario, cargo_funcionario, salario_funcionario, login, senha)
VALUES ('Carlos Souza', 'Garçom', 1800.00, 'carlos_souza', 'senha123');

INSERT INTO produtos (nome_produto, custo_produto, preco_produto, porcentagem_compra, quantidade_vendida, produto_total_vendido)
VALUES ('Pizza Margherita', 10.00, 25.00, 40.00, 50, 0);


SELECT SUM((preco_produto * quantidade_vendida)) AS total_venda_bruta FROM produtos;
 

SHOW VARIABLES LIKE "max_connections";
SET GLOBAL max_connections = 20000;
select * from vendas;
select * from produtos;
select * from funcionarios