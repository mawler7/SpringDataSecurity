package com.example.SpringDataSecurity.repository;

import com.example.SpringDataSecurity.model.PortalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PortalUser, Integer > {
}
