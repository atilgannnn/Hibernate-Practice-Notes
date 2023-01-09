package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch9 {

    public static void main(String[] args) {


        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //----------------------CRITERIA API--------------------------------------------//

        CriteriaBuilder cbuilder = session.getCriteriaBuilder();//CriteriaQuery nesnesi oluşturmak ve bazı methodları için
        CriteriaQuery<Developer09> cq = cbuilder.createQuery(Developer09.class);
        Root<Developer09> root = cq.from(Developer09.class);//classımızın tüm datalarını tutan kaynak
        // 1 - ismi Cemal olan developerları getririniz
        cq.select(root).//tüm dataya ulaşır
        where(cbuilder.equal(root.get("name"),"Cemal"));//where Predicate ister
        List<Developer09> result = session.createQuery(cq).getResultList();
        result.forEach(System.out::println);


        // 2 - ismi Erdem veya salarysi 9000 den fazla olan developerları getririniz
        Predicate pred1 = cbuilder.equal(root.get("name"),"Erdem");
        Predicate pred2 = cbuilder.greaterThan(root.get("salary"),9000);
        Predicate pred3 = cbuilder.or(pred1,pred2);

        cq.select(root).where(pred3);
        List<Developer09> result2 = session.createQuery(cq).getResultList();
        result2.forEach(System.out::println);

        // 3 - Salary'si 8000 olan developerları getiriniz
        cq.select(root).where(cbuilder.equal(root.get("salary"),8000));
        List<Developer09> result3 = session.createQuery(cq).getResultList();
        result3.forEach(System.out::println);


        // 4 - Salary'si 8000 den fazla olan developerları getiriniz





        tx.commit();
        session.close();
        sf.close();




    }








}
