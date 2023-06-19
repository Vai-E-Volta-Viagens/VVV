drop table if exists users;
create table users (

	id int auto_increment primary key,
	nome varchar(255) not null,
	email varchar(255) not null,
	senha varchar(255) not null

);