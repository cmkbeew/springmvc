package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.C;
import org.fullstack4.springmvc.dto.LoginDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.LoginServiceIf;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.fullstack4.springmvc.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginServiceIf loginServiceIf;
    private final MemberServiceIf memberServiceIf;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET(HttpServletRequest req, Model model) {
        // 아이디 저장 했을 때
        String save_id = CookieUtil.getCookieValue("save_id", req);
        String auto_login = CookieUtil.getCookieValue("auto_login", req);

        if(!save_id.equals("")) {
            model.addAttribute("save_id", save_id);
        }
        if(!auto_login.equals("")) {
            model.addAttribute("auto_login", auto_login);
        }

        String acc_url = req.getHeader("referer");

        model.addAttribute("acc_url", acc_url);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid LoginDTO loginDTO,
                            BindingResult bindingResult,
                            @RequestParam(name="acc_url", defaultValue = "/bbs/list", required = false) String acc_url,
                            Model model,
                            RedirectAttributes redirectAttributes,
                            HttpServletRequest req,
                            HttpServletResponse res) {
        log.info("loginDTO : " + loginDTO);

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);

            return "redirect:/login/login";
        }

        MemberDTO loginMemberDTO = loginServiceIf.login_info(loginDTO.getUser_id(), loginDTO.getPwd());

        if(loginMemberDTO != null) {
            // true : 세션이 없으면 생성하고 리턴, 있으면 있는 세션 리턴
            // false : 세션 있으면 리턴, 없으면 생성 안함
            HttpSession session = req.getSession();
            log.info("loginMemberDTO : " + loginMemberDTO);
            session.setAttribute("user_id", loginMemberDTO.getUser_id());
            session.setAttribute("name", loginMemberDTO.getName());

            // 아이디 저장 -> 쿠키에 아이디 저장
            if(loginDTO.getSave_id() != null) {
                CookieUtil.setCookies("save_id", loginMemberDTO.getUser_id(), 60*60*24*7, res);
            } else {
                CookieUtil.deleteCookie("save_id", null, 0, res);
            }

            // 자동 로그인 확인
            if(loginDTO.getAuto_login() != null) {
                CookieUtil.setCookies("auto_login", loginMemberDTO.getUser_id(), 60*60*24*7, res);
                CookieUtil.setCookies("user_name", loginMemberDTO.getName(), 60*60*24*7, res);
            }

            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("login_err_msg", "사용자 정보가 일치하지 않습니다.");
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);

            return "redirect:/login/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);

        if(session != null) {
            session.invalidate();
        }
        CookieUtil.deleteCookie("auto_login", null, 0, res);
        CookieUtil.deleteCookie("user_name", null, 0, res);

        return "redirect:/";
    }
}
