package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsReplyVO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.mapper.BbsReplyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BbsReplyServiceImpl implements BbsReplyServiceIf {

    private final ModelMapper modelMapper;
    private final BbsReplyMapper bbsReplyXmlMapper;

    @Override
    public int reply_regist(BbsReplyDTO bbsReplyDTO) {
        BbsReplyVO bbsReplyVO = modelMapper.map(bbsReplyDTO, BbsReplyVO.class);

        int result = bbsReplyXmlMapper.reply_regist(bbsReplyVO);
        int reply_result = bbsReplyXmlMapper.update_reply_cnt(bbsReplyVO.getBbs_idx());

        return result;
    }

    @Override
    public int update_reply_cnt(int bbs_idx) {
        int result = bbsReplyXmlMapper.update_reply_cnt(bbs_idx);

        return result;
    }

    @Override
    public List<BbsReplyDTO> reply_list() {
        return null;
    }
}
