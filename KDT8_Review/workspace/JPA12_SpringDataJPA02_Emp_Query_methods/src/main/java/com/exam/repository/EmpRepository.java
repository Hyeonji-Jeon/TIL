package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {

	//1. JpaRepository 에서 기본으로 제공하는 CRUD 메서드
	//2. @Query(JPQL)
	
	//3. Query Method
	
	//가. ename으로 검색
	List<Emp> findByEname(String ename);
	
	
	//나. ename 또는 sal 로 검색
	List<Emp> findByEnameOrSal(String ename, Long sal);
	
	//다.지정된 sal보다 작은 사원 검색
	List<Emp> findBySalLessThan(Long sal);
	
	//라. ename중에서  A 글자를 포함하는 사원 검색
	List<Emp> findByEnameContaining(String ename);
	
	
	//마. comm 이 null 값을 가진 사원 검색
	List<Emp> findByCommIsNull();
}




