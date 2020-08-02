package com.company.resumecv.controller;

import com.company.resumecv.form.ResumeForm;
import com.company.resumecv.service.PdfService;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;


@Controller
@RequestMapping(value = "/pdf")
@RequiredArgsConstructor
public class PdfController {
    private final PdfService pdfService;
    private final ResumeService resumeService;


//    @GetMapping("/{id}")
//    public String generate(@PathVariable("id") String id, HttpSession session) throws Exception {
//        String s = generatePdf.urlToString("http://localhost:8080/resume/" + id);
//        System.out.println(s);
//        generatePdf.stringToPdf(s);
//
//        return "index";
//    }

//  @GetMapping("/{id}")
//  @ResponseBody
//    public FileSystemResource generate(@PathVariable("id") String id, HttpSession session) throws Exception {
//      OutputStream outputStream = generatePdf.generatePdf(null);
//      return new FileSystemResource(outputStream.toString());
//    }

    @GetMapping("/generate")
    public String generateBySession(HttpSession session) throws Exception {
        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");
        pdfService.generatePdf(resumeForm);

        return "redirect:/builder";
    }

    @GetMapping("/generate/{id}")
    public String generateById(@PathVariable("id") Long id, HttpSession session) throws Exception {
        ResumeForm resumeForm = resumeService.findById(id);
        resumeForm = pdfService.generatePdf(resumeForm);
        session.setAttribute("resume", resumeForm);
        return "main";
    }


    @GetMapping(value = "/download/{id}",produces = "application/pdf")
    @ResponseBody
    public FileSystemResource downloadResumeById(@PathVariable("id") Long id) throws Exception {
        ResumeForm resumeForm = resumeService.findById(id);
        pdfService.generatePdf(resumeForm);
        return pdfService.getPdfFile(resumeForm);
    }

    @GetMapping(value = "/download",produces = "application/pdf")
    @ResponseBody
    public FileSystemResource downloadResumeBySession(HttpSession session) throws Exception {
        ResumeForm resumeForm = (ResumeForm) session.getAttribute("resume");
        pdfService.generatePdf(resumeForm);
        return pdfService.getPdfFile(resumeForm);
    }
}
