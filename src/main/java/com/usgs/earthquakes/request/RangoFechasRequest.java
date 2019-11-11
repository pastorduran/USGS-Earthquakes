package com.usgs.earthquakes.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Request 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @interface RangoFechasRequest
 * @date nov 12, 2019
 *
 */
@Getter
@Setter
@ToString
public class RangoFechasRequest implements Serializable {

	private static final long serialVersionUID = 9202738013269864987L;
	
	private String fechaInicioR1;
	
	private String fechaTerminoR1;
	
	private String fechaInicioR2;
	
	private String fechaTerminoR2;

}
