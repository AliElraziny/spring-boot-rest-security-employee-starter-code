package com.trycoding.hr.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trycoding.hr.dao.MemberRepository;
import com.trycoding.hr.entity.Member;

@Service
public class CustomDetailsService implements UserDetailsService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		if (member == null) {
			throw new UsernameNotFoundException("User not found");
		}
		User getMember = new User(member.getUsername(), member.getPassword(), member.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
		return getMember;
	}

}