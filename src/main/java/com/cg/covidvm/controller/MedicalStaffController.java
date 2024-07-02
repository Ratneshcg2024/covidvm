package com.cg.covidvm.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.covidvm.entity.MedicalStaff;
import com.cg.covidvm.model.MedicalStaffDto;
import com.cg.covidvm.service.MedicalStaffService;

@RestController
public class MedicalStaffController {
	@Autowired
	private MedicalStaffService medicalStaffService;

	@PostMapping("/staff/save")
	public ResponseEntity<MedicalStaffDto> addMedicalStaff(@Valid @RequestBody MedicalStaffDto medicalStaffDto) {
		MedicalStaffDto newMedicalStaff = medicalStaffService.saveMedicalStaff(medicalStaffDto);
		ResponseEntity<MedicalStaffDto> responseEntity = new ResponseEntity<>(newMedicalStaff, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/staff/all")
	public List<MedicalStaff> fetchAllMedicalStaff() {
		List<MedicalStaff> list = medicalStaffService.getAllMedicalStaff();
		return list;
	}

	@GetMapping("/staff/{id}")
	public ResponseEntity<MedicalStaff> fetchMedicalStaffDetails(@PathVariable("id") int staffId) {
		MedicalStaff medicalStaff = medicalStaffService.getMedicalStaffById(staffId);
		ResponseEntity<MedicalStaff> responseEntity = new ResponseEntity<>(medicalStaff, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/staff/{id}")
	public ResponseEntity<String> removeMedicalStaff(@PathVariable("id") int staffId) {

		medicalStaffService.deleteMedicalStaff(staffId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Staff deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	

}