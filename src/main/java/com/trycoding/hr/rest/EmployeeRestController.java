package com.trycoding.hr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycoding.hr.entity.Employee;
import com.trycoding.hr.service.EmployeeService;

@RestController
@RequestMapping("/apiForEmployees")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	List<Employee> findAll(){
		
		List<Employee> dbEmployees =employeeService.findAll();
		return dbEmployees;
	}
	
	@GetMapping("/getEmployee/{theId}")
	Employee getEmployee(@PathVariable int theId) {
		Employee dbEmployee =employeeService.findById(theId);

		return dbEmployee;
	}
	
	@PostMapping("/saveEmployee")
	Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		Employee dbEmployee =employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@PutMapping("/updateEmployee")
	Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee) ;
		
		return dbEmployee;
	}
	
	@DeleteMapping("/deleteEmployee/{theId}")
	String  deleteEmployee(@PathVariable int theId){
		employeeService.deleteById(theId);
		return "Deleted employee id - " + theId;
		
	}
}
