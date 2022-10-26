package com.ey.hib;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private  static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			Properties p = new Properties();
			p.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			p.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/test");
			p.setProperty(Environment.USER,"root");
			p.setProperty(Environment.PASS, "root");
			p.setProperty(Environment.FORMAT_SQL, "true");
			p.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			p.setProperty(Environment.SHOW_SQL, "true");
			p.setProperty(Environment.HBM2DDL_AUTO, "validate");
			p.setProperty(Environment.POOL_SIZE, "5");

			sessionFactory = new Configuration().setProperties(p).addAnnotatedClass(Student.class).buildSessionFactory();

		}catch(Exception e){
			System.out.print(e.getMessage());
		}

		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}
