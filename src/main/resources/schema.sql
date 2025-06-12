DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id serial primary key,
    name varchar(100) not null,
    age int not null,
    email varchar(100)
);