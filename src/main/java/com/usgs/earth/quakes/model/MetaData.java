package com.usgs.earth.quakes.model;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* MetaData model
*
* @author Pastor Durán
* @project USGS-Earthquakes
* @class MetaData
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class MetaData {

	private String generated;
	
	
	private String url;
	
	private String title;
	
	private BigInteger status;
	
	private String api;
	
	private BigInteger count;

}