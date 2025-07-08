package com.exam.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class TodoDTO {

	Long id;
	String description;
	LocalDateTime createdDate;
	LocalDateTime lastUpdatedDate;
	/*
	   lombok 으로 boolean 타입을 사용할 때는
	   setter: setDone()
	   geeter: isDone() 
	   
	   isDone() 대신에 직접 getter 구현도 가능
	
	*/
	boolean done;
	
	// getter 직접구현
	public boolean getDone() {
		return done;
	}
	
	
}
