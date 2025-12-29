package com.jsp.empapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.empapp.entity.Employee;
import com.jsp.empapp.exception.DataExistException;
import com.jsp.empapp.exception.DataNotFoundException;
import com.jsp.empapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getEmployees(int page,int size,String sort,boolean desc)
	
	{
		PageRequest pageRequest = PageRequest.of(page-1, size, desc ? Sort.by(sort).descending(): Sort.by(sort).ascending());
		
		List<Employee> employees= repository.findAll(pageRequest).getContent();
		if(employees.isEmpty())
			throw new DataNotFoundException("No Emloyees Records Found");
		return employees;
	}
	public Employee saveEmployee(Employee employee)
	{
		if (repository.existsByPhno(employee.getPhno()))
			throw new DataExistException("Phone Number Already Exists");
			return repository.save(employee);
	}
	
	public Employee findById(Integer id) {
		return repository.findById(id)
				.orElseThrow(()-> new DataNotFoundException("no employees record with Id:" +id));
	}

	public List<Employee> findByName(String name){
		List<Employee> employees=repository.findByName(name);
		if(employees.isEmpty())
			throw new DataNotFoundException("No employees Record with Name:" +name);
		return employees;
	}
	
	public Employee findByPhone(Long mobile) {
		return repository.findByPhno(mobile)
				.orElseThrow(()-> new DataNotFoundException("No Employees with Phone number: " +mobile));
	}
	
	public List<Employee> findByDepartment(String department){
	    List<Employee> employees = repository.findByDepartment(department);
	    if (employees.isEmpty())
	        throw new DataNotFoundException("No employees Record with Department: " + department);
	    return employees;
	}
	
	public void deleteById(Integer id) {
		repository.findById(id).orElseThrow(()-> new DataNotFoundException("No employees with id" +id));
		 repository.deleteById(id);
		 	
	}
	
	
	public Employee completeUpdate(Integer id, Employee employee) {
	 repository.findById(id).orElseThrow(()-> new DataNotFoundException("No employees with id:" +id));
	 employee.setId(id);
	 return repository.save(employee);
		 
	}
	public Employee partialUpdate(Integer id, Employee employee) {
		 Employee exEmployee = repository.findById(id)
				 .orElseThrow(()-> new DataNotFoundException ("No Employees Record with id:" +id));
		 if(employee.getDepartment()!=null)
			 exEmployee.setDepartment(employee.getDepartment());
		 if(employee.getName()!=null)
			 exEmployee.setName(employee.getName());
		 if(employee.getPhno()!=null)
			 exEmployee.setPhno(employee.getPhno());
		 if(employee.getSalary()!=null)
			 exEmployee.setSalary(employee.getSalary());
		return repository.save(exEmployee);
	}

	
	
}