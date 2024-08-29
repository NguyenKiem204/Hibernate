package until;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Khởi tạo SessionFactory từ hibernate.cfg.xml
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Exception e) {
                System.out.println("SessionFactory to erro: "+e.getMessage());
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        // Đóng SessionFactory khi ứng dụng kết thúc
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
