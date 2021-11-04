package com.ss.utopia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airplane_type")
public class AirplaneType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "max_capacity")
	private Integer maxCapacity;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getID() {
		return id;
	}
	public void setCapacity(Integer capacity) {
		this.maxCapacity = capacity;
	}
	public Integer getCapacity() {
		return maxCapacity;
	}
}
	