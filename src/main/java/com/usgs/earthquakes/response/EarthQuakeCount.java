package com.usgs.earthquakes.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para enviar al cliente con cantidad de sismos
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EarthQuakeCount
 * @date nov 12, 2019
 *
 */
@Getter
@Setter
public class EarthQuakeCount implements Serializable {
	
	private static final long serialVersionUID = -1544802874489921664L;
	
	private Integer countEartQuakes;

	public EarthQuakeCount(Integer countEartQuakes) {
		super();
		this.countEartQuakes = countEartQuakes;
	}	
	

}
