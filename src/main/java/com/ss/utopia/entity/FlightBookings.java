package com.ss.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.io.Serializable;
@Entity
@IdClass(FBCompound.class)
@Table(name="flight_bookings")
public class FlightBookings implements Serializable{
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@Id
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Integer getBookingId() {
		return booking.getId();
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
