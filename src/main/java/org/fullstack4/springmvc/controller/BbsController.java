package org.fullstack4.springmvc.controller;


import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping(value = "/bbs")
public class BbsController {

    @GetMapping("/list")
    public void list() {
        log.info("============================");
        log.info("BbsController >> list()");
        log.info("============================");
    }

    @GetMapping("/view")
    public void view(@RequestParam(name="idx", defaultValue = "0") int idx,
                     Model model) {
        log.info("============================");
        log.info("BbsController >> view()");
        log.info("idx :" + idx);
        log.info("============================");

        model.addAttribute("idx", idx);
    }

    @GetMapping("/regist")
    public void registGET() {
        log.info("============================");
        log.info("BbsController >> registGET()");
        log.info("============================");
    }

    @PostMapping("/regist")
    public String registPOST(BbsDTO bbsDTO,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        log.info("============================");
        log.info("BbsController >> registPOST()");
        log.info("bbsDTO :" + bbsDTO.toString());
        log.info("============================");

        return "redirect:/bbs/list";
    }

    @GetMapping("/modify")
    public void modifyGET() {
        log.info("============================");
        log.info("BbsController >> modifyGET()");
        log.info("============================");
    }

    @PostMapping("/modify")
    public void modifyPOST() {
        log.info("============================");
        log.info("BbsController >> modifyPOST()");
        log.info("============================");
    }

    @PostMapping("/delete")
    public void deletePOST() {
        log.info("============================");
        log.info("BbsController >> deletePOST()");
        log.info("============================");
    }

}
