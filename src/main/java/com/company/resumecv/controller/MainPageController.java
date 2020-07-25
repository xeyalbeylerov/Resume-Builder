package com.company.resumecv.controller;

import com.company.resumecv.config.ResumeInitializerForTest;
import com.company.resumecv.form.ResumeForm;
import com.company.resumecv.form.UserForm;
import com.company.resumecv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/main")
@RequiredArgsConstructor
public class MainPageController {
    private final UserService userService;
    private final ResumeInitializerForTest resumeInitializer;

    @GetMapping
    public String userRegister(Model model, HttpSession session) {
        UserForm userForm=(UserForm) session.getAttribute("user");
        model.addAttribute("user",userForm);
        return "main";
    }

    //    Blank resume object
    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        UserForm userForm=new UserForm();
        userForm.setId(1l);
        userForm.setName("Test name");
        userForm.setSurname("Test surname");
        userForm.setEmail("test email");
        userForm.setPassword("test password");

//        ResumeForm resumeForm = resumeInitializer.resumeBuilder();
//        ResumeForm resumeForm2 = resumeInitializer.resumeBuilder();
//        ResumeForm resumeForm3 = resumeInitializer.resumeBuilder();
//        ResumeForm resumeForm4 = resumeInitializer.resumeBuilder();
//        userForm.setResumeList(Arrays.asList(resumeForm,resumeForm2,resumeForm3,resumeForm4));
        return userForm;
    }
}
