package com.will.dawnpatrol.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateConnection {
	
	public static Session startConnection() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session sesh = factory.openSession();
		
		return sesh;
	}
	
}
