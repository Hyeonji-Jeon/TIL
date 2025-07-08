package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exam.dto.LockerDTO;
import com.exam.dto.MemberDTO;
import com.exam.entity.Locker;
import com.exam.entity.Member;
import com.exam.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService{

	MemberRepository memberRepository;
	
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
    
	@Override
	public List<MemberDTO> findAll(){
		
		List<Member> memberList= memberRepository.findAll();
		
		// Lazy|Eager 실습 로그
		 log.info("LOGGER:findAll: {} ", memberList);
		
		// List<Member> 타입을 List<MemberDTO>로 변환
		List<MemberDTO> memberDTOList = memberList.stream().map( s -> { 
																		   Locker locker = s.getLocker();	
																		   LockerDTO lockerDTO = LockerDTO.builder()
																				                     .id(locker.getId())
																				                     .name(locker.getName())
																				   					 .build();
																		   
			                                                               MemberDTO memberDTO = MemberDTO.builder()
				                                                                          .id(s.getId())
				                                                                          .username(s.getUsername())
				                                                                          .locker(lockerDTO)
				                                                                          .build();
																		 return memberDTO;						
		                                                              }
				                                               ).collect(Collectors.toList());    // 그냥 toList() 도 가능.
		return memberDTOList;
	}
	
	@Override
	public void addMember( MemberDTO memberDTO) {
		
		LockerDTO lockerDTO = memberDTO.getLocker();	
		Locker locker  = Locker.builder()
								.id(lockerDTO.getId())
				                .name(lockerDTO.getName())
			                   .build();
		
		// MemberDTO 타입을 Member로 변환
		Member member = Member.builder()
						 .id(memberDTO.getId())
		                 .username(memberDTO.getUsername())
		                 .locker(locker)
				        .build();
		
		memberRepository.save(member);
	}

	@Override
	public void deleteMember(Long id){
		Member member = memberRepository.findById(id).orElse(null);
		if(member != null)
		    memberRepository.deleteById(id);
	}

	@Override
	public void updateMember(Long id,  MemberDTO memberDTO) {
		
		Member member = memberRepository.findById(id).orElse(null);
		// 더티체킹
		if( member != null ) {
			member.setUsername(memberDTO.getUsername());
		}
//		courseRepository.save(course);
	}

	// 양방향
	@Override
	public LockerDTO findAllLocker(Long id) {
		
		Member m= memberRepository.findById(id).orElse(null);
		

		
		// 양방향 참조 ( Locker 이용해서 Member 참조 )
		Locker locker = m.getLocker();
		Member m2 = locker.getMember();
		
		MemberDTO memberDTO = MemberDTO.builder()
                .id(m2.getId())
                .username(m2.getUsername())
                .build();
		
		
		LockerDTO lockerDTO = LockerDTO.builder()
							  .id(locker.getId())
							  .name(locker.getName())
							  .member(memberDTO)
							  .build();
		
		return lockerDTO;
	}
	
}
