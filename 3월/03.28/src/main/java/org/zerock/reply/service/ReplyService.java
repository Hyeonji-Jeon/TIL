package org.zerock.reply.service;

import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.reply.dto.ReplyDTO;

public interface ReplyService {

	
  PageResponseDTO<ReplyDTO>	addReply(ReplyDTO replyDTO);
  
  PageResponseDTO<ReplyDTO>	list(Integer bno, PageRequestDTO requestDTO, boolean last);
  
  ReplyDTO getOne(Integer rno);
  
  void modify(ReplyDTO replyDTO, boolean del);
	
}
