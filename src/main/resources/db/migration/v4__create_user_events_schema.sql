create table if not exists user_events(
                            user_id bigint not null,
                            event_id bigint not null,
                            foreign key (user_id) references users(id),
                            foreign key (event_id) references events(id)
)