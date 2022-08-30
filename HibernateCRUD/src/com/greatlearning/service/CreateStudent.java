package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Student;

public class CreateStudent {
	public static void main(String args []) {
		SessionFactory factory= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			System.out.println("Creating studnet object...");
			Student student1=new Student("Vikas","vikas@gl.com");
			
			session.beginTransaction();
			session.save(student1);
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
}
