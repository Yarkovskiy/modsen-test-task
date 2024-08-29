insert into users (username, password)
values ('admin@example.com', '$2a$12$jw8xQP/qisylg8Q3EZqyo.rK3VOgqsgkw3JmRoMEcu50AAscqp0AK'),
       ('user@example.com', '$2a$12$RtADxq5uYc2StLk9hVI9wO2n.kg4CjeSpMnhEnMdUEKcEP.ZlFcTi');

insert into users_roles (user_id, role)
values (1, 'ROLE_USER'),
       (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

insert into authors (name)
values ('First Author'),
       ('Second Author');

insert into genres (name)
values ('First genre'),
       ('Second genre');

insert into books (isbn, title, description)
values ('0-123-45678-9', 'First book', 'Description of the first book.'),
       ('9-976-54321-0', 'Second book', 'Description of the second book.');

insert into book_author (book_id, author_id)
values (1, 1),
       (2, 1),
       (2, 2);

insert into book_genre (book_id, genre_id)
values (1, 1),
       (2, 1),
       (2, 2);