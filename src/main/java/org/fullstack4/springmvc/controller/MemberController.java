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
        MemberDTO memberDTO = memberServiceIf.view(user_id);

        model.addAttribute("memberDTO", memberDTO);
    }

    @GetMapping("/join")
    public void joinGET() {
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

        boolean duplicate_id_check = memberServiceIf.duplicateId(memberDTO.getUser_id());

        if(duplicate_id_check) {
            int result = memberServiceIf.join(memberDTO);
            if(result > 0) {
                return "redirect:/login/login";
            } else {
                return "/member/join";
            }
        } else {
            redirectAttributes.addFlashAttribute("duplicate_error", "이미 존재하는 아이디입니다.");
            redirectAttributes.addFlashAttribute("memberDTO", memberDTO);

            return "redirect:/member/join";
        }
    }

    @GetMapping("/modify")
    public void modifyGET(@RequestParam(name="user_id", defaultValue = "") String user_id,
                          Model model) {
        MemberDTO memberDTO = memberServiceIf.view(user_id);

        model.addAttribute("memberDTO", memberDTO);
    }

    @PostMapping("/modify")
    public String modifyPOST(@Valid MemberDTO memberDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("Errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("memberDTO", memberDTO);

            return "redirect:/member/modify?user_id=" + memberDTO.getUser_id();
        }
        int result = memberServiceIf.modify(memberDTO);

        if(result > 0) {
            return "redirect:/member/view?user_id=" + memberDTO.getUser_id();
        } else {
            return "/member/modify?user_id=" + memberDTO.getUser_id();
        }

    }

    @PostMapping("/delete")
    public String deletePOST(String user_id) {

        int result = memberServiceIf.delete(user_id);

        if(result > 0) {
            return "redirect:/";
        } else {
            return "/member/view?user_id=" + user_id;
        }
    }
}
