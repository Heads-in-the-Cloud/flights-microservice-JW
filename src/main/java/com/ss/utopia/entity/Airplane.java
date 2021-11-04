package com.ss.utopia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airplane")
public class Airplane {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
    @ManyToOne
    @JoinColumn(name = "type_id")
	private AirplaneType aType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getaTypeId() {
		return aType.getID();
	}
	public void setaType(AirplaneType aType) {
		this.aType = aType;
	}

}
