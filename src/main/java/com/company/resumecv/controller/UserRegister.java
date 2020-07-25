package com.company.resumecv.controller;

import com.company.resumecv.form.*;
import com.company.resumecv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserRegister {
    private final UserService userService;

    //    Register ucun blank model qaytarir
    @GetMapping
    public String userRegister(Model model) {
        return "user";
    }


    //    yeni user alib register edir ve sessiona add edir
    @PostMapping
    public String userRegister(Model model,
                               @ModelAttribute("user") UserForm userForm,
                               HttpSession session) {
        userForm = userService.save(userForm);
        session.setAttribute("user", userForm);
        return "main";
    }

    //    Blank resume object for register
    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        UserForm userForm = new UserForm();
        return userForm;
    }
}
