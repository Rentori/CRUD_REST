create table if not exists files (
                       id bigint not null auto_increment,
                       file_name varchar(30),
                       primary key (id)
)