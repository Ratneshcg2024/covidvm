package com.cg.covidvm.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class SlotDto {

	private int slotId;

	@NotNull(message = "slot Date is required")
	private LocalDate slotDate;

	@NotNull(message = "time slot is required")
	private String timeSlot1;

	private int slot1Availability;

	private String timeSlot2;

	private int slot2Availability;

	private String timeSlot3;

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public LocalDate getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}

	public String getTimeSlot1() {
		return timeSlot1;
	}

	public void setTimeSlot1(String timeSlot1) {
		this.timeSlot1 = timeSlot1;
	}

	public int getSlot1Availability() {
		return slot1Availability;
	}

	public void setSlot1Availability(int slot1Availability) {
		this.slot1Availability = slot1Availability;
	}

	public String getTimeSlot2() {
		return timeSlot2;
	}

	public void setTimeSlot2(String timeSlot2) {
		this.timeSlot2 = timeSlot2;
	}

	public int getSlot2Availability() {
		return slot2Availability;
	}

	public void setSlot2Availability(int slot2Availability) {
		this.slot2Availability = slot2Availability;
	}

	public String getTimeSlot3() {
		return timeSlot3;
	}

	public void setTimeSlot3(String timeSlot3) {
		this.timeSlot3 = timeSlot3;
	}

	public int getSlot3Availability() {
		return slot3Availability;
	}

	public void setSlot3Availability(int slot3Availability) {
		this.slot3Availability = slot3Availability;
	}

	private int slot3Availability;

}