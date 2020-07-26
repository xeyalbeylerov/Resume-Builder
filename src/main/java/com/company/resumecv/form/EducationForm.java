package com.company.resumecv.form;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class EducationForm {

    private String educationDate;
    private String educationHeader;
    private String educationBody;
}
