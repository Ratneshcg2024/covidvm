package com.cg.covidvm.exception;

 

 

public class MedicalStaffNotFoundException extends RuntimeException{
    public MedicalStaffNotFoundException(String msg) {
            super(msg);
        }
}