package com.company.resumecv.form;

import com.company.resumecv.entity.Resume;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class EmploymentHistoryForm {
    private Long id;
    private String experienceDate;
    private String experienceHeader;
    private String experienceBody;
//    private ResumeForm resumeForm;
}
