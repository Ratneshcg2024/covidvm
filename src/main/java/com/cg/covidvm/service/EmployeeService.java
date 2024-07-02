package com.cg.covidvm.service;

 

 

import java.util.List;

 

 

import org.springframework.stereotype.Service;

 

 

import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.exception.EmployeeNotFoundException;
import com.cg.covidvm.model.EmployeeDto;

 

 

@Service
public interface EmployeeService {

 

 

    
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

 

    public Employee getEmployeeById(int empId);

 

 

    public List<Employee> getAllEmployees();

 


    public void deleteEmployee(int employeeId);

 

 

    

 

    public void cancelSlot(int empId,int slotId);

 

 

    Employee getCetificationById(int empId) throws EmployeeNotFoundException;

 

 

    Employee getVitalsDetailsById(int empId) throws EmployeeNotFoundException;

 

 

    

 

 

    //public Employee findById(int empId);

 

 

    
}