create table userfca (
  userId      serial PRIMARY KEY,
  login       varchar(50) not null,
  email       varchar(100) not null,
  pass        varchar(100) not null,
  firstname   varchar(100),
  lastname    varchar(100),
  upper       integer references userfca (userid),
  accesstoken varchar(50)
);

create table fuzi
(
  plusunid   serial PRIMARY KEY,
  user1id    integer references userfca (userid),
  user2id    integer references userfca (userid)
);

create table album(
  albumid  serial PRIMARY KEY,
  name      varchar(50),
  owner     integer references userfca (userid)
);

create table picture(
  pictureid  serial PRIMARY KEY,
  name        varchar(50),
  path        varchar(50),
  album       integer references album(albumid)
);

create table posts(
  postid   serial primary key,
  title     varchar(50),
  body      text,
  date      date,
  writer    integer references userfca (userid)
);

create table postpics(
  postpicsid  serial primary key,
  postid       integer references posts(postid),
  picsid       integer references picture(pictureid)
);

create table event(
  eventid    serial primary key,
  name        varchar(50),
  date        date,
  place       varchar(100),
  description text,
  eventpics  integer,
  eventpost  integer references posts(postid)
);

create table position(
  positionid   serial primary key,
  userposition integer references userfca (userid),
  latitude      double precision,
  longitude     double precision
);

create table bill(
  billid serial primary key,
  amount  integer,
  date    date,
  payer   integer references userfca (userid)
);

create type bottletype as enum ('Pastis', 'Get', 'Vodka', 'Rhum');

create table bottle(
  bottleid     serial primary key,
  quantity      integer,
  date          date,
  bottletype   bottletype,
  deliveryuser integer references userfca (userid)
);
