package org.fullstack4.springmvc.mapper;

import org.apache.ibatis.annotations.Param;
import org.fullstack4.springmvc.domain.MemberVO;

public interface LoginMapper {
    MemberVO login_info(@Param("user_id") String user_id, @Param("pwd") String pwd);

    void logout(String user_id);
}
