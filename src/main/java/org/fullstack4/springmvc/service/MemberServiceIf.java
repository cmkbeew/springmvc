package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.MemberDTO;

public interface MemberServiceIf {

    int join(MemberDTO memberDTO);

    MemberDTO view(String user_id);

    int modify(MemberDTO memberDTO);

    int delete(String user_id);

    boolean duplicateId(String user_id);
}
