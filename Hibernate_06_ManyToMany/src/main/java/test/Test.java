package test;

import model.Course;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import until.HibernateUntil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
try (Session session = HibernateUntil.getSessionFactory().openSession()){
    Transaction transaction = session.beginTransaction();
    Student student1 = new Student("HE1", "Nguyễn Văn Kiểm");
    Student student2 = new Student("HE2", "Trịnh Thanh Bình");
    Student student3 = new Student("HE3", "Lê Thanh Tùng");

    Course course1 = new Course("Java");
    Course course2 = new Course("Laravel");
    Course course3 = new Course("C#");
    Course course4 = new Course("Python");

    student1.getCourses().add(course1);
    student1.getCourses().add(course2);
    student2.getCourses().add(course4);
    student3.getCourses().add(course3);
    student3.getCourses().add(course4);


    session.persist(student1);
    session.persist(student2);
    session.persist(student3);



    transaction.commit();
} catch (Exception e) {
    System.out.println("Insert to error: "+e.getMessage());
}

    }
}
