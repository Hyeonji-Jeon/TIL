package com.exam.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Team {

	@Id
	@Column(name = "team_id")
	Long id;
	String name;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)  // Team 삭제시 해당 Team에 속한 Member도 삭제됨.
	List<Member> member;
}










