package com.exam.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	/*
	
   다음 메서드들은 기본적으로 제공됨.
	 
   - 전체엔티티 조회:  findAll():List
   - 특정엔티티 조회:  findById(ID id):Optional
   - 엔티티 저장:     save(entity)

   - 엔티티 삭제
      전체삭제:  deleteAll()
      id로 삭제: deleteById(ID id)
      엔티티로 삭제: delete(T entity)

   - 엔티티 수정:  메서드 지원없이 더티체킹 이용.
   - 엔티티 갯수: count()
   
	 */
	
	//JPQL
	//1. 조회1: 엔티티로 반환
	// select 엔티티 => List<엔티티>
//	@Query("select t from Todo as t")
//	@Query("select t from Todo as t where t.id BETWEEN 100 AND 10002")
//	@Query("select t from Todo as t  WHERE t.id  IN ( 10002, 10003 )")
	@Query("select t from Todo as t WHERE t.description  LIKE '%50%' ")
	List<Todo> findAllTodoList();
	
	@Query("select t from Todo as t where t.id = ?1")
	Todo findByIdTodo2(Long id);
	@Query("select t from Todo as t where t.id = :x")
	Todo findByIdTodo(@Param("x")  Long id);
	
	//1. 조회2: 값 하나로 반환 => List<String> | List<Inteager>
	@Query("select t.description from Todo as t")
	List<String> findAllDescription();
	
	
	//1. 조회3: 값 두개이상 반환 => List<Map> | List<Tuple>
	@Query("select t.id as id,  t.description as desc from Todo as t")
	List<Map> findAllIdAndDescripion();
	
	
}
