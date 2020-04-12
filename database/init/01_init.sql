create table userfca (
  user_id        serial PRIMARY KEY,
  login         varchar(50) not null,
  email         varchar(100) not null,
  pass          varchar(100) not null,
  firstname     varchar(100),
  lastname      varchar(100),
  accesstoken   varchar(50),
  upper         integer references userfca (user_id),
  profil_pic     integer,
  user_position  integer
);

create table plusun
(
  plusun_id      serial PRIMARY KEY,
  user1_id       integer references userfca (user_id),
  user2_id       integer references userfca (user_id)
);

create table album(
  album_id       serial PRIMARY KEY,
  name          varchar(50),
  owner         integer references userfca (user_id)
);

create table picture(
  picture_id     serial PRIMARY KEY,
  name          varchar(50),
  path          varchar(50),
  album         integer references album(album_id)
);

create table posts(
  post_id        serial primary key,
  title         varchar(50),
  body          text,
  date          date,
  writer        integer references userfca (user_id)
);

create table postpics(
  postpics_id    serial primary key,
  post_id        integer references posts(post_id),
  pics_id        integer references picture(picture_id)
);

create table event(
  event_id       serial primary key,
  name          varchar(50),
  start_date     date,
  end_date     date,
  place         varchar(100),
  description   text,
  eventpics     integer references picture(picture_id),
  eventpost     integer references posts(post_id)
);

create table position(
  position_id    serial primary key,
  latitude      double precision,
  longitude     double precision,
  position_user  integer references userfca (user_id)
);

create table bill(
  bill_id        serial primary key,
  amount        double precision ,
  date          date,
  payer         integer references userfca (user_id)
);

create type bottletype as enum ('Pastis', 'Get', 'Vodka', 'Rhum');

create table bottlebill(
  bottle_bill_id      serial primary key,
  quantity      integer,
  date          date,
  bottle_type    bottletype,
  giver  integer references userfca (user_id)
);

ALTER TABLE userfca ADD CONSTRAINT picture_fk FOREIGN KEY (profil_pic) REFERENCES picture (picture_id);
ALTER TABLE userfca ADD CONSTRAINT position_fk FOREIGN KEY (user_position) REFERENCES position(position_id);