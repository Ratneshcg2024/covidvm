package com.cg.covidvm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.covidvm.entity.Employee;
@Repository
public interface EmployeeRepository    extends JpaRepository<Employee,Integer>{

 

 

    

 

    }