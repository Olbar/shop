drop table if exists categories;
create table if not exists categories (
  id serial primary key,
  name varchar(64) not null unique,
  active  boolean not null default true
);

insert into categories (name)
values
      ('Туристические палатки'),
      ('Спальные мешки'),
      ('Рыболовные снасти'),
      ('Все для пикника'),
      ('Спортивные товары');


drop table if exists items;

create table if not exists items(
id serial primary key,
name varchar(100) not null unique,
article_number varchar(64) not null unique,
price double precision not null,
count integer not null,
category_id integer not null,
constraint auth_sessions_category_id_fkey foreign key (category_id) references categories(id)
);

insert into items(name,article_number,price,count,category_id) values
('палатка одноместная','0000001','2500',9,1),
('палатка двухместная','0000002','4500',13,1),
('палатка трехместная','0000003','12500',5,1),
('палатка четырехместная','0000004','17300',4,1),
('палатка пятиместная','0000005','18400',4,1),
('палатка кемпинговая 4x','0000006','18400',4,1),
('палатка кемпинговая 5x','0000007','21800',2,1),
('палатка с автокаркасом','0000008','9900',6,1),
('ремкомплект','0000009','560',25,1),
('комплект дуг','0000010','340',18,1),
('спальный мешок','0000011','1250',21,2),
('спальный мешок 2x','0000012','1850',14,2),
('спиннинг ultralight','0000013','5500',6,3),
('набор грузил','0000014','100',16,3),
('катушка инерционная','0000015','2500',5,3),
('мангал','0000016','450',55,4),
('набор шампуров','0000017','350',40,4),
('уголь березовый 10л','0000018','150',86,4),
('эспандер кистевой 30кг','0000019','150',12,5),
('теннисные ракетки','0000020','500',8,5);

drop table if exists users;

create table if not exists users(
id serial primary key,
first_name varchar(30) not null,
address varchar(100),
login varchar(30) not null unique,
password varchar(100) not null
);

insert into users(login,first_name, password) values
('admin','Ivan','admin'),
('test','Petr', 'test');

drop type  if exists raiting;
CREATE TYPE raiting AS ENUM ('excellent', 'good', 'bad','awful','terrible');

drop table if exists feedbacks;

create table if not exists feedbacks(
id serial primary key,
text varchar(256) not null,
send_date    timestamp not null,
author_id    integer not null,
item_id  integer not null,
mark raiting,
constraint feedbacks_author_id_fkey foreign key (author_id) references users(id),
constraint feedbacks_item_id_fkey foreign key (item_id) references items(id)
);

  insert into feedbacks (text, send_date, author_id, item_id)
  values
('Товар хороший, жаль что небесплатно', now(), 1, 1),
('Прекрасный товар', now(), 1, 2),
('Всем доволен', now(), 1, 2),
('Ужасный товар', now(), 1, 3);