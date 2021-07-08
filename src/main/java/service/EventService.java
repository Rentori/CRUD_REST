package service;

import model.Event;
import repository.hibernateImpl.EventRepositoryImpl;

import java.util.List;

public class EventService implements GenericService<Event, Long> {
    EventRepositoryImpl eventRepository = EventRepositoryImpl.getInstance();

    @Override
    public void setRepository(Event type) {
    }

    @Override
    public Event save(Event type) {
        return null;
    }

    @Override
    public Event update(Event type) {
        return null;
    }

    @Override
    public Event getById(Long aLong) {
        return eventRepository.getById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Event> getAll() {
        return eventRepository.getAll();
    }
}
