package com.usgs.earthquakes.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.usgs.earthquakes.model.Event;


/**
 * Tool to format response to client on json format
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EarthQuakeClient
 * @date nov 12, 2019
 *
 */
public class EarthQuakeClient {
	
	private static final String DATE_FORMAT = "yyyy-mm-dd";
	
	private EarthQuakeClient() {
		
	}
	
	/**
	 * Method that convert java object to Json String format
	 * @param object
	 * @return json object as string format
	 */
	public static String getJson(Object object) {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).serializeNulls().create().toJson(object);
	}
	
	/**
	 * Method that convert json string to Event Object
	 * @param jsonEvent
	 * @return Event 
	 */
	public static Event getEventFromJson(String jsonEvent) {
		return new Gson().fromJson(jsonEvent, Event.class);
	}

}
