package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.service.BbsReplyServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/bbsReply")
@RequiredArgsConstructor
public class BbsReplyController {

    private final BbsReplyServiceIf bbsReplyServiceIf;

    @PostMapping("/regist")
    public String registPOST(@Valid BbsReplyDTO bbsReplyDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbsReplyDTO", bbsReplyDTO);

            return "redirect:/bbs/view?idx=" + bbsReplyDTO.getBbs_idx();
        }
        int result = bbsReplyServiceIf.reply_regist(bbsReplyDTO);

        // AJAX로 수정 가능
        if(result > 0) {
            return "redirect:/bbs/view?idx=" + bbsReplyDTO.getBbs_idx();
        } else {

            return "/bbs/view?idx=" + bbsReplyDTO.getBbs_idx();
        }

    }
}
