package com.ss.utopia.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "airport")
public class Airport {
	@Id
	@Column(name = "iata_id")
	private String iataId;
	
	private String city;
	
//	@OneToMany(targetEntity=Route.class, cascade = CascadeType.MERGE)
//    @JoinColumn(name="origin_id")
//	@JsonManagedReference
//    private List<Route> originRoutes;
//	
//	@OneToMany(targetEntity=Route.class, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "destination_id")
//	@JsonManagedReference
//	private List<Route> destRoutes;
	
	public String getAirportCode() {
		return iataId;
	}
	public void setAirportCode(String airportCode) {
		this.iataId = airportCode;
	}
	public String getCityName() {
		return city;
	}
	public void setCityName(String cityName) {
		this.city = cityName;
	}

//	public List<Route> getOriginRoutes() {
//		return originRoutes;
//	}
//
//	public void setOriginRoutes(List<Route> originRoutes) {
//		this.originRoutes = originRoutes;
//	}
//	
//	public List<Route> getDestRoutes() {
//		return destRoutes;
//	}
//
//	public void setDestRoutes(List<Route> destRoutes) {
//		this.destRoutes = destRoutes;
//	}
}
