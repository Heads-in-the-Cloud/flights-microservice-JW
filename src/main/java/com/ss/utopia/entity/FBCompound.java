package com.ss.utopia.entity;

import java.io.Serializable;


public class FBCompound implements Serializable{

	private Integer flight;

	private Integer booking;
	
	protected FBCompound() {
	}
	
	public FBCompound(Integer flight, Integer booking) {
		this.flight=flight;
		this.booking=booking;
	}
	public Integer getFlightId() {
		return flight;
	}

	public void setFlightId(Integer flight) {
		this.flight = flight;
	}

	public Integer getBookingId() {
		return booking;
	}

	public void setBookingId(Integer booking) {
		this.booking = booking;
	}
}
