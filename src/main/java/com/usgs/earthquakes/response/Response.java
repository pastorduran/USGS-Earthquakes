package com.usgs.earthquakes.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pastorduran
 *
 */
@ApiModel("Modelo Response")
@Getter
@Setter
public class Response {

	@ApiModelProperty(value = "Codigo interno del API para evaluar status de la peticion", required = true, example = "200")
	private String internalCode;
	@ApiModelProperty(value = "Mensaje interno del API para indicar el resultado de la peticion", required = true, example = "Successful")
	private String message;
	@ApiModelProperty(value = "Objeto generico para ajustar la respuesta de acuerdo a la peticion", required = true)
	private Object payload;

	public Response() {
		super();
	}

	public Response(String internalCode, String message, Object payload) {
		super();
		this.internalCode = internalCode;
		this.message = message;
		this.payload = payload;
	}
}
