package com.tpe.manytoone;

import com.tpe.onetoone.Computer;
import com.tpe.onetoone.Developer03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1--id=2 olan developerın çalıştığı company bilgilerini getiriniz.
        Developer04 dev=session.get(Developer04.class,2L);
        System.out.println("***********************************************************");
        System.out.println(dev);
        System.out.println(dev.getCompany());
        System.out.println("***********************************************************");
        //developerdan company e ulaşabiliyoruz. tersi mümkün değil.tek yönlü ilişki

        //2--tüm developerların ismini ve çalıştığı company ismini görüntüleyiniz.
        String sql="Select d.name,c.companyname from t_developer4 d inner join company c on d.company_id=c.id ";
        List<Object[]> resultList=session.createSQLQuery(sql).getResultList();
        for(Object[] r: resultList){
            System.out.println(Arrays.toString(r));
        }

        //3--Googleda çalışan developerların ismini ve branchini görüntüleyiniz.***ÖDEV***





        tx.commit();
        session.close();
        sf.close();
    }
}
