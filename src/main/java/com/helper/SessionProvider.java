package com.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Project;

public class SessionProvider {
	public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class);
		SessionFactory factory = cfg.buildSessionFactory();
		return factory.openSession();
	}
}
