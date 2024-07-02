package com.cg.covidvm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.model.VaccinationCentreDto;

@Service
public interface VaccinationCentreService {
	public VaccinationCentre getVaccinationCentreById(int centreId);

	public List<VaccinationCentre> getAllVaccinationCentre();

	public VaccinationCentreDto saveVaccinationCentre(VaccinationCentreDto vaccinationcentreDto);

	
}