//package com.company.resumecv.controller;
//
//import com.company.resumecv.config.ResumeInitializerForTest;
//import com.company.resumecv.form.ResumeForm;
//import com.company.resumecv.service.Html2Pdf;
//import com.company.resumecv.service.ResumeService;
//import com.company.resumecv.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping(value = "/generate")
//@RequiredArgsConstructor
//public class GeneratePdfController {
//    private final ResumeService resumeService;
//    private final Html2Pdf generatePdf;
//
//    @GetMapping("/{id}")
//    public String generatePdf(@PathVariable("id") Long id, Model model) {
//        ResumeForm resumeForm = resumeService.findById(id);
//        String inputUrl = "http://localhost:8080/resume/" + id;
//        String outputUrl = "TestPdf_" + id + ".pdf";
//        generatePdf.generatePDF(inputUrl);
//
//        model.addAttribute("resume", resumeForm);
//        return "resume";
//    }
//}
