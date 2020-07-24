package com.company.resumecv.service;

import com.company.resumecv.entity.Resume;
import com.company.resumecv.form.ResumeForm;
import com.company.resumecv.repo.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResumeService {
    private final ResumeRepository repository;
    private final ModelMapper modelMapper;

    @Transactional
    public ResumeForm save(ResumeForm resumeForm) {
        Resume resume = modelMapper.map(resumeForm, Resume.class);
        resume = repository.save(resume);
        System.out.println(resume);
        return resumeForm;
    }

    public List<ResumeForm> getAll() {
        List<Resume> resumes=repository.findAll();
//        ModelMapper List converter
        List<ResumeForm> resumeForms=modelMapper.map(resumes,new TypeToken<List<ResumeForm>>() {}.getType());
        return resumeForms;
    }
}
