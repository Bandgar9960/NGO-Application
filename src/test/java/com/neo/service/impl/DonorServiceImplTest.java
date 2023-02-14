package com.neo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.neo.dto.DonorDto;
import com.neo.dto.LoginDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Address;
import com.neo.model.Donor;
import com.neo.model.Login;
import com.neo.repository.DonorRepository;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DonorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DonorServiceImplTest {
    @MockBean
    private DonorRepository donorRepository;

    @Autowired
    private DonorServiceImpl donorServiceImpl;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link DonorServiceImpl#saveDonor(DonorDto)}
     */
    @Test
    void testSaveDonor() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        when(donorRepository.save((Donor) any())).thenReturn(donor);
        when(modelMapper.map((Object) any(), (Class<Object>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.saveDonor(new DonorDto()));
        verify(modelMapper).map((Object) any(), (Class<Donor>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#saveDonor(DonorDto)}
     */
    @Test
    void testSaveDonor2() {
        Address address = mock(Address.class);
        doNothing().when(address).setArea((String) any());
        doNothing().when(address).setCity((String) any());
        doNothing().when(address).setCountry((String) any());
        doNothing().when(address).setPincode((String) any());
        doNothing().when(address).setState((String) any());
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");
        Login login = mock(Login.class);
        doNothing().when(login).setLoginId((Long) any());
        doNothing().when(login).setLoginPassword((String) any());
        doNothing().when(login).setLoginType((String) any());
        doNothing().when(login).setLoginUsername((String) any());
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");
        Donor donor = mock(Donor.class);
        doNothing().when(donor).setAddress((Address) any());
        doNothing().when(donor).setDonorAmount((Long) any());
        doNothing().when(donor).setDonorContact((String) any());
        doNothing().when(donor).setDonorDOB((String) any());
        doNothing().when(donor).setDonorGender((String) any());
        doNothing().when(donor).setDonorId((Long) any());
        doNothing().when(donor).setDonorName((String) any());
        doNothing().when(donor).setDonorPAN((String) any());
        doNothing().when(donor).setLogin((Login) any());
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        when(donorRepository.save((Donor) any())).thenReturn(donor);
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn(null);
        assertNull(donorServiceImpl.saveDonor(new DonorDto()));
        verify(donorRepository).save((Donor) any());
        verify(donor).setAddress((Address) any());
        verify(donor).setDonorAmount((Long) any());
        verify(donor).setDonorContact((String) any());
        verify(donor).setDonorDOB((String) any());
        verify(donor).setDonorGender((String) any());
        verify(donor).setDonorId((Long) any());
        verify(donor).setDonorName((String) any());
        verify(donor).setDonorPAN((String) any());
        verify(donor).setLogin((Login) any());
        verify(address).setArea((String) any());
        verify(address).setCity((String) any());
        verify(address).setCountry((String) any());
        verify(address).setPincode((String) any());
        verify(address).setState((String) any());
        verify(login).setLoginId((Long) any());
        verify(login).setLoginPassword((String) any());
        verify(login).setLoginType((String) any());
        verify(login).setLoginUsername((String) any());
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<Donor>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#updateDonor(DonorDto, Long)}
     */
    @Test
    void testUpdateDonor() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        Optional<Donor> ofResult = Optional.of(donor);

        Address address1 = new Address();
        address1.setArea("Area");
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setPincode("Pincode");
        address1.setState("MD");

        Login login1 = new Login();
        login1.setLoginId(123L);
        login1.setLoginPassword("iloveyou");
        login1.setLoginType("Login Type");
        login1.setLoginUsername("janedoe");

        Donor donor1 = new Donor();
        donor1.setAddress(address1);
        donor1.setDonorAmount(1L);
        donor1.setDonorContact("Donor Contact");
        donor1.setDonorDOB("Donor DOB");
        donor1.setDonorGender("Donor Gender");
        donor1.setDonorId(123L);
        donor1.setDonorName("Donor Name");
        donor1.setDonorPAN("Donor PAN");
        donor1.setLogin(login1);
        when(donorRepository.save((Donor) any())).thenReturn(donor1);
        when(donorRepository.findById((Long) any())).thenReturn(ofResult);
        DonorDto donorDto = new DonorDto();
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any())).thenReturn(donorDto);
        assertSame(donorDto, donorServiceImpl.updateDonor(new DonorDto(), 123L));
        verify(donorRepository).save((Donor) any());
        verify(donorRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#updateDonor(DonorDto, Long)}
     */
    @Test
    void testUpdateDonor2() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        Optional<Donor> ofResult = Optional.of(donor);

        Address address1 = new Address();
        address1.setArea("Area");
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setPincode("Pincode");
        address1.setState("MD");

        Login login1 = new Login();
        login1.setLoginId(123L);
        login1.setLoginPassword("iloveyou");
        login1.setLoginType("Login Type");
        login1.setLoginUsername("janedoe");

        Donor donor1 = new Donor();
        donor1.setAddress(address1);
        donor1.setDonorAmount(1L);
        donor1.setDonorContact("Donor Contact");
        donor1.setDonorDOB("Donor DOB");
        donor1.setDonorGender("Donor Gender");
        donor1.setDonorId(123L);
        donor1.setDonorName("Donor Name");
        donor1.setDonorPAN("Donor PAN");
        donor1.setLogin(login1);
        when(donorRepository.save((Donor) any())).thenReturn(donor1);
        when(donorRepository.findById((Long) any())).thenReturn(ofResult);
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.updateDonor(new DonorDto(), 123L));
        verify(donorRepository).save((Donor) any());
        verify(donorRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#updateDonor(DonorDto, Long)}
     */
   /* @Test
    void testUpdateDonor3() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        when(donorRepository.save((Donor) any())).thenReturn(donor);
        when(donorRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
       // when(modelMapper.map((Object) any(), (Class<DonorDto>) any())).thenReturn(new DonorDto());
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.updateDonor(new DonorDto(), 123L));
        verify(donorRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<Object>) any());
    }
*/
    /**
     * Method under test: {@link DonorServiceImpl#getAllDonors()}
     */
    @Test
    void testGetAllDonors() {
        when(donorRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(donorServiceImpl.getAllDonors().isEmpty());
        verify(donorRepository).findAll();
    }

    /**
     * Method under test: {@link DonorServiceImpl#getAllDonors()}
     */
    @Test
    void testGetAllDonors2() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get All the donor Details");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get All the donor Details");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get All the donor Details");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Initiating dao call for the get All the donor Details");
        donor.setDonorDOB("Initiating dao call for the get All the donor Details");
        donor.setDonorGender("Initiating dao call for the get All the donor Details");
        donor.setDonorId(123L);
        donor.setDonorName("Initiating dao call for the get All the donor Details");
        donor.setDonorPAN("Initiating dao call for the get All the donor Details");
        donor.setLogin(login);

        ArrayList<Donor> donorList = new ArrayList<>();
        donorList.add(donor);
        when(donorRepository.findAll()).thenReturn(donorList);
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any())).thenReturn(new DonorDto());
        assertEquals(1, donorServiceImpl.getAllDonors().size());
        verify(donorRepository).findAll();
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#getAllDonors()}
     */
    @Test
    void testGetAllDonors3() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get All the donor Details");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get All the donor Details");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get All the donor Details");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Initiating dao call for the get All the donor Details");
        donor.setDonorDOB("Initiating dao call for the get All the donor Details");
        donor.setDonorGender("Initiating dao call for the get All the donor Details");
        donor.setDonorId(123L);
        donor.setDonorName("Initiating dao call for the get All the donor Details");
        donor.setDonorPAN("Initiating dao call for the get All the donor Details");
        donor.setLogin(login);

        Address address1 = new Address();
        address1.setArea("Initiating dao call for the get All the donor Details");
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setPincode("Initiating dao call for the get All the donor Details");
        address1.setState("MD");

        Login login1 = new Login();
        login1.setLoginId(123L);
        login1.setLoginPassword("iloveyou");
        login1.setLoginType("Initiating dao call for the get All the donor Details");
        login1.setLoginUsername("janedoe");

        Donor donor1 = new Donor();
        donor1.setAddress(address1);
        donor1.setDonorAmount(1L);
        donor1.setDonorContact("Initiating dao call for the get All the donor Details");
        donor1.setDonorDOB("Initiating dao call for the get All the donor Details");
        donor1.setDonorGender("Initiating dao call for the get All the donor Details");
        donor1.setDonorId(123L);
        donor1.setDonorName("Initiating dao call for the get All the donor Details");
        donor1.setDonorPAN("Initiating dao call for the get All the donor Details");
        donor1.setLogin(login1);

        ArrayList<Donor> donorList = new ArrayList<>();
        donorList.add(donor1);
        donorList.add(donor);
        when(donorRepository.findAll()).thenReturn(donorList);
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any())).thenReturn(new DonorDto());
        assertEquals(2, donorServiceImpl.getAllDonors().size());
        verify(donorRepository).findAll();
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#getAllDonors()}
     */
    @Test
    void testGetAllDonors4() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get All the donor Details");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get All the donor Details");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get All the donor Details");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Initiating dao call for the get All the donor Details");
        donor.setDonorDOB("Initiating dao call for the get All the donor Details");
        donor.setDonorGender("Initiating dao call for the get All the donor Details");
        donor.setDonorId(123L);
        donor.setDonorName("Initiating dao call for the get All the donor Details");
        donor.setDonorPAN("Initiating dao call for the get All the donor Details");
        donor.setLogin(login);

        ArrayList<Donor> donorList = new ArrayList<>();
        donorList.add(donor);
        when(donorRepository.findAll()).thenReturn(donorList);
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.getAllDonors());
        verify(donorRepository).findAll();
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#deleteDonors(Long)}
     */
    @Test
    void testDeleteDonors() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        Optional<Donor> ofResult = Optional.of(donor);
        doNothing().when(donorRepository).delete((Donor) any());
        when(donorRepository.findById((Long) any())).thenReturn(ofResult);
        donorServiceImpl.deleteDonors(123L);
        verify(donorRepository).findById((Long) any());
        verify(donorRepository).delete((Donor) any());
        assertTrue(donorServiceImpl.getAllDonors().isEmpty());
    }

    /**
     * Method under test: {@link DonorServiceImpl#deleteDonors(Long)}
     */
    @Test
    void testDeleteDonors2() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        Optional<Donor> ofResult = Optional.of(donor);
        doThrow(new ResourceNotFoundException("An error occurred")).when(donorRepository).delete((Donor) any());
        when(donorRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.deleteDonors(123L));
        verify(donorRepository).findById((Long) any());
        verify(donorRepository).delete((Donor) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#deleteDonors(Long)}
     */
    @Test
    void testDeleteDonors3() {
        doNothing().when(donorRepository).delete((Donor) any());
        when(donorRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.deleteDonors(123L));
        verify(donorRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#getDonorByLogin(LoginDto)}
     */
    @Test
    void testGetDonorByLogin() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        when(donorRepository.findByLogin((LoginDto) any())).thenReturn(donor);
        DonorDto donorDto = new DonorDto();
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any())).thenReturn(donorDto);
        assertSame(donorDto, donorServiceImpl.getDonorByLogin(new LoginDto()));
        verify(donorRepository).findByLogin((LoginDto) any());
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }

    /**
     * Method under test: {@link DonorServiceImpl#getDonorByLogin(LoginDto)}
     */
    @Test
    void testGetDonorByLogin2() {
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Donor donor = new Donor();
        donor.setAddress(address);
        donor.setDonorAmount(1L);
        donor.setDonorContact("Donor Contact");
        donor.setDonorDOB("Donor DOB");
        donor.setDonorGender("Donor Gender");
        donor.setDonorId(123L);
        donor.setDonorName("Donor Name");
        donor.setDonorPAN("Donor PAN");
        donor.setLogin(login);
        when(donorRepository.findByLogin((LoginDto) any())).thenReturn(donor);
        when(modelMapper.map((Object) any(), (Class<DonorDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> donorServiceImpl.getDonorByLogin(new LoginDto()));
        verify(donorRepository).findByLogin((LoginDto) any());
        verify(modelMapper).map((Object) any(), (Class<DonorDto>) any());
    }
}

