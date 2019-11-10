package com.usgs.earthquakes.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Feature model  
*
* @author pastorduran
* @project USGS-Earthquakes
* @class Feature
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Feature implements Serializable {

	private static final long serialVersionUID = 9091603678234745422L;

	private String id;
	
	private String type;
	
	private Property properties;
	
	private Geometry geometry;
	
	
}
