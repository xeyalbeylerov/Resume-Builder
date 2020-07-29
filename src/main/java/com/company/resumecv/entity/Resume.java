package com.company.resumecv.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resume")
@Data
@EqualsAndHashCode(of = "id")
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String resumeTitle;
    private String jobTitle;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String surname;
    private String vocation;
    private String address;
    private String country;
    private String city;
    private String nationality;
    private String birthplace;
    private Date birthDate;
    private String phone;
    private String email;
    private String website;
    private String about;
    private String imageName;
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<EmploymentHistory> employmentHistory;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Education> educations;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Skill> skills;
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Social> socials;

//    @OneToMany(mappedBy="resume",orphanRemoval = true, cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<EmploymentHistory> employmentHistory;
//    @OneToMany(mappedBy="resume",orphanRemoval = true, cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Education> educations;
//    @OneToMany(mappedBy="resume",orphanRemoval = true, cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Skill> skills;
//    @OneToMany(mappedBy="resume",orphanRemoval = true, cascade = CascadeType.ALL)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<Social> socials;
}
