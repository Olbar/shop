
drop table if exists items;

create table if not exists items(
id serial primary key,
name varchar(64) not null unique,
price double precision not null,
count integer not null
)

insert into items(name,price,count) values
('палатка одноместная','2500',9),
('палатка двухместная','4500',13),
('спальный мешок','1250',21),
('мангал','450',55),
('набор шампуров','350',40);

drop table if exists users;

create table if not exists users(
id serial primary key,
login varchar(30) not null unique,
password varchar(100) not null
)

insert into users(login, password) values
('admin','admin'),
('test', 'test');