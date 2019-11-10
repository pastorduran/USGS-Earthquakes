package com.usgs.earthquakes.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Event model to store earthqueakes  
*
* @author pastorduran
* @project USGS-Earthquakes
* @class Event
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Event implements Serializable {
	
	private static final long serialVersionUID = 9106061993028058614L;

	private String type;
	
	private MetaData metadata;
	
	private List<Feature> features;
	
	private List<String> bbox;
}
