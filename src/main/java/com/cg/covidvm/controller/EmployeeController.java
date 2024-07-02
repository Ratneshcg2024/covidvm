package com.cg.covidvm.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.model.EmployeeDto;
import com.cg.covidvm.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/all")
	public List<Employee> fetchAllEmployee() {
		List<Employee> list = employeeService.getAllEmployees();
		return list;
	}

	@PostMapping("/Employee/save")
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		EmployeeDto newEmployee = employeeService.saveEmployee(employeeDto);
		ResponseEntity<EmployeeDto> responseEntity = new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> fetchEmployeeDetails(@PathVariable("id") int empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id") int empId) {
		employeeService.deleteEmployee(empId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Employee Deleted Sucessfully", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/employee/{empId}/vitals")
	public ResponseEntity<Employee> getVitalsDetailsById(@PathVariable(value = "id") int empId) {
		Employee employee = employeeService.getVitalsDetailsById(empId);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/employee/certification/{empId}/{doseNo}")
	public ResponseEntity<Employee> getCertificationById(@PathVariable("id") int empId,
			@PathVariable("doseNo") int doseNo) {
		Employee employee = employeeService.getCetificationById(empId);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
		return responseEntity;

	}

}