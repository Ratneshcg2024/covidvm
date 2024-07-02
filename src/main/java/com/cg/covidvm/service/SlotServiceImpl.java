package com.cg.covidvm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.covidvm.exception.SlotNotFoundException;
import com.cg.covidvm.model.SlotDto;
import com.cg.covidvm.entity.Slot;
import com.cg.covidvm.repository.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	private SlotRepository slotRepository;

	@Override
	public SlotDto saveSlot(SlotDto slotDto) {
		Slot st = new Slot();

		st.setSlotDate(slotDto.getSlotDate());
		st.setTimeSlot1(slotDto.getTimeSlot1());
		st.setSlot1Availability(slotDto.getSlot1Availability());
		st.setTimeSlot2(slotDto.getTimeSlot2());
		st.setSlot2Availability(slotDto.getSlot2Availability());
		st.setTimeSlot3(slotDto.getTimeSlot3());
		st.setSlot3Availability(slotDto.getSlot3Availability());

		Slot newSlot = slotRepository.save(st);
		SlotDto newSlotDto = new SlotDto();
		newSlotDto.setSlotId(newSlot.getSlotId());
		newSlotDto.setSlotDate(newSlot.getSlotDate());
		newSlotDto.setTimeSlot1(newSlot.getTimeSlot1());
		newSlotDto.setSlot1Availability(newSlot.getSlot1Availability());
		newSlotDto.setTimeSlot2(newSlot.getTimeSlot2());
		newSlotDto.setSlot2Availability(newSlot.getSlot2Availability());
		newSlotDto.setTimeSlot3(newSlot.getTimeSlot3());
		newSlotDto.setSlot3Availability(newSlot.getSlot3Availability());

		return newSlotDto;
	}

	@Override
	public Slot getSlotById(int slotId) throws SlotNotFoundException {
		Optional<Slot> optionalSlot = slotRepository.findById(slotId);
		if (optionalSlot.isEmpty()) {
			throw new SlotNotFoundException("Slot Not Found with id: " + slotId);

		}
		Slot slot = optionalSlot.get();
		return slot;
	}

	@Override
	public void deleteSlot(int slotId) throws SlotNotFoundException {
		Optional<Slot> optionalSlot = slotRepository.findById(slotId);
		if (optionalSlot.isEmpty()) {
			throw new SlotNotFoundException("Slot Not exists with id: " + slotId);
		}
		slotRepository.deleteById(slotId);
	}

	

	@Override
	public List<Slot> getSlotDetails() {
		List<Slot> slot = slotRepository.findAll();
		return slot;
	}

}