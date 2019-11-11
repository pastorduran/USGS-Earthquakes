package com.usgs.earthquakes.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase para recibir parametros de la petici�n del cliente
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class PaisesYFechasRequest
 * @date nov 12, 2019
 *
 */
@ApiModel("Modelo PaisesYFechasRequest")
@Getter
@Setter
public class PaisesYFechasRequest extends RangoFechasRequest implements Serializable{

	private static final long serialVersionUID = -6902462970506867932L;
	
	@ApiModelProperty(value = "Pa�s para el primer rango de fechas", required = true, example = "Argentina")
	private String paisR1;
	@ApiModelProperty(value = "Pa�s para el segundo rango de fechas", required = true, example = "chile")
	private String paisR2;
}
