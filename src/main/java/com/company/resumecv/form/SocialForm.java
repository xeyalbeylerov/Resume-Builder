package com.company.resumecv.form;

import com.company.resumecv.entity.Resume;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(of = "id")
public class SocialForm {
    private Long id;
    private String socialNetworkName;
    private String socialNetworkAddress;
//    private ResumeForm resumeForm;
}
