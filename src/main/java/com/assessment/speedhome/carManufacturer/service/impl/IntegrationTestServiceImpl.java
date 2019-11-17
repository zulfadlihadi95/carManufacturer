package com.assessment.speedhome.carManufacturer.service.impl;

import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.assessment.speedhome.carManufacturer.model.CarManufacturerModel;
import com.assessment.speedhome.carManufacturer.service.IntegrationTestService;

@Component
@PropertySource("classpath:application.properties")
public class IntegrationTestServiceImpl implements IntegrationTestService
{
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Value("${application.url}")
	private String applicationUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<String> testRequest(CarManufacturerModel carManufacturerModel) throws URISyntaxException
	{
		ResponseEntity<String> response = null;
		
		try
		{
			response = restTemplate.getForEntity(applicationUrl, String.class);
			logger.info(response.getStatusCodeValue());
			
		} catch (Exception e)
		{
			logger.error("unable to get entity with reason {}",e.getMessage());
			throw e;
		}
		
		return response;
	}
}
