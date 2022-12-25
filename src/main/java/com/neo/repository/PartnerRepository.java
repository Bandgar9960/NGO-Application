package com.neo.repository;

import com.neo.dto.LoginDto;
import com.neo.dto.PartnerDto;
import com.neo.dto.StaffDto;
import com.neo.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner,Long> {

    Partner findByLogin(LoginDto login);
}
