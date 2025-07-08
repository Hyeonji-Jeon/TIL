package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
