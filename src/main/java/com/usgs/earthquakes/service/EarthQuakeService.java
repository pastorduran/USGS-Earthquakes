package com.usgs.earthquakes.service;


/**
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @interface EarthQuakeService
 * @date nov 11, 2019
 *
 */
public interface EarthQuakeService {
	
	
	/**
	 * Metodo para obtener los sismos registrados entre dos fechas
	 * 
	 * @param startTime
	 * @param endTime
	 * @return Event Object as String
	 */
	String getEarthQuakeBetweenDates(String startTime, String endTime);

	
	/**
	 * Metodo para obtener los sismos registrados entre dos magnitudes
	 * 
	 * @param mingMagnitude
	 * @param maxMagnitude
	 * @return Event Object as String
	 */
	String getEarthQuakeBetweenMagnitudes(String mingMagnitude, String maxMagnitude);

}
