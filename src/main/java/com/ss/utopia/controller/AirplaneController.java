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

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.service.AirplaneService;

@RestController
@RequestMapping("/airplane")

public class AirplaneController {
	@Autowired
	AirplaneService airplaneService;
	
	@PostMapping
	public @ResponseBody ResponseEntity<String> addAirplane(@RequestBody Airplane airplane)
			throws ClassNotFoundException, SQLException {
		return airplaneService.createAirplane(airplane);
	}
	
	@GetMapping
	public @ResponseBody Iterable<Airplane> getAirplanes() throws ClassNotFoundException, SQLException {
		return airplaneService.getAirplanes();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Airplane> getAirplaneById(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return airplaneService.getAirplaneById(id);
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<String> updateAirplane(@RequestParam int id, @RequestBody Airplane airplane) throws ClassNotFoundException, SQLException {
		return airplaneService.updateAirplane(id, airplane);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteAirplane(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return airplaneService.deleteAirplaneType(id);
	}
}
