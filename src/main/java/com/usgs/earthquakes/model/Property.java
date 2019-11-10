package com.usgs.earthquakes.model;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* Property model
*
* @author pastorduran
* @project USGS-Earthquakes
* @class Property
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class Property implements Serializable {
	
	private static final long serialVersionUID = 1911498671130501487L;

	private Double mag;
	
	private String place;
	
	private BigInteger time;
	
	private BigInteger updated;
	
	private Integer tz;
	
	private String url;
	
	private String detail;
	
	private String felt;
	
	private String cdi;
	
	private String mmi;
	
	private String alert;
	
	private String status;
	
	private Integer tsunami;

	private Integer sig;
	
	private String net;
	
	private String code;
	
	// TODO check type of this attr ,nc73291300,n456456456
	private String ids;
	
	private String sources;
	
	private String types;
	
	private Integer nst;
	
	private Double dmin;
	
	private Double rms;
	
	private BigInteger gap;
	
	private String magType;
	
	private String type;
	
	private String tittle;

}
