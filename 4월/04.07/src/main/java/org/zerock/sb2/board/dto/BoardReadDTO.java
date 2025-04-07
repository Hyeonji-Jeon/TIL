package org.zerock.sb2.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardReadDTO {
    
    private Long bno;

    private String title, content, writer;

    private boolean delFlag;

    private int veiwCnt;

    private LocalDateTime regDate, modDate;

    //bno, title, content, writer, delFlag, veiwCnt, regDate, modDate
    public BoardReadDTO(Long bno, String title, String content, String writer, boolean delFlag, int veiwCnt,
            LocalDateTime regDate, LocalDateTime modDate) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.delFlag = delFlag;
        this.veiwCnt = veiwCnt;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    
}
