package com.usgs.earthquakes.constant;

/**
 * Response Constant class
 * Constants to Response object
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class ResponseConstant
 * @date nov 12, 2019
 *
 */
public class ResponseConstant {
	
	public static final String STATUS_CODE_OK = "200";

	public static final String MESSAGE_OK = "Successful";

	public static final String STATUS_CODE_FAILED = "500";

	public static final String MESSAGE_FAILED = "Failed";

	public static final String STATUS_CODE_FORBIDDEN = "403";

	public static final String MESSAGE_FORBIDDEN = "Forbidden";

	public static final String STATUS_CODE_UNAUTHORIZED = "401";

	public static final String MESSAGE_UNAUTHORIZED = "Unauthorized";

	public static final String STATUS_CODE_NOT_FOUND = "404";

	public static final String MESSAGE_NOT_FOUND = "Unauthorized";

	private ResponseConstant() {
		super();
	}
}
