package com.neo.service;

import java.util.List;

import com.neo.dto.DonorDto;
import com.neo.dto.LoginDto;

public interface DonorService {

	DonorDto saveDonor(DonorDto donorDto);

	DonorDto updateDonor(DonorDto donorDto, Long donorId);

	List<DonorDto> getAllDonors();

	void deleteDonors(Long donorId);

	DonorDto getDonorByLogin(LoginDto loginDto);

}
