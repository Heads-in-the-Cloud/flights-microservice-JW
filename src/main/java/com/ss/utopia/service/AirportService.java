package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.AirportRepository;
import com.ss.utopia.entity.Airport;

@Service
public class AirportService{
	@Autowired
	private AirportRepository airportRepo;
	
	public ResponseEntity<String> createAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Collection<Airport> airportExist = airportRepo.getAirportByIata(airport.getAirportCode());
		if(!airportExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This airport already exists");
		}
		airportRepo.save(airport);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post Succeeded");
	}
	
	public Iterable<Airport> getAirports() throws ClassNotFoundException, SQLException {		
		return airportRepo.findAll();
	}
	
	public ResponseEntity<Airport> getAirportById(String iata_id) {
		Collection<Airport> airports = airportRepo.getAirportByIata(iata_id.toUpperCase());
		if(airports.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(airports.iterator().next());
	}
	public ResponseEntity<String> updateAirport(String airportCode, String updateCityName) throws ClassNotFoundException, SQLException {
		Collection<Airport> airportExist = airportRepo.getAirportByIata(airportCode);
		if(airportExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Airport does not exist");		
		}
		Airport airport = new Airport();
		airport.setAirportCode(airportCode);
		airport.setCityName(updateCityName);
		airportRepo.save(airport);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated");

	}
	
	public ResponseEntity<String> deleteAirport(String iataId) throws ClassNotFoundException, SQLException {	
		Collection<Airport> airportExist = airportRepo.getAirportByIata(iataId);
		if(airportExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Airport does not exist");		
		}
		airportRepo.deleteAirport(iataId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully deleted");
	}
}
	