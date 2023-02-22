package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;


/**
 * @author willw
 * Session entity for storage in the database. Has a Long type ID that is auto generated. 
 * User_id is a foreign key and a session will be deleted if the associted User is deleted. 
 * Standard POJO.
 */
@Component
@Entity
@Table
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id")
	private User user;

	private Double size;
	private int period;
	private int direction;
	private int windStrength;
	private int windDirection;
	private int rating;

	private int boardRating;

	private String board;

	private String spot;

	private String date;

	private String comment;

	public Session() {
	}

	public Session(User user, Double size, int period, int direction, int windStrength, int windDirection, int rating, int boardRating, String board, String spot, String date, String comment) {
		this.user = user;
		this.size = size;
		this.period = period;
		this.direction = direction;
		this.windStrength = windStrength;
		this.windDirection = windDirection;
		this.rating = rating;
		this.boardRating = boardRating;
		this.board = board;
		this.spot = spot;
		this.date = date;
		this.comment = comment;
	}

	public Session(Long id, User user, Double size, int period, int direction, int windStrength, int windDirection, int rating, int boardRating, String board, String spot, String date, String comment) {
		this.id = id;
		this.user = user;
		this.size = size;
		this.period = period;
		this.direction = direction;
		this.windStrength = windStrength;
		this.windDirection = windDirection;
		this.rating = rating;
		this.boardRating = boardRating;
		this.board = board;
		this.spot = spot;
		this.date = date;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getWindStrength() {
		return windStrength;
	}

	public void setWindStrength(int windStrength) {
		this.windStrength = windStrength;
	}

	public int getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getBoardRating() {
		return boardRating;
	}

	public void setBoardRating(int boardRating) {
		this.boardRating = boardRating;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Session session = (Session) o;
		return period == session.period && direction == session.direction && windStrength == session.windStrength && windDirection == session.windDirection && rating == session.rating && boardRating == session.boardRating && Objects.equals(id, session.id) && Objects.equals(user, session.user) && Objects.equals(size, session.size) && Objects.equals(board, session.board) && Objects.equals(spot, session.spot) && Objects.equals(date, session.date) && Objects.equals(comment, session.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, size, period, direction, windStrength, windDirection, rating, boardRating, board, spot, date, comment);
	}

	@Override
	public String toString() {
		return "Session{" +
				"id=" + id +
				", user=" + user +
				", size=" + size +
				", period=" + period +
				", direction=" + direction +
				", windStrength=" + windStrength +
				", windDirection=" + windDirection +
				", rating=" + rating +
				", boardRating=" + boardRating +
				", board='" + board + '\'' +
				", spot='" + spot + '\'' +
				", date='" + date + '\'' +
				", comment='" + comment + '\'' +
				'}';
	}
}
