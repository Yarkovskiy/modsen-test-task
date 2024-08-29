create table if not exists books
(
    id          bigserial primary key,
    isbn        varchar(255) not null unique,
    title       varchar(255) not null,
    description varchar(1000)
);

create table if not exists authors
(
    id   bigserial primary key,
    name varchar(255)
);

create table if not exists genres
(
    id   bigserial primary key,
    name varchar(255)
);

create table if not exists book_author
(
    book_id   bigint not null,
    author_id bigint not null,
    primary key (book_id, author_id),
    foreign key (book_id) references books (id) on delete cascade,
    foreign key (author_id) references authors (id) on delete cascade
);

create table if not exists book_genre
(
    book_id  bigint not null,
    genre_id bigint not null,
    primary key (book_id, genre_id),
    foreign key (book_id) references books (id) on delete cascade,
    foreign key (genre_id) references genres (id) on delete cascade
);

create table if not exists users
(
    id       bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists users_roles
(
    user_id bigint       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    foreign key (user_id) references users (id) on delete cascade
);

create table if not exists book_loans
(
    id            bigserial primary key,
    book_id       bigint    not null,
    user_id       bigint    not null,
    borrowed_time timestamp not null,
    return_time   timestamp not null,
    foreign key (book_id) references books (id) on delete cascade,
    foreign key (user_id) references users (id) on delete cascade
);