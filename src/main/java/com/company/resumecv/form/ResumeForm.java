package com.company.resumecv.form;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(of = "{id}")
public class ResumeForm {
    private Long id;
    private String resumeTitle;
    private String name;
    private String surname;
    private String vocation;
    private String address;
    private String country;
    private String phone;
    private String email;
    private String website;
    private String aboutUs;
    private List<WorkExperienceForm> workExperience;
    private List<EducationForm> educations;
    private List<SkillForm> skills;
    private List<SocialForm> socials;
}
