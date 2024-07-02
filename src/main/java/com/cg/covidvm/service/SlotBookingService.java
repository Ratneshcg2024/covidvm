package com.cg.covidvm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.SlotBooking;
import com.cg.covidvm.model.SlotBookingDto;

@Service
public interface SlotBookingService {

	public SlotBookingDto saveSlotBooking(SlotBookingDto slotBookingDto);

	public void deleteSlotBooking(int slotBookingId);

	public List<SlotBooking> getAllSlotBooking();

	public SlotBooking getSlotBookingById(int slotBookingId);

	//public SlotBooking updateSlotBooking(SlotBooking slotbooking);

}
