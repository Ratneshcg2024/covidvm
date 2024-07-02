package com.cg.covidvm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.repository.VaccinationCentreRepository;

@SpringBootTest
public class VaccinationCentreServiceTest {

	@InjectMocks
	private VaccinationCentreServiceImpl vaccinationcentreService = new VaccinationCentreServiceImpl();

	@Mock
	private VaccinationCentreRepository vaccinationcentreRepository;

	@Test
	public void testgetVaccinationCentreById() {

		VaccinationCentre vaccinationcentre = new VaccinationCentre();
		vaccinationcentre.setCentreId(1);
		vaccinationcentre.setCentreAddress("xyz");
		vaccinationcentre.setCentreName("aaa");
		vaccinationcentre.setCentreCity("chennai");
		vaccinationcentre.setCentreState("tamilnadu");
		vaccinationcentre.setCentrePincode("654789");
		vaccinationcentre.setCentrePhoneno("7689789564");

		Optional<VaccinationCentre> optionalVaccinationCentre = Optional.of(vaccinationcentre);

		when(vaccinationcentreRepository.findById(1)).thenReturn(optionalVaccinationCentre);

		VaccinationCentre vaccinationcentreObj = vaccinationcentreService.getVaccinationCentreById(1);

		assertEquals("aaa", vaccinationcentreObj.getCentreName());

		assertEquals("chennai", vaccinationcentreObj.getCentreCity());

		assertEquals("xyz", vaccinationcentreObj.getCentreAddress());
		assertEquals("tamilnadu", vaccinationcentreObj.getCentreState());
		assertEquals("654789", vaccinationcentreObj.getCentrePincode());
		assertEquals("7689789564", vaccinationcentreObj.getCentrePhoneno());

	}

	@Test
	public void testgetAllVaccinationCentre() {

		List<VaccinationCentre> vaccinationcentre = new ArrayList<>();

		VaccinationCentre vc = new VaccinationCentre();

		vc.setCentreId(1);
		vc.setCentreAddress("xyz");
		vc.setCentreName("aaa");
		vc.setCentreCity("chennai");
		vc.setCentreState("tamilnadu");
		vc.setCentrePhoneno("7689789564");
		vc.setCentrePincode("654789");

		vaccinationcentre.add(vc);

		when(vaccinationcentreRepository.findAll()).thenReturn(vaccinationcentre);

		List<VaccinationCentre> vaccinationcentreList = vaccinationcentreService.getAllVaccinationCentre();

		assertEquals(1, vaccinationcentreList.size());

	}

}