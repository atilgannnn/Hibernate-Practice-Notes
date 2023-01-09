package com.tpe.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.
        String hql="FROM Company3 c WHERE c.companyname='Amazon'";
        Company3 companyA=session.createQuery(hql,Company3.class).uniqueResult();
        System.out.println("*******************Amazonda çalışanlar**************************************");
        companyA.getDevs().forEach(System.out::println);
        System.out.println("****************************************************************************");
        //companyden devlere ulaşılıyor

        //2--"Gandalf"ın çalıştığı company bilgilerini getiriniz.
        String hql2="FROM Developer06 d WHERE d.name='Gandalf'";
        Developer06 dev=session.createQuery(hql2,Developer06.class).uniqueResult();
        System.out.println("*******************Gandalf'ın companysi**************************************");
        System.out.println(dev.getCompany());
        System.out.println("****************************************************************************");


        //-------------------------DELETE-ORPHANREMOVAL-CASCADETYPEALL------------------------------------------------------

        //3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.
//        Developer06 dev3=session.get(Developer06.class,3L);
//        Company3 company=session.get(Company3.class,22L);
//        company.getDevs().remove(dev3);
//        System.out.println("Amazon dev listesi: "+company.getDevs());
        //orphanRemoval true ise tabledan da siliyor
        //cascadetypeALL da sadece listeden çıkarıyor.

        //4--id 11 olan company i sil
        Company3 company2=session.get(Company3.class,11L);
        session.delete(company2);
        //company iflas etti devlerde gitti(cascadetypeALL)


        tx.commit();
        session.close();
        sf.close();
    }
}
