                         
package com.exam.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
@Entity
public class Todo {

	@Id // pk 역할
	Long id;
	
	String description;

	@CreationTimestamp
	@Column(updatable = false)
	LocalDateTime createdDate;	// JPA는 create_date로 만들어버림
	
	@UpdateTimestamp
	@Column(insertable = false)
	LocalDateTime lastUpdatedDate;
	
	boolean done;
	
	// getter 직접구현
	public boolean getDone() {
		return done;
	}
}
