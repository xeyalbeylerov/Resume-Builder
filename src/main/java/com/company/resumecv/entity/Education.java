package com.company.resumecv.entity;

import com.company.resumecv.form.ResumeForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "education")
@Data
@EqualsAndHashCode(of = "id")
public class Education implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String educationDate;
    private String educationHeader;
    private String educationBody;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="resume_id")
//    private Resume resume;
}
