package com.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity
public class Member {

	@Id
	@Column(name = "member_id")
	Long id;
	String username;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locker_id")   // 지정된 name값으로 컬럼이 생성됨.
	Locker locker;                    // @JoinColumn 지정하지 않으면 자동으로 locker_id 컬럼명으로 생성됨.
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", locker=" + locker.getName() + "]";
	}   
}









