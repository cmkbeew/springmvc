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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.UUID;

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
        log.info("pageRequestDTO : " + pageRequestDTO.toString());

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

    @GetMapping("/fileUpload")
    public String fileUploadGET() {
        return "/bbs/fileUpload";
    }

    @PostMapping("/fileUpload")
    public String fileUploadPOST(@RequestParam("file") MultipartFile multipartFile) {
        String uploadFolder = "D:\\java4\\uploads";
        String fileRealName = multipartFile.getOriginalFilename();
        long size = multipartFile.getSize();
        String ext = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());

        log.info("========================");
        log.info("uploadFolder : " + uploadFolder);
        log.info("fileRealName : " + fileRealName);
        log.info("size : " + size);
        log.info("ext : " + ext);

        // 새로운 파일명 생성
        UUID uuid = UUID.randomUUID();
        String[] uuids = uuid.toString().split("-");
        String newName = uuids[0];

        log.info("uuid : " + uuid);
        log.info("uuids : " + uuids);
        log.info("newName : " + newName);

        File saveFile = new File(uploadFolder + "\\" + newName + ext);

        log.info("saveFile : " + saveFile);

        try {
            multipartFile.transferTo(saveFile);
        } catch(IllegalStateException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        log.info("========================");

        return "/bbs/fileUpload";
    }

    @PostMapping("/fileUpload2")
    public String fileUploadPOST2(MultipartHttpServletRequest files) {
        String uploadFolder = "D:\\java4\\uploads";

        List<MultipartFile> list = files.getFiles("files");

        for(int i=0; i<list.size(); i++) {
            String fileRealName = list.get(i).getOriginalFilename();
            long size = list.get(i).getSize();
            String ext = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());

            log.info("fileRealName : " + fileRealName);
            log.info("size : " + size);
            log.info("ext : " + ext);

            UUID uuid = UUID.randomUUID();
            String[] uuids = uuid.toString().split("-");
            String newName = uuids[0];

            File saveFile = new File(uploadFolder + "\\" + newName + ext);

            try {
                list.get(i).transferTo(saveFile);
            } catch(IllegalStateException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return "/bbs/fileUpload";
    }
}
