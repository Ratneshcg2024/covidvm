package com.cg.covidvm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.covidvm.entity.VitalsAtVaccination;
import com.cg.covidvm.service.VitalsAtVaccinationService;

@RestController
public class VitalsAtVaccinationController {

	@Autowired
	private VitalsAtVaccinationService vitalsAtVaccinationService;

	@GetMapping("/vitalDetails/all")
	public List<VitalsAtVaccination> fetchAllVitalsAtVaccination() {
		List<VitalsAtVaccination> list = vitalsAtVaccinationService.getVitalDetails();
		return list;
	}

}