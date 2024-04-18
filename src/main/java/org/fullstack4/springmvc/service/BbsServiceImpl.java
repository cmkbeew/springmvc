package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BbsServiceImpl implements BbsServiceIf {

    private final BbsMapper bbsMapper;
    private final ModelMapper modelMapper;

    @Override
    public int regist(BbsDTO bbsDTO) {
        log.info("============================");
        log.info("BbsServiceImpl >> regist(bbsDTO) : " + bbsDTO);

        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);
        int result = bbsMapper.regist(bbsVO);
        log.info("BbsServiceImpl >> bbsVO : " + bbsVO);
        log.info("BbsServiceImpl >> result : " + result);

        log.info("============================");

        return result;
    }

    @Override
    public List<BbsDTO> list() {
        log.info("============================");
        log.info("BbsServiceImpl >> list() : ");
        log.info("============================");

        List<BbsDTO> bbsDTOList = bbsMapper.list().stream()
                                                .map(vo -> modelMapper.map(vo, BbsDTO.class))
                                                .collect(Collectors.toList());
        return bbsDTOList;
    }

    @Override
    public BbsDTO view(int idx) {
        BbsVO bbsVO = bbsMapper.view(idx);

        BbsDTO bbsDTO = modelMapper.map(bbsVO, BbsDTO.class);

        return bbsDTO;
    }

    @Override
    public int modify(BbsDTO bbsDTO) {
        log.info("============================");
        log.info("BbsServiceImpl >> modify()");
        log.info("============================");

        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);

        int result = bbsMapper.modify(bbsVO);

        return result;
    }

    @Override
    public int delete(int idx) {
        log.info("============================");
        log.info("BbsServiceImpl >> delete()");
        log.info("============================");

        int result = bbsMapper.delete(idx);

        return result;
    }
}
