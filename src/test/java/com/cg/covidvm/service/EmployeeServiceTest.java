package com.cg.covidvm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.covidvm.entity.Employee;
import com.cg.covidvm.exception.EmployeeNotFoundException;
import com.cg.covidvm.model.EmployeeDto;
import com.cg.covidvm.repository.EmployeeRepository;
import com.cg.covidvm.repository.SlotBookingRepository;
import com.cg.covidvm.repository.SlotRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private SlotRepository slotRepository;

	@Mock
	private SlotBookingRepository slotBookingRepository;

	@Test
	public void testEmployeeById() {
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("Kanchan");
		employee.setBirthdate(LocalDate.of(2001, 03, 05));
		employee.setPassword("Kanchan123");
		employee.setMobileNo("9096202107");

		Optional<Employee> optionalEmployee = Optional.of(employee);
		when(employeeRepository.findById(1)).thenReturn(optionalEmployee);

		Employee employeeObj = employeeService.getEmployeeById(1);

		assertEquals("Kanchan", employeeObj.getEmpName());

		assertEquals("9096202107", employeeObj.getMobileNo());

	}

	@Test
	public void testGetEmployeeByIdException() {

		when(employeeRepository.findById(1)).thenThrow(EmployeeNotFoundException.class);

		assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(1));
	}

	@Test
	void testGetAllEmployees() {

		List<Employee> employee = new ArrayList<>();

		Employee employee1 = new Employee();
		employee1.setEmpId(1);
		employee1.setEmpName("Kanchan");
		employee1.setBirthdate(LocalDate.of(2001, 03, 05));
		employee1.setPassword("Kanchan123");
		employee1.setMobileNo("9096202107");

		Employee employee2 = new Employee();
		employee2.setEmpId(2);
		employee2.setEmpName("Sakshi");
		employee2.setBirthdate(LocalDate.of(2001, 04, 01));
		employee2.setPassword("Sakshi123");
		employee2.setMobileNo("9456202107");

		Employee employee3 = new Employee();
		employee3.setEmpId(3);
		employee3.setEmpName("Dipali");
		employee3.setBirthdate(LocalDate.of(1998, 01, 24));
		employee3.setPassword("Dipali123");
		employee3.setMobileNo("7796202107");

		employee.add(employee3);
		employee.add(employee2);
		employee.add(employee1);

		when(employeeRepository.findAll()).thenReturn(employee);

		List<Employee> employeeList = employeeService.getAllEmployees();

		assertEquals(3, employeeList.size());
	}

	@Test
	public void testDeleteEmployee() {

		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("Kanchan");
		employee.setBirthdate(LocalDate.of(2001, 03, 05));
		employee.setPassword("Kanchan123");
		employee.setMobileNo("9096202107");
		Optional<Employee> optionalEmployee = Optional.of(employee);

		when(employeeRepository.findById(1)).thenReturn(optionalEmployee);

		doNothing().when(employeeRepository).deleteById(1);

		employeeService.deleteEmployee(1);

		verify(employeeRepository, times(1)).findById(1);
		verify(employeeRepository, times(1)).deleteById(1);
	}

	@Test
	void testSaveEmployee() {
		EmployeeDto newDto = new EmployeeDto();
		newDto.setEmpId(1);
		newDto.setEmpName("Kanchan");
		newDto.setBirthdate(LocalDate.of(2001, 03, 05));
		newDto.setPassword("Kanchan123");
		newDto.setMobileNo("9096202107");

	//	when(employeeRepository.save(newDto)).thenReturn(newDto);

		EmployeeDto newEmployee = employeeService.saveEmployee(newDto);

		assertEquals("Kanchan", newEmployee.getEmpName());

	}
}