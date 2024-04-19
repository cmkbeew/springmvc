package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.LoginDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.LoginServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginServiceIf loginServiceIf;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET(HttpServletRequest req, Model model) {
        log.info("============================");
        log.info("LoginController >> loginGET()");
        log.info("============================");

        String acc_url = req.getHeader("referer");
        model.addAttribute("acc_url", acc_url);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid LoginDTO loginDTO,
                            BindingResult bindingResult,
                            @RequestParam(name="acc_url", defaultValue = "/bbs/list", required = false) String acc_url,
                            Model model,
                            RedirectAttributes redirectAttributes,
                            HttpServletRequest req) {
        log.info("============================");
        log.info("LoginController >> loginPOST()");
        log.info("memberDTO : " + loginDTO.toString());
        log.info("============================");

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);

            return "redirect:/login/login";
        }

        MemberDTO loginMemberDTO = loginServiceIf.login_info(loginDTO.getUser_id(), loginDTO.getPwd());
        log.info("loginMemberDTO : " + loginMemberDTO.toString());

        if(loginMemberDTO != null) {
            // true : 세션이 없으면 생성하고 리턴, 있으면 있는 세션 리턴
            // false : 세션 있으면 리턴, 없으면 생성 안함
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", loginMemberDTO);

            model.addAttribute("loginInfo", loginMemberDTO);

            return "redirect:" + acc_url;
        } else {
            redirectAttributes.addFlashAttribute("errors['err_user_info']", "사용자 정보가 일치하지 않습니다.");

            return "/login/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest req) {
        log.info("============================");
        log.info("LoginController >> logout()");

        HttpSession session = req.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        log.info("============================");

        return "redirect:/";
    }
}
