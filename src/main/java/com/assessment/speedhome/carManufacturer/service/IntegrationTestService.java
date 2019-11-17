package com.assessment.speedhome.carManufacturer.service;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;

import com.assessment.speedhome.carManufacturer.model.CarManufacturerModel;

public interface IntegrationTestService
{
	public ResponseEntity<String> testRequest(CarManufacturerModel carManufacturerModel) throws URISyntaxException;
	
}