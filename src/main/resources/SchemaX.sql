
drop index ix_auth_username;
drop table if exists authorities;
drop table if exists users;

create table users(
                      username varchar(50) not null,
                      password varchar(255) not null,
                      enabled boolean not null default 1,
                      primary key (username)
);

create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             primary key (username, authority),
                             foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities (username, authority);