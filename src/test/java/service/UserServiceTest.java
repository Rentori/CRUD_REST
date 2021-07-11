package service;

import junit.framework.TestCase;
import model.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernateImpl.UserRepositoryImpl;
import service.impl.UserServiceImpl;

import java.util.List;

@RunWith(value = MockitoJUnitRunner.class)
public class UserServiceTest extends TestCase {
    private final UserService userService = new UserServiceImpl();
    private final User user = new User(1L, "test", "test", 1L);

    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private Session session;

    @Mock
    private List<User> userList;

    @Before
    public void setUp() {
        userService.setUserRepository(userRepository);
    }

    @Test
    public void testSave() {
        when(userRepository.save(any())).thenReturn(user);
        assertEquals(userService.save(user), new User(1L, "test", "test", 1L));

        session.save(user);
        verify(session).save(user);
    }

    @Test
    public void testUpdate() {
        when(userRepository.update(any())).thenReturn(user);
        assertEquals(userService.update(user), new User(1L, "test", "test", 1L));

        session.save(user);
        verify(session).save(user);
    }

    @Test
    public void testGetById() {
        when(userRepository.getById(anyLong())).thenReturn(user);
        assertEquals(userService.getById(1L), new User(1L, "test", "test", 1L));

        session.get(User.class, 1L);
        verify(session).get(User.class, 1L);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(userRepository).deleteById(anyLong());
        userService.deleteById(1L);

        verify(userRepository).deleteById(1L);
    }

    @Test
    public void testGetAll() {
        when(userRepository.getAll()).thenReturn(userList);
        assertNotNull(userList);

        userService.getAll();
        verify(userRepository).getAll();
    }
}