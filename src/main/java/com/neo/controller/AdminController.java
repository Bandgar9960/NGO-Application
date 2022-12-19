package com.neo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.constants.AppConstants;
import com.neo.dto.AdminDto;
import com.neo.payloads.ApiResponse;
import com.neo.service.AdminService;

//Validation , Validation Handle
@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * @author Dnyaneshwar
	 * @apiNote This Api is to save admin data
	 * @param adminDto
	 * @return
	 */

	@PostMapping("/admins")
	public ResponseEntity<AdminDto> saveAdmin(@Valid @RequestBody AdminDto adminDto) {
		logger.info("Initiated request for save the Admin details");
		AdminDto saveAdmin = this.adminService.saveAdmin(adminDto);
		logger.info("Completed request for save the Admin details");
		return new ResponseEntity<AdminDto>(saveAdmin, HttpStatus.CREATED);

	}

	/**
	 * @apiNote This api is for get AllAdmin details
	 * @return
	 */

	@GetMapping("/admins")
	public ResponseEntity<List<AdminDto>> getAllAdmin() {
		logger.info("Initiated request for get all Admin details");
		List<AdminDto> allAdmin = this.adminService.getAllAdmin();
		logger.info("Completed request for get all Admin details");
		return new ResponseEntity<List<AdminDto>>(allAdmin, HttpStatus.OK);

	}

	/**
	 * @apiNote This api is for update the admin details
	 * @param adminDto
	 * @param adminId
	 * @return
	 */

	@PutMapping("/admins/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin(@Valid @RequestBody AdminDto adminDto, @PathVariable Long adminId) {
		logger.info("Initiated request for update the Admin details with adminId:{}", adminId);
		AdminDto updateAdmin = this.adminService.updateAdmin(adminDto, adminId);
		logger.info("Completed request for update the Admin details with adminId:{}", adminId);
		return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.CREATED);

	}

	/**
	 * @apiNote This api is used for delete the admin
	 * @param adminId
	 * @return
	 */
	@DeleteMapping("/admins/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long adminId) {
		logger.info("Initiated request for delete the Admin details with adminId : {}", adminId);
		this.adminService.deleteAdmin(adminId);
		logger.info("Completed request for delete the Admin details with adminId : {}", adminId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.ADMIN_DELETE, false), HttpStatus.OK);

	}

}
