create table if not exists users (
                      id bigint not null auto_increment,
                      first_name varchar(30) not null,
                      last_name varchar(30) not null,
                      primary key (id)
)