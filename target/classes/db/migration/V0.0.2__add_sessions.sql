create table if not exists auth_sessions (
  sid varchar(100) primary key,
  user_id integer not null unique,
  expired_date timestamp not null,
  constraint auth_sessions_user_id_fkey foreign key (user_id) references users(id)
);