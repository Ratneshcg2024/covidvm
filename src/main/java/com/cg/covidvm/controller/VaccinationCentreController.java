package com.cg.covidvm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.model.VaccinationCentreDto;
import com.cg.covidvm.service.VaccinationCentreService;

@RestController
public class VaccinationCentreController {

	@Autowired
	private VaccinationCentreService vaccinationcentreService;

	@GetMapping("/vaccinationcentre/all")
	public List<VaccinationCentre> fetchAllVaccinationCentre() {
		List<VaccinationCentre> list = vaccinationcentreService.getAllVaccinationCentre();
		return list;
	}

	@GetMapping("/vaccinationcentre/id/{id}")
	public ResponseEntity<VaccinationCentre> fetchVaccinationCentreById(@PathVariable("id") int centreId) {
		ResponseEntity<VaccinationCentre> responseEntity = null;
		VaccinationCentre vaccinationcentre = vaccinationcentreService.getVaccinationCentreById(centreId);
		responseEntity = new ResponseEntity<>(vaccinationcentre, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/vaccinationcentre/save")
	public ResponseEntity<VaccinationCentreDto> addVaccinationCentre(
			@Valid @RequestBody VaccinationCentreDto vaccinationcentreDto) {
		VaccinationCentreDto newVaccinationCentre = vaccinationcentreService
				.saveVaccinationCentre(vaccinationcentreDto);
		ResponseEntity<VaccinationCentreDto> responseEntity = new ResponseEntity<>(newVaccinationCentre,
				HttpStatus.CREATED);
		return responseEntity;
	}

}