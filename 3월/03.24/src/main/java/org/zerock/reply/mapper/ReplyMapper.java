package org.zerock.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.reply.dto.ReplyDTO;

// DML 의 리턴은 항상 int 

public interface ReplyMapper {

	int add(ReplyDTO replyDTO);
	
	int countOfBno(Integer bno);
	
	int calcSkip(Integer bno);
	
	List<ReplyDTO> selectBno(@Param("bno") Integer bno, @Param("skip") int skip);
	
}
