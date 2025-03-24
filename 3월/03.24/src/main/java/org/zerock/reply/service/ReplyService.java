package org.zerock.reply.service;

import org.zerock.board.dto.PageResponseDTO;
import org.zerock.reply.dto.ReplyDTO;

public interface ReplyService {

	
  PageResponseDTO<ReplyDTO>	addReply(ReplyDTO replyDTO);
	
}
