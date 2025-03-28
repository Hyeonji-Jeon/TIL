package org.zerock.member.mapper;

import org.zerock.member.dto.MemberDTO;

public interface MemberMapper {

	int insert(MemberDTO memberDTO);
	
	int insertRoles(MemberDTO memberDTO);
	
	MemberDTO selectByMid (String mid);
	
}
