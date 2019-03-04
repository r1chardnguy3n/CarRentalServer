package com.Server;

public class VehicleData {
	
	private String make;
	private String model;
	private String year;
	private String type;
	
	
	//Constructor
	public VehicleData(String make, String model, String year, String type) {
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
		this.setType(type);
	}

	
	//Getters
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getType() {
		return type;
	}

	//Setters
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public void setType(String type) {
		this.type = type;
	}

}
