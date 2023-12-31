package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*


get() ---> gerçek nesneyi döndürür ,
        nesne yoksa null döner
        nesnenin olduğundan emin değilseniz get() kullanın
        dönen nesneye hemen kullanacaksam get() kullanılmalı
        load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
        nesne yoksa exception fırlatır
        dönen nesne üzerinde delete yapılacaksa kullanılabilir

*/
public class RunnerFetch13 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       // System.out.println("********get methodunun basladigi yer**************");
       // Student13 student1 = session.get(Student13.class,1L);
       // System.out.println("********get methodunun bittiği yer*******");

        //System.out.println("Student ID :" + student1.getId());
        //System.out.println("Student Name :" + student1.getName());

        //System.out.println("***************************************************");

        //System.out.println("************Load methodunun basladigi yer***********");
        //Student13 student2 = session.load(Student13.class,2L);
        //System.out.println("************Load methodunun bittigi yer**************");

        //System.out.println("*************-->getId() cagrildi");
        //System.out.println("Student ID :"+student2.getId());
        //System.out.println("*************-->getName() cagrildi");
        //System.out.println("Student Name :"+student2.getName());

        //db de olmayan id ler ile get ve load methodlarini karsilastiralim

      //Student13 student3 = session.get(Student13.class,5L);
      //if(student3!=null){
        //  System.out.println("Student ID :"+student3.getId());
         // System.out.println("Student Name :"+student3.getName());
     // }
       // System.out.println("***************************");

        //Student13 student4 =session.load(Student13.class,100L);
        //if(student4!=null){
        //    System.out.println("Student ID :"+student4.getId());
        //    System.out.println("Student Name :"+student4.getName());
        //}

        //LOAD METODU NEREDE KULLANILIR
        //Student13 student5 = session.get(Student13.class,1L);
        //session.delete(student5);

        Student13 student6 = session.load(Student13.class,3L);
        session.delete(student6);

        tx.commit();
        session.close();
        sf.close();

    }
}
