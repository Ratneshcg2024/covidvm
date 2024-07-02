package com.cg.covidvm.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.covidvm.entity.SlotBooking;
import com.cg.covidvm.exception.SlotBookingNotFoundException;
import com.cg.covidvm.repository.SlotBookingRepository;

@SpringBootTest
public class SlotBookingServiceTest {

	@InjectMocks
	private SlotBookingServiceImpl slotBookingService = new SlotBookingServiceImpl();

	@Mock
	private SlotBookingRepository slotBookingRepository;

	@Test
	public void testGetSlotBookingException() {
		when(slotBookingRepository.findAll().isEmpty()).thenThrow(SlotBookingNotFoundException.class);

		assertThrows(SlotBookingNotFoundException.class, () -> slotBookingService.getAllSlotBooking());
	}

	@Test
	public void testGetAllSlotBookingById() {

		List<SlotBooking> SlotBooking = new ArrayList<SlotBooking>();

		SlotBooking slotBooking1 = new SlotBooking();
		slotBooking1.setSlotBookingId(1);
		slotBooking1.setBookingDate(LocalDate.of(2022, 12, 30));
		slotBooking1.setSelectedTimeSlot("12-1");

		SlotBooking slotBooking2 = new SlotBooking();
		slotBooking2.setSlotBookingId(2);
		slotBooking2.setBookingDate(LocalDate.of(2022, 12, 31));
		slotBooking2.setSelectedTimeSlot("12-1");

		SlotBooking slotBooking3 = new SlotBooking();
		slotBooking3.setSlotBookingId(3);
		slotBooking3.setBookingDate(LocalDate.of(2022, 12, 31));
		slotBooking3.setSelectedTimeSlot("2-3");

		SlotBooking.add(slotBooking3);
		SlotBooking.add(slotBooking2);
		SlotBooking.add(slotBooking1);

		when(slotBookingRepository.findAll()).thenReturn(SlotBooking);

		List<SlotBooking> slotBookingList = slotBookingService.getAllSlotBooking();

		assertEquals(3, slotBookingList.size());

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
