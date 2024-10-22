create table users (
    id serial primary key,
    name VARCHAR(100) NOT NULL,
    creation_date timestamp default current_timestamp
);

create table if not exists tickets (
    id serial primary key,
    user_id int,
    ticket_type varchar(10) check (ticket_type in ('DAY', 'WEEK', 'MONTH', 'YEAR')),
    creation_date timestamp default current_timestamp,
    foreign key (user_id) references users(id) on delete restrict
);