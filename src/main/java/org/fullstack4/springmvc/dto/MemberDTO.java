package org.fullstack4.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    @NotBlank
    private String user_id;

    @Builder.Default
    @NotBlank
    private String name = "";

    @NotBlank
    private String pwd;

    @NotBlank
    private String email;

    private String jumin;

    @NotBlank
    private String addr1;

    @NotBlank
    private String addr2;

    @NotBlank
    private String birthday;

    @NotBlank
    private String interest;

    private String jobCode;
    private int mileage;
    private String user_state;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private LocalDate pwd_change_date;
    private LocalDate leave_date;
}
