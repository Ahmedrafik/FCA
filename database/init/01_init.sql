create table userfca (
  userId        serial PRIMARY KEY,
  login         varchar(50) not null,
  email         varchar(100) not null,
  pass          varchar(100) not null,
  firstname     varchar(100),
  lastname      varchar(100),
  accesstoken   varchar(50),
  upper         integer references userfca (userId),
  profilPic     integer,
  userPosition  integer
);

create table plusun
(
  plusunId      serial PRIMARY KEY,
  user1Id       integer references userfca (userId),
  user2Id       integer references userfca (userId)
);

create table album(
  albumId       serial PRIMARY KEY,
  name          varchar(50),
  owner         integer references userfca (userId)
);

create table picture(
  pictureId     serial PRIMARY KEY,
  name          varchar(50),
  path          varchar(50),
  album         integer references album(albumId)
);

create table posts(
  postId        serial primary key,
  title         varchar(50),
  body          text,
  date          date,
  writer        integer references userfca (userId)
);

create table postpics(
  postpicsId    serial primary key,
  postId        integer references posts(postId),
  picsId        integer references picture(pictureId)
);

create table event(
  eventId       serial primary key,
  name          varchar(50),
  startDate     date,
  endDate     date,
  place         varchar(100),
  description   text,
  eventpics     integer references picture(pictureId),
  eventpost     integer references posts(postId)
);

create table position(
  positionId    serial primary key,
  latitude      double precision,
  longitude     double precision,
  positionUser  integer references userfca (userId)
);

create table bill(
  billId        serial primary key,
  amount        double precision ,
  date          date,
  payer         integer references userfca (userId)
);

create type bottletype as enum ('Pastis', 'Get', 'Vodka', 'Rhum');

create table bottlebill(
  bottleBillId      serial primary key,
  quantity      integer,
  date          date,
  bottleType    bottletype,
  giver  integer references userfca (userId)
);

ALTER TABLE userfca ADD CONSTRAINT picture_fk FOREIGN KEY (profilPic) REFERENCES picture (pictureId);
ALTER TABLE userfca ADD CONSTRAINT position_fk FOREIGN KEY (userPosition) REFERENCES position(positionId);