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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
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
        log.info("Resume saved " + resume);
        return resumeForm;
    }

    @Transactional
    public ResumeForm update(ResumeForm resumeForm) {
        Assert.notNull(resumeForm.getId(), "ResumeForm Id can not be null");
        Resume resume = modelMapper.map(resumeForm, Resume.class);
        resume = repository.save(resume);
        log.info("Resume updated " + resume);
        return resumeForm;
    }

    public List<ResumeForm> findAll() {
        List<Resume> resumes = repository.findAll();
//        ModelMapper List converter
        List<ResumeForm> resumeForms = modelMapper.map(resumes, new TypeToken<List<ResumeForm>>() {
        }.getType());
        return resumeForms;
    }

    public ResumeForm findById(Long id) {
        Resume resume = repository.getOne(id);
        ResumeForm resumeForms = modelMapper.map(resume, ResumeForm.class);
        return resumeForms;
    }

    @Transactional
    public void deleteById(Long id) {
        Assert.notNull(id, "ResumeForm Id can not be null while delete resume");
        repository.deleteById(id);
    }

    public ResumeForm imageUpload(ResumeForm resumeForm, MultipartFile img) throws Exception {
//        generate image name by resumeId+imageName.Example:1_Image
        String imgName = resumeForm.getId() + "_" + img.getOriginalFilename();

//        setting image name on resume
        resumeForm.setImageName(imgName);

//        print image name
        System.out.println("imgName " + imgName);

//      set folder and image name
        File upl = new File("images/" + imgName);

//      Creating new file.Folder must be created before
        upl.createNewFile();

//        write bytes to image file
        FileOutputStream fout = new FileOutputStream(upl);
        fout.write(img.getBytes());
        fout.close();

        ResumeForm updateResume = update(resumeForm);
        return updateResume;
    }
}
