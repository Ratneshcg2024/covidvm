package com.cg.covidvm.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class CertificationDto {

	private int certificateId;

	private EmployeeDto employeeDto;

	@NotNull(message = "dose no is required")
	private int doseNo;

	@NotNull(message = "vaccineName is required")
	private String vaccineName;

	private LocalDate dateOfDose;

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public int getDoseNo() {
		return doseNo;
	}

	public void setDoseNo(int doseNo) {
		this.doseNo = doseNo;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public LocalDate getDateOfDose() {
		return dateOfDose;
	}

	public void setDateOfDose(LocalDate dateOfDose) {
		this.dateOfDose = dateOfDose;
	}

}