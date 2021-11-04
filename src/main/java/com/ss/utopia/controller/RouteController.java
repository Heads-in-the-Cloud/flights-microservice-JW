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

import com.ss.utopia.entity.Route;
import com.ss.utopia.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
	RouteService routeService;

	@PostMapping
	public @ResponseBody ResponseEntity<String> addRoute(@RequestBody Route route)
			throws ClassNotFoundException, SQLException {
		return routeService.createRoute(route);
	}
	
	@GetMapping
	public @ResponseBody Iterable<Route> getRoutes() throws ClassNotFoundException, SQLException{
		return routeService.getRoutes();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Route> getRouteById(@PathVariable int id){
		return routeService.getRouteById(id);
	}
	@PutMapping()
	public @ResponseBody ResponseEntity<String> updateroute(@RequestParam Integer id, @RequestBody Route route){
		return routeService.updateRoute(id, route);
	}
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deleteRoute(@PathVariable int id) {
		return routeService.deleteRoute(id);
	}
}
	