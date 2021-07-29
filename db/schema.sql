Create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created date not null default now()
);


Create table users (
                       id serial primary key,
                       username varchar(2000) NOT NULL unique,
                       password varchar(2000)
);


Create table discussion (
                            post_id int references posts(id),
                            discussion text,
                            primary key(post_id, discussion )
);