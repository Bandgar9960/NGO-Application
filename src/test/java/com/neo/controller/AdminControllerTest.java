package com.neo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dto.AdminDto;
import com.neo.service.AdminService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AdminController.class})
@ExtendWith(SpringExtension.class)
class AdminControllerTest {
    @Autowired
    private AdminController adminController;

    @MockBean
    private AdminService adminService;

    /**
     * Method under test: {@link AdminController#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin() throws Exception {
        when(adminService.getAllAdmin()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admins");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#getAllAdmin()}
     */
    @Test
    void testGetAllAdmin2() throws Exception {
        when(adminService.getAllAdmin()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/admins");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin() throws Exception {
        doNothing().when(adminService).deleteAdmin((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/admins/{adminId}", 123L);
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Admin Delete SuccessFully with Id\",\"status\":false}"));
    }

    /**
     * Method under test: {@link AdminController#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin2() throws Exception {
        doNothing().when(adminService).deleteAdmin((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/admins/{adminId}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Admin Delete SuccessFully with Id\",\"status\":false}"));
    }

    /**
     * Method under test: {@link AdminController#saveAdmin(AdminDto)}
     */
    @Test
    void testSaveAdmin() throws Exception {
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminAadhar("Admin Aadhar");
        adminDto.setAdminContact("Admin Contact");
        adminDto.setAdminGender("Admin Gender");
        adminDto.setAdminId(123L);
        adminDto.setAdminName("Admin Name");
        String content = (new ObjectMapper()).writeValueAsString(adminDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/admins")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link AdminController#updateAdmin(AdminDto, Long)}
     */
    @Test
    void testUpdateAdmin() throws Exception {
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminAadhar("Admin Aadhar");
        adminDto.setAdminContact("Admin Contact");
        adminDto.setAdminGender("Admin Gender");
        adminDto.setAdminId(123L);
        adminDto.setAdminName("Admin Name");
        String content = (new ObjectMapper()).writeValueAsString(adminDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/admins/{adminId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

