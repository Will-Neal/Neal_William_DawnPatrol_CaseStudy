package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
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

	public Spot(String name, String location, String type, String idealExposure, String idealWind) {
		super();
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
	public int hashCode() {
		return Objects.hash(id, idealExposure, idealWind, location, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spot other = (Spot) obj;
		return id == other.id && Objects.equals(idealExposure, other.idealExposure)
				&& Objects.equals(idealWind, other.idealWind) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Break [id=" + id + ", name=" + name + ", location=" + location + ", type=" + type + ", idealExposure="
				+ idealExposure + ", idealWind=" + idealWind + "]";
	}




	
	
}
