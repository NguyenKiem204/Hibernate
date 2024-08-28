package dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import until.HibernateUntil;

import java.util.ArrayList;
import java.util.List;

public class CatDAO implements InterfaceDAO<Cat> {
    @Override
    public List<Cat> selectAll() {
        List<Cat> listCat = new ArrayList<>();
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            // Không cần transaction nếu chỉ đọc dữ liệu
            String hql = "FROM Cat c";
            Query query = session.createQuery(hql, Cat.class);
            listCat = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCat;
    }

    @Override
    public Cat selectById(Cat cat) {
        Cat resultCat = null;
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            String hql = "FROM Cat c WHERE c.id = :id";
            Query query = session.createQuery(hql, Cat.class);
            query.setParameter("id", cat.getId());

            resultCat = (Cat) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("No Cat found with the given ID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultCat;
    }

    //cách này dùng get
    public Cat selectById2(Cat cat) {
        Cat resultCat = null;
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Sử dụng session.get() để lấy đối tượng theo ID
            resultCat = session.get(Cat.class, cat.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultCat;
    }


    @Override
    public boolean insert(Cat cat) {
        Transaction transaction = null;
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(cat); // Những phiên bản Hibernate sẽ không sử dụng save nữa thay thế nó là persist
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi thêm đối tượng Cat: " + e.getMessage());
            if (transaction != null) transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Cat cat) {
        Transaction transaction = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(cat); // Không nên sử dụng saveOrUpdate nữa thay vào đó sử dụng merge
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi thêm đối tượng Cat: " + e.getMessage());
            if (transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
                return false;
        }
        return true;
    }


    @Override
    public boolean delete(Cat cat) {
        Transaction transaction = null;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(cat);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Delete fail: " + e.getMessage());
            if (transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
            return false;
        }
        return true;
    }
}
