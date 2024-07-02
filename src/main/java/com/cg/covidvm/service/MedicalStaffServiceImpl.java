package com.cg.covidvm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.MedicalStaff;
import com.cg.covidvm.exception.MedicalStaffNotFoundException;
import com.cg.covidvm.model.MedicalStaffDto;
import com.cg.covidvm.repository.MedicalStaffRepository;

@Service
public class MedicalStaffServiceImpl implements MedicalStaffService {
	@Autowired
	private MedicalStaffRepository medicalStaffRepository;

	@Override
	public MedicalStaffDto saveMedicalStaff(MedicalStaffDto medicalStaffDto) {
		MedicalStaff ms = new MedicalStaff();
		ms.setStaffName(medicalStaffDto.getStaffName());
		ms.setEmailId(medicalStaffDto.getEmailId());
		ms.setPassword(medicalStaffDto.getPassword());
		ms.setMobileNo(medicalStaffDto.getMobileNo());
		ms.setLocation(medicalStaffDto.getLocation());

		MedicalStaff newMedicalStaff = medicalStaffRepository.save(ms);
		MedicalStaffDto newMedicalStaffDto = new MedicalStaffDto();
		newMedicalStaffDto.setStaffId(newMedicalStaff.getStaffId());
		newMedicalStaffDto.setStaffName(newMedicalStaff.getStaffName());
		newMedicalStaffDto.setEmailId(newMedicalStaff.getEmailId());
		newMedicalStaffDto.setPassword(newMedicalStaff.getPassword());
		newMedicalStaffDto.setMobileNo(newMedicalStaff.getMobileNo());
		newMedicalStaffDto.setLocation(newMedicalStaff.getLocation());
		return newMedicalStaffDto;
	}

	@Override
	public void deleteMedicalStaff(int staffId) throws MedicalStaffNotFoundException {
		Optional<MedicalStaff> optionalMedicalStaff = medicalStaffRepository.findById(staffId);
		if (optionalMedicalStaff.isEmpty()) {
			throw new MedicalStaffNotFoundException("Staff Not exists with id: " + staffId);
		}
		medicalStaffRepository.deleteById(staffId);

	}

	@Override
	public List<MedicalStaff> getAllMedicalStaff() {
		List<MedicalStaff> medicalStaff = medicalStaffRepository.findAll();
		return medicalStaff;
	}

	@Override
	public MedicalStaff getMedicalStaffById(int staffId) throws MedicalStaffNotFoundException {
		Optional<MedicalStaff> optionalMedicalStaff = medicalStaffRepository.findById(staffId);
		if (optionalMedicalStaff.isEmpty()) {
			throw new MedicalStaffNotFoundException("MedicalStaff Not Found with id: " + staffId);
		}
		MedicalStaff medicalStaff = optionalMedicalStaff.get();
		return medicalStaff;
	}

	

}