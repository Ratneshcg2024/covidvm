package com.cg.covidvm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class MedicalStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staffId")
	private int staffId;

	@Column(name = "staffName")
	private String staffName;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "password")
	private String password;

	@Column(name = "location")
	private String location;

	@Column(name = "mobileNo")
	private String mobileNo;

	public List<VitalsAtVaccination> getVitalsAtVaccination() {
		return vitalsAtVaccination;
	}

	public void setVitalsAtVaccination(List<VitalsAtVaccination> vitalsAtVaccination) {
		this.vitalsAtVaccination = vitalsAtVaccination;
	}

	@OneToMany(mappedBy = "medicalStaff")
	// @JoinColumn(name="medicalStaff_vitalsAtVaccination")
	private List<VitalsAtVaccination> vitalsAtVaccination;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}