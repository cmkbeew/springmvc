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
        BbsVO bbsVO = modelMapper.map(bbsDTO, BbsVO.class);
        int result = bbsMapper.regist(bbsVO);

        return result;
    }

    @Override
    public List<BbsDTO> list() {
        List<BbsDTO> bbsDTOList = bbsMapper.list().stream()
                                                .map(vo -> modelMapper.map(vo, BbsDTO.class))
                                                .collect(Collectors.toList());

        // 보여지는 내용 길이 설정
        for(BbsDTO dto : bbsDTOList) {
            dto.setContent(dto.getContent().replace("\r\n", " "));
            if(dto.getContent().length() >= 30) {
                dto.setContent(dto.getContent().substring(0, 30) + ".....");
            }
        }

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
