package com.cg.covidvm.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class VitalsAtVaccination {

	@Id
	@Column(name = "vitalId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vitalId;

	@Column(name = "temperature")
	private float temperature;

	@Column(name = "saturation")
	private float saturation;

	@Column(name = "bloodPressure")
	private float bloodPressure;

	@Column(name = "vitalTime")
	private String vitalTime;

	@Column(name = "empId")
	private int empId;

	@Column(name = "staffId")
	private int staffId;

	@Column(name = "slotId")
	private int slotId;

	public MedicalStaff getMedicalStaff() {
		return medicalStaff;
	}

	public void setMedicalStaff(MedicalStaff medicalStaff) {
		this.medicalStaff = medicalStaff;
	}

	public int getVitalId() {
		return vitalId;
	}

	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getSaturation() {
		return saturation;
	}

	public void setSaturation(float saturation) {
		this.saturation = saturation;
	}

	public float getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(float bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getVitalTime() {
		return vitalTime;
	}

	public void setVitalTime(String vitalTime) {
		this.vitalTime = vitalTime;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public DoseDetails getDoseDetails() {
		return doseDetails;
	}

	public void setDoseDetails(DoseDetails doseDetails) {
		this.doseDetails = doseDetails;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private MedicalStaff medicalStaff;

	@OneToOne
	private DoseDetails doseDetails;

}