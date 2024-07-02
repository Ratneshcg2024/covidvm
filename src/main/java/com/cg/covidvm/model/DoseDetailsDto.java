package com.cg.covidvm.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.entity.VaccinationCentre;
import com.cg.covidvm.entity.VitalsAtVaccination;

public class DoseDetailsDto {

	private int doseId;

	@NotNull(message = "dateOfDose is required")
	private LocalDate dateOfDose;

	@NotNull(message = "doseNo is required")
	private String doseNo;

	@NotNull(message = "time is required")
	private String time;

	@NotNull(message = "vitalId is required")
	private int vitalId;

	@NotNull(message = "staffId is required")
	private int staffId;

	@NotNull(message = "vaccine name is required")
	private String vaccineName;

	private Employee employee;

	private VitalsAtVaccination vitalsAtVaccination;

	private VaccinationCentre vaccinationCentre;

	private MedicalStaffDto medicalStaffDto;

	public int getDoseId() {
		return doseId;
	}

	public void setDoseId(int doseId) {
		this.doseId = doseId;
	}

	public LocalDate getDateOfDose() {
		return dateOfDose;
	}

	public void setDateOfDose(LocalDate dateOfDose) {
		this.dateOfDose = dateOfDose;
	}

	public String getDoseNo() {
		return doseNo;
	}

	public void setDoseNo(String doseNo) {
		this.doseNo = doseNo;
	}

	public String getTime() {
		return time;
	}

	public VitalsAtVaccination getVitalsAtVaccination() {
		return vitalsAtVaccination;
	}

	public void setVitalsAtVaccination(VitalsAtVaccination vitalsAtVaccination) {
		this.vitalsAtVaccination = vitalsAtVaccination;
	}

	public VaccinationCentre getVaccinationCentre() {
		return vaccinationCentre;
	}

	public void setVaccinationCentre(VaccinationCentre vaccinationCentre) {
		this.vaccinationCentre = vaccinationCentre;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getVitalId() {
		return vitalId;
	}

	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MedicalStaffDto getMedicalStaffDto() {
		return medicalStaffDto;
	}

	public void setMedicalStaffDto(MedicalStaffDto medicalStaffDto) {
		this.medicalStaffDto = medicalStaffDto;
	}

}