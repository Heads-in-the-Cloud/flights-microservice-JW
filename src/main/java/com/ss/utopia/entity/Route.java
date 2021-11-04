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
@Table(name = "route")
public class Route {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
    @ManyToOne
    @JoinColumn(name = "origin_id")
	private Airport originAirport;
    
    @ManyToOne
    @JoinColumn(name = "destination_id")
	private Airport destinationAirport;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOriginAirportId() {
		return originAirport.getAirportCode();
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	
	public String getDestinationAirportId() {
		return destinationAirport.getAirportCode();
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
}
