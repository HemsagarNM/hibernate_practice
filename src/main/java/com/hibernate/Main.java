package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import  org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        person p1= new person();
        p1.setPid(101);
        p1.setPname("Suresh");
        p1.setTech("Java");

        SessionFactory sessionFactory =new Configuration()
                .addAnnotatedClass(com.hibernate.person.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction= session.beginTransaction();

        session.persist(p1);
//        session.merge(p1);

        person p2 = session.
                //byId(person.class).load(101);
                find(person.class,101);


        System.out.println(p2);

        person p3=session.find(person.class,101);
        session.remove(p3);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}