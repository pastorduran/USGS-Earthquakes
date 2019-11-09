package com.usgs.earth.quakes.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Event model to store earthqueakes  
*
* @author Pastor Durán
* @project USGS-Earthquakes
* @class Event
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Event {
	
	private String type;
	
	private MetaData metaData;
	
	private List<Feature> features;
	
	private List<String> bbox;
}
