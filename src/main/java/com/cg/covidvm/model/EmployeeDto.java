package com.cg.covidvm.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class EmployeeDto {
	private int empId;

	@NotNull(message = "employee name is required")
	private String empName;

	@NotNull(message = "password is required")
	private String password;

	@NotNull(message = "birth date is required")
	private LocalDate birthdate;

	@NotNull(message = "mobile no is required")
	private String mobileNo;

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

}