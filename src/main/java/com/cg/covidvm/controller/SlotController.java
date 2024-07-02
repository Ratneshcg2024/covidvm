package com.cg.covidvm.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cg.covidvm.entity.Slot;
import com.cg.covidvm.model.SlotDto;
import com.cg.covidvm.service.SlotService;

@RestController
public class SlotController {

	@Autowired
	private SlotService slotService;

	@PostMapping("/addSlot/save")
	public ResponseEntity<SlotDto> addSlot(@Valid @RequestBody SlotDto slotDto) {
		SlotDto newSlot = slotService.saveSlot(slotDto);
		ResponseEntity<SlotDto> responseEntity = new ResponseEntity<>(newSlot, HttpStatus.CREATED);
		return responseEntity;

	}

	@DeleteMapping("/slot/{id}")
	public ResponseEntity<String> removeSlot(@PathVariable("id") int slotId) {

		slotService.deleteSlot(slotId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Slot deleted Sucessfully", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/slotDetails/all")
	public List<Slot> fetchAllSlot() {
		List<Slot> list = slotService.getSlotDetails();
		return list;
	}

	@GetMapping("/slot/{id}")
	public ResponseEntity<Slot> fetchSlotDetails(@PathVariable("id") int slotId) {
		Slot slot = slotService.getSlotById(slotId);
		ResponseEntity<Slot> responseEntity = new ResponseEntity<>(slot, HttpStatus.OK);

		return responseEntity;
	}

}