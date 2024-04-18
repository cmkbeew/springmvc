package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.dto.MemberDTO;

public interface LoginServiceIf {

    MemberDTO login_info(String user_id, String pwd);

    void logout(String user_id);
}
