package com.will.dawnpatrol.model;

import org.hibernate.Session;

import com.will.dawnpatrol.utils.HibernateConnection;

public class EntityBuilder {

	public static void main(String[] args) {
	Session session = HibernateConnection.startConnection();
	@SuppressWarnings("unused")
	User user = new User();
	@SuppressWarnings("unused")
	Spot spot = new Spot();
	@SuppressWarnings("unused")
	Surfboard surfboard = new Surfboard();
	@SuppressWarnings("unused")
	Wetsuit wetsuit = new Wetsuit();
	@SuppressWarnings("unused")
	Sessions sessions = new Sessions();
	
	session.close();

	}

}
