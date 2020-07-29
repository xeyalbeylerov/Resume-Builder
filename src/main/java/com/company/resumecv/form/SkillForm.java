package com.company.resumecv.form;

import com.company.resumecv.entity.Resume;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class SkillForm {
    private Long id;
    private String skillName;
    private int power;
//    private ResumeForm resumeForm;
}
