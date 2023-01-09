package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Developer01 dev1 = new Developer01();
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer01.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        dev1 = session.get(Developer01.class,1);
        System.out.println(dev1.toString());

       //1 - SQL ile tüm datayı çekiniz

        String sqlQuery1 = "SELECT * FROM t_developer01";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
        System.out.println("---SQL---");
        for (Object[] r : resultList1){

            System.out.println(Arrays.toString(r));

        }

        //2 - HQL ile tüm datayı çekiniz

        String hqlQuery1 = "FROM Developer01";
        List<Developer01> resultList2 = session.createQuery(hqlQuery1, Developer01.class).getResultList();//Burada List'in geleceği sınıfı bilmiyorsam Object diyorum
        System.out.println("---HQL---");
        for (Developer01 d : resultList2){

            System.out.println(d.toString());

        }

        //3 - HQL ile ismi "Shrek" olan datayı çekiniz

        String hqlQuery2 = "FROM Developer01 WHERE name='Shrek'";
        List<Developer01> resultList3 = session.createQuery(hqlQuery2, Developer01.class).getResultList();
        System.out.println("---HQL---");
        for (Developer01 d : resultList3){


            System.out.println(d.toString());

        }

        //4 - HQL ile emaili "jack@gmail.com" olan datayı çekiniz

        String hqlQuery3 = "FROM Developer01 WHERE email='jack@gmail.com'";
        Object result = session.createQuery(hqlQuery3, Developer01.class).uniqueResult();
        System.out.println("---HQL---");
        System.out.println(result.toString());

        //5-HQL ile branch i backend olan datanın ismini getiriniz. ***ÖDEV***


        tx.commit();
        session.close();
        sf.close();

    }




}
