package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table
public class Wetsuit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String brand;
	private Double thickness;
	
	private String booties;
	private Double bootiesThickness;
	
	private String gloves;
	private Double gloveThickness;
	
	private Boolean hood;

	public Wetsuit() {
		super();
	}

	public Wetsuit(User user, String brand, Double thickness, String booties, Double bootiesThickness,
			String gloves, Double gloveThickness, Boolean hood) {
		super();
		this.user = user;
		this.brand = brand;
		this.thickness = thickness;
		this.booties = booties;
		this.bootiesThickness = bootiesThickness;
		this.gloves = gloves;
		this.gloveThickness = gloveThickness;
		this.hood = hood;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getThickness() {
		return thickness;
	}

	public void setThickness(Double thickness) {
		this.thickness = thickness;
	}

	public String getBooties() {
		return booties;
	}

	public void setBooties(String booties) {
		this.booties = booties;
	}

	public Double getBootiesThickness() {
		return bootiesThickness;
	}

	public void setBootiesThickness(Double bootiesThickness) {
		this.bootiesThickness = bootiesThickness;
	}

	public String getGloves() {
		return gloves;
	}

	public void setGloves(String gloves) {
		this.gloves = gloves;
	}

	public Double getGloveThickness() {
		return gloveThickness;
	}

	public void setGloveThickness(Double gloveThickness) {
		this.gloveThickness = gloveThickness;
	}

	public Boolean getHood() {
		return hood;
	}

	public void setHood(Boolean hood) {
		this.hood = hood;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booties, bootiesThickness, brand, gloveThickness, gloves, hood, id, thickness, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wetsuit other = (Wetsuit) obj;
		return Objects.equals(booties, other.booties) && Objects.equals(bootiesThickness, other.bootiesThickness)
				&& Objects.equals(brand, other.brand) && Objects.equals(gloveThickness, other.gloveThickness)
				&& Objects.equals(gloves, other.gloves) && Objects.equals(hood, other.hood) && id == other.id
				&& Objects.equals(thickness, other.thickness) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Wetsuit [id=" + id + ", user=" + user + ", brand=" + brand + ", thickness=" + thickness + ", booties="
				+ booties + ", bootiesThickness=" + bootiesThickness + ", gloves=" + gloves + ", gloveThickness="
				+ gloveThickness + ", hood=" + hood + "]";
	}
	
}
