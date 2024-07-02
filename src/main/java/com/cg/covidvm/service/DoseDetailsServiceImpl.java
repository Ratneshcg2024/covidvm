package com.cg.covidvm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.Certification;
import com.cg.covidvm.entity.DoseDetails;

import com.cg.covidvm.repository.CertificationRepository;
import com.cg.covidvm.repository.DoseDetailsRepository;

@Service
public class DoseDetailsServiceImpl implements DoseDetailsService {

	@Autowired
	private DoseDetailsRepository dosedetailsRepository;

	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public DoseDetails saveDoseDetails(DoseDetails dosedetails) {

		/*
		 * dd.setDateOfDose(LocalDate.now());
		 * dd.setTime(LocalDateTime.now().toString());
		 * dd.setVaccineName(dosedetailsDto.getVaccineName());
		 * dd.setDoseNo(dosedetailsDto.getDoseNo());
		 * dd.setEmployee(dosedetailsDto.getEmployee());
		 * dd.setVaccinationCentre(dosedetailsDto.getVaccinationCentre());
		 * dd.setVitalsAtVaccination(dosedetailsDto.getVitalsAtVaccination());
		 * dd.setStaffId(dosedetailsDto.getStaffId());
		 */
		DoseDetails newDoseDetails = dosedetailsRepository.save(dosedetails);

		Certification newCer = new Certification();
		newCer.setDateOfDose(newDoseDetails.getDateOfDose());
		newCer.setDoseNo(newDoseDetails.getDoseNo());
		newCer.setVaccineName(newDoseDetails.getVaccineName());
		newCer.setEmployee(newDoseDetails.getEmployee());
		certificationRepository.save(newCer);

		/*
		 * DoseDetailsDto newDoseDetails= new DoseDetailsDto();
		 * newDoseDetails.setDoseId(newDoseDetails.getDoseId());
		 * newDoseDetails.setDateOfDose(newDoseDetails.getDateOfDose());
		 */
		return newDoseDetails;
	}

	@Override
	public List<DoseDetails> getAllDoseDetails() {
		List<DoseDetails> list = dosedetailsRepository.findAll();
		return list;
	}

	

}