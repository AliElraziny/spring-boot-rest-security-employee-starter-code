package com.trycoding.hr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycoding.hr.dao.RoleRepository;
import com.trycoding.hr.entity.Role;
import com.trycoding.hr.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long theId) {
		return roleRepository.findById(theId).orElseThrow();
	}

	@Override
	public Role save(Role employee) {
		return roleRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		Role theCurrrentRole =roleRepository.findById(id).orElseThrow();
		roleRepository.delete(theCurrrentRole);
	}
}
