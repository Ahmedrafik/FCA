create table userfca (
  user_id           serial PRIMARY KEY,
  login             varchar(50) not null,
  email             varchar(100) not null,
  pass              varchar(100) not null,
  firstname         varchar(100),
  lastname          varchar(100),
  access_token      varchar(100)
);

create table bill(
  bill_id           serial primary key,
  amount            double precision ,
  date              date,
  payer             integer references userfca (user_id)
);

create table bottle_bill(
  bottle_bill_id    serial primary key,
  quantity          integer,
  date              date,
  bottle_type       integer,
  giver             integer references userfca (user_id)
);

create table position(
  position_id       serial primary key,
  latitude          double precision,
  longitude         double precision,
  position_user     integer references userfca (user_id),
  UNIQUE (position_user)
);

create table album(
  album_id          serial PRIMARY KEY,
  name              varchar(50),
  owner             integer references userfca (user_id)
);

create table picture(
  picture_id        serial PRIMARY KEY,
  name              varchar(50),
  path              varchar(50),
  album             integer references album(album_id)
);