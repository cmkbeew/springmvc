package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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

import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginServiceIf loginServiceIf;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET() {
        log.info("============================");
        log.info("LoginController >> loginGET()");
        log.info("============================");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(Model model,
                            @SessionAttribute(name="user_id", required = false) @RequestParam String user_id,
                            @RequestParam String pwd,
                            RedirectAttributes redirectAttributes) {
        log.info("============================");
        log.info("LoginController >> loginPOST()");
        log.info("============================");

        MemberDTO memberDTO = loginServiceIf.login_info(user_id, pwd);

        if(memberDTO != null) {
            model.addAttribute("user_id", memberDTO.getUser_id());

            return "redirect:/bbs/list";
        } else {
            return "redirect:/login/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        log.info("============================");
        log.info("LoginController >> logout()");
        log.info("============================");

        return "redirect:/bbs/list";
    }
}
