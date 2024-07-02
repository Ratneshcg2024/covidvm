package com.cg.covidvm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.MedicalStaff;
import com.cg.covidvm.model.MedicalStaffDto;

@Service
public interface MedicalStaffService {
	public MedicalStaffDto saveMedicalStaff(MedicalStaffDto medicalstaffDto);

	public void deleteMedicalStaff(int staffId);

	public List<MedicalStaff> getAllMedicalStaff();

	public MedicalStaff getMedicalStaffById(int medicalStaffId);

	
}