package org.fullstack4.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    @NotBlank(message = "아이디를 입력하세요.")
    @Pattern(regexp = "^[a-z0-9]{4,12}", message = "4~12자의 영어, 숫자만 입력 가능합니다.")
    private String user_id;

    @NotBlank(message = "이름을 입력하세요.")
    @Pattern(regexp = "[가-힣a-zA-Z]{2,20}", message = "2~20자의 한글, 영어만 입력 가능합니다.")
    private String name;

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,20}$", message = "대문자, 소문자, 숫자를 1개 이상씩 4~20자로 입력하세요.")
    private String pwd;

    @NotBlank(message = "이메일을 입력하세요.")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "이메일 형식을 입력하세요.")
    private String email;

    private String jumin;

    @NotBlank(message = "주소1을 입력하세요.")
    @Pattern(regexp = "^[가-힣]{2,10}", message = "2~10자 이내의 한글로 입력하세요.")
    private String addr1;

    @NotBlank(message = "주소2를 입력하세요.")
    @Pattern(regexp = "^[가-힣]{2,10}", message = "2~10자 이내의 한글로 입력하세요.")
    private String addr2;

    @NotNull(message = "생년월일을 입력하세요.")
    @PastOrPresent(message = "오늘 이전의 날짜를 입력하세요.")
    private LocalDate birthday;

    @NotBlank(message = "관심사항을 선택하세요.")
    private String interest;

    private String jobCode;
    private int mileage;
    private String user_state;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private LocalDate pwd_change_date;
    private LocalDate leave_date;
}
