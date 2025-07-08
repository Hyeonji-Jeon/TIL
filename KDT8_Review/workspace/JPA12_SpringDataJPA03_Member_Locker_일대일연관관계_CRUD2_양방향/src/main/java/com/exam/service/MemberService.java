package com.exam.service;

import java.util.List;

import com.exam.dto.LockerDTO;
import com.exam.dto.MemberDTO;

public interface MemberService {

	public List<MemberDTO> findAll();
	public void addMember(MemberDTO memberDTO);
	public void deleteMember(Long id);
	public void updateMember(Long id, MemberDTO memberDTO);
	
	// 양방향
	public LockerDTO findAllLocker(Long id);
}
