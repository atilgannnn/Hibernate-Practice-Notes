package com.tpe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //id=1 olan developerın tüm bilgilerini getiriniz.
        Developer03 developer = session.get(Developer03.class,1L);
        System.out.println("***********************");
        System.out.println(developer);
        System.out.println("***********************");

        //id=33 olan computerın tüm bilgilerini getiriniz.
        Computer computer = session.get(Computer.class,33L);
        System.out.println("***********************");
        System.out.println(computer);
        System.out.println("***********************");

        //id=22 olan computerı kullanan dev bilgilerini getiriniz.
        Computer computer2 = session.get(Computer.class,22L);
        System.out.println("***********************");
        System.out.println(computer2.getDeveloper());
        System.out.println("***********************");

        //id=2 olan developerın kullandığı computer bilgilerini getiriniz.***ÖDEV**

        tx.commit();
        session.close();
        sf.close();
    }
}
