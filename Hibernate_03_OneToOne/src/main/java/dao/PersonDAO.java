package dao;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements InterfaceDAO<Person, Integer> {
    @Override
    public List<Person> selectAll() {
        List<Person> people = new ArrayList<>();
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            String hql = "FROM Person";
            people = session.createQuery(hql, Person.class).getResultList();
        } catch (Exception e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return people;
    }

    @Override
    public Person selectById(Integer id) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            return session.find(Person.class, id);
        } catch (Exception e) {
            System.err.println("Not Found: " + e.getMessage());
        }
        return null;
    }


    @Override
    public boolean insert(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Insert fail: " + e.getMessage());
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean update(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Update error: " + e.getMessage());
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean delete(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(person);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Update error: " + e.getMessage());
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}
