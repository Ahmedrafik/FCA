create table userfca (
  user_id           bigint PRIMARY KEY,
  login             varchar(50) not null,
  email             varchar(100) not null,
  pass              varchar(100) not null,
  firstname         varchar(100),
  lastname          varchar(100),
  accesstoken       varchar(50)
);

create table bill(
  bill_id           serial primary key,
  amount            double precision ,
  date              date,
  payer             integer references userfca (user_id)
);

create type bottletype as enum ('Pastis', 'Get', 'Vodka', 'Rhum');

create table bottlebill(
  bottle_bill_id    serial primary key,
  quantity          integer,
  date              date,
  bottle_type       bottletype,
  giver             integer references userfca (user_id)
);