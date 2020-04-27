INSERT INTO public.userfca (login,email,pass,firstname,lastname) VALUES ('ironMan','iron.man@avengers.top','iron','Tony','Stark');
INSERT INTO public.userfca (login,email,pass,firstname,lastname) VALUES ('captainMarvel','captain.marvel@avengers.top','captain','Carol','Danvers');

INSERT INTO public.bill (amount,"date",payer) VALUES (15,'2020-04-23',1);
INSERT INTO public.bill (amount,"date",payer) VALUES (25,'2020-04-23',1);
INSERT INTO public.bill (amount,"date",payer) VALUES (35,'2020-04-23',2);
INSERT INTO public.bill (amount,"date",payer) VALUES (45,'2020-04-23',2);


INSERT INTO public.bottle_bill (quantity,"date",bottle_type,giver) VALUES (1,'2020-04-23',1,2);
INSERT INTO public.bottle_bill (quantity,"date",bottle_type,giver) VALUES (2,'2020-04-23',4,2);
INSERT INTO public.bottle_bill (quantity,"date",bottle_type,giver) VALUES (2,'2020-04-23',3,1);

INSERT INTO public."position" (latitude,longitude,position_user) VALUES (40.725946,3.069941,2);

INSERT INTO public.album ("name","owner") VALUES ('fête à castries 2020',1);
INSERT INTO public.album ("name","owner") VALUES ('Annif Hulk',1);
INSERT INTO public.album ("name","owner") VALUES ('Assemblée avengers',2);
INSERT INTO public.album ("name","owner") VALUES ('Black Widow Top less',2);
INSERT INTO public.album ("name","owner") VALUES ('Intégration Spiderman',2);

INSERT INTO public.picture (name,"path",album) VALUES ('Intégration Spiderman 1','/appli/FCA/pics/spiderman/1.jpg',5);
INSERT INTO public.picture (name,"path",album) VALUES ('Intégration Spiderman 2','/appli/FCA/pics/spiderman/2.jpg',5);
INSERT INTO public.picture (name,"path",album) VALUES ('Encierro1','/appli/FCA/pics/feteACastries1/1.jpg',1);