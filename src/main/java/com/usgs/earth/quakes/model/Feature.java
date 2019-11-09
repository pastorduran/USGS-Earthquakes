package com.usgs.earth.quakes.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Feature model  
*
* @author Pastor Durán
* @project USGS-Earthquakes
* @class Feature
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Feature {
	
	private String id;
	
	private String type;
	
	private List<Property> properties;
	
	private Geometry geometry;
	
	
}
