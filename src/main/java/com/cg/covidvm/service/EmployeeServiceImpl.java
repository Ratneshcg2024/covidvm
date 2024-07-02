package com.cg.covidvm.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.entity.Slot;
import com.cg.covidvm.exception.EmployeeNotFoundException;
import com.cg.covidvm.exception.SlotNotFoundException;
import com.cg.covidvm.model.EmployeeDto;
import com.cg.covidvm.repository.EmployeeRepository;
import com.cg.covidvm.repository.SlotBookingRepository;
import com.cg.covidvm.repository.SlotRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SlotRepository slotRepository;

	@Autowired
	private SlotBookingRepository slotBookingRepository;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		Employee emp = new Employee();
		emp.setEmpName(employeeDto.getEmpName());
		emp.setPassword(employeeDto.getPassword());
		emp.setMobileNo(employeeDto.getMobileNo());
		emp.setBirthdate(employeeDto.getBirthdate());

		Employee newEmployee = employeeRepository.save(emp);
		EmployeeDto newEmployeeDto = new EmployeeDto();
		newEmployeeDto.setEmpId(newEmployee.getEmpId());
		newEmployeeDto.setEmpName(newEmployee.getEmpName());
		newEmployeeDto.setPassword(newEmployee.getPassword());
		newEmployeeDto.setMobileNo(newEmployee.getMobileNo());
		newEmployeeDto.setBirthdate(newEmployee.getBirthdate());
		return newEmployeeDto;
	}

	@Override
	public void deleteEmployee(int employeeId) throws EmployeeNotFoundException {
		Optional<Employee> optionalTrainee = employeeRepository.findById(employeeId);
		if (optionalTrainee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not existing with id:" + employeeId);
		}
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (optionalEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not Found with id: " + empId);
		}
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public Employee getCetificationById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (optionalEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with id:" + empId);
		}
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public Employee getVitalsDetailsById(int empId) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (optionalEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with id:" + empId);
		}
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public void cancelSlot(int empId, int slotId) throws SlotNotFoundException {
		// TODO Auto-generated method stub

		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		if (optionalEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with id:" + empId);
		}
		Employee employee = optionalEmployee.get();

		Optional<Slot> optionalSlot = slotRepository.findById(slotId);
		if (optionalSlot.isEmpty()) {
			throw new SlotNotFoundException("Slot not found with id:" + slotId);
		}
		Slot slot = optionalSlot.get();
		slotBookingRepository.deleteSlot(empId);
	}

}