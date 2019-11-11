package com.usgs.earthquakes.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.usgs.earthquakes.request.PaisesYFechasRequest;
import com.usgs.earthquakes.request.RangoFechasRequest;
import com.usgs.earthquakes.response.EarthQuakeCount;
import com.usgs.earthquakes.response.Response;
import com.usgs.earthquakes.service.EarthQuakeService;
import com.usgs.earthquakes.util.EarthQuakeTool;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Event controller
 *
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EventController
 * @date nov 12, 2019
 * 
 */
@Api(value = "Sismos microservice", description = "Esta API lee los sismos registrados a nivel mundial")
@RestController
@RequestMapping("/sismos")
public class EventController {
	
	@Autowired
	private EarthQuakeService earthQuakeService;
	
	
	@Loggable
	@ApiOperation(value = "Busqueda de sismos por rango de fecha", notes = "retorna los sismos registrados en el rango de fecha", response = Response.class )
	@GetMapping(path = "/porFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorFecha(@RequestParam String fechaInicio, @RequestParam String fechaFin){
		Event event = null;
		try {
			event = earthQuakeService.getEarthQuakeBetweenDates(fechaInicio, fechaFin);
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		if (event != null && event.getFeatures() != null) {
			return new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event.getFeatures())), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, ResponseConstant.MESSAGE_FAILED, null)), HttpStatus.OK);
		}
	}
	
	@Loggable
	@ApiOperation(value = "Busqueda de sismos por rango de magnitud", notes = "retorna los sismos registrados en el rango de magnitudes ingresadas", response = Response.class )
	@GetMapping(path = "/porMagnitud", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorMagnitud(@RequestParam String magnitudMinima, @RequestParam String magnitudMaxima){
		Event event = null;
		try {
			event = earthQuakeService.getEarthQuakeBetweenMagnitudes(magnitudMinima, magnitudMaxima);	
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		
		if (event != null && event.getFeatures() != null) {
			return new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event.getFeatures())), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_NOT_FOUND, null)), HttpStatus.OK);
		}
	}
	
	@Loggable
	@ApiOperation(value = "Busqueda de sismos por país", notes = "retorna los sismos registrados por país", response = Response.class )
	@GetMapping(path = "/porPais", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorPais(@RequestParam String pais){
		Event event = null;
		List<Feature> features = new ArrayList<>();
		try {
			event = earthQuakeService.getEarthQuakes();
			features.addAll(EarthQuakeTool.getFeatures(pais, event));
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		return new ResponseEntity<>(EarthQuakeTool
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, features)),HttpStatus.OK);
	}
	
	@Loggable
	@ApiOperation(value = "Busqueda de sismos por rango de fechas", notes = "retorna los sismos registrados en dos rangos de fechas", response = Response.class )
	@GetMapping(path = "/porRangoFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getSismosPorRangoFechas(@RequestBody RangoFechasRequest rangoFechas){
		List<Feature> features = new ArrayList<>();
		try {
			Event firstSearchEvent = earthQuakeService.getEarthQuakeBetweenDates(rangoFechas.getFechaInicioR1(), rangoFechas.getFechaTerminoR1());
			Event secondSearchEvent = earthQuakeService.getEarthQuakeBetweenDates(rangoFechas.getFechaInicioR2(), rangoFechas.getFechaTerminoR2());
			features.addAll(firstSearchEvent.getFeatures());
			features.addAll(secondSearchEvent.getFeatures());
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		return new ResponseEntity<>(EarthQuakeTool
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, features)),HttpStatus.OK);
	}
	
	@Loggable
	@ApiOperation(value = "Busqueda de sismos por rango de fechas y paises", notes = "retorna los sismos registrados en dos rangos de fechas y paises", response = Response.class)
	@GetMapping(path = "/porPaisesYFechas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCantidadSismosPorPaisYFechas(@RequestBody PaisesYFechasRequest paisesYFechas) {
		Integer counterEq = 0;
		try {
			counterEq += earthQuakeService.countEarthQuakes(paisesYFechas.getFechaInicioR1(), paisesYFechas.getFechaTerminoR1(), paisesYFechas.getPaisR1());
			counterEq += earthQuakeService.countEarthQuakes(paisesYFechas.getFechaInicioR2(), paisesYFechas.getFechaTerminoR2(), paisesYFechas.getPaisR2());
		} catch (UsgsEarthQuakesException e) {
			new ResponseEntity<>(EarthQuakeTool
					.getJson(new Response(ResponseConstant.STATUS_CODE_FAILED, e.getMessage(), null)), HttpStatus.OK);
		}
		return new ResponseEntity<>(EarthQuakeTool
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, new EarthQuakeCount(counterEq))),HttpStatus.OK);
	}
}
