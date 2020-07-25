package com.company.resumecv;

import com.company.resumecv.config.ResumeInitializerForTest;
import com.company.resumecv.entity.*;
import com.company.resumecv.form.*;
import com.company.resumecv.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ResumeCvApplication {
    private final ResumeService resumeService;
    private final ResumeInitializerForTest resumeInitializer;

    public static void main(String[] args) {
        SpringApplication.run(ResumeCvApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void applicationStarter() {
        ResumeForm resume=resumeService.save(resumeInitializer.resumeBuilder());
    }



}
