package com.company.resumecv.form;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class SkillForm {

    private String skillName;
    private int power;
}
