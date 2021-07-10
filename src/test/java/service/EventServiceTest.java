package service;

import com.mysql.cj.Session;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernateImpl.EventRepositoryImpl;
import service.impl.EventServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(value = MockitoJUnitRunner.class)
public class EventServiceTest extends TestCase {
    private final EventServiceImpl eventService = new EventServiceImpl();

    @Mock
    private EventRepositoryImpl eventRepository;

    @Mock
    private Session session;

    @Before
    public void setUp() {
    }

    @Test
    public void testSave() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testGetById() {
    }

    @Test
    public void testDeleteById() {
    }

    @Test
    public void testGetAll() {
    }
}