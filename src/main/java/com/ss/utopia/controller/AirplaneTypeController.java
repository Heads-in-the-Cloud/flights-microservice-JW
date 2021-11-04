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

import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.service.AirplaneTypeService;

@RestController
@RequestMapping("/airplanetype")
public class AirplaneTypeController {
	@Autowired
	AirplaneTypeService airplaneTypeService;
	
	@PostMapping
	public @ResponseBody ResponseEntity<String> addAirplaneType(@RequestParam int max_capacity)
			throws ClassNotFoundException, SQLException {
		return airplaneTypeService.createAirplaneType(max_capacity);
	}
	
	@GetMapping
	public @ResponseBody Iterable<AirplaneType> getAirplaneTypes() throws ClassNotFoundException, SQLException {
		return airplaneTypeService.getAirplaneTypes();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<AirplaneType> getAirplaneTypesById(@PathVariable int id) throws ClassNotFoundException, SQLException {
		return airplaneTypeService.getAirplaneTypeById(id);
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<String> updateAirplaneType(@RequestParam int id, @RequestParam int max_capacity) throws ClassNotFoundException, SQLException {
		return airplaneTypeService.updateAirplaneType(id, max_capacity);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteAirplaneType(@PathVariable Integer id) throws ClassNotFoundException, SQLException {
		return airplaneTypeService.deleteAirplaneType(id);
	}
}
