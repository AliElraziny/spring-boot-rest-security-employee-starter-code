package com.trycoding.hr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycoding.hr.dao.EmployeeRepository;
import com.trycoding.hr.entity.Employee;
import com.trycoding.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeRepository.findById(theId).orElseThrow();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		Employee theCurrrentEmp =employeeRepository.findById(id).orElseThrow();
		employeeRepository.delete(theCurrrentEmp);
	}

}
