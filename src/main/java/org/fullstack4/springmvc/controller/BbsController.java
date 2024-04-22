package org.fullstack4.springmvc.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
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
    public void list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes,
                     Model model) {
        log.info("===========================");
        log.info("BbsController >> list() START");
//        log.info("pageRequestDTO : " + pageRequestDTO.toString());

        if(bindingResult.hasErrors()) {
            log.info("BbsController >> list Error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        }

        PageResponseDTO<BbsDTO> responseDTO = bbsServiceIf.bbsListByPage(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);

        log.info("responseDTO : " + responseDTO);
        log.info("BbsController >> list() END");
        log.info("===========================");
    }
//    public void list(Model model) {
//        List<BbsDTO> bbsList = bbsServiceIf.list();
//
//        model.addAttribute("bbsList", bbsList);
//    }

    @GetMapping("/view")
    public void view(@RequestParam(name="idx", defaultValue = "0") int idx,
                     Model model) {
        BbsDTO bbsDTO = bbsServiceIf.view(idx);

        model.addAttribute("bbsDTO", bbsDTO);
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
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbs", bbsDTO);

            return "redirect:/bbs/regist";
        }
        int result = bbsServiceIf.regist(bbsDTO);

        if(result > 0) {
            return "redirect:/bbs/list";
        } else {

            return "/bbs/regist";
        }

    }

    @GetMapping("/modify")
    public void modifyGET(@RequestParam(name = "idx", defaultValue = "0") int idx,
                          Model model) {
        BbsDTO bbsDTO = bbsServiceIf.view(idx);

        model.addAttribute("bbsDTO", bbsDTO);
    }

    @PostMapping("/modify")
    public String modifyPOST(@Valid BbsDTO bbsDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbs", bbsDTO);

            return "redirect:/bbs/modify?idx=" + bbsDTO.getIdx();
        }
        int result = bbsServiceIf.modify(bbsDTO);

        if(result > 0) {
            return "redirect:/bbs/view?idx=" + bbsDTO.getIdx();
        } else {
            return "/bbs/modify?idx=" + bbsDTO.getIdx();
        }
    }

    @PostMapping("/delete")
    public String deletePOST(@RequestParam(name = "idx", defaultValue = "0") int idx) {
        int result = bbsServiceIf.delete(idx);

        if(result > 0) {
            return "redirect:/bbs/list";
        } else {
            return "redirect:/bbs/view?idx="+idx;
        }
    }

}
