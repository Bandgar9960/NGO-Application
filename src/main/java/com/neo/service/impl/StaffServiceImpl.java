package com.neo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.constants.AppConstants;
import com.neo.dto.StaffDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Staff;
import com.neo.repository.StaffRepository;
import com.neo.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Override
	public StaffDto saveStaff(StaffDto staffDto) {
		logger.info("Initiating dao call for the save the staff Details");
		Staff staff = this.modelMapper.map(staffDto, Staff.class);
		Staff saveStaff = this.staffRepository.save(staff);
		StaffDto Staffdto = this.modelMapper.map(saveStaff, StaffDto.class);
		logger.info("Completed dao call for the save the staff Details");
		return Staffdto;
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		logger.info("Initiating dao call for the update the staff Details with staffId :{}", staffId);
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + staffId));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffAadhar(staffDto.getStaffAadhar());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffDepartment(staffDto.getStaffDepartment());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffDOB(staffDto.getStaffDOB());
		staff.setStaffGender(staffDto.getStaffGender());
	
		Staff updatedStaff = this.staffRepository.save(staff);
		logger.info("Completed dao call for the update the staff Details with staffId :{}", staffId);
		return this.modelMapper.map(updatedStaff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		logger.info("Initiating dao call for the get all the staff Details ");
		List<Staff> list = this.staffRepository.findAll();
		List<StaffDto> staffDtolist = list.stream().map((staff) -> this.modelMapper.map(staff, StaffDto.class))
				.collect(Collectors.toList());
		logger.info("Completed dao call for the get all the staff Details ");
		return staffDtolist;
	}

	@Override
	public void deleteStaff(Long staffId) {
		logger.info("Initiating dao call for the delete the staff Details with staffId :{}", staffId);
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + staffId));
		logger.info("Completed dao call for the delete the staff Details with staffId :{}", staffId);
		this.staffRepository.delete(staff);

	}

}
