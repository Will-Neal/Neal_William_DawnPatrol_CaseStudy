package com.will.dawnpatrol.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name = "spot_id")
//	private Spot spot;
//
//	@ManyToOne
//	@JoinColumn(name = "surfboard_id")
//	private Surfboard surfboard;
	
	private Double size;
	private int period;
	private int direction;
	private int windStrength;
	private int windDirection;
	private int rating;

	private int boardRating;

	private String board;

	private String spot;

	public Session() {
	}

	public Session(User user, Double size, int period, int direction, int windStrength, int windDirection, int rating, int boardRating, String board, String spot) {
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
	}

	public Session(Long id, User user, Double size, int period, int direction, int windStrength, int windDirection, int rating, int boardRating, String board, String spot) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Session session = (Session) o;
		return period == session.period && direction == session.direction && windStrength == session.windStrength && windDirection == session.windDirection && rating == session.rating && boardRating == session.boardRating && Objects.equals(id, session.id) && Objects.equals(user, session.user) && Objects.equals(size, session.size) && Objects.equals(board, session.board) && Objects.equals(spot, session.spot);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, user, size, period, direction, windStrength, windDirection, rating, boardRating, board, spot);
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
				'}';
	}
}
