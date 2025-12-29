package com.jsp.empapp.repository;

 

 
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.empapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	boolean existsByPhno(Long phno);
	
	List<Employee> findByName(String name);
	
	Optional<Employee> findByPhno(Long phno);
	

    List<Employee> findByDepartment(String department);

}