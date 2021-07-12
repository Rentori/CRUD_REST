create table if not exists events(
                       id bigint not null auto_increment,
                       event_name varchar(30) not null,
                       file_id bigint not null,
                       foreign key (file_id) references files(id),
                       primary key (id)
)