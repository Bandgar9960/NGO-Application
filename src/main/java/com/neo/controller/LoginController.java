package com.neo.controller;

import com.neo.dto.*;
import com.neo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private DonorService donorService;


    @GetMapping("/get/{loginUsername}/{loginPassword}")
    public Object getLogin(@PathVariable String loginUsername, @PathVariable String loginPassword) {
        logger.info("Initiated request for get the login details");
        LoginDto login = this.loginService.getLogin(loginUsername, loginPassword);

        if (login.getLoginType().equalsIgnoreCase("staff")) {
            logger.info("Initiated request for save the staff details");
            StaffDto staffDto = this.staffService.getStaffByLogin(login);
            logger.info("Completed request for save the staff details");
            return staffDto;
        } else if (login.getLoginType().equalsIgnoreCase("admin")) {
            logger.info("Initiated request for save the admin details");
            AdminDto adminDto = this.adminService.getAdminByLogin(login);
            logger.info("Completed request for save the admin details");
            return adminDto;
        } else if (login.getLoginType().equalsIgnoreCase("partner")) {
            logger.info("Initiated request for save the partner details");
            PartnerDto partnerDto = this.partnerService.getPartnerByLogin(login);
            logger.info("Completed request for save the partner details");
            return partnerDto;
        } else if (login.getLoginType().equalsIgnoreCase("donor")) {
            logger.info("Initiated request for save the donor details");
            DonorDto donorDto = this.donorService.getDonorByLogin(login);
            logger.info("Completed request for save the donor details");
            return donorDto;
        }
        return login;
    }
}
