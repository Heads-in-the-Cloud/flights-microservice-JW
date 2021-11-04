package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.AirplaneTypeRepository;
import com.ss.utopia.entity.AirplaneType;


@Service
public class AirplaneTypeService {
	@Autowired
	private AirplaneTypeRepository airplaneTypeRepo;
	
	public ResponseEntity<String> createAirplaneType(int capacity) throws ClassNotFoundException, SQLException {
		AirplaneType aType = new AirplaneType();
		aType.setCapacity(capacity);
		airplaneTypeRepo.save(aType);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post Succeeded");
	}
	
	public Iterable<AirplaneType> getAirplaneTypes() throws ClassNotFoundException, SQLException {		
		Iterable<AirplaneType> airplaneTypes = airplaneTypeRepo.findAll();
		return airplaneTypes;
	}
	
	public ResponseEntity<AirplaneType> getAirplaneTypeById(int id) {
		Collection<AirplaneType> airportTypes = airplaneTypeRepo.findATypeByATypeId(id);
		if(airportTypes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(airportTypes.iterator().next());
	}
	
	public ResponseEntity<String> updateAirplaneType(int id, int max_capacity) throws ClassNotFoundException, SQLException {
		Collection<AirplaneType> airplaneTypeExist = airplaneTypeRepo.findATypeByATypeId(id);
		if(airplaneTypeExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type does not exist");		}
		AirplaneType airplaneType = new AirplaneType(); 	
		airplaneType.setId(id);
		airplaneType.setCapacity(max_capacity);
		airplaneTypeRepo.save(airplaneType);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated");
	}
	public ResponseEntity<String> deleteAirplaneType(Integer id) throws ClassNotFoundException, SQLException {	
		Collection<AirplaneType> airportTypes = airplaneTypeRepo.findATypeByATypeId(id);
		if(airportTypes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type with this ID does not exist");
		}
		airplaneTypeRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully deleted");
	}
}
