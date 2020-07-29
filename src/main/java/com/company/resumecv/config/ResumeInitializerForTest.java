package com.company.resumecv.config;

import com.company.resumecv.form.*;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ResumeInitializerForTest {
    public ResumeForm getEmptyResumeForm() {
        ResumeForm resumeForm = new ResumeForm();
        resumeForm.setEducations(Arrays.asList(new EducationForm()));
        resumeForm.setSkills(Arrays.asList(new SkillForm()));
        resumeForm.setSocials(Arrays.asList(new SocialForm()));
        resumeForm.setEmploymentHistory(Arrays.asList(new EmploymentHistoryForm()));
        return resumeForm;
    }

    public ResumeForm resumeBuilder() {
        ResumeForm resume = new ResumeForm();
        resume.setAbout("Haqqimdakilar bu qeder2");
        resume.setEmploymentHistory(workExperienceBuilder());
        resume.setEducations(educationBuilder());

        resume.setResumeTitle("Resume for work");
        resume.setName("Khayal");
        resume.setSurname("Baylarov");
        resume.setVocation("Java programmer");
        resume.setCountry("Azerbaijan");
        resume.setAddress("Baku");
        resume.setPhone("+994519140605");
        resume.setEmail("xeyalbeylerov@mail.ru");
        resume.setWebsite("This site");
        resume.setSkills(skillBuilder());
        resume.setSocials(socialBuilder());
        return resume;
    }

    private List<EmploymentHistoryForm> workExperienceBuilder() {
        List<EmploymentHistoryForm> workExperiences = new ArrayList<>();

        EmploymentHistoryForm experience = new EmploymentHistoryForm();
        experience.setExperienceDate("2013 - 2015");
        experience.setExperienceHeader("Azercellde");
        experience.setExperienceBody("Azercellde islemisem  rem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, volupta");

        EmploymentHistoryForm experience2 = new EmploymentHistoryForm();
        experience2.setExperienceDate("2011 - 2015");
        experience2.setExperienceHeader("Narda");
        experience2.setExperienceBody("Narda islemisem  rem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, volupta");


        EmploymentHistoryForm experience3 = new EmploymentHistoryForm();
        experience3.setExperienceDate("2012 - 2015");
        experience3.setExperienceHeader("Bakcellde");
        experience3.setExperienceBody("Bakcellde islemisem  rem ipsum dolor sit amet consectetur adipisicing elit. Nostrum, volupta");

        workExperiences.add(experience);
        workExperiences.add(experience2);
        workExperiences.add(experience3);
        return workExperiences;
    }

    private List<EducationForm> educationBuilder() {
        List<EducationForm> educations = new ArrayList<>();
        EducationForm education = new EducationForm();
        education.setEducationDate("2000 - 2010");
        education.setEducationHeader("Bku State University");
        education.setEducationBody("Bit. Nostrum, voluptatibus!");

        EducationForm education2 = new EducationForm();
        education2.setEducationDate("2000 - 2010");
        education2.setEducationHeader("Bku Germany University");
        education2.setEducationBody("Bit. Nostrum, Germany!");

        educations.add(education);
        educations.add(education2);
        return educations;
    }

    private List<SkillForm> skillBuilder() {
        List<SkillForm> skills = new ArrayList<>();

        SkillForm skill = new SkillForm();
        skill.setSkillName("Java");
        skill.setPower(100);

        SkillForm skill2 = new SkillForm();
        skill2.setSkillName("JS");
        skill2.setPower(40);

        SkillForm skill3 = new SkillForm();
        skill3.setSkillName("CSS");
        skill3.setPower(50);

        SkillForm skill4 = new SkillForm();
        skill4.setSkillName("MySQL");
        skill4.setPower(80);

        SkillForm skill5 = new SkillForm();
        skill5.setSkillName("Spring");
        skill5.setPower(100);

        skills.add(skill);
        skills.add(skill2);
        skills.add(skill3);
        skills.add(skill4);
        skills.add(skill5);
        return skills;
    }

    private List<SocialForm> socialBuilder() {
        List<SocialForm> socials = new ArrayList<>();

        SocialForm social = new SocialForm();
        social.setSocialNetworkName("Facebook");
        social.setSocialNetworkAddress("xeyalbeylerov@facebook");

        SocialForm social2 = new SocialForm();
        social2.setSocialNetworkName("Twitter");
        social2.setSocialNetworkAddress("xeyalbeylerov@Twitter");

        SocialForm social3 = new SocialForm();
        social3.setSocialNetworkName("Youtube");
        social3.setSocialNetworkAddress("xeyalbeylerov@Youtube");

        SocialForm social4 = new SocialForm();
        social4.setSocialNetworkName("Linkedin");
        social4.setSocialNetworkAddress("xeyalbeylerov@Linkedin");

        socials.add(social);
        socials.add(social2);
        socials.add(social3);
        socials.add(social4);
        return socials;
    }
}
