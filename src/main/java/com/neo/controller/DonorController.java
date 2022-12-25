package com.neo.controller;

import com.neo.constants.AppConstants;
import com.neo.dto.DonorDto;
import com.neo.payloads.ApiResponse;
import com.neo.service.DonorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DonorController {

    Logger logger = LoggerFactory.getLogger(DonorController.class);
    @Autowired
    private DonorService donorService;

    @PostMapping("/donors")
    public ResponseEntity<DonorDto> saveDonor(@Valid @RequestBody DonorDto donorDto) {
        logger.info("Initiated request for save the donor details");
        DonorDto saveDonor = this.donorService.saveDonor(donorDto);
        logger.info("Completed request for save the donor details");
        return new ResponseEntity<>(saveDonor, HttpStatus.CREATED);
    }

    @GetMapping("/donors")
    public ResponseEntity<List<DonorDto>> getAllDonors() {
        logger.info("Initiated request for get all the donor details");
        List<DonorDto> allDonors = this.donorService.getAllDonors();
        logger.info("Completed request for get all the donor details");
        return new ResponseEntity<>(allDonors, HttpStatus.OK);
    }

    @PutMapping("/donors/{donorId}")
    public ResponseEntity<DonorDto> updateDonor(@Valid @RequestBody DonorDto donorDto, @PathVariable Long donorId) {
        logger.info("Initiated request for update the donor details with donorId:{}", donorId);
        DonorDto updateDonor = this.donorService.updateDonor(donorDto, donorId);
        logger.info("Completed request for update the donor details with donorId:{}", donorId);
        return new ResponseEntity<>(updateDonor, HttpStatus.CREATED);
    }

    @DeleteMapping("/donors/{donorId}")
    public ResponseEntity<ApiResponse> deleteDonor(@PathVariable Long donorId) {
        logger.info("Initiated request for delete the donor details with donorId:{}", donorId);
        this.donorService.deleteDonors(donorId);
        logger.info("Initiated request for delete the donor details with donorId:{}", donorId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.DONOR_DELETE, true), HttpStatus.CREATED);
    }

}
