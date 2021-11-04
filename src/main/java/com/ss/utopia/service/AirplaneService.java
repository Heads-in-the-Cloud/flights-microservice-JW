package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.AirplaneRepository;
import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.dao.AirplaneTypeRepository;

@Service
public class AirplaneService {
	@Autowired 
	AirplaneRepository airplaneRepo;
	
	@Autowired
	AirplaneTypeRepository airplaneTypeCheck;
	
	public Iterable<Airplane> getAirplanes() throws ClassNotFoundException, SQLException {		
		return airplaneRepo.findAll();
	}
	
	public ResponseEntity<Airplane> getAirplaneById(int id) {
		Optional<Airplane> airports = airplaneRepo.findById(id);
		if(airports.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(airports.get());
	}
	
	public ResponseEntity<String> createAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		Collection<AirplaneType> checkType = airplaneTypeCheck.findATypeByATypeId(airplane.getaTypeId());
		if(checkType.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type with this ID does not exist");
		}
		airplaneRepo.save(airplane);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post Succeeded");
	}
	
	public ResponseEntity<String> updateAirplane(int id, Airplane airplane) throws ClassNotFoundException, SQLException {
		Optional<Airplane> airplaneExist = airplaneRepo.findById(id);
		if(airplaneExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Airplane does not exist");		
		}
		if(airplane.getId()!=id) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID's do not match");		

		}
		Collection<AirplaneType> checkType = airplaneTypeCheck.findATypeByATypeId(airplane.getaTypeId());
		if(checkType.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create with this type.");
		}
		airplaneRepo.save(airplane);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated");
	}
	public ResponseEntity<String> deleteAirplaneType(int id) throws ClassNotFoundException, SQLException {	
		Optional<Airplane> airports = airplaneRepo.findById(id);
		if(airports.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot delete, this airplane with this ID does not exist");
		}
		airplaneRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete Succeeded");
	}
}
