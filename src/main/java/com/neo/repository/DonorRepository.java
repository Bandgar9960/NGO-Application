package com.neo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{

}
