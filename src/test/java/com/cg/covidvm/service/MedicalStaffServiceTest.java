package com.cg.covidvm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.covidvm.entity.MedicalStaff;

import com.cg.covidvm.exception.MedicalStaffNotFoundException;
import com.cg.covidvm.repository.MedicalStaffRepository;

@SpringBootTest
public class MedicalStaffServiceTest {

	@InjectMocks
	private MedicalStaffServiceImpl medicalStaffService = new MedicalStaffServiceImpl();

	@Mock
	private MedicalStaffRepository medicalStaffRepository;

	@Test
	public void testMedicalStaffById() {
		MedicalStaff medicalStaff = new MedicalStaff();
		medicalStaff.setStaffId(1);
		;
		medicalStaff.setStaffName("Misba");
		;
		medicalStaff.setPassword("Misba123");
		;
		medicalStaff.setEmailId("misba@gmail.com");
		medicalStaff.setLocation("Pune");
		medicalStaff.setMobileNo("9088766567");

		Optional<MedicalStaff> optionalMedicalStaff = Optional.of(medicalStaff);
		when(medicalStaffRepository.findById(1)).thenReturn(optionalMedicalStaff);

		MedicalStaff medicalStaffObj = medicalStaffService.getMedicalStaffById(1);

		assertEquals("Misba", medicalStaffObj.getStaffName());

		assertEquals("9096202107", medicalStaffObj.getMobileNo());

	}

	@Test
	public void testGetMedicalStaffByIdException() {

		when(medicalStaffRepository.findById(1)).thenThrow(MedicalStaffNotFoundException.class);

		assertThrows(MedicalStaffNotFoundException.class, () -> medicalStaffService.getMedicalStaffById(1));
	}

	@Test
	void testGetAllMedicalStaff() {

		List<MedicalStaff> medicalStaff = new ArrayList<>();

		MedicalStaff medicalStaff1 = new MedicalStaff();
		medicalStaff1.setStaffId(1);
		;
		medicalStaff1.setStaffName("Misba");
		;
		medicalStaff1.setPassword("Misba123");
		medicalStaff1.setEmailId("misba@gmail.com");
		medicalStaff1.setLocation("Pune");
		medicalStaff1.setMobileNo("9088766567");

		MedicalStaff medicalStaff2 = new MedicalStaff();
		medicalStaff2.setStaffId(2);
		medicalStaff2.setStaffName("Priyanka");
		medicalStaff2.setPassword("Priyanka123");
		medicalStaff2.setEmailId("priyanka@gmail.com");
		medicalStaff2.setLocation("Mumbai");
		medicalStaff2.setMobileNo("7788766567");

		MedicalStaff medicalStaff3 = new MedicalStaff();
		medicalStaff3.setStaffId(3);
		medicalStaff3.setStaffName("Shivani");
		medicalStaff3.setPassword("Shivani123");
		medicalStaff3.setEmailId("shivani@gmail.com");
		medicalStaff3.setLocation("Banglore");
		medicalStaff3.setMobileNo("7788766505");

		medicalStaff.add(medicalStaff3);
		medicalStaff.add(medicalStaff2);
		medicalStaff.add(medicalStaff1);

		when(medicalStaffRepository.findAll()).thenReturn(medicalStaff);

		List<MedicalStaff> medicalStaffList = medicalStaffService.getAllMedicalStaff();

		assertEquals(3, medicalStaffList.size());
	}
}