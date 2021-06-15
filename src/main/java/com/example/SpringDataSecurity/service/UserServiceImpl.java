package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.PortalUser;
import com.example.SpringDataSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<PortalUser> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Page<PortalUser> getUsersPaginated(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    ;


}
