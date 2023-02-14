package com.neo.service.impl;

import com.neo.dto.AdminDto;
import com.neo.dto.LoginDto;
import com.neo.exception.ResourceNotFoundException;
import com.neo.model.Address;
import com.neo.model.Admin;
import com.neo.model.Login;
import com.neo.repository.AdminRepository;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AdminServiceImplTest {

    @MockBean
    private AdminRepository adminRepository;

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link AdminServiceImpl#saveAdmin(AdminDto)}
     */
    @Test
    void testSaveAdmin() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        when(adminRepository.save((Admin) any())).thenReturn(admin);
        when(modelMapper.map((Object) any(), (Class<Object>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.saveAdmin(new AdminDto()));
        verify(modelMapper).map((Object) any(), (Class<Admin>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#saveAdmin(AdminDto)}
     */
    @Test
    void testSaveAdmin2() {
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
        Admin admin = mock(Admin.class);
        doNothing().when(admin).setAddress((Address) any());
        doNothing().when(admin).setAdminAadhar((String) any());
        doNothing().when(admin).setAdminContact((String) any());
        doNothing().when(admin).setAdminGender((String) any());
        doNothing().when(admin).setAdminId((Long) any());
        doNothing().when(admin).setAdminName((String) any());
        doNothing().when(admin).setLogin((Login) any());
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        when(adminRepository.save((Admin) any())).thenReturn(admin);
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn(null);
        assertNull(adminServiceImpl.saveAdmin(new AdminDto()));
        verify(adminRepository).save((Admin) any());
        verify(admin).setAddress((Address) any());
        verify(admin).setAdminAadhar((String) any());
        verify(admin).setAdminContact((String) any());
        verify(admin).setAdminGender((String) any());
        verify(admin).setAdminId((Long) any());
        verify(admin).setAdminName((String) any());
        verify(admin).setLogin((Login) any());
        verify(address).setArea((String) any());
        verify(address).setCity((String) any());
        verify(address).setCountry((String) any());
        verify(address).setPincode((String) any());
        verify(address).setState((String) any());
        verify(login).setLoginId((Long) any());
        verify(login).setLoginPassword((String) any());
        verify(login).setLoginType((String) any());
        verify(login).setLoginUsername((String) any());
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<Admin>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateAdmin(AdminDto, Long)}
     */
    @Test
    void testUpdateAdmin() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        Optional<Admin> ofResult = Optional.of(admin);

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

        Admin admin1 = new Admin();
        admin1.setAddress(address1);
        admin1.setAdminAadhar("Admin Aadhar");
        admin1.setAdminContact("Admin Contact");
        admin1.setAdminGender("Admin Gender");
        admin1.setAdminId(123L);
        admin1.setAdminName("Admin Name");
        admin1.setLogin(login1);
        when(adminRepository.save((Admin) any())).thenReturn(admin1);
        when(adminRepository.findById((Long) any())).thenReturn(ofResult);
        AdminDto adminDto = new AdminDto();
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any())).thenReturn(adminDto);
        assertSame(adminDto, adminServiceImpl.updateAdmin(new AdminDto(), 123L));
        verify(adminRepository).save((Admin) any());
        verify(adminRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateAdmin(AdminDto, Long)}
     */
    @Test
    void testUpdateAdmin2() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        Optional<Admin> ofResult = Optional.of(admin);

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

        Admin admin1 = new Admin();
        admin1.setAddress(address1);
        admin1.setAdminAadhar("Admin Aadhar");
        admin1.setAdminContact("Admin Contact");
        admin1.setAdminGender("Admin Gender");
        admin1.setAdminId(123L);
        admin1.setAdminName("Admin Name");
        admin1.setLogin(login1);
        when(adminRepository.save((Admin) any())).thenReturn(admin1);
        when(adminRepository.findById((Long) any())).thenReturn(ofResult);
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.updateAdmin(new AdminDto(), 123L));
        verify(adminRepository).save((Admin) any());
        verify(adminRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateAdmin(AdminDto, Long)}
     */
/*
    @Test
    void testUpdateAdmin3() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        when(adminRepository.save((Admin) any())).thenReturn(admin);
        when(adminRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(modelMapper.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
     //   when(modelMapper.map((Object) any(), (Class<AdminDto>) any())).thenReturn(new AdminDto());
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.updateAdmin(new AdminDto(), 123L));
        verify(adminRepository).findById((Long) any());
        verify(modelMapper).map((Object) any(), (Class<Object>) any());
    }
*/

    /**
     * Method under test: {@link AdminServiceImpl#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin() {
        when(adminRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(adminServiceImpl.getAllAdmin().isEmpty());
        verify(adminRepository).findAll();
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin2() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get all the admin");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get all the admin");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get all the admin");
        login.setLoginUsername("janedoe");

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Initiating dao call for the get all the admin");
        admin.setAdminContact("Initiating dao call for the get all the admin");
        admin.setAdminGender("Initiating dao call for the get all the admin");
        admin.setAdminId(123L);
        admin.setAdminName("Initiating dao call for the get all the admin");
        admin.setLogin(login);

        ArrayList<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        when(adminRepository.findAll()).thenReturn(adminList);
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any())).thenReturn(new AdminDto());
        assertEquals(1, adminServiceImpl.getAllAdmin().size());
        verify(adminRepository).findAll();
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin3() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get all the admin");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get all the admin");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get all the admin");
        login.setLoginUsername("janedoe");

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Initiating dao call for the get all the admin");
        admin.setAdminContact("Initiating dao call for the get all the admin");
        admin.setAdminGender("Initiating dao call for the get all the admin");
        admin.setAdminId(123L);
        admin.setAdminName("Initiating dao call for the get all the admin");
        admin.setLogin(login);

        Address address1 = new Address();
        address1.setArea("Initiating dao call for the get all the admin");
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setPincode("Initiating dao call for the get all the admin");
        address1.setState("MD");

        Login login1 = new Login();
        login1.setLoginId(123L);
        login1.setLoginPassword("iloveyou");
        login1.setLoginType("Initiating dao call for the get all the admin");
        login1.setLoginUsername("janedoe");

        Admin admin1 = new Admin();
        admin1.setAddress(address1);
        admin1.setAdminAadhar("Initiating dao call for the get all the admin");
        admin1.setAdminContact("Initiating dao call for the get all the admin");
        admin1.setAdminGender("Initiating dao call for the get all the admin");
        admin1.setAdminId(123L);
        admin1.setAdminName("Initiating dao call for the get all the admin");
        admin1.setLogin(login1);

        ArrayList<Admin> adminList = new ArrayList<>();
        adminList.add(admin1);
        adminList.add(admin);
        when(adminRepository.findAll()).thenReturn(adminList);
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any())).thenReturn(new AdminDto());
        assertEquals(2, adminServiceImpl.getAllAdmin().size());
        verify(adminRepository).findAll();
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<AdminDto>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin4() {
        Address address = new Address();
        address.setArea("Initiating dao call for the get all the admin");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Initiating dao call for the get all the admin");
        address.setState("MD");

        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Initiating dao call for the get all the admin");
        login.setLoginUsername("janedoe");

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Initiating dao call for the get all the admin");
        admin.setAdminContact("Initiating dao call for the get all the admin");
        admin.setAdminGender("Initiating dao call for the get all the admin");
        admin.setAdminId(123L);
        admin.setAdminName("Initiating dao call for the get all the admin");
        admin.setLogin(login);

        ArrayList<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        when(adminRepository.findAll()).thenReturn(adminList);
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.getAllAdmin());
        verify(adminRepository).findAll();
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    @Test
    void saveAdmin() {
    }

    @Test
    void updateAdmin() {
    }

    @Test
    void getAllAdmin() {
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        Optional<Admin> ofResult = Optional.of(admin);
        doNothing().when(adminRepository).delete((Admin) any());
        when(adminRepository.findById((Long) any())).thenReturn(ofResult);
        adminServiceImpl.deleteAdmin(123L);
        verify(adminRepository).findById((Long) any());
        verify(adminRepository).delete((Admin) any());
        assertTrue(adminServiceImpl.getAllAdmin().isEmpty());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin2() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        Optional<Admin> ofResult = Optional.of(admin);
        doThrow(new ResourceNotFoundException("An error occurred")).when(adminRepository).delete((Admin) any());
        when(adminRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.deleteAdmin(123L));
        verify(adminRepository).findById((Long) any());
        verify(adminRepository).delete((Admin) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin3() {
        doNothing().when(adminRepository).delete((Admin) any());
        when(adminRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.deleteAdmin(123L));
        verify(adminRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAdminByLogin(LoginDto)}
     */
    @Test
    void testGetAdminByLogin() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        when(adminRepository.findByLogin((LoginDto) any())).thenReturn(admin);
        AdminDto adminDto = new AdminDto();
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any())).thenReturn(adminDto);
        assertSame(adminDto, adminServiceImpl.getAdminByLogin(new LoginDto()));
        verify(adminRepository).findByLogin((LoginDto) any());
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAdminByLogin(LoginDto)}
     */
    @Test
    void testGetAdminByLogin2() {
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

        Admin admin = new Admin();
        admin.setAddress(address);
        admin.setAdminAadhar("Admin Aadhar");
        admin.setAdminContact("Admin Contact");
        admin.setAdminGender("Admin Gender");
        admin.setAdminId(123L);
        admin.setAdminName("Admin Name");
        admin.setLogin(login);
        when(adminRepository.findByLogin((LoginDto) any())).thenReturn(admin);
        when(modelMapper.map((Object) any(), (Class<AdminDto>) any()))
                .thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> adminServiceImpl.getAdminByLogin(new LoginDto()));
        verify(adminRepository).findByLogin((LoginDto) any());
        verify(modelMapper).map((Object) any(), (Class<AdminDto>) any());
    }

    @Test
    void deleteAdmin() {
    }

    @Test
    void getAdminByLogin() {
    }
}