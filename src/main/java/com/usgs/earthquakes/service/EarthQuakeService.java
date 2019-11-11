package com.usgs.earthquakes.service;

import com.usgs.earthquakes.exception.UsgsEarthQuakesException;
import com.usgs.earthquakes.model.Event;

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
	 * @return Event Object
	 * @throws UsgsEarthQuakesException 
	 */
	Event getEarthQuakeBetweenDates(String startTime, String endTime) throws UsgsEarthQuakesException;

	
	/**
	 * Metodo para obtener los sismos registrados entre dos magnitudes
	 * 
	 * @param mingMagnitude
	 * @param maxMagnitude
	 * @return Event Object
	 * @throws UsgsEarthQuakesException 
	 */
	Event getEarthQuakeBetweenMagnitudes(String mingMagnitude, String maxMagnitude) throws UsgsEarthQuakesException;
	

	/**
	 * Method that search all earthquakes
	 * 
	 * @param
	 * @return Evemt Object
	 */
	Event getEarthQuakes() throws UsgsEarthQuakesException;

}
