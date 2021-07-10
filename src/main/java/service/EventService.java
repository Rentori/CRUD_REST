package service;

import model.Event;
import repository.hibernateImpl.EventRepositoryImpl;

public interface EventService extends GenericService<Event, Long> {
    void setEventRepository(EventRepositoryImpl eventRepository);
}
