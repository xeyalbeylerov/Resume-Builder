package com.company.resumecv.service;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.form.ResumeForm;
import com.company.resumecv.repo.ResumeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class ResumeService {
    private final ResumeRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public ResumeForm save(ResumeForm resumeForm) {
        Resume resume = modelMapper.map(resumeForm, Resume.class);
        resume = repository.save(resume);
        resumeForm.setId(resume.getId());
        System.out.println(resume);
        log.info("Resume saved "+resume);
        return resumeForm;
    }
    @Transactional
    public ResumeForm update(ResumeForm resumeForm) {
        Assert.notNull(resumeForm.getId(),"ResumeForm Id can not be null");
        Resume resume = modelMapper.map(resumeForm, Resume.class);
        resume = repository.save(resume);
        log.info("Resume updated "+resume);
        return resumeForm;
    }

    public List<ResumeForm> getAll() {
        List<Resume> resumes=repository.findAll();
//        ModelMapper List converter
        List<ResumeForm> resumeForms=modelMapper.map(resumes,new TypeToken<List<ResumeForm>>() {}.getType());
        return resumeForms;
    }
    public ResumeForm findById(Long id) {
       Resume resume=repository.getOne(id);
       ResumeForm resumeForms=modelMapper.map(resume,ResumeForm.class);
        return resumeForms;
    }
}
