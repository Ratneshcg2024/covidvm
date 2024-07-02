package com.cg.covidvm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.covidvm.entity.SlotBooking;
import com.cg.covidvm.exception.SlotBookingNotFoundException;
import com.cg.covidvm.model.SlotBookingDto;
import com.cg.covidvm.repository.SlotBookingRepository;

@Service
public class SlotBookingServiceImpl implements SlotBookingService {

	@Autowired
	private SlotBookingRepository slotBookingRepository;

	@Override
	public void deleteSlotBooking(int slotBookingId) throws SlotBookingNotFoundException {

		Optional<SlotBooking> optionalSlotBooking = slotBookingRepository.findById(slotBookingId);
		if (optionalSlotBooking.isEmpty()) {

			throw new SlotBookingNotFoundException("SlotBookingDetails Not Found with id: " + slotBookingId);
		}
		slotBookingRepository.deleteById(slotBookingId);
	}

	@Override
	public List<SlotBooking> getAllSlotBooking() {

		List<SlotBooking> slotBooking = slotBookingRepository.findAll();
		return slotBooking;
	}

	@Override
	public SlotBooking getSlotBookingById(int slotBookingId) throws SlotBookingNotFoundException {

		Optional<SlotBooking> optionalSlotBooking = slotBookingRepository.findById(slotBookingId);

		if (optionalSlotBooking.isEmpty()) {

			throw new SlotBookingNotFoundException("SlotBookingDetails Not Found with id: " + slotBookingId);
		}
		SlotBooking slotBooking = optionalSlotBooking.get();

		return slotBooking;
	}

	/*@Override
	public SlotBooking updateSlotBooking(SlotBooking slotBooking) throws SlotBookingNotFoundException {

		Optional<SlotBooking> optionalSlotBooking = slotBookingRepository.findById(slotBooking.getSlotBookingId());

		if (optionalSlotBooking.isEmpty()) {

			throw new SlotBookingNotFoundException("SlotBooking Not exists with id: " + slotBooking.getSlotBookingId());
		}
		SlotBooking updateSlotBooking = slotBookingRepository.save(slotBooking);

		return updateSlotBooking;
	}*/

	@Override
	public SlotBookingDto saveSlotBooking(SlotBookingDto slotBookingDto) {

		SlotBooking slot = new SlotBooking();
		slot.setBookingDate(slotBookingDto.getBookingDate());
		slot.setSelectedTimeSlot(slotBookingDto.getSelectedTimeSlot());

		SlotBooking newSlotBooking = slotBookingRepository.save(slot);
		SlotBookingDto newSlotBookingDto = new SlotBookingDto();

		newSlotBookingDto.setSlotBookingId(newSlotBooking.getSlotBookingId());
		newSlotBookingDto.setBookingDate(newSlotBooking.getBookingDate());
		newSlotBookingDto.setSelectedTimeSlot(newSlotBooking.getSelectedTimeSlot());

		return newSlotBookingDto;
	}

}
