package com.neo.controller;

import com.neo.constants.AppConstants;
import com.neo.dto.PartnerDto;
import com.neo.payloads.ApiResponse;
import com.neo.service.PartnerService;
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
public class PartnerController {

    Logger logger = LoggerFactory.getLogger(PartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @PostMapping("/partners")
    public ResponseEntity<PartnerDto> savePartner(@Valid @RequestBody PartnerDto partnerDto) {
        logger.info("Initiated request for save the partner details");
        PartnerDto savePartner = this.partnerService.savePartner(partnerDto);
        logger.info("Completed request for save the partner details");
        return new ResponseEntity<>(savePartner, HttpStatus.CREATED);
    }

    @GetMapping("/partners")
    public ResponseEntity<List<PartnerDto>> getAllPartners() {
        logger.info("Initiated request for get all the partner details");
        List<PartnerDto> allPartners = this.partnerService.getAllPartners();
        logger.info("Completed request for get all the partner details");
        return new ResponseEntity<>(allPartners, HttpStatus.OK);
    }

    @PutMapping("/partners/{partnerId}")
    public ResponseEntity<PartnerDto> updatePartner(@Valid @RequestBody PartnerDto partnerDto, @PathVariable Long partnerId) {
        logger.info("Initiated request for update the partner details with:{}", partnerId);
        PartnerDto updatePartner = this.partnerService.updatePartner(partnerDto, partnerId);
        logger.info("Completed request for update the partner details with:{}", partnerId);
        return new ResponseEntity<>(updatePartner, HttpStatus.CREATED);
    }

    @DeleteMapping("/partners/{partnerId}")
    public ResponseEntity<ApiResponse> deletePartner(@PathVariable Long partnerId) {
        logger.info("Initiated request for delete the partner details with:{}", partnerId);
        this.partnerService.deletePartner(partnerId);
        logger.info("Completed request for delete the partner details with:{}", partnerId);
        return new ResponseEntity<>(new ApiResponse(AppConstants.PARTNER_DELETE, true), HttpStatus.OK);
    }


}
