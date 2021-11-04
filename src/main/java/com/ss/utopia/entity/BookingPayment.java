package com.ss.utopia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="booking_payment")
public class BookingPayment{
	@Id
	private Integer booking_id;
	
//	@OneToOne
//	@JoinColumn(name="booking_id")
//	@MapsId
//	private Booking booking;
	
	private String stripe_id;
	private Integer refunded;
	
	public Integer getBookingId() {
		return booking_id;
	}

	public void setBookingId(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public String getStripeId() {
		return stripe_id;
	}

	public void setStripeId(String stripe_id) {
		this.stripe_id = stripe_id;
	}

	public Integer getRefunded() {
		return refunded;
	}

	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}

}
