package com.assessment.speedhome.carManufacturer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.speedhome.carManufacturer.model.CarManufacturerModel;
import com.assessment.speedhome.carManufacturer.service.IntegrationTestService;

@RestController
@RequestMapping("carmanufacturer")
public class CarManufacturerController
{
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	IntegrationTestService integrationTestService;
	
	@GetMapping(value= {"/hello"})
	public ResponseEntity<String> requestBillingHistory(@RequestBody(required = false) CarManufacturerModel carManufacturerModel) throws Exception
	{
		logger.info(carManufacturerModel);

		ResponseEntity<String> response = integrationTestService.testRequest(carManufacturerModel);

		if(HttpStatus.OK.equals(response.getStatusCode()) & response.getBody() != null) 
		{
			return ResponseEntity.ok("The Entity received from REST call : "+response.getBody());
		
		} else
		{
			return ResponseEntity.ok("Unable to get response");
		}
	}
	
}