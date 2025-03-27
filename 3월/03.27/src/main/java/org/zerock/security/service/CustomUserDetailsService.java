package org.zerock.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("========loadUserByUsername=======" + username);
		log.info("========passwordEncoder=======" + passwordEncoder);
		//log.info("========1111=======" + passwordEncoder.encode("1111"));
		
		
		
		UserDetails user = User.builder()
		.username(username)
		.password("$2a$10$nQ12.AaWcuxvBwjn3Q0NY..BPTgonCpFOORqeUlMiALYhbd7laCUW")
		.authorities("ROLE_USER")
		.build();
		
		return user;
	}

}