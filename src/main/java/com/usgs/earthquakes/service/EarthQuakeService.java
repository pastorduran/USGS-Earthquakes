package com.usgs.earthquakes.service;


/**
 * 
 * @author Pastor Duran
 * @project USGS-Earthquakes
 * @interface EarthQuakeService
 * @date nov 11, 2019
 *
 */
public interface EarthQuakeService {
	
	
	/**
	 * Metodo para obtener los sismos registrados entre dos fechas
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return Objeto evento en formato String
	 */
	String getEarthQuakeBetweenDates(String fechaInicio, String fechaFin);

	
	/**
	 * Metodo para obtener los sismos registrados entre dos magnitudes
	 * 
	 * @param magnitudMinima
	 * @param magnitudMaxima
	 * @return Objeto Event en formato String
	 */
	String getEarthQuakeBetweenMagnitudes(String magnitudMinima, String magnitudMaxima);

}
