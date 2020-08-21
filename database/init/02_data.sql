INSERT INTO public.userfca (login,email,pass,firstname,lastname,access_token,color) VALUES ('ironMan','iron.man@avengers.top','U2FsdGVkX18RtMA4sh3UMe8R5XqvDCJX7svl8ZJkzao=','Tony','Stark','062064168185439f842a41ea83729c64','red');  --pass = iron
INSERT INTO public.userfca (login,email,pass,firstname,lastname,access_token,color,upper) VALUES ('captainMarvel','captain.marvel@avengers.top','U2FsdGVkX1+rZsxWtUsN4S4fgM/3lQTPVxwGgjXYwFU=','Carol','Danvers','3670dbb874924ba9b0145cac36719a99','yellow',1);             --pass = captain
INSERT INTO public.userfca (login,email,pass,firstname,lastname,access_token,color,upper) VALUES ('captainAmerica','captain.america@avengers.top','U2FsdGVkX18z8XbdrOX91Lmh2mvil9h0Iy/ElR+VrVw=','Steve','Rogers','f94bcf74d7d2457092c8e433b3e5c705','blue',1);              --pass = america
INSERT INTO public.userfca (login,email,pass,firstname,lastname,access_token,color,upper) VALUES ('blackWidow','black.widow@avengers.top','U2FsdGVkX19aPYM9+m20eWK9PbsT6aiZ+SYLBMMTn+U=','Natasha','Romanoff','d0cee40938394f2fb50cca7c46499d21','black',2);                   --pass = widow
INSERT INTO public.userfca (login,email,pass,firstname,lastname,access_token,color,upper) VALUES ('hulk','hulk@avengers.top','U2FsdGVkX18TFFH4RPmW3JDogTQ4cjGDvaw/L79GEik=','Bruce','Banner','83f54b0b4fe346ef8e84a3ae3c7951cd','green',4);                                     --pass = hulk



INSERT INTO public.bill (amount,"date",payer) VALUES (15,'2020-04-23',1);
INSERT INTO public.bill (amount,"date",payer) VALUES (25,'2020-04-28',1);
INSERT INTO public.bill (amount,"date",payer) VALUES (35,'2020-04-23',2);
INSERT INTO public.bill (amount,"date",payer) VALUES (45,'2020-04-28',2);
INSERT INTO public.bill (amount,"date",payer) VALUES (28,'2020-04-23',3);
INSERT INTO public.bill (amount,"date",payer) VALUES (42,'2020-04-23',4);
INSERT INTO public.bill (amount,"date",payer) VALUES (12,'2020-04-23',5);
INSERT INTO public.bill (amount,"date",payer) VALUES (23,'2020-04-30',2);
INSERT INTO public.bill (amount,"date",payer) VALUES (24,'2020-04-23',5);
INSERT INTO public.bill (amount,"date",payer) VALUES (16,'2020-04-30',3);
INSERT INTO public.bill (amount,"date",payer) VALUES (5,'2020-06-30',1);
INSERT INTO public.bill (amount,"date",payer) VALUES (8,'2020-06-30',4);
INSERT INTO public.bill (amount,"date",payer) VALUES (12,'2020-06-30',2);


INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-04-23',2);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (2,'2020-04-23',2);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-06-23',1);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (3,'2020-04-23',3);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (2,'2020-04-23',4);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-05-18',4);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-04-17',5);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-04-23',1);
INSERT INTO public.bottle_bill (quantity,"date",giver) VALUES (1,'2020-04-23',3);


INSERT INTO public."position" (latitude,longitude,position_user) VALUES (40.725946,3.069941,2);

INSERT INTO public.album ("name","owner") VALUES ('fête à castries 2020',1);
INSERT INTO public.album ("name","owner") VALUES ('Annif Hulk',1);
INSERT INTO public.album ("name","owner") VALUES ('Assemblée avengers',2);
INSERT INTO public.album ("name","owner") VALUES ('Black Widow Top less',2);
INSERT INTO public.album ("name","owner") VALUES ('Intégration Spiderman',2);

INSERT INTO public.picture (name,"path",album) VALUES ('Intégration Spiderman 1','/appli/FCA/pics/spiderman/1.jpg',5);
INSERT INTO public.picture (name,"path",album) VALUES ('Intégration Spiderman 2','/appli/FCA/pics/spiderman/2.jpg',5);
INSERT INTO public.picture (name,"path",album) VALUES ('Encierro1','/appli/FCA/pics/feteACastries1/1.jpg',1);