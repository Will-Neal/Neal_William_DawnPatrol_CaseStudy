package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;


/**
 * @author willw
 * POJO that describes Spots in the application and determines the structure of Spots saved to database.
 * Id is an Integer which is autogenerated. Has a Many to One relationship with Users on foreign key user_id.
 * If the associated User is deleted the Spot will be deleted. 
 */
@Component
@Entity
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id")
	private User user;
	private String name;
	private String location;
	private String type;
	private String idealExposure;
	private String idealWind;
	

	public Spot() {
		super();
	}

	public Spot(int id, User user, String name, String location, String type, String idealExposure, String idealWind) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.location = location;
		this.type = type;
		this.idealExposure = idealExposure;
		this.idealWind = idealWind;
	}

	public Spot(User user, String name, String location, String type, String idealExposure, String idealWind) {
		this.user = user;
		this.name = name;
		this.location = location;
		this.type = type;
		this.idealExposure = idealExposure;
		this.idealWind = idealWind;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdealExposure() {
		return idealExposure;
	}

	public void setIdealExposure(String idealExposure) {
		this.idealExposure = idealExposure;
	}

	public String getIdealWind() {
		return idealWind;
	}

	public void setIdealWind(String idealWind) {
		this.idealWind = idealWind;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Spot spot = (Spot) o;
		return id == spot.id && Objects.equals(user, spot.user) && Objects.equals(name, spot.name) && Objects.equals(location, spot.location) && Objects.equals(type, spot.type) && Objects.equals(idealExposure, spot.idealExposure) && Objects.equals(idealWind, spot.idealWind);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, name, location, type, idealExposure, idealWind);
	}
}
