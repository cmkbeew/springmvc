package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;

import java.util.List;

public interface BbsServiceIf {
    int regist(BbsDTO bbsDTO);

    List<BbsDTO> list();

    BbsDTO view(int idx);

    int modify(BbsDTO bbsDTO);

    int delete(int idx);
}
