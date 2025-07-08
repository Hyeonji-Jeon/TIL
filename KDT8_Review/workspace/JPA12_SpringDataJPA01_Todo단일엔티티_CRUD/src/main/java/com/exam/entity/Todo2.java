package com.exam.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "TB_TODO")
public class Todo2 {

	@Id // pk 역할
	Long id;
	
	 @Column(name="content")
	String description;

	@CreationTimestamp
	@Column(updatable = false)
	LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	LocalDateTime lastUpdatedDate;
	
	@Transient	// 컬럼으로 만들지 않겠다
	Long age;
	
	boolean done;
	
	// getter 직접구현
	public boolean getDone() {
		return done;
	}
}
