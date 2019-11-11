/**
 * 
 */
package com.usgs.earthquakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.usgs.earthquakes.configuration.ApplicationConfig;
import com.usgs.earthquakes.exception.UsgsEarthQuakesException;
import com.usgs.earthquakes.model.Event;
import com.usgs.earthquakes.service.EarthQuakeService;

/**
 * Service implementation to EarthQuakeService interface
 * 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class EarthQuakesServiceImpl
 * @date nov 12, 2019
 */
@Service
public class EarthQuakesServiceImpl implements EarthQuakeService {

	private static final String INIT_PARAMS = "?";

	private static final String EQUAL_SYMBOL = "=";

	private static final String AND_SYMBOL = "&";

	@Autowired
	private ApplicationConfig appConfig;

	@Autowired
	private RestTemplate ugsRestTemplate;

	/**
	 * @see com.usgs.earthquakes.service.EarthQuakeService#getEarthQuakeBetweenDates(String,
	 *      String)
	 */
	@Override
	public Event getEarthQuakeBetweenDates(String startTime, String endTime) throws UsgsEarthQuakesException {
		try {
			return ugsRestTemplate.getForObject(appConfig.getUsgsProperties().getSchema()
					.concat(appConfig.getUsgsProperties().getHost().concat(appConfig.getUsgsProperties().getPath()
							.concat(appConfig.getUsgsEndPoint().getEarthQuakesBetweenDate()).concat(INIT_PARAMS)
							.concat(appConfig.getUsgsEndPoint().getFormatParam()).concat(EQUAL_SYMBOL)
							.concat(appConfig.getUsgsEndPoint().getFormatValue()).concat(AND_SYMBOL)
							.concat(appConfig.getUsgsEndPoint().getStartTimeParam()).concat(EQUAL_SYMBOL)
							.concat(startTime).concat(AND_SYMBOL).concat(appConfig.getUsgsEndPoint().getEndTimeParam())
							.concat(EQUAL_SYMBOL).concat(endTime))),
					Event.class);
		} catch (RestClientException exception) {
			throw new UsgsEarthQuakesException(exception.getMessage());
		}
	}

	/**
	 * @see com.usgs.earthquakes.service.EarthQuakeService#getEarthQuakeBetweenMagnitudes(String,
	 *      String)
	 */
	@Override
	public Event getEarthQuakeBetweenMagnitudes(String minMagnitude, String maxMagnitude)
			throws UsgsEarthQuakesException {
		try {
			return ugsRestTemplate
					.getForObject(appConfig.getUsgsProperties().getSchema()
							.concat(appConfig.getUsgsProperties().getHost().concat(appConfig.getUsgsProperties()
									.getPath().concat(appConfig.getUsgsEndPoint().getEarthQuakesBetweenDate())
									.concat(INIT_PARAMS).concat(appConfig.getUsgsEndPoint().getFormatParam())
									.concat(EQUAL_SYMBOL).concat(appConfig.getUsgsEndPoint().getFormatValue())
									.concat(AND_SYMBOL).concat(appConfig.getUsgsEndPoint().getMinMagnitudeParam())
									.concat(EQUAL_SYMBOL).concat(minMagnitude).concat(AND_SYMBOL)
									.concat(appConfig.getUsgsEndPoint().getMaxMagnitudeParam()).concat(EQUAL_SYMBOL)
									.concat(maxMagnitude))),
							Event.class);
		} catch (RestClientException exception) {
			throw new UsgsEarthQuakesException(exception.getMessage());
		}
	}

	/**
	 * @see com.usgs.earthquakes.service.EarthQuakeService#getEarthQuakes()
	 */
	@Override
	public Event getEarthQuakes() throws UsgsEarthQuakesException {
		try {
			return ugsRestTemplate.getForObject(
					appConfig.getUsgsProperties().getSchema()
							.concat(appConfig.getUsgsProperties().getHost().concat(appConfig.getUsgsProperties()
									.getPath().concat(appConfig.getUsgsEndPoint().getEarthQuakesBetweenDate())
									.concat(INIT_PARAMS).concat(appConfig.getUsgsEndPoint().getFormatParam())
									.concat(EQUAL_SYMBOL).concat(appConfig.getUsgsEndPoint().getFormatValue()))),
					Event.class);
		} catch (RestClientException exception) {
			throw new UsgsEarthQuakesException(exception.getMessage());
		}
	}

}
