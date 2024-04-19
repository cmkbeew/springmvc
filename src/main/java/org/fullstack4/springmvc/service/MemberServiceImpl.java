package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.MemberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberServiceIf {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    public int join(MemberDTO memberDTO) {
        log.info("====================");
        log.info("MemberServiceImpl >> join >> memberDTO : " + memberDTO);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);

        log.info("MemberServiceImpl >> join >> memberVO : " + memberVO);
        log.info("====================");
        int result = memberMapper.join(memberVO);

        return result;
    }
}
