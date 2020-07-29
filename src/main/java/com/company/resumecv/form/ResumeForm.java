package com.company.resumecv.form;


import com.company.resumecv.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Data
@EqualsAndHashCode(of = "id")
public class ResumeForm {
    private Long id;
    private String resumeTitle;
    private String jobTitle;
    private String name;
    private String surname;
    private String vocation;
    private String address;
    private String city;
    private String country;
    private String nationality;
    private String birthplace;
    private Date birthDate;
    private String phone;
    private String email;
    private String website;
    private String about;
    private String imageName;
    private List<EmploymentHistoryForm> employmentHistory;
    private List<EducationForm> educations;
    private List<SkillForm> skills;
    private List<SocialForm> socials;

    private UserForm userForm;

}
