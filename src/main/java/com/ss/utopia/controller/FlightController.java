package com.ss.utopia.controller;

import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	FlightService flightService;
	
	@GetMapping
	public @ResponseBody Iterable<Flight> getFlights() throws ClassNotFoundException, SQLException{
		return flightService.getFlights();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Flight> getFlightById(@PathVariable Integer id){
		return flightService.getFlightById(id);
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<String> addFlight(@RequestBody Flight flight){
		return flightService.createFlight(flight);
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<String> updateFlight(@RequestParam Integer id, @RequestBody Flight flight){
		return flightService.updateFlight(id, flight);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteFlight(@PathVariable Integer id) {
		return flightService.deleteFlight(id);
	}
}
