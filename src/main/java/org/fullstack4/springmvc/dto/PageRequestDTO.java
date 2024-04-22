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
    @Min(value = 1)
    private int page = 1;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_size = 10;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 0)
    private int page_skip_count = 0;

    @Builder.Default
    @PositiveOrZero
    @Min(value = 1)
    private int page_block_size = 10;

    // 검색 조건
    private String[] search_type;
    private String search_word;
    private String search_date1;
    private String search_date2;


    public int getPage_skip_count() {
        return ((this.page-1) * this.page_size);
    }
}
