package com.neo.service;

import java.util.List;

import com.neo.dto.DonorDto;

public interface DonorService {

	DonorDto saveDonor(DonorDto staffDto);

	DonorDto updateDonor(DonorDto staffDto, Long donorId);

	List<DonorDto> getAllStaff();

	void deleteStaff(Long donorId);

}
