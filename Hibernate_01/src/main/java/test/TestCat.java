package test;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.sql.Date;

public class TestCat {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUntil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Bắt đầu giao dịch
            Transaction tr = session.beginTransaction();

            try {
                // Tạo và lưu đối tượng Cat
                Cat cat1 = new Cat();
                cat1.setName("Tom");
                cat1.setDateOfBirth(Date.valueOf("2024-04-10"));
                cat1.setSex(true);
                session.save(cat1);

                // Commit giao dịch
                tr.commit();
            } catch (Exception e) {
                // Rollback nếu có lỗi
                if (tr != null) tr.rollback();
                throw e; // Ném lại exception để dễ debug
            }

        } catch (Exception e) {
            e.printStackTrace(); // Xử lý ngoại lệ nếu cần
        }


    }
}
