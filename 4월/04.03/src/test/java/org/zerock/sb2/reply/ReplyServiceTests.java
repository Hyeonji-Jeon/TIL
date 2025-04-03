package org.zerock.sb2.reply;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb2.reply.dto.ReplyAddDTO;
import org.zerock.sb2.reply.service.ReplyService;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {

    @Autowired
    private ReplyService service;

    @Test
    public void testAdd(){

        Long bno = 122L;

        for (int i = 0; i < 3; i++) {

            ReplyAddDTO addDTO = ReplyAddDTO.builder()
                    .replyText("케잌의 평화")
                    .replyer("악뮤")
                    .bno(bno)
                    .build();

            log.info(service.add(addDTO));
        }//end for
    }

    @Test
    public void testRead(){
        log.info(service.get(27L));
    }
}
