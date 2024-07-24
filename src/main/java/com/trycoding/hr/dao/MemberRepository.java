package com.trycoding.hr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trycoding.hr.entity.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	public Member findByUsername(String username);
	
	

}
