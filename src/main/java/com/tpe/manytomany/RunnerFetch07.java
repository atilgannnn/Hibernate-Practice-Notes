package com.tpe.manytomany;

import com.tpe.onetomany_bi.Company3;
import com.tpe.onetomany_bi.Developer06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1--id=11 olan projede çalışan developer bilgilerini getiriniz
        Project project=session.get(Project.class,11L);
        project.getDevelopers().forEach(System.out::println);

        //2--id=1 olan developerın çalıştığı proje bilgilerini getiriniz.
        Developer07 dev=session.get(Developer07.class,1L);
        dev.getProjects().forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();
    }
}
