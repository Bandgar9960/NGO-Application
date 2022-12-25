package com.neo.repository;

import com.neo.dto.DonorDto;
import com.neo.dto.LoginDto;
import com.neo.dto.PartnerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{

    Donor findByLogin(LoginDto login);

}
