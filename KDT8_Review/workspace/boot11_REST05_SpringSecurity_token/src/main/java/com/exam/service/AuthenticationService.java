package com.exam.service;

import java.util.Map;

import com.exam.dto.MemberDTO;

// 로그인만 구현하자.
public interface AuthenticationService {

	//로그인
	public MemberDTO authenticate(Map<String, String> map);;
}
