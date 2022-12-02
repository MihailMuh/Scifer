DROP TABLE IF EXISTS students, staffers;

CREATE TABLE students
(
    id               bigint PRIMARY KEY,

    name             text   NOT NULL,
    surname          text   NOT NULL,
    patronymic       text,

    photo            text   NOT NULL,
    photo_rec        text   NOT NULL,

    hash             text   NOT NULL,
    access_token     text   NOT NULL,

    specialization   text   NOT NULL,

    refs_to_articles text[] NOT NULL,

    type             text   NOT NULL,

    register_date    date   NOT NULL,

    interests        text   NOT NULL
);

CREATE TABLE staffers
(
    id                       bigint PRIMARY KEY,

    name                     text   NOT NULL,
    surname                  text   NOT NULL,
    patronymic               text,

    photo                    text   NOT NULL,
    photo_rec                text   NOT NULL,

    hash                     text   NOT NULL,
    access_token             text   NOT NULL,

    specialization           text   NOT NULL,

    refs_to_articles         text[] NOT NULL,

    type                     text   NOT NULL,

    register_date            date   NOT NULL,

    position                 text   NOT NULL,
    academic_degree          text,
    academic_title           text,
    refs_to_qualifying_works text[]
)
