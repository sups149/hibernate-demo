package com.spnd.hibernate;

import com.spnd.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiibernateDemo {
    public static void main(String[] args) {
        final SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Country.class).buildSessionFactory();

        final Session session = factory.getCurrentSession();

        //Country country1 = new Country("India");
        //Country country1 = new Country(2, "Sri Lanka");
        Country country1 = new Country("Sri Lanka");
        Country country2 = new Country("Bangladesh");

        try {

            session.beginTransaction();
            session.save(country1);
            session.save(country2);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
