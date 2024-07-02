package com.cg.covidvm.model;

 

import java.time.LocalDate;

 


public class DoseReq {

 

    private String doseNo;
    private String vaccineName;
    private int empId;
    private LocalDate dateOfDose;
    private int centreId;
    private int vitalId;
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
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public LocalDate getDateOfDose() {
        return dateOfDose;
    }
    public void setDateOfDose(LocalDate dateOfDose) {
        this.dateOfDose = dateOfDose;
    }
    public int getCentreId() {
        return centreId;
    }
    public void setCentreId(int centreId) {
        this.centreId = centreId;
    }
    public int getVitalId() {
        return vitalId;
    }
    public void setVitalId(int vitalId) {
        this.vitalId = vitalId;
    }

}