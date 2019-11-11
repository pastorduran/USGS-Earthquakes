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
	 * Method that search earthquakes between two dates
	 * 
	 * @param startTime
	 * @param endTime
	 * @return Event Object
	 * @throws UsgsEarthQuakesException 
	 */
	Event getEarthQuakeBetweenDates(String startTime, String endTime) throws UsgsEarthQuakesException;

	
	/**
	 * Method that search earthquakes between two magnitudes
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
	
	/**
	 * Method that count earthquakes by dates and country
	 * @param startTime
	 * @param endTime
	 * @param country
	 * @return count earthquakes
	 * @throws UsgsEarthQuakesException
	 */
	Integer countEarthQuakes(String startTime, String endTime, String country) throws UsgsEarthQuakesException;

}
