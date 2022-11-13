CREATE TABLE IF NOT EXISTS students
(
    id               bigint PRIMARY KEY,

    name             text                        NOT NULL,
    surname          text                        NOT NULL,
    patronymic       text                        NOT NULL,

    photo            text                        NOT NULL,
    photo_rec        text                        NOT NULL,

    hash             text                        NOT NULL,
    access_token     text                        NOT NULL,

    specialization   text                        NOT NULL,

    refs_to_articles text[]                      NOT NULL,

    type             text                        NOT NULL,

    register_date    timestamp without time zone NOT NULL,

    interests        text                        NOT NULL
);

CREATE TABLE IF NOT EXISTS staffers
(
    id                       bigint PRIMARY KEY,

    name                     text                        NOT NULL,
    surname                  text                        NOT NULL,
    patronymic               text                        NOT NULL,

    photo                    text                        NOT NULL,
    photo_rec                text                        NOT NULL,

    hash                     text                        NOT NULL,
    access_token             text                        NOT NULL,

    specialization           text                        NOT NULL,

    refs_to_articles         text[]                      NOT NULL,

    type                     text                        NOT NULL,

    register_date            timestamp without time zone NOT NULL,

    position                 text                        NOT NULL,
    academic_degree          text,
    academic_title           text,
    refs_to_qualifying_works text[]
)
