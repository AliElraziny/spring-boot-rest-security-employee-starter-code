package com.trycoding.hr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycoding.hr.dao.MemberRepository;
import com.trycoding.hr.entity.Member;
import com.trycoding.hr.service.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	
	

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member findById(Long theId) {
		return memberRepository.findById(theId).orElseThrow();
	}

	@Override
	public Member save(Member employee) {
		return memberRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		Member theCurrrentMem =memberRepository.findById(id).orElseThrow();
		memberRepository.delete(theCurrrentMem);
	}


}
