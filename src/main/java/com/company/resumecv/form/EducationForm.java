package com.company.resumecv.form;

import com.company.resumecv.entity.Resume;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class EducationForm {
    private Long id;
    private String educationDate;
    private String educationHeader;
    private String educationBody;
//    private ResumeForm resumeForm;
}
