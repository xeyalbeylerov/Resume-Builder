package com.company.resumecv.form;

import com.company.resumecv.entity.Resume;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.List;


@Data
@EqualsAndHashCode(of = "{id}")
public class UserForm {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<ResumeForm> resumeList;
}
