package org.fullstack4.springmvc.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Log4j2
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String user_id;
    private String name;
    private String pwd;
    private String email;
    private String jumin;
    private String addr1;
    private String addr2;
    private String birthday;
    private String interest;
    private String jobCode;
    private int mileage;
    private String user_state;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private LocalDate pwd_change_date;
    private LocalDate leave_date;
}
