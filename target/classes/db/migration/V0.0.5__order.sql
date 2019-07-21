
create table if not exists orders (
  id             serial primary key,
  user_id        integer not null,
  item_ids        varchar(20),
  address varchar(200) not null,
  phone varchar(30) not null,
  payment_method varchar(40) CHECK(payment_method ='Наличные' OR payment_method ='Банковская карта'),
  delivery_method varchar(40) CHECK(delivery_method ='Самовывоз' OR delivery_method ='Доставка'),
  date timestamp not null,
  total_price double precision,
  constraint orders_user_id_fkey foreign key (user_id) references users(id)

);
