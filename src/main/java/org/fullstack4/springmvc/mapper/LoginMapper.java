package org.fullstack4.springmvc.mapper;

import org.fullstack4.springmvc.domain.MemberVO;

public interface LoginMapper {
    MemberVO login_info(String user_id, String pwd);

    void logout(String user_id);
}
