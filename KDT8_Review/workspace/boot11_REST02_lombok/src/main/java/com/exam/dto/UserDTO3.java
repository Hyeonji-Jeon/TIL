package com.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
public class UserDTO3 {

	String username;
	int age;
	String address;
	
	@Builder
	public UserDTO3(String username, int age) {
		this.username = username;
		this.age= age;
	}
}
