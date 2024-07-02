package com.cg.covidvm.entity;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@Column(name = "empId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	@Column(name = "empName")
	private String empName;

	@Column(name = "password")
	private String password;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "mobileNo")
	private String mobileNo;

	@OneToOne
	@JoinColumn(name = "employee_slotBooking")
	private SlotBooking slotBooking;

	@OneToMany(mappedBy = "employee")
	private List<DoseDetails> doseDetails;

	public SlotBooking getSlotBooking() {
		return slotBooking;
	}

	public void setSlotBooking(SlotBooking slotBooking) {
		this.slotBooking = slotBooking;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<DoseDetails> getDoseDetails() {
		return doseDetails;
	}

	public void setDoseDetails(List<DoseDetails> doseDetails) {
		this.doseDetails = doseDetails;
	}

}