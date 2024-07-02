package com.cg.covidvm.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DoseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doseId")
	private int doseId;

	@Column(name = "dateOfDose")
	private LocalDate dateOfDose;

	@Column(name = "time")
	private String time;

	@Column(name = "vitalId")
	private int vitalId;

	@Column(name = "staffId")
	private int staffId;

	@Column(name = "vaccineName")
	private String vaccineName;

	@Column(name = "doseNo")
	private String doseNo;

	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	@OneToOne(mappedBy = "doseDetails")
	// @JoinColumn(name="doseDetails_vitalsAtVaccination")
	private VitalsAtVaccination vitalsAtVaccination;

	@ManyToOne
	private VaccinationCentre vaccinationCentre;

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

	public String getTime() {
		return time;
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

	public String getDoseNo() {
		return doseNo;
	}

	public void setDoseNo(String doseNo) {
		this.doseNo = doseNo;
	}

}