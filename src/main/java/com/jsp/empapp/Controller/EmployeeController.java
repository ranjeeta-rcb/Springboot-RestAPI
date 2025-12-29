package com.jsp.empapp.Controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

import com.jsp.empapp.entity.Employee;

import com.jsp.empapp.Service.EmployeeService;

@RestController

@RequestMapping("/api/v1/employees")

public class EmployeeController {

@Autowired

private EmployeeService service;



@GetMapping

@ResponseStatus(HttpStatus.OK)

public List<Employee> getEmployee(@RequestParam(defaultValue ="1") int page,
		@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sort,
		@RequestParam(defaultValue = "false") boolean desc){

	return service.getEmployees(page, size, sort, desc);

}


@PostMapping

@ResponseStatus(HttpStatus.CREATED)

public Employee saveEmployee(@RequestBody Employee employee){

	return service.saveEmployee(employee);

}

@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Employee findById(@PathVariable Integer id) {
	
	return service.findById(id);
}

@GetMapping("/name/{name}")
@ResponseStatus(HttpStatus.OK)
public List<Employee> findByName(@PathVariable String name){
	 return service.findByName(name);
}

@GetMapping("/phno/{mobile}")
@ResponseStatus(HttpStatus.OK)
public Employee findByPhone(@PathVariable Long mobile) {
	return service.findByPhone(mobile);
}

@GetMapping("/department/{department}")
@ResponseStatus(HttpStatus.OK)
public List<Employee> findByDepartment(@PathVariable String department){
    return service.findByDepartment(department);
}


@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteById(@PathVariable Integer id) {
   service.deleteById(id);
}


@PutMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Employee completeUpdate(@PathVariable Integer id, @RequestBody Employee employee) {
	return service.completeUpdate(id,employee);
}

@PatchMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Employee partialUpdate(@PathVariable Integer id, @RequestBody Employee employee) {
	return service.partialUpdate(id,employee);
}

}

