package com.cg.covidvm.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class VaccinationCentre {

	@Id
	@Column(name = "centreId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int centreId;

	@Column(name = "centreName")
	private String centreName;

	@Column(name = "centreCity")
	private String centreCity;

	@Column(name = "centreState")
	private String centreState;

	@Column(name = "centrePincode")
	private String centrePincode;

	@Column(name = "centreAddress")
	private String centreAddress;

	@Column(name = "centrePhoneno")
	private String centrePhoneno;

	@OneToMany
	// @JoinColumn(name="vaccinationCentre_slot")
	private List<Slot> slots;

	@OneToMany(mappedBy = "vaccinationCentre")
	private List<SlotBooking> slotBooking;

	@OneToMany(mappedBy = "vaccinationCentre")
	private List<DoseDetails> doseDetails;

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

	public String getCentrePhoneno() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCentrePhoneno(String centrePhoneno2) {
		// TODO Auto-generated method stub

	}

	public void setCentreAddress(String centreAddress2) {
		// TODO Auto-generated method stub

	}

}