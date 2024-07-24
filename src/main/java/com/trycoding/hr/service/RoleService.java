package com.trycoding.hr.service;

import java.util.List;

import com.trycoding.hr.entity.Role;

public interface RoleService {
	
	List<Role> findAll();
	
	Role findById(Long theId);
	
	Role save(Role member);
	
	void deleteById(Long id );

}
