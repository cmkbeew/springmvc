package org.fullstack4.springmvc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Data
public class PageResponseDTO<E> {

    private int total_count;
    private int page;
    private int page_size;
    private int page_skip_count;
    private int total_page;
    private int page_block_size;
    private int page_block_start;
    private int page_block_end;

    private boolean prev_page_flag;
    private boolean next_page_flag;

    List<E> dtoList;

    // 검색 조건
    private String[] search_type;
    private String search_word;
    private String search_date1;
    private String search_date2;

    private String linkParams;

    PageResponseDTO() {}

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO requestDTO, List<E> dtoList, int total_count) {
        log.info("=======================");
        log.info("PageResponseDTO START");

        this.total_count = total_count;
        this.page = requestDTO.getPage();
        this.page_size = requestDTO.getPage_size();
        this.page_skip_count = requestDTO.getPage_skip_count();
        this.total_page = (int)Math.ceil(total_count / (double)page_size);
        this.page_block_size = requestDTO.getPage_block_size();
        this.page_block_start = (int)(Math.ceil(page / (double)page_block_size) -1 ) * 10 + 1;
        this.page_block_end = (int)Math.ceil(page / (double)page_block_size) * 10;
        this.page_block_end = page_block_end > total_page ? total_page : page_block_end;
        this.prev_page_flag = (this.page_block_start > 1);
        this.next_page_flag = (this.total_page > this.page_block_end);
        this.dtoList = dtoList;

        this.linkParams = "?page_size=" + this.page_size;

        log.info("PageResponseDTO END");
        log.info("=======================");
    }

}
