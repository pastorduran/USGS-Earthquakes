package com.usgs.earthquakes.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para recibir parametros de la petición del cliente
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class PaisesYFechasRequest
 * @date nov 12, 2019
 *
 */
@Getter
@Setter
public class PaisesYFechasRequest extends RangoFechasRequest implements Serializable{

	private static final long serialVersionUID = -6902462970506867932L;
	
	private String paisR1;
	private String paisR2;
}
