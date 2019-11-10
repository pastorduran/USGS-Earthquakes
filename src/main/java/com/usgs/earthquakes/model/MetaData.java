package com.usgs.earthquakes.model;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* MetaData model
*
* @author pastorduran
* @project USGS-Earthquakes
* @class MetaData
* @date nov 11, 2019
* 
*/
@Getter
@Setter
@ToString
public class MetaData implements Serializable  {

	private static final long serialVersionUID = -6851399707071334615L;

	private BigInteger generated;	
	
	private String url;
	
	private String title;
	
	private Integer status;
	
	private String api;
	
	private Integer count;

}