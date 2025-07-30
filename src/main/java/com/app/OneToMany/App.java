package com.app.OneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.OneToMany.pojos.Books;
import com.app.OneToMany.pojos.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "One To Many Relationship here" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sfg = cfg.buildSessionFactory();
       
        Session session = sfg.openSession();
        Transaction tx = session.beginTransaction();
        
        try {
            
            Query<Student> query = session.createQuery("from Student where name = :name", Student.class);
            query.setParameter("name", "Ram");
            Student std1 = query.uniqueResult();

            if (std1 == null) {
               
                std1 = new Student();
                std1.setName("Ram");

                Books book1 = new Books();
                book1.setBookName("Java");
                book1.setStudent(std1);

                Books book2 = new Books();
                book2.setBookName("History");
                book2.setStudent(std1);

                Books book3 = new Books();
                book3.setBookName("Advanced Java");
                book3.setStudent(std1);

                Set<Books> bookList1 = new HashSet<>();
                bookList1.add(book1);
                bookList1.add(book2);
                bookList1.add(book3);

                std1.setBooks(bookList1);

                session.save(std1);  
            } else {
                System.out.println("Student Ram already exists with ID: " + std1.getId());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
