package com.cg.covidvm.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.covidvm.entity.DoseDetails;
import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.model.DoseReq;
import com.cg.covidvm.service.DoseDetailsService;
import com.cg.covidvm.service.EmployeeService;
import com.cg.covidvm.service.VaccinationCentreService;
import com.cg.covidvm.service.VitalsAtVaccinationService;

@RestController
public class DoseDetailsController {

	@Autowired
	private DoseDetailsService dosedetailsService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VitalsAtVaccinationService vitalsAtVaccinationService;

	@Autowired
	private VaccinationCentreService vaccinationCentreService;

	@PostMapping("/dosedetails/save")
	public ResponseEntity<DoseDetails> addDoseDetails(@Valid @RequestBody DoseReq doseReq) {
		Employee employee = employeeService.getEmployeeById(doseReq.getEmpId());
		// VitalsAtVaccination vitalsAtVaccination=vitalsAtVaccinationService.
		VaccinationCentre vaccinationCentre = vaccinationCentreService.getVaccinationCentreById(doseReq.getCentreId());
		DoseDetails dosedetails = new DoseDetails();
		dosedetails.setDateOfDose(doseReq.getDateOfDose());
		dosedetails.setDoseNo(doseReq.getDoseNo());
		dosedetails.setVaccineName(doseReq.getVaccineName());
		dosedetails.setEmployee(employee);
		dosedetails.setVaccinationCentre(vaccinationCentre);
		dosedetails.setVitalsAtVaccination(null);
		DoseDetails newdosedetails = dosedetailsService.saveDoseDetails(dosedetails);
		ResponseEntity<DoseDetails> responseEntity = new ResponseEntity<>(newdosedetails, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/dosedetails/all")
	public List<DoseDetails> fetchAllDoseDetails() {
		List<DoseDetails> list = dosedetailsService.getAllDoseDetails();
		return list;
	}

	public VitalsAtVaccinationService getVitalsAtVaccinationService() {
		return vitalsAtVaccinationService;
	}

	public void setVitalsAtVaccinationService(VitalsAtVaccinationService vitalsAtVaccinationService) {
		this.vitalsAtVaccinationService = vitalsAtVaccinationService;
	}

}