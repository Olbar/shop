drop type  if exists sex;
--CREATE TYPE sex AS ENUM ('Мужской','Женский');

create table if not exists user_details (
  id            integer primary key,
  first_name    varchar(30) not null,
  last_name     varchar(30) not null,
  avatar_path   text,
  age           integer,
  constraint user_details_id_fkey foreign key (id) references users(id)
);

insert into user_details
values
    (1, 'Ivan', 'Ivanov', '/avatars/default.png', 25),
    (2, 'Petr', 'Petrov', '/avatars/default.png', 27);