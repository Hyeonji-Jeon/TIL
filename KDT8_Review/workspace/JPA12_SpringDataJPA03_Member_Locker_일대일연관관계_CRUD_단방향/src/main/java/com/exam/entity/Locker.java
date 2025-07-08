package com.exam.entity;

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
@ToString
@Entity
public class Locker {

	@Id
	@Column(name = "locker_id")
	Long id;
	String name;
	
	
	/*
       create table locker (
        id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
       ) engine=InnoDB
    */
}










