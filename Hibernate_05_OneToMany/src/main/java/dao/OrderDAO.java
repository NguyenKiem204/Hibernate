package dao;

import jakarta.persistence.Query;
import model.My_Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.List;

public class OrderDAO implements InterfaceDAO<My_Order, String> {
    @Override
    public List<My_Order> selectAll() {
        List<My_Order> listOrder;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String hql = "FROM Order";
            Query query = session.createQuery(hql, My_Order.class);
            listOrder = query.getResultList();
        } catch (Exception e) {
            System.out.println("Select error: " + e.getMessage());
            return null;
        }
        return listOrder;
    }

    @Override
    public My_Order selectById(String s) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String hql = "From Order o Where o.id = :id";
            Query query = session.createQuery(hql, My_Order.class);
            query.setParameter("id", s);
            return (My_Order) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Select to fail: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(My_Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(order);
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
    public boolean update(My_Order order) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "Update Order o Set o.address = :address o.customer = :customer Where id = :id";
            Query query = session.createQuery(hql, My_Order.class);
            query.setParameter("id", order.getId());
            query.setParameter("address", order.getAddress());
            query.setParameter("customer", order.getCustomer());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Update error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(My_Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(order);
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
