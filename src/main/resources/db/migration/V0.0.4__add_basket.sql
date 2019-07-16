create table if not exists basket (
  id             serial primary key,
  user_id        integer not null,
  item_id        integer not null,
  article_number varchar(64) not null,
  price double precision not null,
  constraint basket_user_id_fkey foreign key (user_id) references users(id),
  constraint basket_item_id_fkey foreign key (item_id) references items(id)
);

insert into basket(user_id,item_id,article_number,price)
values
        (2, 1,'0000001','2500'),
        (1, 2,'0000002','4500');