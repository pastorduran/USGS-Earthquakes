package com.usgs.earthquakes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.usgs.earthquakes.model.Event;
import com.usgs.earthquakes.model.Feature;

/**
 * Tool to format response to client on json format Filter objects from params,
 * etc
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EarthQuakeTool
 * @date nov 12, 2019
 *
 */
public class EarthQuakeTool {

	private static final String DATE_FORMAT = "yyyy-mm-dd";

	private EarthQuakeTool() {

	}

	/**
	 * Method that convert java object to Json String format
	 * 
	 * @param object
	 * @return json object as string format
	 */
	public static String getJson(Object object) {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).serializeNulls().create().toJson(object);
	}

	/**
	 * Method that convert json string to Event Object
	 * 
	 * @param jsonEvent
	 * @return Event
	 */
	public static Event getEventFromJson(String jsonEvent) {
		return new Gson().fromJson(jsonEvent, Event.class);
	}

	/**
	 * Method than filter features by country
	 * 
	 * @param country
	 * @param event
	 * @return feature list
	 */
	public static List<Feature> getFeatures(String country, Event event) {
		List<Feature> features = new ArrayList<>();
		features.addAll(event.getFeatures().stream()
				.filter(feat -> feat.getProperties().getPlace().toUpperCase().contains(country.toUpperCase()))
				.collect(Collectors.toList()));
		return features;
	}

	/**
	 * Method to validate correct date format
	 * 
	 * @param dateToValidate
	 * @param dateFromat
	 * @return boolean
	 */
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {
		if (dateToValidate == null) {
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

}
