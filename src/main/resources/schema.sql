drop table if exists USERS cascade;
create table USERS (
                      id bigint primary key not null auto_increment,
                      name varchar(255) not null,
                      email varchar(255) not null,
                      password varchar(255) not null
);