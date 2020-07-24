package com.company.resumecv.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "work_experience")
@Data
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String experienceDate;
    private String experienceHeader;
    private String experienceBody;
}
