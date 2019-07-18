create table if not exists orders (
  id             serial primary key,
  user_id        integer not null,
  item_id        integer [],
  article_number varchar(64)[] ,
  price double precision not null,
  address varchar(200) not null,
  phone varchar(30) not null,
  payment_method varchar(100),
  delivery_method varchar(100),
  constraint orders_user_id_fkey foreign key (user_id) references users(id)

);
