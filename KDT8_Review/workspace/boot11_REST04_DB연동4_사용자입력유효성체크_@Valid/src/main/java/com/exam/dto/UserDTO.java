package com.exam.dto;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
	 
	 @NotBlank(message = "username 필수") 
	 String username;
	 
	 
	 @Past(message = "과거 날짜만 가능")  
	 LocalDate birthdate;
	 
}
