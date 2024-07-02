package com.cg.covidvm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.covidvm.entity.SlotBooking;
import com.cg.covidvm.model.SlotBookingDto;
import com.cg.covidvm.service.SlotBookingService;

@RestController
public class SlotBookingController {

	@Autowired
	private SlotBookingService slotBookingService;

	@PostMapping("/SlotBooking/saveById")

	public ResponseEntity<SlotBookingDto> addSlotBooking(@RequestBody SlotBookingDto slotBookingDto) {

		SlotBookingDto newslotBooking = slotBookingService.saveSlotBooking(slotBookingDto);

		ResponseEntity<SlotBookingDto> responseEntity = new ResponseEntity<>(newslotBooking, HttpStatus.CREATED);

		return responseEntity;

	}

	@GetMapping("/slotBooking/allBookedSlot")
	public List<SlotBooking> fetchAllSlotBooking() {
		List<SlotBooking> list = slotBookingService.getAllSlotBooking();
		return list;
	}

	@GetMapping("/slotBooking/{id}")
	public ResponseEntity<SlotBooking> fetchAllSlotBookingDetails(@PathVariable("id") int slotBookingId) {

		SlotBooking slotBooking = slotBookingService.getSlotBookingById(slotBookingId);
		ResponseEntity<SlotBooking> responseEntity = new ResponseEntity<>(slotBooking, HttpStatus.OK);

		return responseEntity;

	}

	@DeleteMapping("/slotBooking/{id}")
	public ResponseEntity<String> removeSlotBooking(@PathVariable("id") int slotBookingId) {

		slotBookingService.deleteSlotBooking(slotBookingId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Slot Booking deleted successfully",
				HttpStatus.OK);

		return responseEntity;
	}

	/*@PutMapping("/slotBooking/update")
	public ResponseEntity<SlotBooking> modifySlotBooking(@RequestBody SlotBooking slotBooking) {

		SlotBooking updateSlotBooking = slotBookingService.updateSlotBooking(slotBooking);

		ResponseEntity<SlotBooking> responseEntity = new ResponseEntity<>(updateSlotBooking, HttpStatus.OK);
		return responseEntity;
	}*/

}

