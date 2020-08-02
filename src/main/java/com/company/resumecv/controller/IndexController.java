package com.company.resumecv.controller;

import com.company.resumecv.config.ResumeInitializerForTest;
import com.company.resumecv.form.*;
import com.company.resumecv.service.ResumeService;
import com.company.resumecv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class IndexController {
private final ResumeInitializerForTest initializer;

    @GetMapping("/")
    public String index(Model model) {
        ResumeForm resumeForm = initializer.resumeBuilder();
        resumeForm.setName(resumeForm.getName()+i);
        model.addAttribute("resume",resumeForm);
        return "index";
    }

    int i=0;
    @GetMapping("/reload")
    public ModelAndView reset(Model model) {
        ResumeForm resumeForm = initializer.resumeBuilder();
        resumeForm.setName("Reloaded "+i);
        model.addAttribute("resume",resumeForm);
        i++;
        System.out.println(i);
        return new ModelAndView("index :: header");
//        return "index :: header";
    }

    @PostMapping("/reload2")
    public ModelAndView reset2(Model model) {
        ResumeForm resumeForm = initializer.resumeBuilder();
        resumeForm.setName("Reloaded "+i);
        model.addAttribute("resume",resumeForm);
        i++;
        System.out.println(i);
        return new ModelAndView("index :: header");
//        return "index :: header";
    }
}
