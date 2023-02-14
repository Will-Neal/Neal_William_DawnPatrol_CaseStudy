package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;


@Component
@Entity
public class Surfboard {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String shaper;
	private String length;
	private String tail;
	private int finNum;
	private String finType;
	
	public Surfboard() {
		
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Surfboard(String shaper, String length, String tail, int finNum, String finType, User user) {
		super();
		this.shaper = shaper;
		this.length = length;
		this.tail = tail;
		this.finNum = finNum;
		this.finType = finType;
		this.user = user;
	}

	public Surfboard(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShaper() {
		return shaper;
	}

	public void setShaper(String shaper) {
		this.shaper = shaper;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

	public int getFinNum() {
		return finNum;
	}

	public void setFinNum(int finNum) {
		this.finNum = finNum;
	}

	public String getFinType() {
		return finType;
	}

	public void setFinType(String finType) {
		this.finType = finType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Surfboard surfboard = (Surfboard) o;
		return id == surfboard.id && finNum == surfboard.finNum && Objects.equals(user, surfboard.user) && Objects.equals(shaper, surfboard.shaper) && Objects.equals(length, surfboard.length) && Objects.equals(tail, surfboard.tail) && Objects.equals(finType, surfboard.finType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, shaper, length, tail, finNum, finType);
	}

	@Override
	public String toString() {
		return "Surfboard{" +
				"id=" + id +
				", user=" + user +
				", shaper='" + shaper + '\'' +
				", length='" + length + '\'' +
				", tail='" + tail + '\'' +
				", finNum=" + finNum +
				", finType='" + finType + '\'' +
				'}';
	}
}
