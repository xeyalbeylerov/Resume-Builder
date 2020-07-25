package com.company.resumecv.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Resume> resumeList;
}
