package com.company.resumecv.service;

import com.company.resumecv.entity.User;
import com.company.resumecv.form.UserForm;
import com.company.resumecv.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Log4j2
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ResumeService resumeService;

    @Transactional
    public UserForm save(UserForm userForm) {
        User user = modelMapper.map(userForm, User.class);
        user = userRepository.save(user);
        userForm.setId(user.getId());
        log.info("User registered " + userForm);
        return userForm;
    }

    @Transactional
    public UserForm update(UserForm userForm) {
        Assert.notNull(userForm.getId(), "UserForm Id can not be null while update");
        User user = modelMapper.map(userForm, User.class);
        user = userRepository.save(user);
        userForm.setId(user.getId());
        log.info("User saved " + userForm);
        return userForm;
    }

    public UserForm findById(Long id) {
        Assert.notNull(id, "Id can not be null while find by id");
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserForm.class);
    }

    public Boolean existsByResumeId(Long id) {
        Assert.notNull(id, "Id can not be null while checking");
        Boolean isExists = userRepository.existsById(id);
        return isExists;
    }


//    public UserForm saveResumeWithUser(){
//
//
//    }
//    public UserForm updateResumeWithUser(){
//
//    }
}
