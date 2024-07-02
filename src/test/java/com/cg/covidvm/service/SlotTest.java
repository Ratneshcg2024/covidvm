package com.cg.covidvm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.covidvm.entity.Slot;
import com.cg.covidvm.exception.SlotNotFoundException;
import com.cg.covidvm.repository.SlotRepository;

@SpringBootTest
public class SlotTest {

	@InjectMocks
	private SlotServiceImpl slotService = new SlotServiceImpl();

	@Mock
	private SlotRepository slotRepository;

	@Test
	public void testGetSlotByIdException() {

		when(slotRepository.findById(1)).thenThrow(SlotNotFoundException.class);

		assertThrows(SlotNotFoundException.class, () -> slotService.getSlotById(1));
	}

	@Test
	public void testGetSlotById() {
		Slot slot = new Slot();
		slot.setSlotId(1);
		slot.setSlotDate(LocalDate.of(2001, 03, 05));
		slot.setTimeSlot1("10-1");
		slot.setSlot1Availability(40);
		slot.setTimeSlot2("2-4");
		slot.setSlot2Availability(50);
		slot.setTimeSlot3("5-6");
		slot.setSlot3Availability(30);

		Optional<Slot> optionalSlot = Optional.of(slot);

		when(slotRepository.findById(1)).thenReturn(optionalSlot);

		Slot slotObj = slotService.getSlotById(1);
		// verify(slotRepository,times(1)).findById(1);
		// assertEquals(1,slot.getSlotId());
		assertEquals("10-1", slotObj.getTimeSlot1());

		assertEquals("2-4", slotObj.getTimeSlot2());

	}

}