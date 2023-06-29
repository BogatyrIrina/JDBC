package utils;
import model.Employee;
import model.City;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.internal.SessionFactoryServiceRegistryImpl;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;
public class HibernateSessionFactoryUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration conf = new Configuration().configure("hibernate.cfg.xml");
            conf.addAnnotatedClass(Employee.class);
            conf.addAnnotatedClass(City.class);
            sessionFactory = conf.buildSessionFactory(
                    new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build());

        }
        return sessionFactory;
    }
}
