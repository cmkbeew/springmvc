package org.fullstack4.springmvc.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Log4j2
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsVO {
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private LocalDate display_date;
    private int read_cnt;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private String interest;
}
