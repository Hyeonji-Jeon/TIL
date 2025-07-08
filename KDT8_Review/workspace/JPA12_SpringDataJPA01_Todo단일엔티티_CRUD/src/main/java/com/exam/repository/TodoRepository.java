package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
	
}
