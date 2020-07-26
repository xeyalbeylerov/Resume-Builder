package com.company.resumecv.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "resume")
@Data
@EqualsAndHashCode(of = "id")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<WorkExperience> workExperience;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Education> educations;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Skill> skills;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Social> socials;
}
