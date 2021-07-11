package service;

import junit.framework.TestCase;
import model.File;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import repository.hibernateImpl.FileRepositoryImpl;
import service.impl.FileServiceImpl;

import java.util.List;

@RunWith(value = MockitoJUnitRunner.class)
public class FileServiceTest extends TestCase {
    private final FileService fileService = new FileServiceImpl();
    private final File file = new File(1L, "test");

    @Mock
    private FileRepositoryImpl fileRepository;

    @Mock
    private Session session;

    @Mock
    private List<File> fileList;

    @Before
    public void setUp() {
        fileService.setFileRepository(fileRepository);

    }

    @Test
    public void testSave() {
        when(fileRepository.save(any())).thenReturn(file);
        assertEquals(fileService.save(new File(1L, "test")), file);

        session.save(file);
        verify(session).save(file);
    }

    @Test
    public void testUpdate() {
        when(fileRepository.update(any())).thenReturn(file);
        assertEquals(fileService.update(new File(1L, "test")), file);

        session.update(file);
        verify(session).update(file);
    }

    @Test
    public void testGetById() {
        when(fileRepository.getById(anyLong())).thenReturn(file);
        assertEquals(fileService.getById(1L), new File(1L, "test"));

        session.get(File.class, 1L);
        verify(session).get(File.class, 1L);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(fileRepository).deleteById(anyLong());
        fileService.deleteById(1L);
        verify(fileRepository).deleteById(1L);
    }

    @Test
    public void testGetAll() {
        when(fileRepository.getAll()).thenReturn(fileList);
        assertNotNull(fileList);

        fileService.getAll();
        verify(fileRepository).getAll();
    }
}