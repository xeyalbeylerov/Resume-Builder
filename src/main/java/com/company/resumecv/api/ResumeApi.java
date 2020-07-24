package com.company.resumecv.api;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.form.ResumeForm;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResumeApi {
    private final ResumeService resumeService;

    @GetMapping
    public List<ResumeForm> getAllList() {
        return resumeService.getAll();
    }
}
