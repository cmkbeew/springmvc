package org.fullstack4.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Log4j2
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsDTO {

    @PositiveOrZero
    private int idx;

    @NotBlank
    private String user_id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private String display_date;

    @Builder.Default // 초기화가 필요함
    @PositiveOrZero
    @Min(value = 0)
    private int read_cnt = 0;

    private LocalDate reg_date;
    private LocalDate modify_date;
    private String interest;
}
