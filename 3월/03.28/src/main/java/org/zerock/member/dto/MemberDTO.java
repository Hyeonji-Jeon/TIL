package org.zerock.member.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO implements UserDetails{

	private String mid;
	private String mpw;
	private String mname;
	private String email;
	
	private LocalDateTime regDate;
	private LocalDateTime modDate;

	private List<String> roleNames;
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 문자열 USER, MANAGER, ADMIN
		// SimpleGrantedAuthority 변환 
		// 모아서 Collection 
		
		return roleNames.stream()
				.map(roleStr -> new SimpleGrantedAuthority("ROLE_"+roleStr))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		
		return mpw;
	}

	@Override
	public String getUsername() {
		return mid;
	}
}




