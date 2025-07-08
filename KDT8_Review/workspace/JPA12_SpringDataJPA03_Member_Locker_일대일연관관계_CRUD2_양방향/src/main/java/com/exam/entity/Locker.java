package com.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@ToString
@Entity
public class Locker {

	@Id
	@Column(name = "locker_id")
	Long id;
	String name;
	
	//양방향( DB 코드 변경없음. 단지 자바에서 편의성 목적)
	@OneToOne(mappedBy = "locker") // Member에 있는 Locker 변수명 지정.
	Member member;
	
	@Override
	public String toString() {
		return "Locker [id=" + id + ", name=" + name + ", member=" + member.getUsername() + "]";
	}
    
}










