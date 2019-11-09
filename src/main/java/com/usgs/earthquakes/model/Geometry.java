package com.usgs.earthquakes.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Geometry model to store earthquakes coordinates   
*
* @author Pastor Durán
* @project USGS-Earthquakes
* @class Geometry
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Geometry {
	
	private String type;
	
	private List<Double> coordinates;

}
