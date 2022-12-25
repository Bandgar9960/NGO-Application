package com.neo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.neo.constants.AppConstants;
import com.neo.dto.DonorDto;
import com.neo.dto.LoginDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Donor;
import com.neo.repository.DonorRepository;
import com.neo.service.DonorService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorServiceImpl implements DonorService {

    Logger logger = LoggerFactory.getLogger(DonorServiceImpl.class);
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DonorDto saveDonor(DonorDto donorDto) {
        logger.info("Initiating dao call for the save the donor Details");
        Donor donor = this.modelMapper.map(donorDto, Donor.class);
        Donor saveDonor = this.donorRepository.save(donor);
        logger.info("Completed dao call for the save the donor Details");
        return this.modelMapper.map(saveDonor, DonorDto.class);
    }

    @Override
    public DonorDto updateDonor(DonorDto donorDto, Long donorId) {
        logger.info("Initiating dao call for the update the donor Details with donorId :{}", donorId);
        Donor donor = this.donorRepository.findById(donorId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + donorId));
        donor.setDonorName(donorDto.getDonorName());
        donor.setDonorPAN(donorDto.getDonorPAN());
        donor.setDonorDOB(donorDto.getDonorDOB());
        donor.setDonorAmount(donorDto.getDonorAmount());
        donor.setDonorContact(donorDto.getDonorContact());
        donor.setDonorGender(donorDto.getDonorGender());

        Donor updatedDonor = this.donorRepository.save(donor);
        logger.info("Completed dao call for the update the donor Details with donorId :{}", donorId);
        return this.modelMapper.map(updatedDonor, DonorDto.class);
    }

    @Override
    public List<DonorDto> getAllDonors() {
        logger.info("Initiating dao call for the get All the donor Details");
        List<Donor> donors = this.donorRepository.findAll();
        List<DonorDto> donorDtos = donors.stream().map((donor) -> this.modelMapper.map(donor, DonorDto.class)).collect(Collectors.toList());
        logger.info("Initiating dao call for the get All the donor Details");
        return donorDtos;
    }

    @Override
    public void deleteDonors(Long donorId) {
        logger.info("Completed dao call for the delete the donor Details with donorId :{}", donorId);
        Donor donor = this.donorRepository.findById(donorId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + donorId));
        logger.info("Completed dao call for the delete the donor Details with donorId :{}", donorId);
        this.donorRepository.delete(donor);

    }

    @Override
    public DonorDto getDonorByLogin(LoginDto loginDto) {
        logger.info("Initiating dao call for the get the donor details for login");
        Donor donor = this.donorRepository.findByLogin(loginDto);
        logger.info("Completed dao call for the get the donor details for login");
        return this.modelMapper.map(donor, DonorDto.class);
    }

}
