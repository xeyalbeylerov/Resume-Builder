package com.company.resumecv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "work_experience")
@Data
@EqualsAndHashCode(of = "id")
public class EmploymentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String experienceDate;
    private String experienceHeader;
    private String experienceBody;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="resume_id")
//    private Resume resume;

}
