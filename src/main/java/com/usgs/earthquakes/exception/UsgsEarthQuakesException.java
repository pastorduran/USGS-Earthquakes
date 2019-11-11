package com.usgs.earthquakes.exception;


/**
 * @author pastorduran
 *
 */
public class UsgsEarthQuakesException extends Exception {
	
	private static final long serialVersionUID = 8899512866874994532L;
	
    public UsgsEarthQuakesException(String message) {
        super(message);
    }
	
	public UsgsEarthQuakesException(String message, Throwable cause) {
        super(message, cause);
    }

}
