package org.fullstack4.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.Length;

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

    @NotBlank(message = "로그인이 필요합니다.")
    private String user_id;

    @NotBlank(message = "제목을 입력하세요.")
    @Length(min = 2, max = 30, message = "2~30자 이내로 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    @Length(min = 10, message = "10자 이상의 내용을 입력하세요.")
    private String content;

    @NotNull(message = "출력일자를 입력하세요.")
    @FutureOrPresent(message = "오늘날짜부터 선택 가능합니다.")
    private LocalDate display_date;

    @Builder.Default // 초기화가 필요함
    @PositiveOrZero
    @Min(value = 0)
    private int read_cnt = 0;

    private LocalDate reg_date;
    private LocalDate modify_date;

    @NotBlank(message = "관심사항을 선택하세요.")
    private String interest;
}
