package org.fullstack4.springmvc.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.service.BbsServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Controller
@RequestMapping(value = "/bbs")
@RequiredArgsConstructor
public class BbsController {

    private final BbsServiceIf bbsServiceIf;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("============================");
        log.info("BbsController >> list()");
        List<BbsDTO> bbsList = bbsServiceIf.list();

        model.addAttribute("bbsList", bbsList);
        log.info("============================");
    }

    @GetMapping("/view")
    public void view(@RequestParam(name="idx", defaultValue = "0") int idx,
                     Model model) {
        log.info("============================");
        log.info("BbsController >> view()");
        log.info("idx :" + idx);

        BbsDTO bbsDTO = bbsServiceIf.view(idx);

        model.addAttribute("bbs", bbsDTO);
        log.info("============================");
    }

    @GetMapping("/regist")
    public void registGET() {
        log.info("============================");
        log.info("BbsController >> registGET()");
        log.info("============================");
    }

    @PostMapping("/regist")
    public String registPOST(@Valid BbsDTO bbsDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("Errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbs", bbsDTO);

            return "redirect:/bbs/regist";
        }

        log.info("============================");
        log.info("BbsController >> registPOST()");
        log.info("bbsDTO :" + bbsDTO.toString());

        int result = bbsServiceIf.regist(bbsDTO);

        log.info("result :" + result);
        log.info("============================");

        if(result > 0) {
            return "redirect:/bbs/list";
        } else {

            return "/bbs/regist";
        }

    }

    @GetMapping("/modify")
    public void modifyGET(@RequestParam(name = "idx", defaultValue = "0") int idx,
                          Model model) {
        log.info("============================");
        log.info("BbsController >> modifyGET()");
        log.info("============================");

        BbsDTO bbsDTO = bbsServiceIf.view(idx);
        model.addAttribute("bbsDTO", bbsDTO);
    }

    @PostMapping("/modify")
    public String modifyPOST(BbsDTO bbsDTO,
                             Model model) {
        log.info("============================");
        log.info("BbsController >> modifyPOST()");
        log.info("============================");

        int result = bbsServiceIf.modify(bbsDTO);

        if(result > 0) {
            return "redirect:/bbs/view?idx=" + bbsDTO.getIdx();
        } else {
            return "/bbs/modify";
        }
    }

    @PostMapping("/delete")
    public String deletePOST(@RequestParam(name = "idx", defaultValue = "0") int idx) {
        log.info("============================");
        log.info("BbsController >> deletePOST()");
        log.info("============================");

        int result = bbsServiceIf.delete(idx);

        if(result > 0) {
            return "redirect:/bbs/list";
        } else {
            return "redirect:/bbs/view?idx="+idx;
        }
    }

}
