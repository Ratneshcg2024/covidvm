package com.cg.covidvm.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Certification {

	@Id
	@Column(name = "certificateId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int certificateId;

	private String doseNo;

	private String vaccineName;

	private LocalDate dateOfDose;

	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getDoseNo() {
		return doseNo;
	}

	public void setDoseNo(String doseNo) {
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

}