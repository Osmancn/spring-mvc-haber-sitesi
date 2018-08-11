package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;


    @Override
    public void save(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder() ;
        String encodePass = passwordEncoder.encode(user.getSifre());
        user.setSifre(encodePass);
        userRepository.save(user);
        //TODO eposta doğrulama işlemleri yapılacak
    }
}
