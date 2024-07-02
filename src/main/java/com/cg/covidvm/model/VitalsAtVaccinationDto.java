package com.cg.covidvm.model;

import javax.validation.constraints.NotNull;

public class VitalsAtVaccinationDto {

	private int vitalId;

	@NotNull(message = "Temperature is required")
	private float temperature;

	@NotNull(message = "Saturation is required")
	private float saturation;

	@NotNull(message = "BloodPressure is required")
	private float bloodPressure;

	@NotNull(message = "VitalTime is required")
	private String vitalTime;

	public int getVitalId() {
		return vitalId;
	}

	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getSaturation() {
		return saturation;
	}

	public void setSaturation(float saturation) {
		this.saturation = saturation;
	}

	public float getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getVitalTime() {
		return vitalTime;
	}

	public void setVitalTime(String vitalTime) {
		this.vitalTime = vitalTime;
	}

}