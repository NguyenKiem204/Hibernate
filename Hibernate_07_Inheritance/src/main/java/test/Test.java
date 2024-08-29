package test;

import model.Student;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
try (Session session = HibernateUntil.getSessionFactory().openSession()){
    Transaction transaction = session.beginTransaction();

    Student student = new Student("ST01", "Nguyễn Văn Kiểm", Date.valueOf("2004-04-10"), 9.8, 4 );
    Teacher teacher = new Teacher("TC01", "Võ Minh Tuấn", Date.valueOf("1990-10-10"), "Master", 5);

    session.persist(student);
    session.persist(teacher);

    transaction.commit();
} catch (Exception e) {
    System.out.println("Insert to error: "+e.getMessage());
}

    }
}
