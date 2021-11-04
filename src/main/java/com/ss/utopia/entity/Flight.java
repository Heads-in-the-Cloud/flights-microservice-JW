package com.ss.utopia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="airplane_id")
	private Airplane airplane;
	
	@Column(name="departure_time")
	private String departure_time;
	@Column(name="reserved_seats")
	private int reserved_seats;
	@Column(name="seat_price")
	private float seat_price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public int getRoute_id() {
//		return route.getId();
//	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
//	public int getAirplane_id() {
//		return airplane.getId();
//	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane_id(Airplane airplane) {
		this.airplane = airplane;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public int getReserved_seats() {
		return reserved_seats;
	}
	public void setReserved_seats(int reserved_seats) {
		this.reserved_seats = reserved_seats;
	}
	public float getSeat_price() {
		return seat_price;
	}
	public void setSeat_price(float seat_price) {
		this.seat_price = seat_price;
	}
}
