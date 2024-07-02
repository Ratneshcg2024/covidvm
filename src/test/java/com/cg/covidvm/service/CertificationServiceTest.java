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


import com.cg.covidvm.entity.Certification;
import com.cg.covidvm.exception.CertificationNotFoundException;

import com.cg.covidvm.repository.CertificationRepository;

@SpringBootTest
public class CertificationServiceTest {

	@InjectMocks
	private CertificationServiceImpl certificationService = new CertificationServiceImpl();

	@Mock
	private CertificationRepository certificationRepository;


	@Test
	public void testGetCertificationException() {
		when(certificationRepository.findAll().isEmpty()).thenThrow(CertificationNotFoundException.class);

		assertThrows(CertificationNotFoundException.class, () -> certificationService.getAllCertifications());
	}

	@Test
	public void testGetAllCertifications() {

		List<Certification> Certifications = new ArrayList<Certification>();

		Certification certification1 = new Certification();
		certification1.setCertificateId(1);
		certification1.setDoseNo("2");
		certification1.setVaccineName("Covaccine");
		certification1.setDateOfDose(LocalDate.of(2022, 12, 23));
		

		Certification certification2 = new Certification();
		certification2.setCertificateId(1);
		certification2.setDoseNo("1");
		certification2.setVaccineName("Covishield");
		certification2.setDateOfDose(LocalDate.of(2022, 12, 25));

		Certifications.add(certification1);
		Certifications.add(certification2);

		when(certificationRepository.findAll()).thenReturn(Certifications);

		List<Certification> certificationList = certificationService.getAllCertifications();

		assertEquals(2,certificationList.size());

	}

}
