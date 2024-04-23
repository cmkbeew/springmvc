package org.fullstack4.springmvc.mapper;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsReplyVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsReplyMapperTests {

    @Autowired(required = false)
    ModelMapper modelMapper;

    @Autowired(required = false)
    BbsReplyMapper bbsReplyMapper;

    @Test
    public void testBbsReplyRegist() {
        BbsReplyVO bbsReplyVO = BbsReplyVO.builder()
                                        .bbs_idx(214)
                                        .user_id("test2")
                                        .title("댓글 내용")
                                        .build();

        int result = bbsReplyMapper.reply_regist(bbsReplyVO);
        log.info("result : " + result);
    }

    @Test
    public void reply_list() {
    }
}