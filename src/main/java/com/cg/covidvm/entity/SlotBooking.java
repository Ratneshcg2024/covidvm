package com.cg.covidvm.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SlotBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slotBookingId;
	private LocalDate bookingDate;
	private String selectedTimeSlot;

	private int empId;
	
	public int getSlotBookingId() {
		return slotBookingId;
	}

	public void setSlotBookingId(int slotBookingId) {
		this.slotBookingId = slotBookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSelectedTimeSlot() {
		return selectedTimeSlot;
	}

	public void setSelectedTimeSlot(String selectedTimeSlot) {
		this.selectedTimeSlot = selectedTimeSlot;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public VaccinationCentre getVaccinationCentre() {
		return vaccinationCentre;
	}

	public void setVaccinationCentre(VaccinationCentre vaccinationCentre) {
		this.vaccinationCentre = vaccinationCentre;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccinationCentre vaccinationCentre;

	
}

