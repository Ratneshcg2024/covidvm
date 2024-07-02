package com.cg.covidvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.exception.VaccinationCentreNotFoundException;
import com.cg.covidvm.model.VaccinationCentreDto;
import com.cg.covidvm.repository.VaccinationCentreRepository;

@Service
public class VaccinationCentreServiceImpl implements VaccinationCentreService {

	@Autowired
	private VaccinationCentreRepository vaccinationcentreRepository;

	@Override
	public List<VaccinationCentre> getAllVaccinationCentre() {
		List<VaccinationCentre> list = vaccinationcentreRepository.findAll();

		return list;
	}

	@Override
	public VaccinationCentre getVaccinationCentreById(int centreId) throws VaccinationCentreNotFoundException {
		Optional<VaccinationCentre> vaccinationcentre = vaccinationcentreRepository.findById(centreId);
		if (vaccinationcentre.isPresent()) {
			VaccinationCentre vaccinationcentre1 = vaccinationcentre.get();
			return vaccinationcentre1;
		}

		throw new VaccinationCentreNotFoundException("VaccinationCentre not existed with id: " + centreId);
	}

	

	@Override
	public VaccinationCentreDto saveVaccinationCentre(VaccinationCentreDto vaccinationcentreDto) {
		VaccinationCentre vc = new VaccinationCentre();
		// vc.setCentreId(vaccinationcentreDto.getCentreId());
		vc.setCentreAddress(vaccinationcentreDto.getCentreAddress());
		vc.setCentreCity(vaccinationcentreDto.getCentreCity());
		vc.setCentreName(vaccinationcentreDto.getCentreName());
		vc.setCentrePhoneno(vaccinationcentreDto.getCentrePhoneno());
		vc.setCentreState(vaccinationcentreDto.getCentreState());
		vc.setCentrePincode(vaccinationcentreDto.getCentrePincode());

		VaccinationCentre newVaccinationCentre = vaccinationcentreRepository.save(vc);
		VaccinationCentreDto newVaccinationCentreDto = new VaccinationCentreDto();
		newVaccinationCentreDto.setCentreId(newVaccinationCentre.getCentreId());
		newVaccinationCentreDto.setCentreAddress(newVaccinationCentre.getCentreAddress());
		newVaccinationCentreDto.setCentreName(newVaccinationCentre.getCentreName());
		newVaccinationCentreDto.setCentreCity(newVaccinationCentre.getCentreCity());
		newVaccinationCentreDto.setCentrePhoneno(newVaccinationCentre.getCentrePhoneno());
		newVaccinationCentreDto.setCentreState(newVaccinationCentre.getCentreState());
		newVaccinationCentreDto.setCentrePincode(newVaccinationCentre.getCentrePincode());
		return newVaccinationCentreDto;

	}

}