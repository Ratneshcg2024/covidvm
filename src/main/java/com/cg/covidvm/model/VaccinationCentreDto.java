package com.cg.covidvm.model;

import javax.validation.constraints.NotNull;

public class VaccinationCentreDto {

	private int centreId;

	@NotNull(message = "centre name is required")
	private String centreName;

	@NotNull(message = "centre city is required")
	private String centreCity;

	@NotNull(message = "centre state is required")
	private String centreState;

	private String centrePincode;

	@NotNull(message = "centre address is required")
	private String centreAddress;

	private String centrePhoneno;

	public int getCentreId() {
		return centreId;
	}

	public void setCentreId(int centreId) {
		this.centreId = centreId;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public String getCentreCity() {
		return centreCity;
	}

	public void setCentreCity(String centreCity) {
		this.centreCity = centreCity;
	}

	public String getCentreState() {
		return centreState;
	}

	public void setCentreState(String centreState) {
		this.centreState = centreState;
	}

	public String getCentrePincode() {
		return centrePincode;
	}

	public void setCentrePincode(String centrePincode) {
		this.centrePincode = centrePincode;
	}

	public String getCentreAddress() {
		return centreAddress;
	}

	public void setCentreAddress(String centreAddress) {
		this.centreAddress = centreAddress;
	}

	public String getCentrePhoneno() {
		return centrePhoneno;
	}

	public void setCentrePhoneno(String centrePhoneno) {
		this.centrePhoneno = centrePhoneno;
	}

}