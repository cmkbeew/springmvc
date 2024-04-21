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
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);

        int result = memberMapper.join(memberVO);

        return result;
    }

    @Override
    public MemberDTO view(String user_id) {
        MemberVO memberVO = memberMapper.view(user_id);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }

    @Override
    public int modify(MemberDTO memberDTO) {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);

        int result = memberMapper.modify(memberVO);

        return result;
    }

    @Override
    public int delete(String user_id) {
        int result = memberMapper.delete(user_id);

        return result;
    }

    @Override
    public boolean duplicateId(String user_id) {
        String save_id = memberMapper.duplicateId(user_id);

        if(save_id != null) {
            return false;
        } else {
            return true;
        }
    }
}
