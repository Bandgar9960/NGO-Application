package com.neo.service.impl;

import com.neo.constants.AppConstants;
import com.neo.dto.LoginDto;
import com.neo.dto.PartnerDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Partner;
import com.neo.repository.PartnerRepository;
import com.neo.service.PartnerService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerServiceImpl implements PartnerService {

    Logger logger = LoggerFactory.getLogger(PartnerService.class);
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PartnerDto savePartner(PartnerDto partnerDto) {
        logger.info("Initiating dao call for the save the partner Details");
        Partner partner = this.modelMapper.map(partnerDto, Partner.class);
        Partner savedPartner = this.partnerRepository.save(partner);
        logger.info("Completed dao call for the save the partner Details");
        return this.modelMapper.map(savedPartner, PartnerDto.class);
    }

    @Override
    public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
        logger.info("Initiating dao call for the update the partner Details with partnerId:{}", partnerId);
        Partner partner = this.partnerRepository.findById(partnerId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + partnerId));
        partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
        partner.setPartnerOrganisation(partnerDto.getPartnerOrganisation());
        partner.setPartnerContact(partnerDto.getPartnerContact());

        Partner updatedPartner = this.partnerRepository.save(partner);
        logger.info("Completed dao call for the update the partner Details with partnerId:{}", partnerId);
        return this.modelMapper.map(updatedPartner, PartnerDto.class);
    }

    @Override
    public List<PartnerDto> getAllPartners() {
        logger.info("Initiating dao call for the get All the partner Details");
        List<Partner> partners = this.partnerRepository.findAll();
        List<PartnerDto> partnerDtos = partners.stream().map((partner) -> this.modelMapper.map(partner, PartnerDto.class)).collect(Collectors.toList());
        logger.info("Completed dao call for the get All the partner Details");
        return partnerDtos;
    }

    @Override
    public void deletePartner(Long partnerId) {
        logger.info("Initiating dao call for the delete the partner Details with partnerId:{}", partnerId);
        Partner partner = this.partnerRepository.findById(partnerId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + partnerId));
        logger.info("Completed dao call for the delete the partner Details with partnerId:{}", partnerId);
        this.partnerRepository.delete(partner);

    }

    @Override
    public PartnerDto getPartnerByLogin(LoginDto loginDto) {
        logger.info("Initiating dao call for the get partner Details for Login");
        Partner partner = this.partnerRepository.findByLogin(loginDto);
        logger.info("Completed dao call for the get partner Details for Login");
        return this.modelMapper.map(partner, PartnerDto.class);
    }
}
