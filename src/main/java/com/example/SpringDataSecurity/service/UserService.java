package com.example.SpringDataSecurity.service;

import com.example.SpringDataSecurity.model.Order;
import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<PortalUser> getAllUsers();

    Page<PortalUser> getUsersPaginated(Pageable pageable);
}
