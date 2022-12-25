package com.neo.service;

import java.util.List;

import com.neo.dto.AdminDto;
import com.neo.dto.LoginDto;

public interface AdminService {

	AdminDto saveAdmin(AdminDto adminDto);

	AdminDto updateAdmin(AdminDto adminDto, Long adminId);

	List<AdminDto> getAllAdmin();
	
	void deleteAdmin(Long adminId);

	AdminDto getAdminByLogin(LoginDto loginDto);

}
