package com.trycoding.hr.service;

import java.util.List;

import com.trycoding.hr.entity.Member;

public interface MemberService {
	
	List<Member> findAll();
	
	Member findById(Long theId);
	
	Member save(Member member);
	
	void deleteById(Long id );

}
