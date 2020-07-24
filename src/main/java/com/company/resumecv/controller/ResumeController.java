package com.company.resumecv.controller;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.entity.Skill;
import com.company.resumecv.form.*;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;
    @GetMapping("/resume")
    public String resume(Model model) {
        List<ResumeForm> resumes = resumeService.getAll();
        model.addAttribute("resume", resumes.get(0));
        return "resume";
    }

    @GetMapping("/builder")
    public String builder(Model model) {

        ResumeForm resumeForm=new ResumeForm();

        resumeForm.setEducations(Arrays.asList(new EducationForm()));
        resumeForm.setSkills(Arrays.asList(new SkillForm()));
        resumeForm.setSocials(Arrays.asList(new SocialForm()));
        resumeForm.setWorkExperience(Arrays.asList(new WorkExperienceForm()));

        model.addAttribute("resume",resumeForm );
        return "builderTest";
    }
    @PostMapping("/builder")
    public String builderPost(Model model,@ModelAttribute ResumeForm resume) {
        resumeService.save(resume);

        ResumeForm resumeForm=new ResumeForm();
        model.addAttribute("resume",resumeForm );
        return "builderTest";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user2", "Xeyal");
        return "index";
    }

    @GetMapping("/up")
    public String greetingPage(Model model, @RequestParam(required = false) String name) {
        name = name == null || name.trim().equals("") ? "Thymeleaf" : name;
        String message = String.format("Merhaba %s!", name);
        model.addAttribute("message", message);
        return "index";
    }


    @GetMapping("/testSpring")
    public String greetingForm(Model model) {
        SkillForm skillForm=new SkillForm();
//        model.addAttribute("skillForm", skillForm);
        model.addAttribute("skillForm", skillForm);
        return "testSpring";
    }

    @PostMapping("/testSpring")
    public String greetingSubmit(@ModelAttribute SkillForm skillForm) {
        System.out.println(skillForm);
        return "testSpring";
    }
}
