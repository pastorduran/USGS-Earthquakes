package com.usgs.earthquakes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.usgs.earthquakes.service.EarthQuakeService;

/**
 * Event controller
 *
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EventController
 * @date nov 12, 2019
 * 
 */
@RestController
@RequestMapping("/sismos")
public class EventController {
	
	@Autowired
	private EarthQuakeService earthQuakeService;
	

	@GetMapping(path = "/porFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorFecha(@RequestParam String fechaInicio, @RequestParam String fechaFin){
		return new ResponseEntity<>(earthQuakeService.getEarthQuakeBetweenDates(fechaInicio, fechaFin), HttpStatus.OK);
	}
	
	@GetMapping(path = "/porMagnitud", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorMagnitud(@RequestParam String magnitudMinima, @RequestParam String magnitudMaxima){
		return new ResponseEntity<>(earthQuakeService.getEarthQuakeBetweenMagnitudes(magnitudMinima, magnitudMaxima),HttpStatus.OK);
	}
}
