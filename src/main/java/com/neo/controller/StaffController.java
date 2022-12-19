package com.neo.controller;

import java.util.List;

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
import com.neo.dto.StaffDto;
import com.neo.payloads.ApiResponse;
import com.neo.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	Logger logger =LoggerFactory.getLogger(StaffController.class);
    
	/**
	 * @apiNote This api is for the save the staff details
	 * @param staffDto
	 * @return
	 */
	@PostMapping("/staff")
	public ResponseEntity<StaffDto> saveStaff(@RequestBody StaffDto staffDto) {
		logger.info("Initiated request for save the staff details");
		StaffDto staff = this.staffService.saveStaff(staffDto);
		logger.info("Completed request for save the staff details");
		return new ResponseEntity<StaffDto>(staff, HttpStatus.CREATED);

	}
    /**
     * @apiNote This api is for the update the staff details
     * @param staffDto
     * @param staffId
     * @return
     */
	@PutMapping("/{staffId}")
	public ResponseEntity<StaffDto> updateStaff(@RequestBody StaffDto staffDto, @PathVariable Long staffId) {
		logger.info("Initiated request for update the staff details with staffId:{}", staffId);
		StaffDto updateStaff = this.staffService.updateStaff(staffDto, staffId);
		logger.info("Completed request for update the staff details with staffId:{}", staffId);
		return new ResponseEntity<StaffDto>(updateStaff, HttpStatus.CREATED);

	}
    
	/**
	 * @apiNote This api is for get all staff
	 * @return
	 */
	@GetMapping("/staff")
	public ResponseEntity<List<StaffDto>> getAllStaff() {
		logger.info("Initiated request for get all staff details");
		List<StaffDto> allStaff = this.staffService.getAllStaff();
		logger.info("Completed request for get all staff details");
		return new ResponseEntity<List<StaffDto>>(allStaff, HttpStatus.OK);

	}
	/**
	 * @apiNote This api is for delete the staff
	 * @param staffId
	 * @return
	 */

	@DeleteMapping("/{staffId}")
	public ResponseEntity<ApiResponse> deleteStaff(@PathVariable Long staffId) {
		logger.info("Initiated request for delete the staff details with adminId : {}", staffId);
		this.staffService.deleteStaff(staffId);
		logger.info("Completed request for delete the staff details with adminId : {}", staffId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.STAFF_DELETE, false), HttpStatus.OK);

	}

}
