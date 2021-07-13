package repository.hibernateImpl;

import model.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.FileRepository;

import java.util.List;

public class FileRepositoryImpl implements FileRepository {
    private static FileRepositoryImpl instance;
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private FileRepositoryImpl() {
    }

    public static FileRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    @Override
    public File save(File type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(type);

        transaction.commit();
        session.close();

        return type;
    }

    @Override
    public File update(File type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        File file = session.get(File.class, type.getId());
        file.setName(type.getName());
        session.update(file);

        transaction.commit();
        session.close();

        return file;
    }

    @Override
    public File getById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        File file = (File) session.createQuery("FROM files WHERE id =: id").setParameter("id", aLong).uniqueResult();

        transaction.commit();
        session.close();

        return file;
    }

    @Override
    public void deleteById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.get(File.class, aLong));

        transaction.commit();
        session.close();
    }

    @Override
    public List<File> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List files = session.createQuery("FROM files").list();

        transaction.commit();
        session.close();

        return files;
    }
}
