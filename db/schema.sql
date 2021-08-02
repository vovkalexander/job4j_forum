Create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created date not null default now()
);


Create table users (
                       id serial primary key,
                       username varchar(2000) NOT NULL unique,
                       password varchar(2000),
                       enabled boolean default true,
                       authority_id int not null references authorities(id)
);


Create table discussion (
                            post_id int references posts(id),
                            discussion text,
                            primary key(post_id, discussion )
);

CREATE TABLE authorities (
                             id serial primary key,
                             authority VARCHAR(50) NOT NULL unique
);


insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');