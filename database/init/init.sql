create table fca_user (
  user_id     serial PRIMARY KEY,
  login       varchar(50) not null,
  email       varchar(100) not null,
  pass        varchar(50) not null,
  firstname   varchar(100),
  lastname    varchar(100),
  upper       integer references fca_user (user_id),
  profilepic  integer
);

create table fuzi
(
  plusun_id   serial PRIMARY KEY,
  user1_id    integer references fca_user (user_id),
  user2_id    integer references fca_user (user_id)
);

create table album(
  album_id  serial PRIMARY KEY,
  name      varchar(50),
  owner     integer references fca_user(user_id)
);

create table picture(
  picture_id  serial PRIMARY KEY,
  name        varchar(50),
  path        varchar(50),
  album       integer references album(album_id)
);

create table post(
  post_id   serial primary key,
  title     varchar(50),
  body      text,
  date      date,
  writer    integer references fca_user(user_id)
);

create table post_pics(
  post_pics_id  serial primary key,
  post_id       integer references post(post_id),
  pics_id       integer references picture(picture_id)
);

create table event(
  event_id    serial primary key,
  name        varchar(50),
  date        date,
  place       varchar(100),
  description text,
  event_pics  integer,
  event_post  integer references post(post_id)
);

create table position(
  position_id   serial primary key,
  user_position integer references fca_user(user_id),
  latitude      double precision,
  longitude     double precision
);

create table bill(
  bill_id serial primary key,
  amount  integer,
  date    date,
  payer   integer references fca_user(user_id)
);

create type bottle_type as enum ('Pastis', 'Get', 'Vodka', 'Rhum');

create table bottle(
  bottle_id     serial primary key,
  quantity      integer,
  date          date,
  bottle_type   bottle_type,
  delivery_user integer references fca_user(user_id)
);
