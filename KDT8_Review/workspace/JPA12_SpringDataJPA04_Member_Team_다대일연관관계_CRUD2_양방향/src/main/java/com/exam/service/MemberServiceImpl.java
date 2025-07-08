package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exam.dto.MemberDTO;
import com.exam.dto.TeamDTO;
import com.exam.entity.Member;
import com.exam.entity.Team;
import com.exam.repository.MemberRepository;
import com.exam.repository.TeamRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService{

	MemberRepository memberRepository;
	
	TeamRepository teamRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository, TeamRepository teamRepository) {
		this.memberRepository = memberRepository;
		this.teamRepository = teamRepository;
	}
    
	@Override
	public List<MemberDTO> findAll(){
		
		List<Member> studentList= memberRepository.findAll();
		
		//////////////////////////////////////////////////////
		// 양방향 실습
		Member findMember = studentList.get(0);
		Team findTeam = findMember.getTeam();
		List<Member> memberList= findTeam.getMember();
		for (Member member : memberList) {
			log.info("LOGGER: 양방향 {}", member.getUsername());
		}
		////////////////////////////////////////////////////////
		///
		///
		// List<Member> 타입을 List<MemberDTO>로 변환
		List<MemberDTO> memberDTOList = studentList.stream().map( s -> { 
		
																			Team team = s.getTeam();	
																		   TeamDTO teamDTO = TeamDTO.builder()
																				                     .id(team.getId())
																				                     .name(team.getName())
																				   					 .build();
																		   
																		   MemberDTO dto = MemberDTO.builder()
				                                                                          .id(s.getId())
				                                                                          .username(s.getUsername())
				                                                                          .team(teamDTO)
				                                                                          .build();
																		 return dto;						
		                                                              }
				                                               ).collect(Collectors.toList());    // 그냥 toList() 도 가능.
		return memberDTOList;
	}
	
	@Override
	public void addMember(MemberDTO memberDTO) {
		
		TeamDTO teamDTO = memberDTO.getTeam();
		Team team = Team.builder()
						  .id(teamDTO.getId())
		                  .name(teamDTO.getName())
			              .build();
		
		// MemberDTO 타입을 Member로 변환
		Member member = Member.builder()
						 .id(memberDTO.getId())
		                 .username(memberDTO.getUsername())
		                 .team(team)
				        .build();
		
		memberRepository.save(member);
	}

	@Override
	public void deleteMember(Long id){
		
		Member member = memberRepository.findById(id).orElse(null);
		
//		memberRepository.deleteById(id);
		memberRepository.delete(member);
	}
	
	@Override
	public void deleteTeam(Long id){
		
		Team team = teamRepository.findById(id).orElse(null);
		
		teamRepository.delete(team);
	}
	

	@Override
	public void updateMember(Long id, MemberDTO memberDTO) {
		
		Member member = memberRepository.findById(id).orElse(null);
		
		// 더티체킹
		if( member != null ) {
			member.setUsername(memberDTO.getUsername());
		}
//		courseRepository.save(course);
	}
	
}
