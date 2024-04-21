package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.LoginMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginServiceIf {

    private final LoginMapper loginXmlMapper;
    private final ModelMapper modelMapper;
    @Override
    public MemberDTO login_info(String user_id, String pwd) {
        MemberVO memberVO = loginXmlMapper.login_info(user_id, pwd);

        MemberDTO memberDTO = null;

        if(memberVO != null && memberVO.getPwd().equals(pwd)) {
            memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        }

        return memberDTO;
    }

    @Override
    public void logout(String user_id) {

    }
}
