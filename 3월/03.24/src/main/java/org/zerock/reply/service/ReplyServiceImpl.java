package org.zerock.reply.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.reply.dto.ReplyDTO;
import org.zerock.reply.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor //의존성 주입에 필요한 생성자 자동 생성 
public class ReplyServiceImpl implements ReplyService {
	
	private final BoardMapper boardMapper;
	
	private final ReplyMapper replyMapper;
	

	@Override
	public PageResponseDTO<ReplyDTO> addReply(ReplyDTO replyDTO) {

		Integer bno = replyDTO.getBno();
		
		replyMapper.add(replyDTO);
		boardMapper.updateReplyCnt(bno, 1);
		
		int replyCount = replyMapper.countOfBno(bno);
		
		int skip = replyMapper.calcSkip(bno);
		
		java.util.List<ReplyDTO> replyDTOList = replyMapper.selectBno(bno, skip);
		
		PageRequestDTO requestDTO = new PageRequestDTO();
		requestDTO.setPage((skip/10) + 1);
		
		
		return PageResponseDTO.<ReplyDTO>withAll()
				.dtoList(replyDTOList)
				.total(replyCount)
				.pageRequestDTO(requestDTO)
				.build();
		
		
	}

}






