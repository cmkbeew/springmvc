package org.fullstack4.springmvc.service;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsServiceImplTests {

    @Autowired
    private BbsServiceIf bbsServiceIf;

    @Test
    public void testRegist() {
        BbsDTO bbsDTO = BbsDTO.builder()
                .user_id("test")
                .title("제목 테스트3")
                .content("내용 테스트3")
//                .display_date("2024-04-11")
                .read_cnt(0)
                .build();

        int result = bbsServiceIf.regist(bbsDTO);
    }

    @Test
    public void testBbsTotalCount() {
        PageRequestDTO requestDTO = PageRequestDTO.builder()
//                .page(3)
//                .page_size(10)
                .build();

        int total_count = bbsServiceIf.bbsTotalCount(requestDTO);

        log.info("===============================");
        log.info("testBbsTotalCount - ServiceImpl : " + total_count);
        log.info("===============================");
    }

    @Test
    public void testBbsListByPage() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .page_size(10)
                .build();

        PageResponseDTO<BbsDTO> pageResponseDTO = bbsServiceIf.bbsListByPage(pageRequestDTO);

        log.info("===============================");
        log.info("testBbsTotalCount >> testBbsListByPage : ");
        pageResponseDTO.getDtoList().forEach(vo -> log.info(vo));
        log.info("===============================");
    }

}