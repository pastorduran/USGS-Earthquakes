/**
 * 
 */
package com.usgs.earthquakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usgs.earthquakes.configuration.ApplicationConfig;
import com.usgs.earthquakes.constant.ResponseConstant;
import com.usgs.earthquakes.model.Event;
import com.usgs.earthquakes.response.Response;
import com.usgs.earthquakes.service.EarthQuakeService;
import com.usgs.earthquakes.util.EarthQuakeClient;

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
	 * @see com.usgs.earthquakes.service.EarthQuakeService#getEarthQuakeBetweenDates(String, String)
	 */
	@Override
	public String getEarthQuakeBetweenDates(String startTime, String endTime) {
		Event event = ugsRestTemplate.getForObject(appConfig.getUsgsProperties().getSchema()
				.concat(appConfig.getUsgsProperties().getHost().concat(appConfig.getUsgsProperties().getPath()
						.concat(appConfig.getUsgsEndPoint().getEarthQuakesBetweenDate()).concat(INIT_PARAMS)
						.concat(appConfig.getUsgsEndPoint().getFormatParam()).concat(EQUAL_SYMBOL)
						.concat(appConfig.getUsgsEndPoint().getFormatValue()).concat(AND_SYMBOL)
						.concat(appConfig.getUsgsEndPoint().getStartTimeParam()).concat(EQUAL_SYMBOL).concat(startTime)
						.concat(AND_SYMBOL).concat(appConfig.getUsgsEndPoint().getEndTimeParam()).concat(EQUAL_SYMBOL)
						.concat(endTime))),
				Event.class);
		return EarthQuakeClient
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event));
	}

	/**
	 * @see com.usgs.earthquakes.service.EarthQuakeService#getEarthQuakeBetweenMagnitudes(String, String)
	 */
	@Override
	public String getEarthQuakeBetweenMagnitudes(String minMagnitude, String maxMagnitude) {
		Event event = ugsRestTemplate.getForObject(appConfig.getUsgsProperties().getSchema()
				.concat(appConfig.getUsgsProperties().getHost()
						.concat(appConfig.getUsgsProperties().getPath()
								.concat(appConfig.getUsgsEndPoint().getEarthQuakesBetweenDate()).concat(INIT_PARAMS)
								.concat(appConfig.getUsgsEndPoint().getFormatParam()).concat(EQUAL_SYMBOL)
								.concat(appConfig.getUsgsEndPoint().getFormatValue()).concat(AND_SYMBOL)
								.concat(appConfig.getUsgsEndPoint().getMinMagnitudeParam()).concat(EQUAL_SYMBOL)
								.concat(minMagnitude).concat(AND_SYMBOL)
								.concat(appConfig.getUsgsEndPoint().getMaxMagnitudeParam()).concat(EQUAL_SYMBOL)
								.concat(maxMagnitude))),
				Event.class);
		return EarthQuakeClient
				.getJson(new Response(ResponseConstant.STATUS_CODE_OK, ResponseConstant.MESSAGE_OK, event));
	}

}
