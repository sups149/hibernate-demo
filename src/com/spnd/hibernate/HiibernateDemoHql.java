package com.spnd.hibernate;

import com.spnd.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HiibernateDemoHql {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Country.class).buildSessionFactory();
        //SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        List<Country> countries=null;


        try {
            session.beginTransaction();
            //Country country = session.get(Country.class, 1);
            countries = session.createQuery("from Country c where c.countryName like '%a'").getResultList();

            countries.forEach(country -> {
                System.out.println(country.getCountryName());
            });
            //System.out.println(country.getCountryName());
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
