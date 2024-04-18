package org.fullstack4.springmvc.mapper;

import org.fullstack4.springmvc.domain.BbsVO;

import java.util.List;

public interface BbsMapper {

    int regist(BbsVO bbsVO);
    List<BbsVO> list();
    BbsVO view(int idx);
    int modify(BbsVO bbsVO);
    int delete(int idx);
}
