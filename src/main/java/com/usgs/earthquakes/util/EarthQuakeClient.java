package com.usgs.earthquakes.util;

import com.google.gson.GsonBuilder;

public class EarthQuakeClient {
	
	private static final String DATE_FORMAT = "yyyy-mm-dd";
	
	private EarthQuakeClient() {
		
	}
	
	public static String getJson(Object object) {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).serializeNulls().create().toJson(object);
	}

}
