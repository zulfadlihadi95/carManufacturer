package com.assessment.speedhome.carManufacturer.model;

public class CarManufacturerModel
{
	private String car;
	private String manufacturer;

	public String getCar()
	{
		return car;
	}

	public void setCar(String car)
	{
		this.car = car;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString()
	{
		return "CarManufacturerModel [car=" + car + ", manufacturer=" + manufacturer +"]";
	}

}
