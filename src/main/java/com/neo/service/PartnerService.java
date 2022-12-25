package com.neo.service;

import com.neo.dto.LoginDto;
import com.neo.dto.PartnerDto;

import java.util.List;

public interface PartnerService {

    PartnerDto savePartner(PartnerDto partnerDto);

    PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId);

    List<PartnerDto> getAllPartners();

    void deletePartner(Long partnerId);

    PartnerDto getPartnerByLogin(LoginDto loginDto);


}
