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
public class Sessions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "spot_id")
	private Spot spot;
	
	@ManyToOne
	@JoinColumn(name = "surfboard_id")
	private Surfboard surfboard;
	
	@ManyToOne
	@JoinColumn(name = "wetsuit_id")
	private Wetsuit wetsuit;
	
	private Double size;
	private int period;
	private int direction;
	
	private int windStrength;
	private int windDirection;
	
	private int waterTemp;
	private int airTemp;
	
	private String precipitation;
	private String sky;
	
	public Sessions() {
		super();
	}

	public Sessions(User user, Spot spot, Surfboard surfboard, Wetsuit wetsuit, Double size, int period,
			int direction, int windStrength, int windDirection, int waterTemp, int airTemp, String precipitation,
			String sky) {
		super();
		this.user = user;
		this.spot = spot;
		this.surfboard = surfboard;
		this.wetsuit = wetsuit;
		this.size = size;
		this.period = period;
		this.direction = direction;
		this.windStrength = windStrength;
		this.windDirection = windDirection;
		this.waterTemp = waterTemp;
		this.airTemp = airTemp;
		this.precipitation = precipitation;
		this.sky = sky;
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

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public Surfboard getSurfboard() {
		return surfboard;
	}

	public void setSurfboard(Surfboard surfboard) {
		this.surfboard = surfboard;
	}

	public Wetsuit getWetsuit() {
		return wetsuit;
	}

	public void setWetsuit(Wetsuit wetsuit) {
		this.wetsuit = wetsuit;
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

	public int getWaterTemp() {
		return waterTemp;
	}

	public void setWaterTemp(int waterTemp) {
		this.waterTemp = waterTemp;
	}

	public int getAirTemp() {
		return airTemp;
	}

	public void setAirTemp(int airTemp) {
		this.airTemp = airTemp;
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public String getSky() {
		return sky;
	}

	public void setSky(String sky) {
		this.sky = sky;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airTemp, direction, id, period, precipitation, size, sky, spot, surfboard, user, waterTemp,
				wetsuit, windDirection, windStrength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessions other = (Sessions) obj;
		return airTemp == other.airTemp && direction == other.direction && Objects.equals(id, other.id)
				&& period == other.period && Objects.equals(precipitation, other.precipitation)
				&& Objects.equals(size, other.size) && Objects.equals(sky, other.sky)
				&& Objects.equals(spot, other.spot) && Objects.equals(surfboard, other.surfboard)
				&& Objects.equals(user, other.user) && waterTemp == other.waterTemp
				&& Objects.equals(wetsuit, other.wetsuit) && windDirection == other.windDirection
				&& windStrength == other.windStrength;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", user=" + user + ", spot=" + spot + ", surfboard=" + surfboard + ", wetsuit="
				+ wetsuit + ", size=" + size + ", period=" + period + ", direction=" + direction + ", windStrength="
				+ windStrength + ", windDirection=" + windDirection + ", waterTemp=" + waterTemp + ", airTemp="
				+ airTemp + ", precipitation=" + precipitation + ", sky=" + sky + "]";
	}
	
	
}
