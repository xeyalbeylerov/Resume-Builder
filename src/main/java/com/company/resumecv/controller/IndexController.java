package com.company.resumecv.controller;

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

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class IndexController {


    @GetMapping
    public String builder(Model model) {
        return "index";
    }

}
