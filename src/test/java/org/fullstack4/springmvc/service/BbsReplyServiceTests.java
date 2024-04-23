package org.fullstack4.springmvc.service;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsReplyServiceTests {

    @Autowired(required = false)
    private BbsReplyServiceIf bbsReplyServiceIf;

    @Test
    public void testBbsReplyRegist() {
        BbsReplyDTO bbsReplyDTO = BbsReplyDTO.builder()
                                            .bbs_idx(214)
                                            .user_id("test3")
                                            .title("댓글 서비스 테스트")
                                            .build();

        int result = bbsReplyServiceIf.reply_regist(bbsReplyDTO);

        log.info("result : " + result);
    }
}
