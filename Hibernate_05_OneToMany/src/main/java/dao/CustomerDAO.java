package dao;

import jakarta.persistence.Query;
import model.Customer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.List;

public class CustomerDAO implements InterfaceDAO<Customer, String> {
    @Override
    public List<Customer> selectAll() {
        List<Customer> listCustomer;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String hql = "FROM customer";
            Query query = session.createQuery(hql, Customer.class);
            listCustomer = query.getResultList();
        } catch (Exception e) {
            System.out.println("Select error: " + e.getMessage());
            return null;
        }
        return listCustomer;
    }

    @Override
    public Customer selectById(String s) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String hql = "From customer o Where o.id = :id";
            Query query = session.createQuery(hql, Customer.class);
            query.setParameter("id", s);
            return (Customer) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Select to fail: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Insert error: " + e.getMessage());
            if(transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean update(Customer customer) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "Update customer C Set C.name = :name Where id = :id";
            Query query = session.createQuery(hql, Customer.class);
            query.setParameter("name", customer.getName());
            query.setParameter("id", customer.getId());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Update error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Remove error: " + e.getMessage());
            if(transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
            return false;
        }
    }
}
