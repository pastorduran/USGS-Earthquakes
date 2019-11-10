package com.usgs.earthquakes.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Geometry model to store earthquakes coordinates   
*
* @author pastorduran
* @project USGS-Earthquakes
* @class Geometry
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Geometry implements Serializable {

	private static final long serialVersionUID = 5089966947548786348L;

	private String type;
	
	private List<Double> coordinates;

}
