package repository.hibernateImpl;

import model.Event;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import repository.UserRepository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl instance;
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public User save(User type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event = null;

        try {
            Query query = session.createQuery("from events where id =: id");
            query.setParameter("id", type.getEventId());
            event = (Event) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Event not found");
        }

        type.setEvents(new ArrayList<>(Collections.singletonList(event)));
        session.save(type);

        transaction.commit();
        session.close();

        return type;
    }

    @Override
    public User update(User type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, type.getId());
        user.setFirstName(type.getFirstName());
        user.setLastName(type.getLastName());
        session.update(user);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public User getById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;

        javax.persistence.Query query = session.createQuery("FROM users WHERE id =: id");
        query.setParameter("id", aLong);
        try {
            Object queryResult = query.getSingleResult();
            user= (User) queryResult;
        } catch (NoResultException e) {
            System.out.println("Entity not found");
        }

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public void deleteById(Long aLong) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, aLong);
        session.delete(user);

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List users = session.createQuery("FROM users ").list();

        transaction.commit();
        session.close();

        return users;
    }
}
