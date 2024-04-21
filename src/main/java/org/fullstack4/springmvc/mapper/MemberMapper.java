package org.fullstack4.springmvc.mapper;

import org.fullstack4.springmvc.domain.MemberVO;

public interface MemberMapper {
    int join(MemberVO memberVO);

    MemberVO view(String user_id);

    int modify(MemberVO memberVO);

    int delete(String user_id);

    String duplicateId(String user_id);
}
