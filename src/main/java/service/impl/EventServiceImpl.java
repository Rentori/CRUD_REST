package service.impl;

import model.Event;

import repository.hibernateImpl.EventRepositoryImpl;
import service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    private EventRepositoryImpl eventRepository = EventRepositoryImpl.getInstance();

    @Override
    public Event save(Event type) {
        return eventRepository.save(type);
    }

    @Override
    public Event update(Event type) {
        return eventRepository.update(type);
    }

    @Override
    public Event getById(Long aLong) {
        return eventRepository.getById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        eventRepository.deleteById(aLong);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.getAll();
    }

    @Override
    public void setEventRepository(EventRepositoryImpl eventRepository) {
        this.eventRepository = eventRepository;
    }
}
