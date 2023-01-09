package com.tpe.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        Education edu1 = new Education("ITU","CENG");
        Education edu2 = new Education("YTU","MATH");

        Developer02 dev1=new Developer02(1L,"HarryPotter","hp@gmail.com","backend",edu1);
        Developer02 dev2=new Developer02(2L,"Shrek","shrek@gmail.com","frontend",edu2);
        Developer02 dev3=new Developer02(3L,"JackSparrow","jack@gmail.com","mobile",edu1);



        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer02.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        session.save(dev1);
        session.save(dev2);
        session.save(dev3);



        tx.commit();
        session.close();
        sf.close();
    }







}
