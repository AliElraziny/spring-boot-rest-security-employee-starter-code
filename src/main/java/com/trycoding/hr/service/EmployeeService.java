package com.trycoding.hr.service;

import java.util.List;

import com.trycoding.hr.entity.Employee;


public interface EmployeeService {

	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee employee);
	
	void deleteById(int id );
}
