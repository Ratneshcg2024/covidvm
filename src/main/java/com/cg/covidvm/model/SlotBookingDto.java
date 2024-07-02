package com.cg.covidvm.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class SlotBookingDto {

	private int slotBookingId;

	@NotNull(message = "bookingDate is required")
	private LocalDate bookingDate;

	@NotNull(message = "selectedTimeSlot is required")
	private String selectedTimeSlot;

	private int empId;

	private int vaccinationCentreId;

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

	public int getVaccinationCentreId() {
		return vaccinationCentreId;
	}

	public void setVaccinationCentreId(int vaccinationCentreId) {
		this.vaccinationCentreId = vaccinationCentreId;
	}

	
}

	