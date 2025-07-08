package com.exam.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Alias("UserDTO")
public class UserDTO {

	 Long id;
	 
	 @JsonProperty("name")
	 String username;
	 
	 @JsonIgnore	// 누락시킴
	 LocalDate birthdate;
	 
}
