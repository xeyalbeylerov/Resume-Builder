package com.company.resumecv.controller;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.entity.Skill;
import com.company.resumecv.form.*;
import com.company.resumecv.service.Html2Pdf;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;
    private final Html2Pdf generatePdf;

    @GetMapping("/resume")
    public String resume(Model model) {
        List<ResumeForm> resumes = resumeService.getAll();
        model.addAttribute("resume", resumes.get(0));
        return "resume";
    }



    @GetMapping("/resume/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        ResumeForm resumeForm = resumeService.findById(id);
        model.addAttribute("resume", resumeForm);
        return "resume";
    }

    @GetMapping("/resumeTemplate/{id}")
    public String findByIdResumeTemplate(@PathVariable("id") Long id, Model model) {
        ResumeForm resumeForm = resumeService.findById(id);
        model.addAttribute("resume", resumeForm);
        return "resumeTemplate";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user2", "Xeyal");
        return "index";
    }

    @GetMapping("/generate/{id}")
    public String generatePdf(@PathVariable("id") Long id, Model model) {
        ResumeForm resumeForm = resumeService.findById(id);
        String inputUrl ="http://localhost:8080/resume/"+id;
        String outputUrl ="TestPdf_"+id+".pdf";
        generatePdf.generatePDF(inputUrl);

        model.addAttribute("resume", resumeForm);
        return "resume";
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
        SkillForm skillForm = new SkillForm();
//        model.addAttribute("skillForm", skillForm);
        model.addAttribute("skillForm", skillForm);
        return "testSpring";
    }

    @PostMapping("/testSpring")
    public String greetingSubmit(@ModelAttribute SkillForm skillForm) {
        System.out.println(skillForm);
        return "testSpring";
    }

    //    Blank resume object
    @ModelAttribute("resume")
    public ResumeForm getEmptyUserForm() {
        ResumeForm resumeForm = new ResumeForm();
        resumeForm.setId(1l);
        resumeForm.setEducations(Arrays.asList(new EducationForm()));
        resumeForm.setSkills(Arrays.asList(new SkillForm()));
        resumeForm.setSocials(Arrays.asList(new SocialForm()));
        resumeForm.setWorkExperience(Arrays.asList(new WorkExperienceForm()));
        return resumeForm;
    }
}
