package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsReplyVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.mapper.BbsReplyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BbsReplyServiceImpl implements BbsReplyServiceIf {

    private final ModelMapper modelMapper;
    private final BbsReplyMapper bbsReplyXmlMapper;

    @Override
    @Transactional
    public int reply_regist(BbsReplyDTO bbsReplyDTO) {
        BbsReplyVO bbsReplyVO = modelMapper.map(bbsReplyDTO, BbsReplyVO.class);

        int result = bbsReplyXmlMapper.reply_regist(bbsReplyVO);
        int reply_result = bbsReplyXmlMapper.update_reply_cnt(bbsReplyVO.getBbs_idx());

        log.info("result : " + result);
        log.info("reply_result : " + reply_result);

        return result;
    }

    @Override
    public int update_reply_cnt(int bbs_idx) {
        int result = bbsReplyXmlMapper.update_reply_cnt(bbs_idx);

        return result;
    }

    @Override
    public List<BbsReplyDTO> reply_list(int bbs_idx) {
        List<BbsReplyDTO> bbsReplyDTOList = bbsReplyXmlMapper.reply_list(bbs_idx).stream()
                .map(vo -> modelMapper.map(vo, BbsReplyDTO.class))
                .collect(Collectors.toList());

        return bbsReplyDTOList;
    }
}
