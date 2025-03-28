package org.zerock.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.member.dto.MemberDTO;
import org.zerock.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final PasswordEncoder passwordEncoder;
	
	private final MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("========loadUserByUsername=======" + username);
		
		MemberDTO memberDTO = memberMapper.selectByMid(username);
		
		log.info("========loadUserByUsername=======" + memberDTO);
		
		if(memberDTO == null) {
			throw new UsernameNotFoundException("MEMBER NOT EXIST");
		}
		
		
		return memberDTO;
	}

}






