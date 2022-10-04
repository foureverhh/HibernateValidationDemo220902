drop table if exists USERS cascade;
create table USERS (
                      id bigint primary key not null auto_increment,
                      name varchar(255) not null,
                      job varchar(255) not null,
                      email varchar(255) not null,
                      password varchar(255) not null
);

insert into USERS (name, job, email, password) values ('Albert','nurse','albert@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Ben','tester','ben@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Ben','teacher','ben@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Zera','designer','zera@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Chance','taxi driver','chance@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Alex','manager','alex@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Alex','police','alexdra@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Cindy','programmer','cindy@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Robert','student','robert@gmail.com', '123');
insert into USERS (name, job, email, password) values ('Geoger','faker','geoger@gmail.com', '123');