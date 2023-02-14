package com.neo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.neo.dto.LoginDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.constants.AppConstants;
import com.neo.dto.AdminDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Admin;
import com.neo.repository.AdminRepository;
import com.neo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        logger.info("Initiating dao call for the save the admin Details");
        Admin admin = this.modelMapper.map(adminDto, Admin.class);
        Admin saveAdmin = this.adminRepository.save(admin);
        logger.info("Completed dao call for the save the admin Details");
        return this.modelMapper.map(saveAdmin, AdminDto.class);
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto, Long adminId) {

        logger.info("Initiating dao call for the update the admin details with : {}", adminId);
        Admin admin = this.adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + adminId));


        admin.setAdminName(adminDto.getAdminName());
        admin.setAdminContact(adminDto.getAdminContact());
        admin.setAdminGender(adminDto.getAdminGender());
        admin.setAdminAadhar(adminDto.getAdminAadhar());


        Admin updatedAdmin = this.adminRepository.save(admin);
        logger.info("Completed dao call for the update the admin details with :{}", adminId);

        return this.modelMapper.map(updatedAdmin, AdminDto.class);
    }

    // Entity - Database
    // Dto - UI FrondEnd

    @Override
    public List<AdminDto> getAllAdmin() {
        logger.info("Initiating dao call for the get all the admin");
        List<Admin> listAdmin = this.adminRepository.findAll();
        List<AdminDto> listDtos = listAdmin.stream().map((admin) -> this.modelMapper.map(admin, AdminDto.class))
                .collect(Collectors.toList());
        logger.info("Completed dao call for the get all the admin");
        return listDtos;
    }

    @Override
    public void deleteAdmin(Long adminId) {
        logger.info("Initiating dao call for the delete the admin details with :{}", adminId);
        Admin admin = this.adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + adminId));
        logger.info("Completed dao call for the delete the admin details with :{}", adminId);

        this.adminRepository.delete(admin);

    }

    @Override
    public AdminDto getAdminByLogin(LoginDto loginDto) {
        logger.info("Initiating dao call for the get the admin details for login");
        Admin admin = this.adminRepository.findByLogin(loginDto);
        logger.info("Completed dao call for the get the admin details for login");
        return this.modelMapper.map(admin, AdminDto.class);
    }

}
