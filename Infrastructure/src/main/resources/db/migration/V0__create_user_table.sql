-- drop table if exists cats_friends cascade;
-- drop table if exists cats_main_info cascade;
-- drop table if exists flyway_schema_history cascade;
-- drop table if exists owners cascade;
-- drop table if exists owners_with_cats cascade;

-- --create type cat_color as enum ('white', 'semi_color', 'black', 'grey');
--
-- create table if not exists owners
-- (
--     owner_id   serial primary key unique,
--     owner_birthday date not null,
--     owner_name varchar(100) not null unique
-- );
--
-- create table if not exists cats_main_info
-- (
--     cat_id       serial primary key unique,
--     cat_name     varchar(50) not null unique,
--     cat_breed    varchar(50) not null,
--     cat_birthday date        not null,
--     cat_color    varchar(20)   not null
-- );
--
-- CREATE TABLE IF NOT EXISTS owners_with_cats
-- (
--     owner_id INT NOT NULL,
--     cat_id   INT NOT NULL,
--     PRIMARY KEY (owner_id, cat_id),
--     FOREIGN KEY (cat_id) REFERENCES cats_main_info (cat_id),
--     FOREIGN KEY (owner_id) REFERENCES owners (owner_id)
-- );
--
--
-- create table if not exists cats_friends
-- (
--     friendship_id serial primary key unique,
--     cat_id    int not null,
--     friend_id int,
--     -- primary key (cat_id, friend_id),
--     foreign key (cat_id) references cats_main_info (cat_id),
--     foreign key (friend_id) references cats_main_info (cat_id)
-- );

create table cats_friends
(
    cat_id        serial  not null,
    friend_id     integer not null,
    primary key (cat_id, friend_id)
);
create table cats_main_info
(
    cat_birthday date         not null,
    cat_id       serial       not null,
    cat_breed    varchar(255) not null,
    cat_color    varchar(255) not null check (cat_color in ('white', 'semi_color', 'black', 'grey', 'undefined')),
    cat_name     varchar(255) unique,
    primary key (cat_id)
);
create table owners
(
    owner_birthday date         not null,
    owner_id       serial       not null,
    owner_name     varchar(255) not null unique,
    primary key (owner_id)
);
create table owners_with_cats
(
    cat_id   integer not null,
    owner_id integer not null,
    primary key (cat_id, owner_id)
);
alter table if exists cats_friends
    add constraint cats_friends_cat_id_constraint foreign key (cat_id) references cats_main_info on delete cascade;
alter table if exists cats_friends
    add constraint cats_friends_friend_id_constraint foreign key (friend_id) references cats_main_info on delete cascade;
alter table if exists owners_with_cats
    add constraint owners_with_cats_cat_id_constraint foreign key (cat_id) references cats_main_info on delete cascade;
alter table if exists owners_with_cats
    add constraint owners_with_cats_owner_id_constraint foreign key (owner_id) references owners on delete cascade;