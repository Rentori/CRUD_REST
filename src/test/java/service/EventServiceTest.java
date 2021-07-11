package service;

import junit.framework.TestCase;
import model.Event;
import model.File;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernateImpl.EventRepositoryImpl;
import service.impl.EventServiceImpl;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(value = MockitoJUnitRunner.class)
public class EventServiceTest extends TestCase {
    private final EventServiceImpl eventService = new EventServiceImpl();
    private final Event event = new Event(1L, "test", new File(1L));

    @Mock
    private EventRepositoryImpl eventRepository;

    @Mock
    private Session session;

    @Mock
    private List<Event> eventList;

    @Before
    public void setUp() {
        eventService.setEventRepository(eventRepository);
    }

    @Test
    public void testSave() {
        when(eventRepository.save(any())).thenReturn(event);
        assertEquals(eventService.save(event), new Event(1L, "test", new File(1L)));

        session.save(event);
        verify(session).save(event);
    }

    @Test
    public void testUpdate() {
        when(eventRepository.update(any())).thenReturn(event);
        assertEquals(eventService.update(event), new Event(1L, "test", new File(1L)));

        session.save(event);
        verify(session).save(event);
    }

    @Test
    public void testGetById() {
        when(eventRepository.getById(anyLong())).thenReturn(event);
        assertEquals(eventService.getById(1L), new Event(1L, "test", new File(1L)));

        session.get(Event.class, 1L);
        verify(session).get(Event.class, 1L);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(eventRepository).deleteById(anyLong());
        eventService.deleteById(1L);

        verify(eventRepository).deleteById(1L);
    }

    @Test
    public void testGetAll() {
        when(eventRepository.getAll()).thenReturn(eventList);
        assertNotNull(eventList);

        eventService.getAll();
        verify(eventRepository).getAll();
    }
}