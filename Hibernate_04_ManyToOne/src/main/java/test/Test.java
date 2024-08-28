package test;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        Transaction transaction = null;
        try(SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
        Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Author author1 = new Author("HE1", "Nguyễn Văn Kiểm", Date.valueOf("2004-04-10"));
            Book book1 = new Book("B001", "Hướng tới tương lai", 30, author1);
            Book book2 = new Book("B002", "Đam mê code", 20, author1);
            Book book3 = new Book("B003", "Đắc nhân tâm", 40, author1);


            session.persist(author1);
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Insert error: "+e.getMessage());
        }

    }
}
