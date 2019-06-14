
---------- Criando Tabela 
CREATE DATABASE desafio_3

---------- Usa o banco de dados 
use desafio_3;

---------- Cria tabela cliente
create table cliente (
id numeric (18,0),
nome varchar (255),
street varchar(255),
city varchar(255),
state char(2),
credit_limit numeric (18,2),
primary key (id)
);

---------- Cria tabela pessoa
create table pessoa (
id_c numeric (18,0),
cpf char(14),
foreign key (id) references cliente (id)
);

---------- Insere linhas na tabela cliente
INSERT INTO `cliente`(`id`, `nome`, `street`, `city`, `state`, `credit_limit`) 
VALUES 
(123,'Lucas','Rua Albertino','Nova Iguacu','RJ',1000.00),
(321,'Sidney','Rua B','Seropedica','RJ',2000.00);

---------- Insere linhas na tabela
insert into pessoa (id_c,cpf)
values
(123,'123.456.789-10'),
(321,'12345678910');

---------- Faz a pesquisa tratando o cpf
SELECT id,nome,street,city,state,credit_limit,REGEXP_REPLACE(cpf, '([0-9]{3})([0-9]{3})([0-9]{3})','\\1.\\2.\\3-\\4') AS cpf FROM pessoa AS p
JOIN cliente as c on c.id = p.id_c



