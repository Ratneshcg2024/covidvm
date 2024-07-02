package com.cg.covidvm.model;

import javax.validation.constraints.NotNull;

public class MedicalStaffDto {

	private int staffId;

	@NotNull(message = "staff name is required")
	private String staffName;

	@NotNull(message = "email id is required")
	private String emailId;

	@NotNull(message = "password is required")
	private String password;

	@NotNull(message = "location is required")
	private String location;

	@NotNull(message = "mobile no is required")
	private String mobileNo;

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