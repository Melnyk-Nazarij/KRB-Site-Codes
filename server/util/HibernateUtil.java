package ua.tntu.server.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.tntu.server.model.Employee;
import ua.tntu.server.model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Employee.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
