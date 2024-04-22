package org.fullstack4.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

@Log4j2
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int total_count = 0;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int first_page = 1;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page = 15;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_size = 10;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int total_page = 1;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int page_skip_count = 10;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_block_size = 10;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_block_start = 1;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_block_end = 1;

    // 검색 조건
    private String[] search_type;
    private String search_word;
    private String search_date1;
    private String search_date2;


    public int getPage_skip_count() {
        return ((this.page-1) * this.page_size);
    }

    public int getTotal_page() {
        return (int)Math.ceil(total_count / (double)page_size);
    }

//    public int getPage_block_start() {
//        return (int)(Math.ceil(page / (double)page_block_size) -1 ) * 10 + 1;
//    }
//
//    public int getPage_block_end() {
//        return ((int)Math.ceil(page / (double)page_block_size) * 10) > total_page ? total_page : page_block_end;
//    }
}
