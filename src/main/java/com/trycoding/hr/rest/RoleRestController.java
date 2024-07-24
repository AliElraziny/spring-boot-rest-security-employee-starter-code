package com.trycoding.hr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trycoding.hr.entity.Role;
import com.trycoding.hr.service.RoleService;

@RestController
public class RoleRestController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	List<Role> findAll(){
		
		List<Role> dbRoles =roleService.findAll();
		return dbRoles;
	}
	
	@GetMapping("/roles/getRole/{theId}")
	Role getRole(@PathVariable long theId) {
		Role dbRole =roleService.findById(theId);

		return dbRole;
	}
	
	@PostMapping("/roles/saveRole")
	Role addRole(@RequestBody Role theRole) {
		theRole.setId(0l);
		
		Role dbRole =roleService.save(theRole);
		
		return dbRole;
	}
	
	@PutMapping("/roles/updateRole")
	Role updateRole(@RequestBody Role theRole) {
		
		Role dbRole = roleService.save(theRole) ;
		
		return dbRole;
	}
	
	@DeleteMapping("/roles/deleteRole/{theId}")
	String  deleteRole(@PathVariable Long theId){
		roleService.deleteById(theId);
		return "Deleted role id - " + theId;
		
	}

}
