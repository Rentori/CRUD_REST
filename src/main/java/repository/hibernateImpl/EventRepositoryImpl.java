package repository.hibernateImpl;

import model.Event;
import model.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.EventRepository;

import javax.persistence.NoResultException;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {
    private static EventRepositoryImpl instance;
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private EventRepositoryImpl() {
    }

    public static EventRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EventRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Event save(Event type) {
        Session session = sessionFactory.openSession();
        File file = null;
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from files where id =: id");
            query.setParameter("id", type.getFile().getId());
            file = (File) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Event not found");
        }
        type.setFile(file);
        session.save(type);

        transaction.commit();
        session.close();

        return type;
    }

    @Override
    public Event update(Event type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Event event = session.get(Event.class, type.getId());
        event.setName(type.getName());
        session.update(event);

        transaction.commit();
        session.close();

        return event;
    }

    @Override
    public Event getById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Event event = session.get(Event.class, aLong);

        transaction.commit();
        session.close();

        return event;
    }

    @Override
    public void deleteById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.get(Event.class, aLong));

        transaction.commit();
        session.close();
    }

    @Override
    public List<Event> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List events = session.createQuery("FROM events ").list();

        transaction.commit();
        session.close();

        return events;
    }
}
