package com.company.resumecv.controller;

import com.company.resumecv.config.ResumeInitializerForTest;
import com.company.resumecv.form.*;
import com.company.resumecv.service.ResumeService;
import com.company.resumecv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/builder")
@RequiredArgsConstructor
public class ResumeBuilderController {
    private final ResumeService resumeService;
    private final UserService userService;
    private final ResumeInitializerForTest resumeInitializer;

    @GetMapping
    public String builder(Model model,
                          HttpSession session) {
//        get user from session
        UserForm userForm = (UserForm) session.getAttribute("user");

        //        get user from session
        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");

        if (resumeForm != null)
            model.addAttribute("resume", resumeForm);
        return "builderTest";
    }

    @GetMapping("/create")
    public String builderCreate(Model model,
                                @ModelAttribute("resume") ResumeForm resumeForm,
                                HttpSession session) {

//     if session exists clear it
        session.setAttribute("resume", null);


//        get user from session
        UserForm userForm = (UserForm) session.getAttribute("user");


//      find user and and get UserForm
        UserForm form = userService.findById(userForm.getId());

//        get ResumeList from UserForm
        List<ResumeForm> resumeList = form.getResumeList();

//        check if user has not resumeList then create new one list
        if (resumeList == null) resumeList = new ArrayList<>();


//        save resumeForm and get resumeForm with id
        resumeForm = resumeService.save(resumeForm);

//        add resumeFrom to resumeList
        resumeList.add(resumeForm);

        //        set resume to userForm
        userForm.setResumeList(resumeList);

        //        update user
        userForm = userService.update(userForm);

        //      user session update
        session.setAttribute("user", userForm);

//        resumeForm session save
        session.setAttribute("resume", resumeForm);

        return "redirect:/builder";
    }

    @PostMapping("/update")
    public String builderUpdate(Model model,
                                @ModelAttribute("resume") ResumeForm resumeForm,
                                BindingResult bindingResult,
                                HttpSession session) {

//        get user from session
        UserForm userForm = (UserForm) session.getAttribute("user");
        System.out.println("List " + resumeForm.getEmploymentHistory());

//        get user from session
//        ResumeForm resumeFormSession = (ResumeForm) session.getAttribute("resume");

//        print resume id after
        System.out.println("Resume id " + resumeForm.getId() + " before update");

//        update resume
        resumeForm = resumeService.update(resumeForm);


//        print user and resume id later
        System.out.println("User id " + userForm.getId());
        System.out.println("Resume id " + resumeForm.getId() + " after update");


//      session update
        session.setAttribute("user", userForm);

//      resume session update
        session.setAttribute("resume", resumeForm);

        return "redirect:/builder";
    }

    //    update for main page
    @GetMapping("/update/{id}")
    public String builderUpdateById(@PathVariable("id") Long id,
                                    Model model,
                                    HttpSession session) {

        ResumeForm resumeForm = resumeService.findById(id);

//        print resume id after
        System.out.println("Resume id " + resumeForm.getId() + " before update");


//      resume session update
        session.setAttribute("resume", resumeForm);

        return "redirect:/builder";

    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile img,
                         HttpSession session) throws Exception {

//        print resume id after
        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");
        System.out.println("Resume id on upload image " + resumeForm.getId());

        resumeForm = resumeService.imageUpload(resumeForm, img);

        session.setAttribute("resume", resumeForm);
        return "redirect:/builder";
    }

    //delete photo by resume id
    @PostMapping("/delete/photo/{id}")
    public String deletePhotoById(@PathVariable("id") Long id,
                                  HttpSession session) {


        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");


        resumeForm = resumeService.deleteResumePhoto(resumeForm, id);

        session.setAttribute("resume", resumeForm);
        return "redirect:/builder";
    }

    @GetMapping("/delete/{id}")
    public String builderDeleteById(@PathVariable("id") Long resumeId,
                                    HttpSession session) {
        UserForm userForm = (UserForm) session.getAttribute("user");
        userForm = resumeService.deleteById(resumeId, userForm);


        session.setAttribute("user", userForm);

        return "redirect:/main";
    }

    @GetMapping("/addedu")
    public String builderAddEdu(HttpSession session) {
        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");
        System.out.println("Adding " + resumeForm);
        resumeForm.getEducations().add(new EducationForm());
        System.out.println("Size Educations " + resumeForm.getEducations().size());
        return "redirect:/builder";
    }

    //    Blank resume object
    @ModelAttribute("resume")
    public ResumeForm getEmptyUserForm() {
        ResumeForm resumeForm = new ResumeForm();

        List<EducationForm> educationForms = new ArrayList<>();
        educationForms.add(new EducationForm());
        resumeForm.setEducations(educationForms);

        List<SkillForm> skillForms = new ArrayList<>();
        skillForms.add(new SkillForm());
        resumeForm.setSkills(skillForms);

        List<SocialForm> socialForms = new ArrayList<>();
        socialForms.add(new SocialForm());
        resumeForm.setSocials(socialForms);

        List<EmploymentHistoryForm> workExperienceForms = new ArrayList<>();
        workExperienceForms.add(new EmploymentHistoryForm());
        resumeForm.setEmploymentHistory(workExperienceForms);

        return resumeForm;
    }




    int i=0;
    @GetMapping("/reload")
    public String reset(Model model) {

        i++;
        System.out.println(i);
        return "builderTest :: ajax_resume";
    }
}
