package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.RouteRepository;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Route;
import com.ss.utopia.dao.AirportRepository;

@Service
public class RouteService {
	@Autowired
	RouteRepository routeRepo;
	@Autowired
	AirportRepository airportCheck;
	public Iterable<Route> getRoutes() throws ClassNotFoundException, SQLException{
		return routeRepo.findAll();
	}
	
	public ResponseEntity<Route> getRouteById(Integer id){
		Optional<Route> routes = routeRepo.findById(id);
		if(routes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(routes.get());
	}
	
	public ResponseEntity<String> createRoute(Route route) throws ClassNotFoundException, SQLException {
		Collection<Airport> checkType = airportCheck.getAirportByIata(route.getOriginAirportId());
		Collection<Airport> checkType2 = airportCheck.getAirportByIata(route.getDestinationAirportId());
		if(checkType.isEmpty() || checkType2.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type with this ID does not exist");
		}
		routeRepo.save(route);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post Succeeded");
	}
	
	public ResponseEntity<String> updateRoute(Integer id, Route route){
		Optional<Route> routeExist = routeRepo.findById(id);
		if(routeExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Route does not exist");
		}
		if(route.getId() != id) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID's do not match.");
		}
		Collection<Airport> checkType = airportCheck.getAirportByIata(route.getOriginAirportId());
		Collection<Airport> checkType2 = airportCheck.getAirportByIata(route.getDestinationAirportId());
		if(checkType.isEmpty() || checkType2.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update with these airports");
		}
		routeRepo.save(route);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated");
	}
	public ResponseEntity<String> deleteRoute(Integer id) {
		Optional<Route> routeExist = routeRepo.findById(id);
		if(routeExist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Route does not exist");
		}
		routeRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully deleted");

	}
}
