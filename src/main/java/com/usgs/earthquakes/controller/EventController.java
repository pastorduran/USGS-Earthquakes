package com.usgs.earthquakes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usgs.earthquakes.annotation.Loggable;
import com.usgs.earthquakes.constant.ResponseConstant;
import com.usgs.earthquakes.exception.UsgsEarthQuakesException;
import com.usgs.earthquakes.model.Event;
import com.usgs.earthquakes.model.Feature;
import com.usgs.earthquakes.request.RangoFechasRequest;
import com.usgs.earthquakes.response.Response;
import com.usgs.earthquakes.service.EarthQuakeService;
import com.usgs.earthquakes.util.EarthQuakeClient;

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
	

	@Loggable
	@GetMapping(path = "/porFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorFecha(@RequestParam String fechaInicio, @RequestParam String fechaFin){
		Event event = null;
		try {
			event = earthQuakeService.getEarthQuakeBetweenDates(fechaInicio, fechaFin);
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		if (event != null && event.getFeatures() != null) {
			return new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event.getFeatures())), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, ResponseConstant.MESSAGE_FAILED, null)), HttpStatus.OK);
		}
	}
	
	@Loggable
	@GetMapping(path = "/porMagnitud", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorMagnitud(@RequestParam String magnitudMinima, @RequestParam String magnitudMaxima){
		Event event = null;
		try {
			earthQuakeService.getEarthQuakeBetweenMagnitudes(magnitudMinima, magnitudMaxima);	
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		
		if (event != null && event.getFeatures()!=null) {
			return new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event.getFeatures())), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_NOT_FOUND, null)), HttpStatus.OK);
		}
	}
	
	@Loggable
	@GetMapping(path = "/porPais", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorPais(@RequestParam String pais){
		Event event = null;
		List<Feature> features = new ArrayList<>();
		try {
			event = earthQuakeService.getEarthQuakes();
			features.addAll(event.getFeatures().stream().filter(
					feat -> feat.getProperties().getPlace().toUpperCase().contains(pais.toUpperCase())
					).collect(Collectors.toList()));
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		return new ResponseEntity<>(EarthQuakeClient
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, features)),HttpStatus.OK);
	}
	
	@Loggable
	@GetMapping(path = "/porRangoFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorRangoFechas(@RequestBody RangoFechasRequest rangoFechas){
		List<Feature> features = new ArrayList<>();
		try {
			Event firstSearchEvent = earthQuakeService.getEarthQuakeBetweenDates(rangoFechas.getFechaInicioR1(), rangoFechas.getFechaTerminoR1());
			Event secondSearchEvent = earthQuakeService.getEarthQuakeBetweenDates(rangoFechas.getFechaInicioR2(), rangoFechas.getFechaTerminoR2());
			features.addAll(firstSearchEvent.getFeatures());
			features.addAll(secondSearchEvent.getFeatures());
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeClient
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		return new ResponseEntity<>(EarthQuakeClient
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, features)),HttpStatus.OK);
	}
}
