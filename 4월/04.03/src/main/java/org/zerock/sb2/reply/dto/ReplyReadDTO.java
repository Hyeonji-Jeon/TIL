package org.zerock.sb2.reply.dto;

import java.time.LocalDateTime;

import org.zerock.sb2.reply.entities.ReplyEntity;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyReadDTO {
    
    private Long rno;

    private String replyText;

    private String replyer;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Long bno;

    public ReplyReadDTO(ReplyEntity entity){
        this.rno = entity.getRno();
        this.replyText = entity.getReplyText();
        this.replyer = entity.getReplyer();
        this.regDate = entity.getRegDate();
        this.modDate = entity.getModDate();

        this.bno = entity.getBoard().getBno();
    }

}
