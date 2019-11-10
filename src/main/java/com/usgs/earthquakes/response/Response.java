package com.usgs.earthquakes.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pastorduran
 *
 */
@Getter
@Setter
public class Response {

	private String internalCode;
	private String message;
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
