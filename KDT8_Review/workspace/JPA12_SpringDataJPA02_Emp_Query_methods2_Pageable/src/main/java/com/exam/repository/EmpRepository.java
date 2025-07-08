package com.exam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Emp;

// https://docs.spring.io/spring-data/jpa/docs/2.6.10/api/
public interface EmpRepository extends JpaRepository<Emp, Long> {

	// 전체 레코드 반환하는 기능인 Page<T> findAll(Pageable pageable) 는 JpaRepository 내에 미리 구현되어 있음.
	
	
	  // job로 검색 + 페이징 처리
    Page<Emp> findByJob(String job, Pageable pageable);
}


