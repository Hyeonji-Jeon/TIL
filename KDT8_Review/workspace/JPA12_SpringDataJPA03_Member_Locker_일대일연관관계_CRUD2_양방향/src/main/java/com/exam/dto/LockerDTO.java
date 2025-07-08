package com.exam.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LockerDTO {

	Long id;
	String name;
    MemberDTO member;
    
    
	@Override
	public String toString() {
		return "LockerDTO [id=" + id + ", name=" + name + ", member=" + member + "]";
	}
    
    
}










