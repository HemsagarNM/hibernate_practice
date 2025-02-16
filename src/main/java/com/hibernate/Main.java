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
        p1.setPid(102);
        p1.setPname("Ramesh");
        p1.setTech("Py");

        SessionFactory sessionFactory =new Configuration()
                .addAnnotatedClass(com.hibernate.person.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction= session.beginTransaction();

        person p2 = session.
                //byId(person.class).load(101);
                find(person.class,101);

        System.out.println(p2);

        //session.persist(p1);
        session.merge(p1);


        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}