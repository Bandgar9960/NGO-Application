package com.neo.service;

import java.util.List;

import com.neo.dto.StaffDto;

public interface StaffService {
	
	StaffDto saveStaff(StaffDto staffDto);

	StaffDto updateStaff(StaffDto staffDto, Long staffId);

	List<StaffDto> getAllStaff();
	
	void deleteStaff(Long staffId);

}
