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

import com.trycoding.hr.entity.Member;
import com.trycoding.hr.service.MemberService;


@RestController
public class UserRestController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	List<Member> findAll(){
		
		List<Member> dbMembers =memberService.findAll();
		return dbMembers;
	}
	
	@GetMapping("/members/getMember/{theId}")
	Member getEmployee(@PathVariable Long theId) {
		Member dbdbMember =memberService.findById(theId);

		return dbdbMember;
	}
	
	@PostMapping("/members/saveMember")
	Member addMember(@RequestBody Member theMember) {
		theMember.setId(0l);
		
		Member dbEmployee =memberService.save(theMember);
		
		return dbEmployee;
	}
	
	@PutMapping("/members/updateMember")
	Member updateEmployee(@RequestBody Member theMember) {
		
		Member dbMember = memberService.save(theMember) ;
		
		return dbMember;
	}
	
	@DeleteMapping("/members/deleteMember/{theId}")
	String  deleteEmployee(@PathVariable Long theId){
		memberService.deleteById(theId);
		return "Deleted member id - " + theId;
		
	}

}
