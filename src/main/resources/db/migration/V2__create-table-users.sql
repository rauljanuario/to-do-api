CREATE TABLE IF NOT EXISTS Users (

    id bigserial primary key,
    name varchar(255) not null,
    email varchar(255) unique not null,
    password varchar(255) unique not null
)