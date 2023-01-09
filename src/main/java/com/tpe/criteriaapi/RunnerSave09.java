package com.tpe.criteriaapi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave09 {
    public static void main(String[] args) {

        Developer09 dev1=new Developer09("Sezai",5000);
        Developer09 dev2=new Developer09("Nazım",7000);
        Developer09 dev3=new Developer09("Akif",8000);
        Developer09 dev4=new Developer09("Cahit",9000);
        Developer09 dev5=new Developer09("Erdem",8000);
        Developer09 dev6=new Developer09("Atilla",9000);
        Developer09 dev7=new Developer09("Cemal",8500);
        Developer09 dev8=new Developer09("Fazıl",10000);
        Developer09 dev9=new Developer09("Nuri",7000);
        Developer09 dev10=new Developer09("Rasim",6500);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(dev4);
        session.save(dev5);
        session.save(dev6);
        session.save(dev7);
        session.save(dev8);
        session.save(dev9);
        session.save(dev10);

        tx.commit();
        session.close();
        sf.close();
    }
}