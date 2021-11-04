package com.ss.utopia.dao;


import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

import com.ss.utopia.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, String>{
	@Query(value = "select * from airport a where a.iata_id = ?1", nativeQuery = true)
	public Collection<Airport> getAirportByIata(String airportCode);
	
	@Transactional
	@Modifying
	@Query(value = "delete from airport a where a.iata_id = ?1", nativeQuery = true)
	public void deleteAirport(String airportCode);
}