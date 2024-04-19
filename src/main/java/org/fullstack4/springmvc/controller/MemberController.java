package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceIf memberServiceIf;

    @GetMapping("/view")
    public void view(@RequestParam(name="user_id", defaultValue = "") String user_id,
                     Model model) {
        log.info("============================");
        log.info("MemberController >> view()");
        log.info("user_id :" + user_id);
        log.info("============================");

        model.addAttribute("user_id", user_id);
    }

    @GetMapping("/join")
    public void joinGET() {
        log.info("============================");
        log.info("MemberController >> joinGET()");
        log.info("============================");
    }

    @PostMapping("/join")
    public String joinPOST(@Valid MemberDTO memberDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("Errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("memberDTO", memberDTO);

            return "redirect:/member/join";
        }
        log.info("============================");
        log.info("MemberController >> joinPOST()");
        log.info("memberDTO :" + memberDTO.toString());


        int result = memberServiceIf.join(memberDTO);

        log.info("============================");
        if(result > 0) {
            return "redirect:/login/login";
        } else {
            return "/member/join";
        }
    }

    @GetMapping("/modify")
    public void modifyGET() {
        log.info("============================");
        log.info("MemberController >> modifyGET()");
        log.info("============================");
    }

    @PostMapping("/modify")
    public void modifyPOST() {
        log.info("============================");
        log.info("MemberController >> modifyPOST()");
        log.info("============================");
    }

    @PostMapping("/leave")
    public void leavePOST() {
        log.info("============================");
        log.info("MemberController >> leavePOST()");
        log.info("============================");
    }
}
