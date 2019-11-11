package com.usgs.earthquakes.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Modelo RangoFechasRequest")
@Getter
@Setter
@ToString
public class RangoFechasRequest implements Serializable {

	private static final long serialVersionUID = 9202738013269864987L;
	
	@ApiModelProperty(value = "Fecha inicio primer rango de fechas", required = true, example = "2019-10-11", allowableValues = "formato ddd-mm-dd")
	private String fechaInicioR1;
	
	@ApiModelProperty(value = "Fecha termino primer rango de fechas", required = true, example = "2019-10-14", allowableValues = "formato ddd-mm-dd")
	private String fechaTerminoR1;
	
	@ApiModelProperty(value = "Fecha inicio segundo rango de fechas", required = true, example = "2019-10-06", allowableValues = "formato ddd-mm-dd")
	private String fechaInicioR2;
	
	@ApiModelProperty(value = "Fecha termino segundo rango de fechas", required = true, example = "2019-10-09", allowableValues = "formato ddd-mm-dd")
	private String fechaTerminoR2;

}
