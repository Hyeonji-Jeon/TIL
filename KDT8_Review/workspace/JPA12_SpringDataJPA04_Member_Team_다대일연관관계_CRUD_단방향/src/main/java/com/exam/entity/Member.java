package com.exam.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Member {

	@Id
	@Column(name = "member_id")
	Long id;
	String username;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")        // 지정된 이름으로 컬럼이 생성됨.
	Team team;                           // List<Team> 이 아니다.
	
	
	
}









