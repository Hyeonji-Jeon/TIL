package org.zerock.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.common.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;

	@Override
	public PageResponseDTO<BoardDTO> list(PageRequestDTO requestDTO) {
		
		List<BoardDTO> dtoList = mapper.list(requestDTO);
		int count = mapper.listCount(requestDTO);
		
		return PageResponseDTO.<BoardDTO>withAll()
				.dtoList(dtoList)
				.total(count)
				.pageRequestDTO(requestDTO)
				.build();
	}

	@Override
	public Integer add(BoardDTO dto) {

//		String str = "This is the story of Dorothy. Her mother and father died when she was very young, and she went to live with Uncle Henry and Aunt Em in Kansas,\r\n"
//				+ " The Wonderful Wizard of Oz (오즈의 마법사)|작성자 JOY";
//		
//		mapper.insertA(str);
//		mapper.insertB(str);
		
		
		int count = mapper.insert(dto);
	
		log.info("Count: " + count);
		log.info("BNO: " + dto.getBno());
		

		return dto.getBno();
	}

	@Override
	public BoardDTO getOne(Integer bno) {

		BoardDTO dto = mapper.selectOne(bno);
		
		if(dto == null) {
			throw new DataNotFoundException();
		}
		
		return dto;
	}

}










