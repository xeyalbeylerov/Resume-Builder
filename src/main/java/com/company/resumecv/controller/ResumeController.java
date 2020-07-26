package com.company.resumecv.controller;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.entity.Skill;
import com.company.resumecv.form.*;
import com.company.resumecv.service.Html2Pdf;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;






    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        ResumeForm resumeForm = resumeService.findById(id);
        model.addAttribute("resume", resumeForm);
        return "resume";
    }

    @GetMapping("/template/{id}")
    public String findByIdResumeTemplate(@PathVariable("id") Long id, Model model) throws InterruptedException {
        Thread.sleep(2000l);
        ResumeForm resumeForm = resumeService.findById(id);
        model.addAttribute("resume", resumeForm);
        return "resumeTemplate";
    }









//    //    Blank resume object
//    @ModelAttribute("resume")
//    public ResumeForm getEmptyUserForm() {
//        ResumeForm resumeForm = new ResumeForm();
//        resumeForm.setId(1l);
//        resumeForm.setEducations(Arrays.asList(new EducationForm()));
//        resumeForm.setSkills(Arrays.asList(new SkillForm()));
//        resumeForm.setSocials(Arrays.asList(new SocialForm()));
//        resumeForm.setWorkExperience(Arrays.asList(new WorkExperienceForm()));
//        return resumeForm;
//    }
}
