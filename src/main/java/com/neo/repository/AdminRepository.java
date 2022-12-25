package com.neo.repository;

import com.neo.dto.AdminDto;
import com.neo.dto.LoginDto;
import com.neo.dto.PartnerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByLogin(LoginDto login);
}
