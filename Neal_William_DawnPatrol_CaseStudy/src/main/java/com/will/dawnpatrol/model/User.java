package com.will.dawnpatrol.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.springframework.stereotype.Component;


/**
 * @author willw
 * POJO describes User entity in database. Stores user information and is mapped to AuthUser for authentication purposes. 
 * JsonIgnored is used to prevent sensitive user data from being displayed in RestApi.
 */
@Component
@Entity
public class User {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnore
	private String firstName;
	@JsonIgnore
	private String lastName;

	@JsonIgnore
	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;
	private String location;
	private String homebreak;
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String password, String location,
			String homebreak) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.location = location;
		this.homebreak = homebreak;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHomebreak() {
		return homebreak;
	}

	public void setHomebreak(String homebreak) {
		this.homebreak = homebreak;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, homebreak, id, lastName, location, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(homebreak, other.homebreak) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(location, other.location)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", location=" + location + ", homebreak=" + homebreak + "]";
	}
	
	
}
