package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.ss.utopia.entity.Route;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.dao.RouteRepository;
import com.ss.utopia.dao.AirplaneRepository;
import com.ss.utopia.dao.FlightRepository;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	AirplaneRepository airplaneCheck;
	
	@Autowired
	RouteRepository routeCheck;
	
	public Iterable<Flight> getFlights(){
		return flightRepo.findAll();
	}
	
	public ResponseEntity<Flight> getFlightById(Integer id){
		Optional<Flight> flight = flightRepo.findById(id);
		if(flight.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight.get());
	}
	
	public ResponseEntity<String> createFlight(Flight flight){
		Optional<Route> confirmRoute = routeCheck.findById(flight.getRoute().getId());
		Optional<Airplane> confirmAirplane = airplaneCheck.findById(flight.getAirplane().getId());
		if(confirmRoute.isEmpty() || confirmAirplane.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Either the route or the airplane does no exist");
		}
		flightRepo.save(flight);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post Succeeded");
	}
	
	public ResponseEntity<String> updateFlight(Integer id, Flight flight){
		Optional<Flight> flightExist = flightRepo.findById(id);
		if(flightExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Flight with this id does not exist");
		}
		if(flight.getId() != id) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID's do not match.");

		}
		Optional<Route> confirmRoute = routeCheck.findById(flight.getRoute().getId());
		Optional<Airplane> confirmAirplane = airplaneCheck.findById(flight.getAirplane().getId());
		if(confirmRoute.isEmpty() || confirmAirplane.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Either the route or the airplane does no exist");
		}
		flightRepo.save(flight);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Update Succeeded");
	}
	
	public ResponseEntity<String> deleteFlight(Integer id){
		Optional<Flight> flightExist = flightRepo.findById(id);
		if(flightExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Flight does not exist");
		}
		flightRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
	}
}
