package com.exam.service;

import com.exam.dto.MemberDTO;

// 회원가입과 mypage만 구현하자.
public interface MemberService {
	//회원가입
	public int save(MemberDTO dto);
	//mypage
	public MemberDTO findById(String userid);
}
