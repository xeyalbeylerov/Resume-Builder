package com.company.resumecv.form;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class WorkExperienceForm {

    private String experienceDate;
    private String experienceHeader;
    private String experienceBody;
}
